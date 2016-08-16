package br.com.iterator.model.helper;

import java.util.List;

import br.com.iterator.model.bean.magento.MagentoAttribute;
import br.com.iterator.model.bean.magento.MagentoAttributeOption;
import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.petcenterjau.Cores;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.rest.AtributoREST;

public class AtributosHelper {
	
	public boolean atributos(Produto produto, MagentoProduct magentoProductReferencia) {
		boolean temCor = false;
		boolean temTamanho = false;
		String magentoAttributeCodeTamanho = null;
		AtributoREST atributoREST = new AtributoREST();
		List<MagentoAttribute> magentoAttributeLista = atributoREST.listarFromProdutoConfigurable(magentoProductReferencia.getEntityId());
		if(produto.getTamanho() != null) {
			magentoAttributeCodeTamanho = this.getValorFromUnidade(produto.getUnidade(), "code");
		}
		// Verifica se o produto referenciado possui vinculo com os atributos necessários.
		for (MagentoAttribute magentoAttribute : magentoAttributeLista) {
			if(produto.getCor() != 0.00000) {
				if(magentoAttribute.getAttributeCode().equals("color")) {
					temCor = true;
				}
			}
			if(produto.getTamanho() != null) {
				if(magentoAttribute.getAttributeCode().equals(magentoAttributeCodeTamanho)) {
					temTamanho = true;
				}
			}
		}
		// Caso não possua, retorna como false, encerrando o processo.
		if(produto.getCor() != 0.00000 && !temCor || produto.getTamanho() != null && !temTamanho) {
			return false;
		}
		// Verifica se o atributo do produto no ERP já é uma opção de atributo no Magento.
		if(produto.getCor() != 0.00000) {
			boolean corExiste = false;
			InterfaceDAO<Cores> coresDAO = new HibernateDAO<Cores>(Cores.class);
			Cores cor = coresDAO.getBean(produto.getCor().intValue());
			List<MagentoAttributeOption> magentoAttributeOptionLista = atributoREST.listarOpcoesAtributo("color");
			for (MagentoAttributeOption magentoAttributeOption : magentoAttributeOptionLista) {
				if(cor.getNome().equals(magentoAttributeOption.getLabel())) {
					corExiste = true;
				}
			}
			if(!corExiste) {
				atributoREST.criarAtualizarOpcaoAtributo("color", "{\"value\" : \""+cor.getNome()+"\"}");
			}
		}
		if(produto.getTamanho() != null && !produto.getTamanho().equals("")) {
			boolean tamanhoExiste = false;
			String tamanhoNome = this.getTamanhoNome(produto.getTamanho(), produto.getUnidade());
			List<MagentoAttributeOption> magentoAttributeOptionLista = atributoREST.listarOpcoesAtributo(magentoAttributeCodeTamanho);
			for (MagentoAttributeOption magentoAttributeOption : magentoAttributeOptionLista) {
				if(tamanhoNome.equals(magentoAttributeOption.getLabel())) {
					tamanhoExiste = true;
				}
			}
			if(!tamanhoExiste) {
				atributoREST.criarAtualizarOpcaoAtributo(magentoAttributeCodeTamanho, "{\"value\" : \""+tamanhoNome+"\"}");
			}
		}

		return true;
	}
	
	public String getTamanhoNome(String tamanho, String unidade){
		String tamanhoNome = null;
		if(tamanho.length() > 2 && tamanho.substring(0, 2).equals("0,")) {
			String tamanhoUnidade = this.getValorFromUnidade(unidade, "menor");
			tamanhoNome = tamanho.substring(2)+tamanhoUnidade;
		} else {
			if(unidade.equals("UN")) {
				if(Integer.valueOf(tamanho) == 1) {
					tamanhoNome = tamanho+" Unidade";
				} else {
					tamanhoNome = tamanho+" Unidades";
				}
			} else if(unidade.equals("CX")) {
				if(Integer.valueOf(tamanho) == 1) {
					tamanhoNome = tamanho+" Comprimido";
				} else {
					tamanhoNome = tamanho+" Comprimidos";
				}
			} else if(unidade.equals("PC")) {
				tamanhoNome = tamanho;
			} else if(unidade.equals("V")) {
				tamanhoNome = tamanho+"V";
			} else {
				String tamanhoUnidade = this.getValorFromUnidade(unidade, "maior");
				tamanhoNome = tamanho+tamanhoUnidade;
			}
		}
		
		return tamanhoNome;
	}
	
	public String getValorFromUnidade(String unidadeERP, String tipo) {
		String valor = "codigo";
		switch (unidadeERP) {
		case "KG":
			if(tipo.equals("code")) {
				valor = "peso";
			} else if(tipo.equals("maior")) {
				valor = "kg";
			} else if(tipo.equals("menor")) {
				valor = "gr";
			}
			break;
		case "L":
			if(tipo.equals("code")) {
				valor = "volume";
			} else if(tipo.equals("maior")) {
				valor = "l";
			} else if(tipo.equals("menor")) {
				valor = "ml";
			}
			break;
		case "UN":
			if(tipo.equals("code")) {
				valor = "quantidade";
			}
			break;
		case "PC":
			if(tipo.equals("code")) {
				valor = "size";
			}
			break;
		case "SC":
			if(tipo.equals("code")) {
				valor = "saco";
			} else if(tipo.equals("maior")) {
				valor = "kg";
			} else if(tipo.equals("menor")) {
				valor = "gr";
			}
			break;
		case "CX":
			if(tipo.equals("code")) {
				valor = "caixa";
			}
			break;
		case "CM":
			if(tipo.equals("code")) {
				valor = "comprimento";
			} else if(tipo.equals("maior")) {
				valor = "cm";
			} else if(tipo.equals("menor")) {
				valor = "mm";
			}
			break;
		case "V":
			if(tipo.equals("code")) {
				valor = "voltagem";
			}
			break;
		default:
			break;
		}
		
		return valor;
	}
	
	public MagentoAttributeOption getOpcaoAtributo(String attributeCode, String attributeOptionLabel) {
		AtributoREST atributoREST = new AtributoREST();
		MagentoAttributeOption magentoAttributeOption = atributoREST.carregarOpcaoAtributo(attributeCode, attributeOptionLabel);
		return magentoAttributeOption;
	}
}
