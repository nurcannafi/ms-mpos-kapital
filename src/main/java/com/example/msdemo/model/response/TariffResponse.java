package com.example.msdemo.model.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TariffResponse {

    String code;
    String currency;
    Integer operationId;
    BigDecimal commission;
}

