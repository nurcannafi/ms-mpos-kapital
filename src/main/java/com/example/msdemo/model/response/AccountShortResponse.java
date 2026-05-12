package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountShortResponse {

    private String accountNumber;
    private String iban;
    private Long plannedBalance;
}
