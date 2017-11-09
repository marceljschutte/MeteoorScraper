package nl.schutte.scraper.util;

import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;

import com.gargoylesoftware.htmlunit.WebClient;
import java.io.IOException;

import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 08-11-2017
 */
public class HtmlWebClient {

    WebClient client;

    public HtmlWebClient() {
        client = new WebClient();
        setup(true);
    }

    private void setup(boolean proxyEnabled){
        if (proxyEnabled){
        ProxyConfig proxyConfig = new ProxyConfig();
        proxyConfig.setProxyHost("cacheflow.nic.agro.nl");
        proxyConfig.setProxyPort(8080);
        client.getOptions().setProxyConfig(proxyConfig);
        }
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
    }

    public HtmlPage getPage(String URL) throws IOException {
        return client.getPage(URL);
    }
}
