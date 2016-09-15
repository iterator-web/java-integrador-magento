package br.com.iterator.model.rest;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.bean.magento.MagentoCustomer;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class ClienteREST {
	
	public void atualizar(MagentoCustomer magentoCustomer) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		String jsonString = jsonObjectHelper.magentoCustomerConvertJavaObjectToJson(magentoCustomer);
		OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/customers/"+magentoCustomer.getEntityId()+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na atualização do cliente: "+response.getBody());
		}
	}

	public MagentoCustomer carregar(Integer customerId) {
		MagentoCustomer magentoCustomer = null;
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/customers/"+customerId+"?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().contains("\"code\":404")) {
			magentoCustomer = jsonObjectHelper.magentoCustomerConvertjsonToJavaObject(response.getBody());
		}
		return magentoCustomer;
	}
}
