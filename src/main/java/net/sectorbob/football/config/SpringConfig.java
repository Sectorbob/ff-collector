package net.sectorbob.football.config;

import net.sectorbob.football.config.properties.ProxyProperties;
import net.sectorbob.football.rest.template.StatefulRestTemplate;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ltm688 on 9/17/16.
 */
@Configuration
public class SpringConfig {

    @Bean
    public RestTemplate proFootballReferenceRestTemplate(ProxyProperties proxyProperties) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().useSystemProperties();

        if (proxyProperties.isEnabled()) {
            httpClientBuilder.setProxy(new HttpHost(proxyProperties.getHost(), proxyProperties.getPort(), proxyProperties.getScheme()));
        }

        CloseableHttpClient client = httpClientBuilder.build();
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
    }

    @Bean
    public RestTemplate yahooDailyFantasyRestTemplate(ProxyProperties proxyProperties) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().useSystemProperties();

        if (proxyProperties.isEnabled()) {
            httpClientBuilder.setProxy(new HttpHost(proxyProperties.getHost(), proxyProperties.getPort(), proxyProperties.getScheme()));
        }

        CloseableHttpClient client = httpClientBuilder.build();
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
    }

    @Bean
    public StatefulRestTemplate statefulRestTemplate(ProxyProperties proxyProperties) {
        return new StatefulRestTemplate(proxyProperties);
    }
}
