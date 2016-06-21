package br.com.iterator.model.bean.petcenterjau;

import java.io.Serializable;
import java.util.Arrays;

public class Configs implements Serializable {

	private static final long serialVersionUID = -4773929508368825103L;
	
	private String baseUrl;
	private String requestTokenEndpoint;
	private String accessTokenEndpoint;
	private String authorizationUrl;
	private String apiKey;
	private String apiSecret;
	private String restApiUrl;
	private String adminUser;
	private char[] adminPassword;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String getRequestTokenEndpoint() {
		return requestTokenEndpoint;
	}
	
	public void setRequestTokenEndpoint(String requestTokenEndpoint) {
		this.requestTokenEndpoint = requestTokenEndpoint;
	}
	
	public String getAccessTokenEndpoint() {
		return accessTokenEndpoint;
	}
	
	public void setAccessTokenEndpoint(String accessTokenEndpoint) {
		this.accessTokenEndpoint = accessTokenEndpoint;
	}
	
	public String getAuthorizationUrl() {
		return authorizationUrl;
	}
	
	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}
	
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
	
	public String getRestApiUrl() {
		return restApiUrl;
	}
	
	public void setRestApiUrl(String restApiUrl) {
		this.restApiUrl = restApiUrl;
	}
	
	public String getAdminUser() {
		return adminUser;
	}
	
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	
	public char[] getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(char[] adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessTokenEndpoint == null) ? 0 : accessTokenEndpoint.hashCode());
		result = prime * result + Arrays.hashCode(adminPassword);
		result = prime * result + ((adminUser == null) ? 0 : adminUser.hashCode());
		result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
		result = prime * result + ((apiSecret == null) ? 0 : apiSecret.hashCode());
		result = prime * result + ((authorizationUrl == null) ? 0 : authorizationUrl.hashCode());
		result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
		result = prime * result + ((requestTokenEndpoint == null) ? 0 : requestTokenEndpoint.hashCode());
		result = prime * result + ((restApiUrl == null) ? 0 : restApiUrl.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configs other = (Configs) obj;
		if (accessTokenEndpoint == null) {
			if (other.accessTokenEndpoint != null)
				return false;
		} else if (!accessTokenEndpoint.equals(other.accessTokenEndpoint))
			return false;
		if (!Arrays.equals(adminPassword, other.adminPassword))
			return false;
		if (adminUser == null) {
			if (other.adminUser != null)
				return false;
		} else if (!adminUser.equals(other.adminUser))
			return false;
		if (apiKey == null) {
			if (other.apiKey != null)
				return false;
		} else if (!apiKey.equals(other.apiKey))
			return false;
		if (apiSecret == null) {
			if (other.apiSecret != null)
				return false;
		} else if (!apiSecret.equals(other.apiSecret))
			return false;
		if (authorizationUrl == null) {
			if (other.authorizationUrl != null)
				return false;
		} else if (!authorizationUrl.equals(other.authorizationUrl))
			return false;
		if (baseUrl == null) {
			if (other.baseUrl != null)
				return false;
		} else if (!baseUrl.equals(other.baseUrl))
			return false;
		if (requestTokenEndpoint == null) {
			if (other.requestTokenEndpoint != null)
				return false;
		} else if (!requestTokenEndpoint.equals(other.requestTokenEndpoint))
			return false;
		if (restApiUrl == null) {
			if (other.restApiUrl != null)
				return false;
		} else if (!restApiUrl.equals(other.restApiUrl))
			return false;
		return true;
	}
}