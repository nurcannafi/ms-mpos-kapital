package com.example.msdemo.client.atlas;

import com.example.msdemo.client.atlas.configuration.AtlasClientConfig;
import com.example.msdemo.model.request.AtlasCustomerSearchRequest;
import com.example.msdemo.model.response.AtlasCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "atlas-client",
        url = "${application.client.account.url}",
        configuration = AtlasClientConfig.class)
public interface AtlasClient {

    @PostMapping("/api/v1/corporate/customers/search")
    List<AtlasCustomerResponse> searchCustomers(@RequestBody AtlasCustomerSearchRequest request);
}

