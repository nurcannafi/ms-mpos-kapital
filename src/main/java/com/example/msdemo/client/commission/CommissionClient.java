package com.example.msdemo.client.commission;

import com.example.msdemo.model.request.TariffRequest;
import com.example.msdemo.model.response.TariffResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "tariff",
        url = "${application.client.tariff.url}",
        primary = false
)
public interface CommissionClient {

    @PostMapping("/tariff/commission/acquiring")
    List<TariffResponse> getCommission(@RequestBody TariffRequest request);
}
