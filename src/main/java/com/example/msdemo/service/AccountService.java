package com.example.msdemo.service;

import com.example.msdemo.client.account.AccountClient;
import com.example.msdemo.model.request.AtlasAccountSearchRequest;
import com.example.msdemo.client.account.configuration.AccountProperties;
import com.example.msdemo.model.response.AccountShortResponse;
import com.example.msdemo.model.response.AtlasAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountClient accountClient;
    private final AccountProperties accountProperties;

    public AccountShortResponse getAccountByCif(String cif) {

        AtlasAccountSearchRequest request = buildRequest(cif);

        AtlasAccountResponse response = accountClient.searchAccounts(request);

        if (response == null || response.getAccounts() == null || response.getAccounts().isEmpty()) {
            throw new RuntimeException("Account not found");
        }

        return response.getAccounts().stream()
                .findFirst()
                .map(this::mapToShort)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    private AtlasAccountSearchRequest buildRequest(String cif) {
        return AtlasAccountSearchRequest.builder()
                .cif(cif)
                .type(accountProperties.getType())
                .currency(accountProperties.getCurrency())
                .status(accountProperties.getStatus())
                .customerType(accountProperties.getCustomerType())
                .build();
    }

    private AccountShortResponse mapToShort(AtlasAccountResponse.Account account) {
        return new AccountShortResponse(
                account.getAccountNumber(),
                account.getIban(),
                account.getPlannedBalance()
        );
    }
}
