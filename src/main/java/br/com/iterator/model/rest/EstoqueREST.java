package br.com.iterator.model.rest;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.bean.magento.MagentoStock;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class EstoqueREST {

	public MagentoStock carregarPorProduto(String skuOrId) {
		MagentoStock magentoStock = null;
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/"+skuOrId+"/estoque?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().contains("\"code\":404")) {
			magentoStock = jsonObjectHelper.magentoStockConvertjsonToJavaObject(response.getBody());
		}
		return magentoStock;
	}
	
	public void atualizar(Integer estoqueTotal, MagentoStock magentoStock) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		String jsonString = jsonObjectHelper.magentoStockConvertJavaObjectToJson(estoqueTotal, magentoStock);
		OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/stockitems/"+magentoStock.getItemId()+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na atualização do estoque: "+response.getBody());
		}
	}
}
