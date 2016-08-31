package br.com.iterator.model.command;

import br.com.iterator.model.helper.EstoqueHelper;

public class EstoqueCommand {

	public boolean atualizar(String codigo) {
		// Atualiza o estoque do produto no Magento a partir do SKU que é o código do produto no ERP
		EstoqueHelper estoqueHelper = new EstoqueHelper();
		estoqueHelper.atualizarMagento(Integer.valueOf(codigo));
		return true;
	}
}
