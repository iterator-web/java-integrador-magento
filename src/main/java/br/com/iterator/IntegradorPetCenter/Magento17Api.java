package br.com.iterator.IntegradorPetCenter;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class Magento17Api extends DefaultApi10a
{
	private static final String BASE_URL = "http://192.168.106.128/magentoPetCenter/index.php/";

	@Override
	public String getRequestTokenEndpoint() {
		return BASE_URL + "oauth/initiate";
	}

	@Override
	public String getAccessTokenEndpoint() {
		return BASE_URL + "oauth/token";
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return BASE_URL + "admin/oauth_authorize?oauth_token=" + requestToken.getToken(); //this implementation is for admin roles only...
	}
}
