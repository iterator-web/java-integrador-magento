package br.com.iterator.controller;

import java.util.List;

import br.com.iterator.model.bean.petcenterjau.MagentoFilaIntegracao;
import br.com.iterator.model.command.EstoqueCommand;
import br.com.iterator.model.command.MagentoFilaIntegracaoCommand;
import br.com.iterator.model.command.PedidoCommand;
import br.com.iterator.model.command.ProdutoCommand;
import br.com.iterator.model.util.MagentoConectar;

public class IntegracaoController {

	public boolean integrar() {
		boolean resultado = true;
		// Conecta-se ao WS.
		MagentoConectar magentoConectar = new MagentoConectar();
        magentoConectar.estabelecerConexao();
        // Busca os itens contidos na fila de integração do PetCenter.
        MagentoFilaIntegracaoCommand magentoFilaIntegracaoCommand = new MagentoFilaIntegracaoCommand();
        List<MagentoFilaIntegracao> magentoFilaIntegracaoLista = magentoFilaIntegracaoCommand.listar();
        if(magentoFilaIntegracaoLista != null) {
        	resultado = this.enviar(magentoFilaIntegracaoLista);
        }
        // Busca os pedidos contidos no Magento que precisam ser integrados no ERP.
        resultado = this.receber();
        
        return resultado;
	}
	
	private boolean enviar(List<MagentoFilaIntegracao> magentoFilaIntegracaoLista) {
		boolean resultado = true;
		// Percorre a fila de integração.
		for(MagentoFilaIntegracao magentoFilaIntegracao : magentoFilaIntegracaoLista) {
			Integer codigo = magentoFilaIntegracao.getCodigo();
			String tabela = magentoFilaIntegracao.getTabela();
			String chave = magentoFilaIntegracao.getChave();
			String operacao = magentoFilaIntegracao.getOperacao();
			// Toma as decisões de acordo com a tabela e operação a ser realizada.
			if(tabela.equals("Produto")) {
				ProdutoCommand produtoCommand = new ProdutoCommand();
				if(operacao.equals("I")) {
					resultado = produtoCommand.checar(chave, operacao);
				} else if(operacao.equals("U")) {
					resultado = produtoCommand.checar(chave, operacao);
				} else if(operacao.equals("D")) {
					resultado = produtoCommand.excluir(chave);
				}
			} else if(tabela.equals("Estoque")) {
				EstoqueCommand estoqueCommand = new EstoqueCommand();
				if(operacao.equals("I")) {
					estoqueCommand.atualizar(chave);
				} else if(operacao.equals("U")) {
					estoqueCommand.atualizar(chave);
				} else if(operacao.equals("D")) {
					estoqueCommand.atualizar(chave);
				}
			}
			// Exclui o item da fila de integração caso tenha ocorrido tudo certo.
			if(resultado) {
				MagentoFilaIntegracaoCommand magentoFilaIntegracaoCommand = new MagentoFilaIntegracaoCommand();
				magentoFilaIntegracaoCommand.excluir(codigo);
			}
		}
		
		return resultado;
	}
	
	private boolean receber() {
		boolean resultado = true;
		PedidoCommand pedidoCommand = new PedidoCommand();
		resultado = pedidoCommand.checar();
		
		return resultado;
	}
}
