package br.com.iterator.IntegradorPetCenter;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringEscapeUtils;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iterator.model.bean.magento.MagentoOrder;
import br.com.iterator.model.bean.magento.MagentoOrderAddress;
import br.com.iterator.model.bean.magento.MagentoOrderItem;
import br.com.iterator.model.bean.magento.MagentoProduct;
import br.com.iterator.model.bean.petcenterjau.Cidade;
import br.com.iterator.model.bean.petcenterjau.Estoque;
import br.com.iterator.model.bean.petcenterjau.Orcamento;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.helper.JsonObjectHelper;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.MagentoConectar;

public class App 
{
    public static void main( String[] args ) {
        MagentoConectar magentoConectar = new MagentoConectar();
        magentoConectar.estabelecerConexao();
        
        // Métodos Web Service Magento
        //cadastrarProduto();
        //atualizarProduto();
        //excluirProduto();
        //associarProdutoWebsite();
        //cadastrarOpcaoAtributo();
        //atualizarPedido();
        //atualizarEstoque();
        //atualizarCliente();
        //vincularProdutos();
        //consultarEstoques();
        //consultarEstoquesPorProduto();
        //consultarProduto();
        //consultarAtributo();
        //consultarAtributos();
        //consultarCodigoPorSku();
        //consultarAtributosProdutoConfigurable();
        //consultarOpcoesAtributo();
        //consultarOpcaoAtributo();
        //consultarProdutoPedidosPendentes();
        consultarPedidos();
        //consultarCliente();
        
        // Métodos Hibernate ERP
        //carregarProdutoERP();
        //contarEstoqueProdutoERP();
        //carregarOrcamentoERP();
    	//salvarOrcamentoERP();
    	//carregarUltimoCodigoOrcamentoERP();
        
        //javaObjectToJson();
        
        // Métodos de geração de Log
         //gerarLog();
    }
    
    private static void cadastrarProduto() {
    	String jsonString = "{\"custom_design\" : \"default/blank\",\"custom_design_from\" : \"02/16/2012\",\"custom_design_to\" : \"05/01/2012\",\"description\" : \"Test description\",\"gift_message_available\" : 1,\"meta_description\" : \"Test meta\",\"meta_keyword\" : \"Test keyword\",\"meta_title\" : \"Test title\",\"msrp\" : 11.015000000000001,\"msrp_display_actual_price_type\" : 1,\"msrp_enabled\" : 1,\"name\" : \"Test Oficial\",\"news_from_date\" : \"02/16/2012\",\"news_to_date\" : \"16.02.2012\",\"options_container\" : \"container1\",\"page_layout\" : \"one_column\",\"price\" : 25.5,\"attribute_set_id\" : \"4\",\"short_description\" : \"Test short description\",\"sku\" : \"teste-oficial\",\"special_from_date\" : \"02/16/2012\",\"special_price\" : 11.199999999999999,\"special_to_date\" : \"03/17/2012\",\"status\" : 1,\"stock_data\" : { \"backorders\" : 1,\"enable_qty_increments\" : 0,\"is_in_stock\" : 0,\"is_qty_decimal\" : 0,\"manage_stock\" : 1,\"max_sale_qty\" : 1,\"min_qty\" : 1.5600000000000001,\"min_sale_qty\" : 1,\"notify_stock_qty\" : -50.990000000000002,\"qty\" : 1,\"use_config_manage_stock\" : 1,\"use_config_min_qty\" : 1,\"use_config_min_sale_qty\": 1,\"use_config_max_sale_qty\" : 1,\"use_config_backorders\": 1,\"use_config_enable_qty_inc\":1,\"use_config_notify_stock_qty\":1 },\"tax_class_id\" : \"2\",\"type_id\" : \"simple\",\"use_config_gift_message_available\" : 0,\"visibility\" : \"4\",\"weight\" : 125}";
    	OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/products?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void atualizarProduto() {
    	String codigoProdutoMagento = "1";
    	String jsonString = "{\"custom_design\" : \"default/blank\",\"custom_design_from\" : \"02/16/2012\",\"custom_design_to\" : \"05/01/2012\",\"description\" : \"Test description\",\"gift_message_available\" : 1,\"meta_description\" : \"Test meta\",\"meta_keyword\" : \"Test keyword\",\"meta_title\" : \"Test title\",\"msrp\" : 11.015000000000001,\"msrp_display_actual_price_type\" : 1,\"msrp_enabled\" : 1,\"name\" : \"Teste Oficial\",\"news_from_date\" : \"02/16/2012\",\"news_to_date\" : \"16.02.2012\",\"options_container\" : \"container1\",\"page_layout\" : \"one_column\",\"price\" : 35.5,\"attribute_set_id\" : \"4\",\"short_description\" : \"Test short description\",\"sku\" : \"teste-oficial\",\"special_from_date\" : \"02/16/2012\",\"special_price\" : 11.199999999999999,\"special_to_date\" : \"03/17/2012\",\"status\" : 1,\"stock_data\" : { \"backorders\" : 1,\"enable_qty_increments\" : 0,\"is_in_stock\" : 0,\"is_qty_decimal\" : 0,\"manage_stock\" : 1,\"max_sale_qty\" : 1,\"min_qty\" : 1.5600000000000001,\"min_sale_qty\" : 1,\"notify_stock_qty\" : -50.990000000000002,\"qty\" : 1,\"use_config_manage_stock\" : 1,\"use_config_min_qty\" : 1,\"use_config_min_sale_qty\": 1,\"use_config_max_sale_qty\" : 1,\"use_config_backorders\": 1,\"use_config_enable_qty_inc\":1,\"use_config_notify_stock_qty\":1 },\"tax_class_id\" : \"2\",\"type_id\" : \"simple\",\"use_config_gift_message_available\" : 0,\"visibility\" : \"4\",\"weight\" : 125}";
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/products/"+codigoProdutoMagento+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    public static void excluirProduto() {
    	String skuProduto = "teste-oficial";
    	OAuthRequest request = new OAuthRequest(Verb.DELETE, MagentoConectar.REST_API_URL + "/products/"+skuProduto+"?type=rest");
    	MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void associarProdutoWebsite() {
    	Integer websiteId = 1;
    	String jsonString = "{\"website_id\" : \""+websiteId+"\"}";
    	OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/products/16/websites?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			System.out.println(response.getBody());
		} else {
			System.out.println("Associação efetuada com sucesso.");
		}
    }
    
    private static void cadastrarOpcaoAtributo() {
    	String cor = "Azul";
    	String jsonString = "{\"value\" : \""+cor+"\"}";
    	OAuthRequest request = new OAuthRequest(Verb.POST, MagentoConectar.REST_API_URL + "/integrador/atributo/color/opcoes?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			System.out.println(response.getBody());
		} else {
			System.out.println("Cadastro efetuado com sucesso.");
		}
    }
    
    private static void atualizarPedido() {
    	String codigoPedidoERP = "12500";
    	String jsonString = "{\"codigo_orcamento\" : \""+codigoPedidoERP+"\"}";
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/integrador/pedido/100000002?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().equals("")) {
			System.out.println(response.getBody());
		} else {
			System.out.println("Pedido atualizado com sucesso.");
		}
    }
    
