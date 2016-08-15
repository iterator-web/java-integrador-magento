package br.com.iterator.model.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import br.com.iterator.model.bean.petcenterjau.Configs;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.helper.XMLHelper;
import br.com.iterator.model.util.Magento17Api;

public class MagentoConectar {
	
	public static OAuthService SERVICE;
	public static Token TOKEN;
	public static String REST_API_URL;

	private Scanner in;
	private WebClient webClient;

	public Token getToken(Configs configs) {
		Token accessToken = null;
		try {
			OAuthService service = this.getService(configs);
			Token requestToken = service.getRequestToken();
			
			webClient = new WebClient();
			HtmlPage pageLegOne = webClient.getPage(service.getAuthorizationUrl(requestToken));
			final HtmlForm formLegOne = pageLegOne.getFirstByXPath("//*[@id = 'loginForm']");
			final HtmlButton buttonLegOne = formLegOne.getFirstByXPath("//*[@type='submit']");
			final HtmlTextInput loginField = formLegOne.getInputByName("login[username]");
			loginField.setValueAttribute(configs.getAdminUser());
			final HtmlPasswordInput passwordField = formLegOne.getInputByName("login[password]");
			passwordField.setValueAttribute(String.valueOf(configs.getAdminPassword()));
			final HtmlHiddenInput tokenHiddenField = formLegOne.getInputByName("oauth_token");
			tokenHiddenField.setValueAttribute(requestToken.getToken());
			final HtmlPage pageLegTwo = buttonLegOne.click();
			
			final HtmlForm formLegTwo = pageLegTwo.getFirstByXPath("//*[@id = 'oauth_authorize_confirm']");
			final HtmlButton buttonLegTwo = formLegTwo.getFirstByXPath("//*[@type='submit']");
			final HtmlHiddenInput tokenHiddenFieldLegTwo = formLegTwo.getInputByName("oauth_token");
			tokenHiddenFieldLegTwo.setValueAttribute(requestToken.getToken());
			final HtmlPage pageLegThree = buttonLegTwo.click();
			
			String verifierCode = getVerifierCode(pageLegThree.asText());
			
			System.setIn(new ByteArrayInputStream(verifierCode.getBytes()));
			this.in = new Scanner(System.in);
			Verifier verifier = new Verifier(in.nextLine());
			
			accessToken = service.getAccessToken(requestToken, verifier);
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
		
		return accessToken;
	}
	
	public OAuthService getService(Configs configs) {
		OAuthService service = new ServiceBuilder().provider(Magento17Api.class).apiKey(configs.getApiKey()).apiSecret(configs.getApiSecret()).build();
		return service;
	}

	public String getMagentoRestApiUrl(Configs configs) {
		return configs.getRestApiUrl();
	}
	
	public void estabelecerConexao() {
		XMLHelper xmlHelper = new XMLHelper();
		Configs configs = xmlHelper.getValorNode();
		MagentoConectar.SERVICE = this.getService(configs);
        MagentoConectar.TOKEN = this.getToken(configs);
        MagentoConectar.REST_API_URL = this.getMagentoRestApiUrl(configs);
	}
	
	private static String getVerifierCode(String retornoAuth) {
		Integer posicaoInicial = retornoAuth.indexOf("Código verificador:");
        Integer posicaoFinal = retornoAuth.indexOf("Magento é uma marca registrada de Magento Inc. Copyright © 2016 Magento Inc.");
        String verifierCode = retornoAuth.substring(posicaoInicial+20, posicaoFinal);
        
        return verifierCode;
	}
}
