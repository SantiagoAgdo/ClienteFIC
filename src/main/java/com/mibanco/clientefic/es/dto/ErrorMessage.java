package com.mibanco.clientefic.es.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class ErrorMessage {

    private String message;
    private int status;

}
