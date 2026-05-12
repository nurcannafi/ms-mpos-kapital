package com.example.msdemo.client.atlas.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "spring.atlas")
public class AtlasProperties {

    private List<Long> blockedCategories;
}
