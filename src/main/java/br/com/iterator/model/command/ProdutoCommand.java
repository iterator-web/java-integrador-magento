package br.com.iterator.model.command;


import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.petcenterjau.Cores;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.helper.AtributosHelper;
import br.com.iterator.model.helper.EstoqueHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.rest.ProdutoREST;

/*
 * Produtos ERP X Produtos Magento - Regras:
 * Os produtos "Vitrines" serão sempre cadastrados no Magento, devido a ausência de campos essenciais para E-Commerce no cadastro do produto no ERP.
 * Sendo assim quando um produto no ERP não possuir atributo(s), o seu correspondente no Magento será cadastrado como Produto do tipo Simple e no SKU
 * deste produto Simple deverá existir o código do produto no ERP.
 * Quando um produto no ERP possuir atributo(s), o seu corresponde no Magento será cadastrado como Produto do tipo Configurable e no SKU deste produto 
 * Configurable deverão existir todos o código de todos os produtos do ERP que serão vinculados à este produto configurable, separados por ponto e vírgula.
 * Os produtos do ERP são vinculados aos produtos do Magento através da seguinte regra: Código do Produto no ERP = SKU do Produto no Magento
 * > Diante desta regra existem as seguintes possibilidades:
 * -É verificado se o produto possui o campo Enviar_Pocket assinalado. Se possuir é integrado, caso não possua, é verificado se ele já é um produto do
 * tipo Simple no Magento, caso seja ele é desativado no Magento.
 * -É verificado se o produto existe no Magento como produto tipo Simple ou então se é uma referência em algum produto tipo Configurable. Caso não seja
 * nenhuma das possibilidades, o produto é descartado sem tomar nenhuma ação.
 * -Um produto ser enviado pela fila de integração do ERP com a Ação Insert e é verificado que ele já possui produto cadastrado no Magento, neste 
 * caso ele seria do tipo Simple sem Atributos, pois acabou de ser criado no ERP e já possui um produto correspondente cadastrado no Magento.
 * -Um produto ser enviado pela fila de integração do ERP com a Ação Insert e é verificado que ele não possui produto cadastrado no Magento, mas possui
 * referência em um Configurable no Magento, neste caso ele seria do tipo Simple com Atributos, pois acabou de ser criado no ERP e é referenciado em um
 * Configurable no Magento.
 * -Um produto ser enviado pela fila de integração do ERP com a Ação Update e é verificado que ele não possui produto cadastrado no Magento, mas possui
 * referência em um Configurable no Magento, neste caso ele seria do tipo Simple com Atributos, pois é referenciado em um Configurable no Magento.
 * -Um produto ser enviado pela fila de integração do ERP com a Ação Update e é verificado que já possui proudto cadastrado no Magento, neste caso ele
 * poderia ser do tipo Simple sem Atributos ou do tipo Simple com Atributos, visto que é um produto que está sendo atualizado no ERP e será tratado de
 * acordo com o seu tipo no método de atualização.
 * > Outras Ações:
 * -Para trocar um produto vinculado em um Configurable de forma errada, é necessário retirar o código do produto no ERP do SKU do produto Configurable 
 * que não mais terá vinculo e adicionar este código no SKU do outro produto Configurable que terá esse produto do ERP vinculado.
 */
public class ProdutoCommand {

