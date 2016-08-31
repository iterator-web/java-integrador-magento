package br.com.iterator.model.helper;

import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.magento.MagentoStock;
import br.com.iterator.model.bean.petcenterjau.Estoque;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.rest.EstoqueREST;
import br.com.iterator.model.rest.PedidoREST;
import br.com.iterator.model.rest.ProdutoREST;

public class EstoqueHelper {

	public void atualizarMagento(Integer produtoCodigoERP) {
		// Busca a quantidade de pedidos pendentes que contém reservas deste produto.
		PedidoREST pedidoREST = new PedidoREST();
		Integer quantidadePendenteMagento = pedidoREST.consultarProdutoPedidosPendentes("c-"+produtoCodigoERP);
		// Busca o estoque do produto no ERP.
		InterfaceDAO<Estoque> estoqueDAO = new HibernateDAO<Estoque>(Estoque.class);
    	Integer quantidadeEstoqueERP = estoqueDAO.somarEstoque(produtoCodigoERP);
		// Decrementa a quantidade reservada do estoque total do produto no ERP.
		Integer estoqueTotal = quantidadeEstoqueERP - quantidadePendenteMagento;
		// Carrega informações de estoque do produto
		EstoqueREST estoqueREST = new EstoqueREST();
		MagentoStock magentoStock = estoqueREST.carregarPorProduto("c-"+produtoCodigoERP);
		// Atualiza o estoque do produto.
		estoqueREST.atualizar(estoqueTotal, magentoStock);
		// Verifica e atualiza caso necessário o produto configurable ao qual o produto simples é vinculado.
		this.atualizarProdutoConfigurable(produtoCodigoERP);
	}
	
	private void atualizarProdutoConfigurable(Integer produtoCodigoERP) {
		// Verifica se o produto possui vinculo com produto configurable.
		ProdutoREST produtoREST = new ProdutoREST();
		MagentoProduct magentoProductReferencia = produtoREST.carregarConfigurableBySku("c-"+produtoCodigoERP+";");
		// Caso exista uma referência do produto do ERP no Magento, então trata-se de um simples vinculado a um Configurable.
		if(magentoProductReferencia.getEntityId() != null && magentoProductReferencia.getTypeId().equals("configurable")) {
			EstoqueREST estoqueREST = new EstoqueREST();
			String skuSplit[] = magentoProductReferencia.getSku().split(";");
			// -100 é o valor definido para indicar que o produto não possui estoque.
			Integer isInStock = -100;
			// Percorre todos os produtos simples vinculados ao configurable.
			for (String sku : skuSplit) {
				MagentoStock produtoSimplesEstoque = estoqueREST.carregarPorProduto(sku);
				// Caso encontre estoque positivo em um dos produtos simples vinculados, define que o produto configurable possui estoque. -200 é o valor definido para indicar que o produto possui estoque.
				if(produtoSimplesEstoque != null && Double.valueOf(produtoSimplesEstoque.getQty()) > 0.0000) {
					isInStock = -200;
					break;
				}
			}
			// Atualiza o estoque do produto configurable, passando o valor isInStock como quantidade para que 
			MagentoStock produtoConfigurableEstoque = estoqueREST.carregarPorProduto(magentoProductReferencia.getSku());
			estoqueREST.atualizar(isInStock, produtoConfigurableEstoque);
		}	
	}
}