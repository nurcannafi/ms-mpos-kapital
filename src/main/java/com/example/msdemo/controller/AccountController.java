package com.example.msdemo.controller;

import com.example.msdemo.model.response.AccountShortResponse;
import com.example.msdemo.model.response.ComplexAgreement;
import com.example.msdemo.model.response.TariffOperationResponse;
import com.example.msdemo.service.AccountService;
import com.example.msdemo.service.AtlasService;

import com.example.msdemo.service.TariffOperationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AtlasService atlasService;
    private final TariffOperationService tariffOperationService;

    @GetMapping
    public ResponseEntity<AccountShortResponse> getAccount(@RequestParam String cif) {
        return ResponseEntity.ok(accountService.getAccountByCif(cif));
    }

    @GetMapping("/customer-type")
    public ResponseEntity<String> getCustomerType(@RequestParam String cif) {
        return ResponseEntity.ok(atlasService.getCustomerType(cif));
    }

    @GetMapping("/agreement")
    public ResponseEntity<ComplexAgreement> getAgreement(@RequestParam String cif) {
        return ResponseEntity.ok(atlasService.getAgreement(cif));
    }

    @GetMapping("/tariffs")
    public ResponseEntity<List<TariffOperationResponse>> getTariffs(@RequestParam String tin) {
        return ResponseEntity.ok(tariffOperationService.getTariffsByTin(tin));
    }
}