package com.example.msdemo.service;

import com.example.msdemo.client.commission.CommissionClient;
import com.example.msdemo.client.commission.configuration.TariffProperties;
import com.example.msdemo.model.request.TariffRequest;
import com.example.msdemo.model.response.TariffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommissionService {

    private final CommissionClient commissionClient;
    private final TariffProperties tariffProperties;

    public List<TariffResponse> getTariffs(String cif, List<String> code) {
        TariffRequest request = TariffRequest.builder()
                .cif(cif)
                .code(code)
                .channelId(tariffProperties.getChannelId())
                .currency(tariffProperties.getCurrency())
                .build();

        return commissionClient.getCommission(request);
    }

}
