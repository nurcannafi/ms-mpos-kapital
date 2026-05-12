package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtlasAccountResponse {

    private List<Account> accounts;

    @Data
    public static class Account {
        private String accountNumber;
        private String iban;
        private Long plannedBalance;
    }
}
