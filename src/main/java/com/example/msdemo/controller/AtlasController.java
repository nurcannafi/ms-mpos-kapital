package com.example.msdemo.controller;

import com.example.msdemo.model.response.AtlasCustomerResponse;
import com.example.msdemo.model.response.EligibilityResponse;
import com.example.msdemo.service.AtlasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class AtlasController {

    private final AtlasService atlasService;

    @GetMapping("/available")
    public ResponseEntity<List<AtlasCustomerResponse>> getCustomer(@RequestParam String cif) {
        return ResponseEntity.ok(atlasService.getCustomerByCif(cif));
    }

    @GetMapping("/eligible")
    public ResponseEntity<EligibilityResponse> getEligibility(@RequestParam String cif) {
        return ResponseEntity.ok(atlasService.checkEligibility(cif));
    }
}
