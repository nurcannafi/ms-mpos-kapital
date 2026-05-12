package com.example.msdemo.client.atlas.interceptor;

import com.example.msdemo.client.atlas.configuration.KeycloakProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class OauthRequestInterceptor implements RequestInterceptor {

    private final OAuth2AuthorizedClientManager authorizedClientManager;
    private final KeycloakProperties keyCloakProperties;

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        OAuth2AuthorizeRequest request =
                OAuth2AuthorizeRequest.withClientRegistrationId(keyCloakProperties.getProvider())
                        .principal(keyCloakProperties.getClientId())
                        .build();

        OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(request);
        if (Objects.nonNull(authorizedClient)) {
            requestTemplate.header(AUTHORIZATION,
                    keyCloakProperties.getTokenPrefix() + authorizedClient.getAccessToken().getTokenValue());
        }
    }
}

