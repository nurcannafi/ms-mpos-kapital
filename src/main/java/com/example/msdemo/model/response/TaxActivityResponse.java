package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxActivityResponse {

    private String activityName;
    private String activityCode;
    private Integer activityType;
}
