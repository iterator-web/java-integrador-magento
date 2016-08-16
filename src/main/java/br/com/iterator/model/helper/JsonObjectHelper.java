package br.com.iterator.model.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iterator.model.bean.magento.MagentoAttribute;
import br.com.iterator.model.bean.magento.MagentoAttributeOption;
import br.com.iterator.model.bean.magento.MagentoProduct;
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
	    	if(produto.getCor() != 0.00000) {
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
}