    private static void atualizarEstoque() {
    	String codigoEstoqueMagento = "1";
    	String jsonString = "{\"qty\" : 12,\"is_in_stock\" : 1}";
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/stockitems/"+codigoEstoqueMagento+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void vincularProdutos() {
    	String produtoUpdated = "127118";
    	String skuConfigurable = "127117;127118;127122;127123;";
    	String skuSplit[] = skuConfigurable.split(";");
    	String jsonString = "{\"product_updated\" : \"c-"+produtoUpdated+"\", \"associated_skus\" : [";
    	int count = 0;
    	for (String skuSimple : skuSplit) {
			jsonString += "\"c-"+skuSimple+"\"";
			count++;
			if(skuSplit.length == count) {
				jsonString += "],";
			} else {
				jsonString += ",";
			}
		}
    	jsonString += "\"price_changes\" : {\"volume\" : {\"600ml\" : 4.49}}}";
    	System.out.println(jsonString);
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/integrador/produto/"+skuConfigurable+"/configurable?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void consultarEstoques() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/stockitems?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void consultarEstoquesPorProduto() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/c-127117/estoque?type=rest"); // Funciona por ID ou por SKU a consulta.
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		if(!response.getBody().contains("\"code\":404")) {
			System.out.println(response.getBody());
		}
    }
    
