package br.com.iterator.model.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iterator.model.bean.magento.MagentoAttribute;
import br.com.iterator.model.bean.magento.MagentoAttributeOption;

public class JsonObjectHelper {
	
	public List<MagentoAttribute> magentoAttributeListConvertjsonToJavaObject(String jsonMagentoAttribute) {
		List<MagentoAttribute> magentoAttributeLista = new ArrayList<MagentoAttribute>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			magentoAttributeLista = objectMapper.readValue(jsonMagentoAttribute, new TypeReference<List<MagentoAttribute>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return magentoAttributeOptionLista;
	}
}