	public boolean checar(String codigo, String operacao) {
		boolean resultado = true;
		ProdutoREST produtoREST = new ProdutoREST();
		// Carregar o produto do ERP a partir de seu código.
		InterfaceDAO<Produto> produtoDAO = new HibernateDAO<Produto>(Produto.class);
		Produto produto = produtoDAO.getBean(Integer.valueOf(codigo));
		// Verificar se produto o produto possui o campo Enviar_Pocket assinalado. Caso não possua.
		if(produto.getEnviarPocket() == null || produto.getEnviarPocket().equals("N")) {
			// Verifica se o produto do ERP já existe no Magento através do seu código. Caso exista, deverá estar vinculado a um produto simples do Magento.
			MagentoProduct magentoProduct = produtoREST.carregar("c-"+produto.getCodigo());
			if(magentoProduct != null) {
				// Caso exista, invoca método para desabilitar o produto no Magento.
				this.desabilitar(magentoProduct);
			}
			// Retorna como true encerrando o processo.
			return true;
		}
		MagentoProduct magentoProductReferencia = null;
		// Verifica se o produto do ERP já existe no Magento através do seu código. Caso exista, deverá estar vinculado a um produto simples do Magento.
		MagentoProduct magentoProduct = produtoREST.carregar("c-"+produto.getCodigo());
		if(magentoProduct == null) {
			// Verifica se o produto do ERP está referenciado no Magento através do seu código. Caso esteja referenciado, deverá estar referenciado por um produto configurable no Magento.
			magentoProductReferencia = produtoREST.carregarConfigurableBySku("c-"+produto.getCodigo()+";");
			if(magentoProductReferencia == null) {
				// Caso não exista no Magento, retornar como true, encerrando o processo.
				return true;
			}
		}
		// Caso o produto do ERP já exista no Magento, este produto será um simples sem atributos ou então um simples com atributos e já vinculado a um Configurable.
		if(magentoProduct != null && magentoProduct.getTypeId().equals("simple")) {
			// Caso seja um produto simples sem atributos ou um simples já vinculado a um Configurable, invoca o método atualizar() passando o produto simples correspondente.
			resultado = this.atualizar(produto, magentoProduct);
		} else if(magentoProductReferencia != null && magentoProductReferencia.getTypeId().equals("configurable")) {
			// Caso não seja um produto simples e contenha referência a um produto configurable, invoca o método criar() passando o produto configurable como referência.
			resultado = this.criar(produto, magentoProductReferencia);
		}
		
		return resultado;
	}
	
	public boolean excluir(String codigo) {
		// Exclui o produto no Magento.
		ProdutoREST produtoREST = new ProdutoREST();
		produtoREST.excluir(codigo);
		return true;
	}
	
	private boolean criar(Produto produto, MagentoProduct magentoProduct) {
		ProdutoREST produtoREST = new ProdutoREST();
		AtributosHelper atributosHelper = new AtributosHelper();
		MagentoProduct magentoProductIntegrar = magentoProduct;
		// Caso o produto seja um Configurable, então ele será uma referencia e deverá ter seus vinculos com atributos verificados, antes da criação do simples.
		if(magentoProduct.getTypeId().equals("configurable")) {
			magentoProductIntegrar = new MagentoProduct();
			magentoProductIntegrar.setAttributeSetId(magentoProduct.getAttributeSetId());
			magentoProductIntegrar.setTypeId("simple");
			magentoProductIntegrar.setDescription(magentoProduct.getDescription());
			magentoProductIntegrar.setShortDescription(magentoProduct.getShortDescription());
			magentoProductIntegrar.setStatus(magentoProduct.getStatus());
			magentoProductIntegrar.setTaxClassId(magentoProduct.getTaxClassId());
			magentoProductIntegrar.setVisibility(1);
			// Verifica os atributos que o produto utiliza no ERP (Cor, Tamanho, Peso e Volume) e se existem no produto referenciado no Magento.
			if(!atributosHelper.atributos(produto, magentoProduct)) {
				// Grava no log que o produto do ERP não possui os mesmos atributos que o produto referenciado no Magento e retorna true para encerrar o processo.
				LogHelper.LOGGER.warning("O produto "+produto.getCodigo()+" não pode ser criado, pois possui atributos diferentes do produto configurable referenciado no Magento.");
				return true;
			}
		}
		// Cria o produto no Magento
		produtoREST.criar(magentoProductIntegrar, produto);
		// Atualiza o estoque do produto no Magento a partir do SKU que é o código do produto no ERP
		EstoqueHelper estoqueHelper = new EstoqueHelper();
		estoqueHelper.atualizarMagento(produto.getCodigo());
		// Caso o produto seja um Configurable, faz a vinculação entre o produto simples e seu configurável referenciado.
		if(magentoProduct.getTypeId().equals("configurable")) {
			this.vincular(produto, magentoProduct);
		}
		
		return true;
	}
	