    private static void consultarProduto() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/products/127134;127135;127136;?type=rest"); // Funciona por ID ou por SKU a consulta.
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		//jsonToJavaObject(response.getBody());
		System.out.println(response.getBody());
    }
    
    private static void consultarAtributo() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/atributo/140?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarAtributos() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/atributos?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarCodigoPorSku() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/123;/configurable?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarAtributosProdutoConfigurable() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/3/configurable/atributos?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarOpcoesAtributo() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/atributo/color/opcoes?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarOpcaoAtributo() {
    	String escapedText = StringEscapeUtils.escapeHtml4("Nº 1").replace(" ", "%20");
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/atributo/size/opcao/"+escapedText+"?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void consultarProdutoPedidosPendentes() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/produto/c-127117/pedidos/quantidade?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		Integer quantidadePendente = Integer.valueOf(response.getBody());
		System.out.println(quantidadePendente);
    }
    
    private static void consultarPedidos() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/integrador/pedido/situacao/processing?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper();
		Map<Integer, MagentoOrder> orderMap = new HashMap<Integer, MagentoOrder>();
		List<MagentoOrder> magentoOrderLista = jsonObjectHelper.magentoOrderListConvertjsonToJavaObject(response.getBody());
		for (MagentoOrder magentoOrder : magentoOrderLista) {
			
			
			if(magentoOrder != null) {
				if(magentoOrder.getCustomerNote() == null) {
					if(magentoOrder.getEntityId() != null) {
						orderMap.put(magentoOrder.getEntityId(), magentoOrder);
					}
					if(magentoOrder.getAddresses() != null) {
						for (MagentoOrderAddress magentoOrderAddress : magentoOrder.getAddresses()) {
							if(magentoOrderAddress.getAddressType().equals("billing")) {
								MagentoOrder magentoOrderInAddress = orderMap.get(magentoOrderAddress.getParentId());
								if(magentoOrderInAddress != null) {
									System.out.println(magentoOrderInAddress.getEntityId());
									String[] endereco = magentoOrderAddress.getStreet().split("\n");
									String logradouro = endereco[0];
									String numero = endereco[1];
									String complemento = null;
									String bairro = null;
									String ddd = magentoOrderAddress.getTelephone().substring(1, 3);
									String telefone = magentoOrderAddress.getTelephone().substring(5);
									String cep = magentoOrderAddress.getPostcode().substring(0, 5)+"-"+magentoOrderAddress.getPostcode().substring(5);
									if(endereco.length == 4) {
										complemento = endereco[2];
										bairro = endereco[3];
									} else if(endereco.length == 3) {
										bairro = endereco[2];
									}
									System.out.println(logradouro+" "+numero+" "+complemento+" "+bairro+" "+cep);
									System.out.println(ddd+" "+telefone);
									System.out.println(magentoOrderAddress.getAddressType()+" - "+magentoOrderAddress.getCity());
								}
							}
						}
					}
					if(magentoOrder.getOrderItems() != null) {
						for (MagentoOrderItem magentoOrderItem : magentoOrder.getOrderItems()) {
							if(magentoOrderItem.getParentItemId() == null) {
								MagentoOrder magentoOrderInItem = orderMap.get(magentoOrderItem.getOrderId());
								if(magentoOrderInItem != null) {
									System.out.println(magentoOrderItem.getName());
								}
							}
						}
					}
				}
			}
		}
		System.out.println(response.getBody());
    }
    
    private static void consultarCliente() {
    	OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/customers/3?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		System.out.println(response.getBody());
    }
    
    private static void atualizarCliente() {
    	String codigoClienteMagento = "1";
    	String jsonString = "{\"suffix\" : 123}";
    	OAuthRequest request = new OAuthRequest(Verb.PUT, MagentoConectar.REST_API_URL + "/customers/"+codigoClienteMagento+"?type=rest");
    	request.addHeader("Content-Type", "application/json");
    	request.addPayload(jsonString);
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
    
    private static void carregarProdutoERP() {
        InterfaceDAO<Produto> produtoDAO = new HibernateDAO<Produto>(Produto.class);
		Produto produto = produtoDAO.getBean(1);
		System.out.println(produto);
    }
    
    private static void contarEstoqueProdutoERP() {
    	InterfaceDAO<Estoque> estoqueDAO = new HibernateDAO<Estoque>(Estoque.class);
    	Integer estoqueQuantidade = estoqueDAO.somarEstoque(127478);
    	System.out.println(estoqueQuantidade);
    }
    
    private static void carregarOrcamentoERP() {
    	InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
    	Orcamento orcamento = orcamentoDAO.getBean(94438);
    	System.out.println(orcamento);
    }
    
    private static void salvarOrcamentoERP() {
    	Orcamento orcamento = new Orcamento();
    	//orcamento.setCodigoCliente(0);
    	// TODO: Preencher todos os campos.
    	

    	InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
    	Orcamento ultimoOrcamento = orcamentoDAO.getBeanByUltimoCodigo();
    	Integer codigoOrcamento = (int)(ultimoOrcamento.getCodigo() + 1);
    	orcamento.setCodigo(codigoOrcamento.doubleValue());
    	orcamentoDAO.salvar(orcamento);
    	
    	// TODO: Preencher todos os campos do VendaItem
    }
    
    private static void carregarUltimoCodigoOrcamentoERP() {
    	InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
    	Orcamento orcamento = orcamentoDAO.getBeanByUltimoCodigo();
    	System.out.println(orcamento.getCodigo()+1);
    }
    
    private static void buscarCodigoCidade() {
    	String nomeCidade = Normalizer.normalize("Gália", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    	InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class);
    	Cidade cidade = cidadeDAO.getBeanByParametro("cidade", nomeCidade);
    	System.out.println(cidade.getCodigo());
    }
    
    private static void gerarLog() {
    	LogHelper logHelper = new LogHelper();
    	logHelper.getLogger();
    	LogHelper.LOGGER.severe("Mensagem Grave");
    	LogHelper.LOGGER.warning("Mensagem Alerta");
    	LogHelper.LOGGER.info("Mensagem Informativa");
    }
    
    private static void javaObjectToJson() {
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	MagentoProduct magentoProduct = new MagentoProduct();
        	magentoProduct.setEntityId(1);
        	magentoProduct.setTypeId("simple");
        	magentoProduct.setAttributeSetId(2);
        	magentoProduct.setSku("123");
        	magentoProduct.setName("teste");
			String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(magentoProduct);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    private static void jsonToJavaObject(String jsonMagentoProduct) {
    	try {
        	ObjectMapper objectMapper = new ObjectMapper();
			MagentoProduct magentoProduct = objectMapper.readValue(jsonMagentoProduct, MagentoProduct.class);
			System.out.println(magentoProduct.getName());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
