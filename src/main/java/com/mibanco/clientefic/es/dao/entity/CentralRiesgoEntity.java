package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class CentralRiesgoEntity {

    private Integer numeroCliente;
    private String resultadoConsultaMasReciente;
    private String vbVigenteParaSerConsultado;
    private String fechaConsultaMasReciente;


}
