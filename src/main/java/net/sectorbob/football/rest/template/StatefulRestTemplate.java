package net.sectorbob.football.rest.template;

import net.sectorbob.football.config.properties.ProxyProperties;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by ltm688 on 9/29/16.
 */
public class StatefulRestTemplate extends RestTemplate
{
    private final HttpClient httpClient;
    private final CookieStore cookieStore;
    private final HttpContext httpContext;
    private final StatefulHttpComponentsClientHttpRequestFactory statefulHttpComponentsClientHttpRequestFactory;

    public StatefulRestTemplate(ProxyProperties proxyProperties) {
        super();

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        // Enable proxy if enabled
        if(proxyProperties.isEnabled()) {
            HttpHost proxy = new HttpHost(proxyProperties.getHost(), proxyProperties.getPort(), proxyProperties.getScheme());
            httpClientBuilder.setProxy(proxy);
        }

        httpClient = httpClientBuilder.build();
        cookieStore = new BasicCookieStore();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(ClientContext.COOKIE_STORE, getCookieStore());
        statefulHttpComponentsClientHttpRequestFactory = new StatefulHttpComponentsClientHttpRequestFactory(httpClient, httpContext);


        super.setRequestFactory(statefulHttpComponentsClientHttpRequestFactory);
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public CookieStore getCookieStore()
    {
        return cookieStore;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public StatefulHttpComponentsClientHttpRequestFactory getStatefulHttpClientRequestFactory()
    {
        return statefulHttpComponentsClientHttpRequestFactory;
    }

    public class StatefulHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {
        private final HttpContext httpContext;

        public StatefulHttpComponentsClientHttpRequestFactory(HttpClient httpClient, HttpContext httpContext)
        {
            super(httpClient);
            this.httpContext = httpContext;
        }

        @Override
        protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri)
        {
            return this.httpContext;
        }
    }

}


