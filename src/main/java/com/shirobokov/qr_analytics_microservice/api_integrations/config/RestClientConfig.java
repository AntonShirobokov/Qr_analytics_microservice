package com.shirobokov.qr_analytics_microservice.api_integrations.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClientForIPWHO(RestClient.Builder builder) {
        return builder
                .baseUrl("https://api.ipwho.org")
                .build();
    }
}
