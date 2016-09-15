package br.com.iterator.model.rest;

import java.util.List;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.bean.magento.MagentoOrder;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class PedidoREST {
	
	public void atualizar(String tipo, Integer codigoERP, String magentoOrderIncrementId) {
		String jsonString = null;
		if(tipo.equals("orcamento")) {
			jsonString = "{\"codigo_orcamento\" : \""+codigoERP+"\"}";
		} else if(tipo.equals("venda")) {
			jsonString = "{\"codigo_venda\" : \""+codigoERP+"\"}";
		}
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/integrador/pedido/"+magentoOrderIncrementId+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na atualização do pedido: "+response.getBody());
		}
	}

	public Integer consultarProdutoPedidosPendentes(String sku) {
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/"+sku+"/pedidos/quantidade?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		Integer quantidadePendente = Integer.valueOf(response.getBody());
		return quantidadePendente;
	}
	
	public List<MagentoOrder> listar() {
		String status = "processing";
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/pedido/situacao/"+status+"?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		List<MagentoOrder> magentoOrderLista = jsonObjectHelper.magentoOrderListConvertjsonToJavaObject(response.getBody());
		return magentoOrderLista;
	}
}
