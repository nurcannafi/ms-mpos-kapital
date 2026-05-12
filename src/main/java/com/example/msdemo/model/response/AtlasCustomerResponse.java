package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtlasCustomerResponse {

    private Long id;
    private String type;
    private String fullName;
    private String pin;
    private String tin;
    private String cif;
    private Boolean citizen;
    private Long categoryId;
    private ComplexAgreement complexAgreement;
}
