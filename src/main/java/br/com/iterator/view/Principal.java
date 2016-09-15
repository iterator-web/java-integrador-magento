package br.com.iterator.view;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.iterator.model.bean.petcenterjau.Configs;
import br.com.iterator.model.bean.petcenterjau.MagentoFilaIntegracao;
import br.com.iterator.model.bean.petcenterjau.Produto;
import br.com.iterator.model.dao.HibernateDAO;
import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.helper.JPanelWithBackground;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.helper.XMLHelper;

public class Principal {
	
	private static PopupMenu createPopupMenu() {
		PopupMenu menu = new PopupMenu();
		final MenuItem exit = new MenuItem("Sair");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel myPanel = new JPanel(new GridLayout(2,1));
				JTextField loginField = new JTextField(10);
				JPasswordField senhaField = new JPasswordField(10);  
				myPanel.add(new JLabel("Login:"));
				myPanel.add(loginField);
				myPanel.add(new JLabel("Senha:"));
				myPanel.add(senhaField);
				
				int action = JOptionPane.showConfirmDialog(null, myPanel, "Digite login e senha para sair:",
			    		JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);  
				if(action == JOptionPane.OK_OPTION) {
					if(new String(loginField.getText()).equals("pet_center_jau") && new String(senhaField.getPassword()).equals("*!Pet@Center2016")) {
						System.exit(0);
					}
				}
			}
		});
		final MenuItem config = new MenuItem("Configurações");
		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XMLHelper xmlHelper = new XMLHelper();
				Configs configs = xmlHelper.getValorNode();
				JPanel myPanel = new JPanel(new GridLayout(10,2));
				JTextField baseUrlField = new JTextField(20);
				baseUrlField.setText(configs.getBaseUrl());
				JTextField requestTokenEndpointField = new JTextField(20);
				requestTokenEndpointField.setText(configs.getRequestTokenEndpoint());
				JTextField accessTokenEndpointField = new JTextField(20);
				accessTokenEndpointField.setText(configs.getAccessTokenEndpoint());
				JTextField authorizationUrlField = new JTextField(20);
				authorizationUrlField.setText(configs.getAuthorizationUrl());
				JTextField apiKeyField = new JTextField(20);
				apiKeyField.setText(configs.getApiKey());
				JTextField apiSecretField = new JTextField(20);
				apiSecretField.setText(configs.getApiSecret());
				JTextField restApiUrlField = new JTextField(20);
				restApiUrlField.setText(configs.getRestApiUrl());
				JTextField adminUserField = new JTextField(20);
				adminUserField.setText(configs.getAdminUser());
				JPasswordField adminPasswordField = new JPasswordField();
				adminPasswordField.setText(String.valueOf(configs.getAdminPassword()));
				JCheckBox integrarCheck = new JCheckBox("Integrar Tudo");
				myPanel.add(new JLabel("Base URL:"));
				myPanel.add(baseUrlField);
				myPanel.add(new JLabel("Request Token Endpoint:"));
				myPanel.add(requestTokenEndpointField);
				myPanel.add(new JLabel("Access Token Endpoint:"));
				myPanel.add(accessTokenEndpointField);
				myPanel.add(new JLabel("Authorization URL:"));
				myPanel.add(authorizationUrlField);
				myPanel.add(new JLabel("API Key:"));
				myPanel.add(apiKeyField);
				myPanel.add(new JLabel("API Secret:"));
				myPanel.add(apiSecretField);
				myPanel.add(new JLabel("REST API URL:"));
				myPanel.add(restApiUrlField);
				myPanel.add(new JLabel("Usuário Admin:"));
				myPanel.add(adminUserField);
				myPanel.add(new JLabel("Senha Admin:"));
				myPanel.add(adminPasswordField);
				myPanel.add(new JLabel("Fila de Integração:"));
				myPanel.add(integrarCheck);
				int action = JOptionPane.showConfirmDialog(null, myPanel, "Configurações:",
			    		JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);  
			    if(action == JOptionPane.OK_OPTION) {
			    	configs.setBaseUrl(baseUrlField.getText());
			    	configs.setRequestTokenEndpoint(requestTokenEndpointField.getText());
			    	configs.setAccessTokenEndpoint(accessTokenEndpointField.getText());
			    	configs.setAuthorizationUrl(authorizationUrlField.getText());
			    	configs.setApiKey(apiKeyField.getText());
			    	configs.setApiSecret(apiSecretField.getText());
			    	configs.setRestApiUrl(restApiUrlField.getText());
			    	configs.setAdminUser(adminUserField.getText());
			    	configs.setAdminPassword(adminPasswordField.getPassword());
			    	xmlHelper.setValorNode(configs);
			    	if(integrarCheck.isSelected() && !integrarCheck.getText().isEmpty()) {
			    		InterfaceDAO<Produto> produtoDAO = new HibernateDAO<Produto>(Produto.class);
			    		List<Produto> produtoList = produtoDAO.getBeans();
			    		InterfaceDAO<MagentoFilaIntegracao> magentoFilaIntegracaoDAO = new HibernateDAO<MagentoFilaIntegracao>(MagentoFilaIntegracao.class);
			    		for(Produto produto : produtoList) {
			    			MagentoFilaIntegracao magentoFilaIntegracao = new MagentoFilaIntegracao();
							magentoFilaIntegracao.setTabela("Produto");
							magentoFilaIntegracao.setChave(String.valueOf(produto.getCodigo()));
							magentoFilaIntegracao.setOperacao("U");
							magentoFilaIntegracao.setHorario(new Date());
							magentoFilaIntegracaoDAO.salvar(magentoFilaIntegracao);
			    		}
			    	}
			    }
			}
		});
		menu.add(config);
		menu.add(exit);		
		return menu;
	}
	
	public Principal() throws ClassNotFoundException, 
		InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, AWTException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		JPanelWithBackground background = new JPanelWithBackground("imagens/background-integrador.jpg");
		JTextField field = new JTextField();		
		final JFrame frame = new JFrame("Integrador Magento");
		
		frame.setSize(806, 620);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);		
		
		background.setLayout(null);
		background.setSize(800,600);
		background.add(field);
		
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setBounds(50, 530, 430, 25);
		field.setOpaque(false);
		Font font1 = new Font("SansSerif", Font.BOLD, 15);
		field.setFont(font1);
		
		frame.getContentPane().add(background);

    	LogHelper logHelper = new LogHelper();
    	logHelper.getLogger();
    	
		new Timer(field).start();
		Image image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagens/favicon.png"));
		TrayIcon icon = new TrayIcon(image, "Integrador Magento", createPopupMenu());
		icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
			}
		});

		SystemTray.getSystemTray().add(icon);
	}
	
	public static void main(String[] args) throws Exception {
		new Principal();
	}
}
