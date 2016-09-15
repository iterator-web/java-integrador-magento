package br.com.iterator.model.command;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.iterator.model.bean.magento.MagentoCustomer;
import br.com.iterator.model.bean.magento.MagentoOrder;
import br.com.iterator.model.bean.magento.MagentoOrderAddress;
import br.com.iterator.model.bean.magento.MagentoOrderItem;
import br.com.iterator.model.bean.petcenterjau.Cidade;
import br.com.iterator.model.bean.petcenterjau.MagentoFilaIntegracao;
import br.com.iterator.model.bean.petcenterjau.Orcamento;
import br.com.iterator.model.bean.petcenterjau.OrcamentoItem;
import br.com.iterator.model.bean.petcenterjau.Pessoa;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.rest.ClienteREST;
import br.com.iterator.model.rest.PedidoREST;

/*
 * Ficou definido que o status pelo qual os pedidos serão buscados no Magento, pois se encontram aptos a serem integrados no ERP é "Processing". 
 * O campo "customer_note" deverá ser o responsável por receber o código do orçamento que foi criado no ERP.
 * O campo "ext_order_id" deverá ser o responsável por receber a informação se o oraçamento já foi transformado em venda no ERP.
 * Os clientes serão integrados somente quando houverem pedidos.
 */
public class PedidoCommand {
	Map<Integer, MagentoOrder> orderMap = new HashMap<Integer, MagentoOrder>();
	Map<Integer, Integer> clienteMap = new HashMap<Integer, Integer>();
	Map<Integer, Double> orcamentoMap = new HashMap<Integer, Double>();

