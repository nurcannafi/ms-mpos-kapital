package com.example.msdemo.client.atlas.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.keycloak")
public class KeycloakProperties {

    private String provider;
    private String clientId;
    private String tokenPrefix;
}

