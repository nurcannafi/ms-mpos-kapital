package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EligibilityResponse {

    private boolean eligible;
    private String reason;
}