	public boolean checar() {
		boolean resultado = true;
		// Busca os pedidos que estejam no Magento com status Processing, mas que ainda não tenham sido integrados ao ERP.
		PedidoREST pedidoREST = new PedidoREST();
		List<MagentoOrder> magentoOrderLista = pedidoREST.listar();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Percorre os pedidos encontrados.
		for (MagentoOrder magentoOrder : magentoOrderLista) {
			if(magentoOrder != null) {
				// Verifica se o pedido do Magento já foi criado como orçamento no ERP.
				if(magentoOrder.getCustomerNote() == null) {
					if(magentoOrder.getEntityId() != null) {
						// Armazena os MagentoOrder com o ID da order como índice. Necessário pela forma como a API retorna as informações separadas.
						orderMap.put(magentoOrder.getEntityId(), magentoOrder);
					}
					// Caso não tenha sido criado como orçamento no ERP. Executa os procedimentos referentes ao cliente do pedido.
					this.checarCliente(magentoOrder);
					// Preenche os campos referentes ao orçamento e endereço.
					if(magentoOrder.getAddresses() != null) {
						for (MagentoOrderAddress magentoOrderAddress : magentoOrder.getAddresses()) {
							if(magentoOrderAddress.getAddressType().equals("shipping")) {
								try {
									MagentoOrder magentoOrderInAddress = orderMap.get(magentoOrderAddress.getParentId());
									if(magentoOrderInAddress != null) {
										Integer clienteCodigoPersistir = clienteMap.get(magentoOrderAddress.getParentId());
										InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class);
										Pessoa pessoa = pessoaDAO.getBean(clienteCodigoPersistir);
										String[] endereco = magentoOrderAddress.getStreet().split("\n");
										String logradouro = endereco[0];
										String numero = endereco[1];
										String bairro = null;
										String ddd = magentoOrderAddress.getTelephone().substring(1, 3);
										String telefone = magentoOrderAddress.getTelephone().substring(5);
										Integer codigoCidade = this.buscarCodigoCidade(magentoOrderAddress.getCity());
										if(endereco.length == 4) {
											bairro = endereco[3];
										} else if(endereco.length == 3) {
											bairro = endereco[2];
										}
										Orcamento orcamento = new Orcamento();
										// Preencher os campos do orçamento.
										orcamento.setData(formatter.parse(magentoOrderInAddress.getCreatedAt()));
										orcamento.setCodigoCliente(clienteCodigoPersistir.doubleValue());
										orcamento.setNomeCliente(pessoa.getNome());
										orcamento.setFoneCliente(ddd+" "+telefone);
										orcamento.setObservacao(magentoOrderInAddress.getIncrementId());
										orcamento.setValorTotal(magentoOrderInAddress.getGrandTotal());
										orcamento.setTotalProdutos(magentoOrderInAddress.getSubtotal() + magentoOrderInAddress.getDiscountAmount());
										orcamento.setFrete(magentoOrderInAddress.getShippingAmount());
										// Início dos valores padrões do ERP.
										orcamento.setVendedor(1.00);
										orcamento.setDesconto(0.00);
										orcamento.setDescontoP(0.00);
										orcamento.setSituacao(4.00);
										orcamento.setDataSituacao(formatter.parse(magentoOrderInAddress.getCreatedAt()));
										orcamento.setOperador(1);
										// Fim dos valores padrões do ERP.
										orcamento.setEnderecoCliente(logradouro+" "+numero);
										orcamento.setBairroCliente(bairro);
										orcamento.setCidadeCliente(codigoCidade);
										orcamento.setContaCorrente("1");
										orcamento.setEmpresa(11);
										orcamento.setPrimeiroOperador(1);
										// Busca o último código de orçamento registrado no ERP e incrementa 1 para o novo registro.
										InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
										Orcamento orcamentoUltimoRegistro = orcamentoDAO.getBeanByUltimoCodigo();
										Double codigoOrcamento = orcamentoUltimoRegistro.getCodigo() + 1;
										// Salva o cliente no ERP.
										orcamento.setCodigo(codigoOrcamento);
										orcamentoDAO.salvar(orcamento);
										// Adiciona o código do orçamento registrado no ERP, ao campo customer_note do pedido no Magento para definir que aquele pedido já foi registrado no ERP.
										pedidoREST.atualizar("orcamento", codigoOrcamento.intValue(), magentoOrderInAddress.getIncrementId());
										// Adiciona o código do orçamento ao Map de orçamentos que será utilizado pelos itens do orçamento.
										orcamentoMap.put(magentoOrderInAddress.getEntityId(), codigoOrcamento);
									}
								} catch (ParseException e) {
									e.printStackTrace();
									LogHelper.LOGGER.severe(e.getMessage());
								}
							}
						}
					}
					// Preenche os campos referentes aos produtos.
					if(magentoOrder.getOrderItems() != null) {
						Integer itemPosicao = 1;
						for (MagentoOrderItem magentoOrderItem : magentoOrder.getOrderItems()) {
							if(magentoOrderItem.getParentItemId() == null) {
								MagentoOrder magentoOrderInItem = orderMap.get(magentoOrderItem.getOrderId());
								if(magentoOrderInItem != null) {
									Double orcamentoCodigo = orcamentoMap.get(magentoOrderItem.getOrderId());
									InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
									Orcamento orcamento = orcamentoDAO.getBean(orcamentoCodigo);
									// Preenche os campos dos itens do orçamento.
									OrcamentoItem orcamentoItem = new OrcamentoItem();
									orcamentoItem.setOrcamento(orcamento);
									orcamentoItem.setProduto(Double.parseDouble(magentoOrderItem.getSku().substring(2)));
									orcamentoItem.setQuantidade(magentoOrderItem.getQtyOrdered());
									orcamentoItem.setValor(magentoOrderItem.getPrice() - (magentoOrderItem.getDiscountAmount() / magentoOrderItem.getQtyOrdered()));
									orcamentoItem.setValorTotal(magentoOrderItem.getBaseRowTotal() - magentoOrderItem.getDiscountAmount());
									orcamentoItem.setSubtotal(magentoOrderItem.getBaseRowTotal() - magentoOrderItem.getDiscountAmount());
									orcamentoItem.setNomeProduto(magentoOrderItem.getName());
									orcamentoItem.setItem(itemPosicao);
									// Busca o último código de orçamento registrado no ERP e incrementa 1 para o novo registro.
									InterfaceDAO<OrcamentoItem> orcamentoItemDAO = new HibernateDAO<OrcamentoItem>(OrcamentoItem.class);
									// Salva o cliente no ERP.
									orcamentoItemDAO.salvar(orcamentoItem);
									itemPosicao++;
								}
							}
						}
					}
				} else {
					// Caso já tenha sido criado como orçamento no ERP. Verifica se o orçamento já foi transformado em venda no ERP.
					if(magentoOrder.getExtOrderId() == null) {
						// Caso não tenha sido transformado em venda no ERP, busca o pedido do Magento a partir de seu increment_id referenciado no campo Observacao da tabela Orcamento do ERP.
						InterfaceDAO<Orcamento> orcamentoDAO = new HibernateDAO<Orcamento>(Orcamento.class);
						Orcamento orcamento = orcamentoDAO.getBeanByParametro("observacao", magentoOrder.getIncrementId());
						// Caso o campo Venda esteja preenchido.
						if(orcamento.getVenda() != null) {
							// Atualiza o campo ext_order_id do Magento com o código da venda no ERP, indicando que o orçamento já foi transformado em venda no ERP.
							pedidoREST.atualizar("venda", orcamento.getVenda().intValue(), magentoOrder.getIncrementId());
							// Busca todos os produtos relacionados ao Orçamento convertido em venda e adiciona na fila de integração para atualização de estoques no site.
							InterfaceDAO<OrcamentoItem> orcamentoItemDAO = new HibernateDAO<OrcamentoItem>(OrcamentoItem.class);
							List<OrcamentoItem> orcamentoItemLista = orcamentoItemDAO.getItensByOrcamento(orcamento);
							InterfaceDAO<MagentoFilaIntegracao> magentoFilaIntegracaoDAO = new HibernateDAO<MagentoFilaIntegracao>(MagentoFilaIntegracao.class);
							for (OrcamentoItem orcamentoItem : orcamentoItemLista) {
								MagentoFilaIntegracao magentoFilaIntegracao = new MagentoFilaIntegracao();
								magentoFilaIntegracao.setTabela("Estoque");
								magentoFilaIntegracao.setChave(String.valueOf(orcamentoItem.getProduto().intValue()));
								magentoFilaIntegracao.setOperacao("U");
								magentoFilaIntegracao.setHorario(new Date());
								magentoFilaIntegracaoDAO.salvar(magentoFilaIntegracao);
							}
						}
						// Caso o campo Venda não esteja preenchido, não faz nenhuma ação e encerra o processo.
					}
				}
			}
		}
		return resultado;
	}
	
	private void checarCliente(MagentoOrder magentoOrder) {
		Integer codigoCliente = null;
		SimpleDateFormat formatterDob = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatterTimeZone = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		ClienteREST clienteREST = new ClienteREST();
		try {
			if(magentoOrder.getAddresses() != null) {
				for (MagentoOrderAddress magentoOrderAddress : magentoOrder.getAddresses()) {
					if(magentoOrderAddress.getAddressType().equals("billing")) {
						// Percorre as informações de endereços e clientes.
						MagentoOrder magentoOrderInAddress = orderMap.get(magentoOrderAddress.getParentId());
						if(magentoOrderInAddress != null) {
							MagentoCustomer magentoCustomer = clienteREST.carregar(magentoOrderInAddress.getCustomerId());
							Pessoa pessoa = new Pessoa();
							// Preenche os campos.
							pessoa.setNome(magentoCustomer.getFirstname()+" "+magentoCustomer.getLastname());
							pessoa.setDataNasc(formatterDob.parse(magentoCustomer.getDob()));
							pessoa.setRg(magentoCustomer.getIe());
							pessoa.setUsuario(1);
							pessoa.setDataCarga(formatterTimeZone.parse(magentoCustomer.getCreatedAt()));
							pessoa.setDataCadastro(formatterTimeZone.parse(magentoCustomer.getCreatedAt()));
							pessoa.setDataAlteracao(formatterTimeZone.parse(magentoCustomer.getCreatedAt()));
							// Início dos valores padrões do ERP.
							pessoa.setInativo("N");
							pessoa.setVenderPrecoCusto("N");
							pessoa.setBloquearCreadiario("N");
							pessoa.setVenderTaxaGrupo("N");
							pessoa.setContaParticular("N");
							pessoa.setDuplicata("N");
							pessoa.setImpagavel("N");
							pessoa.setBloquearVendaCheque("N");
							pessoa.setBloquearConsignacao("N");
							pessoa.setFretePadrao(3.00);
							pessoa.setBloquearVenderOrcamento("N");
							pessoa.setExibirObservacao("N");
							pessoa.setBloquearVendaDinheiro("N");
							pessoa.setBloquearVendaSemKm("N");
							pessoa.setEmpresaOrigem(11);
							pessoa.setBloquearTicekt("N");
							pessoa.setBloquearCartao("N");
							pessoa.setContribuinteIcms("N");
							pessoa.setEmailsPromocionais("N");
							// Fim dos valores padrões do ERP.
							pessoa.setCpf(magentoCustomer.getTaxvat());
							if(magentoCustomer.getGender() == 1) {
								pessoa.setSexo("M");
							} else {
								pessoa.setSexo("F");
							}
							if(magentoCustomer.getTaxvat().length() <= 14) {
								pessoa.setTipo("F");
								pessoa.setTipoContaCorrente("F");
							} else {
								pessoa.setTipo("J");
								pessoa.setTipoContaCorrente("J");
							}
							String[] endereco = magentoOrderAddress.getStreet().split("\n");
							String logradouro = endereco[0];
							String numero = endereco[1];
							String complemento = null;
							String bairro = null;
							String ddd = magentoOrderAddress.getTelephone().substring(1, 3);
							String telefone = magentoOrderAddress.getTelephone().substring(5);
							String cep = magentoOrderAddress.getPostcode().substring(0, 5)+"-"+magentoOrderAddress.getPostcode().substring(5);
							Integer codigoCidade = this.buscarCodigoCidade(magentoOrderAddress.getCity());
							if(endereco.length == 4) {
								complemento = endereco[2];
								bairro = endereco[3];
							} else if(endereco.length == 3) {
								bairro = endereco[2];
							}
							pessoa.setEnderecoNome(logradouro);
							pessoa.setDdd1(ddd);
							pessoa.setFoneNumero(telefone);
							pessoa.setNumero(numero);
							pessoa.setCidade(codigoCidade);
							pessoa.setBairro(bairro);
							pessoa.setCep(cep);
							pessoa.setEmail(magentoCustomer.getEmail()+"; anderson.fiscal@girocontabil.com.br");
							pessoa.setComplemento(complemento);
							// Verifica através do campo suffix, se o cliente do Magento já foi cadastrado no ERP.
							if(magentoCustomer.getSuffix() != null) {
								// Caso seja um cliente já cadastrado no ERP. Preenche o campo Codigo com o valor referenciado no Magento no campo Suffix.
								codigoCliente = Integer.valueOf(magentoCustomer.getSuffix());
								pessoa.setCodigo(codigoCliente);
								// Atualiza o cliente no ERP.
								InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class);
								pessoaDAO.atualizar(pessoa);
							} else {
								// Caso seja um cliente ainda não cadastrado no ERP. Busca o último código de cliente registrado no ERP e incrementa 1 para o novo registro.
								InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class);
								Pessoa pessoaUltimoRegistro = pessoaDAO.getBeanByUltimoCodigo();
								codigoCliente = pessoaUltimoRegistro.getCodigo() + 1;
								// Salva o cliente no ERP.
								pessoa.setCodigo(codigoCliente);
								pessoaDAO.salvar(pessoa);
								// Adiciona o código do cliente registrado no ERP, ao campo suffix do cliente no Magento para definir que aquele cliente já foi registrado no ERP.
								magentoCustomer.setSuffix(String.valueOf(codigoCliente));
								clienteREST.atualizar(magentoCustomer);
							}
							// Adiciona o código do cliente ao Map de clientes que será utilizado pelos orçamentos.
							clienteMap.put(magentoOrderInAddress.getEntityId(), codigoCliente);
						}
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
	}
	
	private Integer buscarCodigoCidade(String cidadeString) {
    	String nomeCidade = Normalizer.normalize(cidadeString, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    	InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class);
    	Cidade cidade = cidadeDAO.getBeanByParametro("cidade", nomeCidade);
    	return cidade.getCodigo();
    }
}
