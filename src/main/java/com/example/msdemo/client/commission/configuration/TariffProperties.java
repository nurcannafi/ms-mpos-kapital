package com.example.msdemo.client.commission.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "application.client.tariff")
public class TariffProperties {

    private String url;
    private Integer channelId;
    private String currency;
}