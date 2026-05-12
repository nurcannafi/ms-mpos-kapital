package com.example.msdemo.client.account;

import com.example.msdemo.client.atlas.configuration.AtlasClientConfig;
import com.example.msdemo.model.request.AtlasAccountSearchRequest;
import com.example.msdemo.model.response.AtlasAccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-client",
        url = "${application.client.account.url}",
        configuration = AtlasClientConfig.class)
public interface AccountClient {

    @PostMapping("/api/v1/corporate/accounts/search")
    AtlasAccountResponse searchAccounts(@RequestBody AtlasAccountSearchRequest request);
}
