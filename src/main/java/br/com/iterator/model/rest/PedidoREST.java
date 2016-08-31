package br.com.iterator.model.rest;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.util.MagentoConectar;

public class PedidoREST {

	public Integer consultarProdutoPedidosPendentes(String sku) {
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/"+sku+"/pedidos/quantidade?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		Integer quantidadePendente = Integer.valueOf(response.getBody());
		return quantidadePendente;
	}
}
