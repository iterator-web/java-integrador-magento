package br.com.iterator.model.command;

import java.util.List;

import br.com.iterator.model.bean.petcenterjau.MagentoFilaIntegracao;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;

public class MagentoFilaIntegracaoCommand {

	/**
     * Lista os itens que serão integrados
     *
     * @return Array
     */
	public List<MagentoFilaIntegracao> listar() {
		InterfaceDAO<MagentoFilaIntegracao> magentoFilaIntegracaoDAO = new HibernateDAO<MagentoFilaIntegracao>(MagentoFilaIntegracao.class);
		List<MagentoFilaIntegracao> magentoFilaIntegracaoLista = magentoFilaIntegracaoDAO.getBeansMaxResults(30);
		return magentoFilaIntegracaoLista;
	}
	
	/**
     * Envia o código do item para ser excluído da Fila de Integração
     *
     * @param Integer codigo
     */
	public void excluir(Integer codigo) {
		InterfaceDAO<MagentoFilaIntegracao> magentoFilaIntegracaoDAO = new HibernateDAO<MagentoFilaIntegracao>(MagentoFilaIntegracao.class);
		MagentoFilaIntegracao magentoFilaIntegracao = magentoFilaIntegracaoDAO.getBean(codigo);
		magentoFilaIntegracaoDAO.excluir(magentoFilaIntegracao);
	}
}
