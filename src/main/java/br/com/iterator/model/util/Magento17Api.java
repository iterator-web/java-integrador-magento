package br.com.iterator.model.util;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

import br.com.iterator.model.bean.Configs;
import br.com.iterator.model.helper.XMLHelper;

public class Magento17Api extends DefaultApi10a
{

	@Override
	public String getRequestTokenEndpoint() {
		Configs configs = this.getConfigs();
		return configs.getBaseUrl() + configs.getRequestTokenEndpoint();
	}

	@Override
	public String getAccessTokenEndpoint() {
		Configs configs = this.getConfigs();
		return configs.getBaseUrl() + configs.getAccessTokenEndpoint();
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		Configs configs = this.getConfigs();
		return configs.getBaseUrl() + configs.getAuthorizationUrl() + requestToken.getToken();
	}
	
	private Configs getConfigs() {
		XMLHelper xmlHelper = new XMLHelper();
		Configs configs = xmlHelper.getValorNode();
		return configs;
	}
}
