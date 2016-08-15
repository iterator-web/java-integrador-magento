package br.com.iterator.view;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.iterator.controller.IntegracaoController;
import br.com.iterator.model.helper.LogHelper;

public class Timer extends Thread {
	private JTextField field;
    private boolean integracao;
                                                                                
    public Timer(JTextField field) {
            this.field = field;
    }
  
	public void run() {
		while(true) {
			field.setText("Integrando Dados...");
			SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						try {
							IntegracaoController integracaoController = new IntegracaoController();
							integracao = ((IntegracaoController) integracaoController).integrar();
							if(integracao) {
								field.setText("Dados Integrados com Sucesso!");
							} else {
								field.setText("Falha na Integração dos Dados!");
							}						
						} catch(Exception e) {
							e.printStackTrace();
							LogHelper.LOGGER.severe(e.getMessage());
						}
					}
				}
			);
			try { 
				Thread.sleep(10000); 
			} catch(InterruptedException e) {
				e.printStackTrace();
				LogHelper.LOGGER.severe(e.getMessage());
			}			
		}
	}
}
