package br.com.iterator.IntegradorPetCenter;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import br.com.iterator.model.bean.petcenterjau.Configs;
import br.com.iterator.model.helper.XMLHelper;
import br.com.iterator.model.util.MagentoConectar;

/**
 * Teste Conexão
 *
 */
public class App 
{
    public static void main( String[] args ) {
        MagentoConectar magentoConectar = new MagentoConectar();
        magentoConectar.estabelecerConexao();
        
        OAuthRequest request = new OAuthRequest(Verb.GET, MagentoConectar.REST_API_URL + "/stockitems?type=rest");
		MagentoConectar.SERVICE.signRequest(MagentoConectar.TOKEN, request);
		Response response = request.send();
		
		System.out.println(response.getBody());
    }
}
