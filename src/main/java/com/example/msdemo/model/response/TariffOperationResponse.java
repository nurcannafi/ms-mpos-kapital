package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TariffOperationResponse {

    private Long id;
    private Long tccsId;
    private Long mcgId;
    private String operationCode;
}