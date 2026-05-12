package com.example.msdemo.controller;


import com.example.msdemo.model.response.MccMcgResponse;
import com.example.msdemo.service.MerchantCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/merchant-category")
public class MerchantCategoryController {

    private final MerchantCategoryService merchantCategoryService;

    @GetMapping
    public ResponseEntity<MccMcgResponse> getMccMcg(@RequestParam String tin) {
        return ResponseEntity.ok(merchantCategoryService.getMccMcgByTin(tin));
    }
}
