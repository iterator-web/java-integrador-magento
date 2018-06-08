package br.com.iterator.IntegradorPetCenter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
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

public class MagentoExample {
	
	static final String MAGENTO_API_KEY = "9f6001633dc189fe63daf8365756d39a";
	static final String MAGENTO_API_SECRET = "9f1f652c17a3cce7257dbae5a1a84027";
	static final String MAGENTO_REST_API_URL = "http://127.0.0.1/magentoPetCenter/api/rest";
	static final String MAGENTO_ADMIN_USER = "seu_usuario";
	static final String MAGENTO_ADMIN_PASS = "sua_senha";

	public static void main(String[] args) {

		try {
			// Início código com Framework Scribe
			OAuthService service = new ServiceBuilder().provider(Magento17Api.class).apiKey(MAGENTO_API_KEY).apiSecret(MAGENTO_API_SECRET).build();

			System.out.println("=== Magento OAuth Workflow ===");
			System.out.println();

			// Faz a requisição pelo Token
			System.out.println("Fetching the Request Token...");
			Token requestToken = service.getRequestToken();
			System.out.println("Got the Request Token!");
			System.out.println(requestToken.getToken());

			// Início do Trecho de código com Framework HTMLUnit.
			WebClient webClient = new WebClient();
			// Acessa página de autorização (Leg One) utilizando o Token recebido.
			HtmlPage pageLegOne = webClient.getPage(service.getAuthorizationUrl(requestToken));
			final HtmlForm formLegOne = pageLegOne.getFirstByXPath("//*[@id = 'loginForm']");
			final HtmlButton buttonLegOne = formLegOne.getFirstByXPath("//*[@type='submit']");
			final HtmlTextInput loginField = formLegOne.getInputByName("login[username]");
			loginField.setValueAttribute(MAGENTO_ADMIN_USER);
			final HtmlPasswordInput passwordField = formLegOne.getInputByName("login[password]");
			passwordField.setValueAttribute(MAGENTO_ADMIN_PASS);
			final HtmlHiddenInput tokenHiddenField = formLegOne.getInputByName("oauth_token");
			tokenHiddenField.setValueAttribute(requestToken.getToken());
			final HtmlPage pageLegTwo = buttonLegOne.click();
			// Acessa página de confirmação (Leg Two) e aciona o botão de confirmação da autorização.
			final HtmlForm formLegTwo = pageLegTwo.getFirstByXPath("//*[@id = 'oauth_authorize_confirm']");
			final HtmlButton buttonLegTwo = formLegTwo.getFirstByXPath("//*[@type='submit']");
			final HtmlHiddenInput tokenHiddenFieldLegTwo = formLegTwo.getInputByName("oauth_token");
			tokenHiddenFieldLegTwo.setValueAttribute(requestToken.getToken());
			final HtmlPage pageLegThree = buttonLegTwo.click();
			// Acessa página do código de verificação (Leg Three) e resgata o valor disponibilizado.
			String verifierCode = getVerifierCode(pageLegThree.asText());
			System.out.println(verifierCode);
			// Fim do Trecho de código com Framework HTMLUnit.
			
			// Retomada do código com Framework Scribe.
			// Realiza a entrada do código de verificação no objeto Verifier do Scribe.
			System.setIn(new ByteArrayInputStream(verifierCode.getBytes()));
			Scanner in = new Scanner(System.in);
			Verifier verifier = new Verifier(in.nextLine());

			// Trade the Request Token and Verfier for the Access Token
			System.out.println("Trading the Request Token for an Access Token...");
			System.out.println(requestToken.getToken()+" '---' "+verifier.getValue());
			Token accessToken = service.getAccessToken(requestToken, verifier);
			System.out.println("Got the Access Token!");
			System.out.println("(if your curious it looks like this: " + accessToken + " )");
			System.out.println();

			// Now let's go and ask for a protected resource!
			System.out.println("Now we're going to access a protected resource...");
			OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL + "/stockitems?type=rest");
			service.signRequest(accessToken, request);
			Response response = request.send();
			System.out.println("Got it! Lets see what we found...");
			System.out.println();
			System.out.println(response.getBody());

			System.out.println();
			System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getVerifierCode(String retornoAuth) {
		Integer posicaoInicial = retornoAuth.indexOf("Verifier code:");
        Integer posicaoFinal = retornoAuth.indexOf("Magento is a trademark of Magento Inc.");
        String verifierCode = retornoAuth.substring(posicaoInicial+15, posicaoFinal);
        
        return verifierCode;
	}
}
