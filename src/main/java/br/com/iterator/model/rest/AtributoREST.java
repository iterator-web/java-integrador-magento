package br.com.iterator.model.rest;

import java.util.List;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.bean.magento.MagentoAttribute;
import br.com.iterator.model.bean.magento.MagentoAttributeOption;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class AtributoREST {
	
	public void criarAtualizarOpcaoAtributo(String attributeCode, String parametrosPostJson) {
    	OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/integrador/atributo/color/opcoes?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(parametrosPostJson);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na criação/atualização da opção de atributo: "+response.getBody());
		}
	}

	public List<MagentoAttribute> listarFromProdutoConfigurable(Integer productId) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/"+productId+"/configurable/atributos?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		List<MagentoAttribute> magentoAttributeLista = jsonObjectHelper.magentoAttributeListConvertjsonToJavaObject(response.getBody());
		return magentoAttributeLista;
	}
	
	public List<MagentoAttributeOption> listarOpcoesAtributo(String attributeCode) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/atributo/"+attributeCode+"/opcoes?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		List<MagentoAttributeOption> magentoAttributeOptionLista = jsonObjectHelper.magentoAttributeOptionListConvertjsonToJavaObject(response.getBody());
		return magentoAttributeOptionLista;
	}
}
