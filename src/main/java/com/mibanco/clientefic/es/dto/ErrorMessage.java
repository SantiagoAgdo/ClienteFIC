package com.mibanco.clientefic.es.dto;

import lombok.Data;

@Data
public class ErrorMessage {
    private int status;
    private String message;
}
