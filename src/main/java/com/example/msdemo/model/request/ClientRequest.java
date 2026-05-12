package com.example.msdemo.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ClientRequest {

    private String cif;
    private List<String> code;
}