	private boolean atualizar(Produto produto, MagentoProduct magentoProduct) {
		ProdutoREST produtoREST = new ProdutoREST();
		AtributosHelper atributosHelper = new AtributosHelper();
		// Verifica se o produto do ERP está referenciado no Magento através do seu código. Caso esteja referenciado, deverá estar referenciado por um produto configurable no Magento.
		MagentoProduct magentoProductReferencia = produtoREST.carregarConfigurableBySku("c-"+produto.getCodigo()+";");
		// Caso exista uma referência do produto do ERP no Magento, então trata-se de um simples vinculado a um Configurable.
		if(magentoProductReferencia != null && magentoProductReferencia.getTypeId().equals("configurable")) {
			// Verifica os atributos que o produto utiliza no ERP (Cor, Tamanho, Peso e Volume) e se existem no produto referenciado no Magento.
			if(!atributosHelper.atributos(produto, magentoProductReferencia)) {
				// Grava no log que o produto do ERP não possui os mesmos atributos que o produto referenciado no Magento e retorna true para encerrar o processo.
				LogHelper.LOGGER.warning("O produto "+produto.getCodigo()+" não pode ser atualizado, pois possui atributos diferentes do produto configurable referenciado no Magento.");
				return true;
			}
		}
		// Atualiza o produto no Magento
		produtoREST.atualizar(magentoProduct, produto);
		// Atualiza o estoque do produto no Magento a partir do SKU que é o código do produto no ERP
		EstoqueHelper estoqueHelper = new EstoqueHelper();
		estoqueHelper.atualizarMagento(produto.getCodigo());
		// Caso o produto seja um Configurable, faz a vinculação entre o produto simples e seu configurável referenciado, assim como também a atualização de preço.
		if(magentoProductReferencia != null && magentoProductReferencia.getTypeId().equals("configurable")) {
			this.vincular(produto, magentoProductReferencia);
		}
		
		return true;
	}
	
	private void desabilitar(MagentoProduct magentoProduct) {
		// Faz o processo de desabilitar o produto do ERP no Magento.
		ProdutoREST produtoREST = new ProdutoREST();
		produtoREST.desabilitar(magentoProduct);
	}
	
	private void vincular(Produto produto, MagentoProduct magentoProduct) {
		// Fazer o vínculo entre o produto simples e o produto configurável.
		AtributosHelper atributosHelper = new AtributosHelper();
		String atributoCode = null;
		String opcaoAtributo = null;
		String skuConfigurable = magentoProduct.getSku();
    	String skuSplit[] = skuConfigurable.split(";");
    	String jsonString = "{\"associated_skus\" : [";
    	int count = 0;
    	for (String skuSimple : skuSplit) {
			jsonString += "\""+skuSimple+"\"";
			count++;
			if(skuSplit.length == count) {
				jsonString += "],";
			} else {
				jsonString += ",";
			}
		}
    	// Busca a opção de atributo do produto, para fixar o preço da variação.
		if(produto.getCor() != null && produto.getCor() != 0.00000 && produto.getTamanho() != null && !produto.getTamanho().equals("")) {
			// Caso o produto possua cor e tamanho, define o valor somente no atributo relacionado ao tamanho.
			atributoCode = atributosHelper.getValorFromUnidade(produto.getUnidade(), "code");
			opcaoAtributo = atributosHelper.getTamanhoNome(produto.getTamanho(), produto.getUnidade());
		} else if (produto.getCor() != null && produto.getCor() != 0.00000 && produto.getTamanho() == null || 
				produto.getCor() != null && produto.getCor() != 0.00000 && produto.getTamanho().equals("")) {
			// Caso o produto possua somente cor.
			atributoCode = "color";
			InterfaceDAO<Cores> coresDAO = new HibernateDAO<Cores>(Cores.class);
			Cores cor = coresDAO.getBean(produto.getCor().intValue());
			opcaoAtributo = cor.getNome();
		} else if (produto.getCor() == null && produto.getTamanho() != null && !produto.getTamanho().equals("") || 
				produto.getCor() == 0.00000 && produto.getTamanho() != null && !produto.getTamanho().equals("")) {
			// Caso o produto possua somente tamanho.
			atributoCode = atributosHelper.getValorFromUnidade(produto.getUnidade(), "code");
			opcaoAtributo = atributosHelper.getTamanhoNome(produto.getTamanho(), produto.getUnidade());
		}
		jsonString += "\"price_changes\" : {\""+atributoCode+"\" : {\""+opcaoAtributo+"\" : "+produto.getPrecoProduto()+"}}}";
		ProdutoREST produtoREST = new ProdutoREST();
		produtoREST.vincularSimplesToConfigurable(skuConfigurable, jsonString);
	}
}
