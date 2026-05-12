package com.example.msdemo.service;

import com.example.msdemo.client.taxes.TaxesClient;
import com.example.msdemo.model.response.TaxActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxesService {

    private final TaxesClient taxesClient;

    public TaxActivityResponse getActivity(String tin) {
        List<TaxActivityResponse> taxes = taxesClient.getActivity(tin);

        if (taxes == null || taxes.isEmpty()) return null;

        return taxes.stream()
                .filter(a -> a.getActivityType() == 1)
                .findFirst()
                .orElse(null);
    }
}