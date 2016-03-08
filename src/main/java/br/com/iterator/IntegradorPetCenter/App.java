package br.com.iterator.IntegradorPetCenter;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import br.com.iterator.model.util.MagentoConectar;

/**
 * Teste Conexão
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MagentoConectar magentoConectar = new MagentoConectar();
        OAuthService service = magentoConectar.getService();
        Token accessToken = magentoConectar.getToken();
        OAuthRequest request = new OAuthRequest(Verb.GET, magentoConectar.getMagentoRestApiUrl() + "/stockitems?type=rest");
		service.signRequest(accessToken, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
}
