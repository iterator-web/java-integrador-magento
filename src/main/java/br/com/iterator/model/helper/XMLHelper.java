package br.com.iterator.model.helper;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.iterator.model.bean.Configs;

public class XMLHelper {
	
	private String caminho = "c:\\Trabalho\\configs.xml";;

	public Configs getValorNode() {
		Configs configs = new Configs();
		Document doc = this.getDocument();
		NodeList listaConfigs = this.getConfiguracoes(doc);
		for(int i = 0; i < listaConfigs.getLength(); i++) {
			Node nodeItem = listaConfigs.item(i);
			if(nodeItem.getNodeName().equals("base_url")) {
				configs.setBaseUrl(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("request_token_endpoint")) {
				configs.setRequestTokenEndpoint(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("access_token_endpoint")) {
				configs.setAccessTokenEndpoint(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("authorization_url")) {
				configs.setAuthorizationUrl(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("api_key")) {
				configs.setApiKey(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("api_secret")) {
				configs.setApiSecret(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("rest_api_url")) {
				configs.setRestApiUrl(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("admin_user")) {
				configs.setAdminUser(nodeItem.getTextContent());
			} else if(nodeItem.getNodeName().equals("admin_password")) {
				configs.setAdminPassword(EncriptBlowFish.decript(nodeItem.getTextContent()).toCharArray());
			}
		}
		return configs;
	}
	
	
	public void setValorNode(Configs configs) {
		Document doc = this.getDocument();
		NodeList listaConfigs = this.getConfiguracoes(doc);
		for(int i = 0; i < listaConfigs.getLength(); i++) {
			Node nodeItem = listaConfigs.item(i);
			if(nodeItem.getNodeName().equals("base_url")) {
				nodeItem.setTextContent(configs.getBaseUrl());
			} else if(nodeItem.getNodeName().equals("request_token_endpoint")) {
				nodeItem.setTextContent(configs.getRequestTokenEndpoint());
			} else if(nodeItem.getNodeName().equals("access_token_endpoint")) {
				nodeItem.setTextContent(configs.getAccessTokenEndpoint());
			} else if(nodeItem.getNodeName().equals("authorization_url")) {
				nodeItem.setTextContent(configs.getAuthorizationUrl());
			} else if(nodeItem.getNodeName().equals("api_key")) {
				nodeItem.setTextContent(configs.getApiKey());
			} else if(nodeItem.getNodeName().equals("api_secret")) {
				nodeItem.setTextContent(configs.getApiSecret());
			} else if(nodeItem.getNodeName().equals("rest_api_url")) {
				nodeItem.setTextContent(configs.getRestApiUrl());
			} else if(nodeItem.getNodeName().equals("admin_user")) {
				nodeItem.setTextContent(configs.getAdminUser());
			} else if(nodeItem.getNodeName().equals("admin_password")) {
				nodeItem.setTextContent(String.valueOf(EncriptBlowFish.cript(String.valueOf(configs.getAdminPassword()))));
			}
		}
		
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(this.caminho));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	private NodeList getConfiguracoes(Document doc) {
		NodeList listaConfigs = null;
		doc.getDocumentElement().normalize();
		Node configsTag = doc.getElementsByTagName("configs").item(0);
		listaConfigs = configsTag.getChildNodes();
		
		return listaConfigs;
	}
	
	private Document getDocument() {
		Document doc = null;
		try {
			File xmlFile = new File(this.caminho);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(xmlFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return doc;
	}
}
