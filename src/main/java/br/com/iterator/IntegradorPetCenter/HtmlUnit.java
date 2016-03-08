package br.com.iterator.IntegradorPetCenter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUnit {

	public static void main(String[] args) {
		final WebClient webClient = new WebClient();
		HtmlPage page1;
		try {
			page1 = webClient.getPage("http://192.168.106.128/magentoPetCenter/index.php/admin/oauth_authorize/?oauth_token=8ee487f36018a70ccc72f1b1a1f22f3e");

			final HtmlForm form = page1.getFirstByXPath("//*[@id = 'loginForm']");

			final HtmlButton button = form.getFirstByXPath("//*[@type='submit']");
			final HtmlTextInput textField = form.getInputByName("login[username]");
			textField.setValueAttribute("ricardo");
			final HtmlPasswordInput textField2 = form.getInputByName("login[password]");
			textField2.setValueAttribute("123a45b67c");
			final HtmlHiddenInput hiddenField = form.getInputByName("oauth_token");
			hiddenField.setValueAttribute("8ee487f36018a70ccc72f1b1a1f22f3e");
			final HtmlPage page2 = button.click();
			
			final HtmlForm form2 = page2.getFirstByXPath("//*[@id = 'oauth_authorize_confirm']");
			final HtmlButton button2 = form2.getFirstByXPath("//*[@type='submit']");
			final HtmlHiddenInput hiddenField2 = form2.getInputByName("oauth_token");
			hiddenField2.setValueAttribute("8ee487f36018a70ccc72f1b1a1f22f3e");
			final HtmlPage page3 = button2.click();
			
			System.out.println(page3.asText());
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
}
