package com.example.msdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CbPosTerminalResponseDto {

    private Long id;
    private Long customerId;
    private Long userId;
    private String email;
    private String state;
    private LocalDateTime createdTs;
    private Boolean isMobilePos;
    private String mobileNumber;

}
