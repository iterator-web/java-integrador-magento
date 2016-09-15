package br.com.iterator.model.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iterator.model.bean.magento.MagentoAttribute;
import br.com.iterator.model.bean.magento.MagentoAttributeOption;
import br.com.iterator.model.bean.magento.MagentoCustomer;
import br.com.iterator.model.bean.magento.MagentoOrder;
import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.magento.MagentoStock;
import br.com.iterator.model.bean.petcenterjau.Cores;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;

public class JsonObjectHelper {
	
	public String magentoProductConvertJavaObjectToJson(MagentoProduct magentoProduct, Produto produto) {
		String jsonString = null;
		try {
    		AtributosHelper atributosHelper = new AtributosHelper();
			ObjectMapper objectMapper = new ObjectMapper();
	    	magentoProduct.setSku("c-"+produto.getCodigo());
	    	magentoProduct.setName(produto.getNome());
	    	magentoProduct.setPrice(produto.getPrecoProduto());
	    	magentoProduct.setStatus(1);
	    	if(produto.getCor() != null && produto.getCor() != 0.00000) {
	    		InterfaceDAO<Cores> coresDAO = new HibernateDAO<Cores>(Cores.class);
				Cores cor = coresDAO.getBean(produto.getCor().intValue());
				MagentoAttributeOption magentoAttributeOption = atributosHelper.getOpcaoAtributo("color", cor.getNome());
	    		magentoProduct.setColor(magentoAttributeOption.getValue());
	    	}
	    	if(produto.getTamanho() != null && !produto.getTamanho().equals("")) {
	    		String magentoAttributeCodeTamanho = atributosHelper.getValorFromUnidade(produto.getUnidade(), "code");
	    		String tamanhoNome = atributosHelper.getTamanhoNome(produto.getTamanho(), produto.getUnidade());
	    		MagentoAttributeOption magentoAttributeOption = atributosHelper.getOpcaoAtributo(magentoAttributeCodeTamanho, tamanhoNome);
	    		if(produto.getUnidade().equals("KG")) {
	    			magentoProduct.setPeso(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("L")) {
	    			magentoProduct.setVolume(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("UN")) {
	    			magentoProduct.setQuantidade(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("PC")) {
	    			magentoProduct.setSize(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("SC")) {
	    			magentoProduct.setSaco(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("CX")) {
	    			magentoProduct.setCaixa(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("CM")) {
	    			magentoProduct.setComprimento(magentoAttributeOption.getValue());
	    		} else if(produto.getUnidade().equals("V")) {
	    			magentoProduct.setVoltagem(magentoAttributeOption.getValue());
	    		}
	    	}
	    	magentoProduct.setWeight(produto.getPesoProduto());
	    	magentoProduct.setVolumeComprimento(produto.getComprimentoProdutoEcommerce());
	    	magentoProduct.setVolumeAltura(produto.getAlturaProdutoEcommerce());
	    	magentoProduct.setVolumeLargura(produto.getLarguraProdutoEcommerce());
			jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(magentoProduct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return jsonString;
	}
	
	public String magentoProductSomenteConvertJavaObjectToJson(MagentoProduct magentoProduct, String acao) {
		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			if(acao.equals("desabilitar")) {
				magentoProduct.setStatus(2);
			}
			jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(magentoProduct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return jsonString;
	}
	
	public String magentoCustomerConvertJavaObjectToJson(MagentoCustomer magentoCustomer) {
		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(Include.NON_NULL); // Necessário para não incluir campos nulos na String json e portanto não alterar de forma errada a data de nascimento.
			magentoCustomer.setDob(null);
			jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(magentoCustomer);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return jsonString;
	}
	
	public String magentoStockConvertJavaObjectToJson(Integer estoqueTotal, MagentoStock magentoStock) {
		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			if(estoqueTotal == -100) {
				// Caso o estoqueTotal possua valor -100, significa que trata-se de um produto configurable sem estoque.
				magentoStock.setIsInStock(0);
			} else if(estoqueTotal == -200) {
				// Caso o estoqueTotal possua valor -200, significa que trata-se de um produto configurable com estoque.
				magentoStock.setIsInStock(1);
			} else {
				// Caso seja um valor diferente dos fixados para os produtos configurables, será um simples e a quantidade deverá ser ajustada com exatidão.
				magentoStock.setQty(estoqueTotal+".0000");
				if(estoqueTotal <= 0) {
					magentoStock.setIsInStock(0);
				} else {
					magentoStock.setIsInStock(1);
				}
			}
			jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(magentoStock);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return jsonString;
	}

	public MagentoProduct magentoProductConvertjsonToJavaObject(String jsonMagentoProduct) {
		MagentoProduct magentoProduct = new MagentoProduct();
    	try {
        	ObjectMapper objectMapper = new ObjectMapper();
			magentoProduct = objectMapper.readValue(jsonMagentoProduct, MagentoProduct.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
    	
    	return magentoProduct;
    }
	
	public List<MagentoAttribute> magentoAttributeListConvertjsonToJavaObject(String jsonMagentoAttribute) {
		List<MagentoAttribute> magentoAttributeLista = new ArrayList<MagentoAttribute>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoAttributeLista = objectMapper.readValue(jsonMagentoAttribute, new TypeReference<List<MagentoAttribute>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoAttributeLista;
	}
	
	public List<MagentoAttributeOption> magentoAttributeOptionListConvertjsonToJavaObject(String jsonMagentoAttributeOption) {
		List<MagentoAttributeOption> magentoAttributeOptionLista = new ArrayList<MagentoAttributeOption>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoAttributeOptionLista = objectMapper.readValue(jsonMagentoAttributeOption, new TypeReference<List<MagentoAttributeOption>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoAttributeOptionLista;
	}
	
	public MagentoAttributeOption magentoAttributeOptionConvertjsonToJavaObject(String jsonMagentoAttributeOption) {
		MagentoAttributeOption magentoAttributeOption = new MagentoAttributeOption();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoAttributeOption = objectMapper.readValue(jsonMagentoAttributeOption, MagentoAttributeOption.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoAttributeOption;
	}
	
	public MagentoStock magentoStockConvertjsonToJavaObject(String jsonMagentoStock) {
		MagentoStock magentoStock = new MagentoStock();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoStock = objectMapper.readValue(jsonMagentoStock, MagentoStock.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoStock;
	}
	
	public List<MagentoOrder> magentoOrderListConvertjsonToJavaObject(String jsonMagentoOrder) {
		List<MagentoOrder> magentoOrderLista = new ArrayList<MagentoOrder>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoOrderLista = objectMapper.readValue(jsonMagentoOrder, new TypeReference<List<MagentoOrder>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoOrderLista;
	}
	
	public MagentoCustomer magentoCustomerConvertjsonToJavaObject(String jsonMagentoCustomer) {
		MagentoCustomer magentoCustomer = new MagentoCustomer();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoCustomer = objectMapper.readValue(jsonMagentoCustomer, MagentoCustomer.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (JsonMappingException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return magentoCustomer;
	}
}
