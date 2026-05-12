package com.example.msdemo.client.taxes;

import com.example.msdemo.model.response.TaxActivityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "taxes",
        url = "${application.client.taxes.url}")
public interface TaxesClient {

    @GetMapping("/taxes/activity")
    List<TaxActivityResponse> getActivity(@RequestParam String tin);
}