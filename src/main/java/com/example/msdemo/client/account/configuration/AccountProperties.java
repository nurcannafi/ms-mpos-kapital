package com.example.msdemo.client.account.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "application.client.account")
public class AccountProperties {

    private Integer type;
    private Integer currency;
    private String status;
    private String customerType;
}
