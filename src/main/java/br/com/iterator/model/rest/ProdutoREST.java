package br.com.iterator.model.rest;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class ProdutoREST {
	
	public void criar(MagentoProduct magentoProduct, Produto produto) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		String jsonString = jsonObjectHelper.magentoProductConvertJavaObjectToJson(magentoProduct, produto);
		OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/products?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na criação do produto: "+response.getBody());
		} else {
			this.associarProdutoWebsite("c-"+produto.getCodigo());
		}
	}
	
	public void atualizar(MagentoProduct magentoProduct, Produto produto) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		String jsonString = jsonObjectHelper.magentoProductConvertJavaObjectToJson(magentoProduct, produto);
		OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/products/"+magentoProduct.getEntityId()+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na atualização do produto: "+response.getBody());
		}
	}
	
	public void excluir(String codigoProdutoERP) {
		String sku = "c-"+codigoProdutoERP;
		OAuthRequest request = new OAuthRequest(Verb.DELETE, MagentoConectar.REST_API_URL + "/products/"+sku+"?type=rest");
    	MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na exclusão do produto: "+response.getBody());
		} else {
			this.alterarSkuConfigurable(codigoProdutoERP);
		}
	}
	
	public void desabilitar(MagentoProduct magentoProduct) {
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		String jsonString = jsonObjectHelper.magentoProductSomenteConvertJavaObjectToJson(magentoProduct, "desabilitar");
		OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/products/"+magentoProduct.getEntityId()+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha ao desabilitar o produto: "+response.getBody());
		}
	}
	
	public void vincularSimplesToConfigurable(String skuConfigurable, String jsonString) {
		OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/integrador/produto/"+skuConfigurable+"/configurable?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na vinculação do produto: "+response.getBody());
		}
	}

	public MagentoProduct carregar(String skuOrId) {
		MagentoProduct magentoProduct = null;
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/products/"+skuOrId+"?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().contains("\"code\":404")) {
			magentoProduct = jsonObjectHelper.magentoProductConvertjsonToJavaObject(response.getBody());
		}
		return magentoProduct;
	}
	
	public MagentoProduct carregarConfigurableBySku(String codigoProdutoERP) {
		MagentoProduct magentoProduct = null;
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/"+codigoProdutoERP+"/configurable?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().contains("\"code\":404")) {
			magentoProduct = jsonObjectHelper.magentoProductConvertjsonToJavaObject(response.getBody());
		}
		return magentoProduct;
	}
	
	private void associarProdutoWebsite(String sku) {
		MagentoProduct magentoProduct = this.carregar(sku);
		Integer websiteId = 1;
    	String jsonString = "{\"website_id\" : \""+websiteId+"\"}";
    	OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/products/"+magentoProduct.getEntityId()+"/websites?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			LogHelper.LOGGER.severe("Falha na associação ao Website: "+response.getBody());
		}
	}
	
	private void alterarSkuConfigurable(String codigoProdutoERP) {
		MagentoProduct magentoProduct = this.carregarConfigurableBySku("c-"+codigoProdutoERP+";");
		if(magentoProduct != null) {
			String skuConfigurable = magentoProduct.getSku();
	    	String skuSplit[] = skuConfigurable.split(";");
	    	String novoSku = "";
	    	for (String skuSimple : skuSplit) {
	    		if(!skuSimple.equals("c-"+codigoProdutoERP)) {
	    			novoSku += skuSimple+";";
	    		}
	    	}
	    	magentoProduct.setSku(novoSku);
	    	JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
	    	String jsonString = jsonObjectHelper.magentoProductSomenteConvertJavaObjectToJson(magentoProduct, "sku_configurable");
			OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/products/"+magentoProduct.getEntityId()+"?type=rest");
	    	request.addHeader("Content-Type", "application/json");
	    	request.addPayload(jsonString);
			MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
			Response response = request.send();
			if(!response.getBody().equals("")) {
				LogHelper.LOGGER.severe("Falha ao alterar SKU do produto: "+response.getBody());
			}
		}
	}
}
