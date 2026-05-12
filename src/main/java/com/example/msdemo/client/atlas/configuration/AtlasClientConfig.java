package com.example.msdemo.client.atlas.configuration;

import com.example.msdemo.client.atlas.interceptor.OauthRequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import feign.RequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@RequiredArgsConstructor
public class AtlasClientConfig {

    private final OAuth2AuthorizedClientManager authorizedClientManager;
    private final KeycloakProperties keyCloakProperties;

    @Bean
    RequestInterceptor oauthRequestInterceptor() {
        return new OauthRequestInterceptor(authorizedClientManager, keyCloakProperties);
    }
}