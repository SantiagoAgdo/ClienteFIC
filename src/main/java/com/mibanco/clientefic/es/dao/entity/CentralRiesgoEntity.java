package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@RegisterForReflection
public class CentralRiesgoEntity {

    private Integer numeroCliente;
    private String resultadoConsultaMasReciente;
    private String vbVigenteParaSerConsultado;
    private String fechaConsultaMasReciente;

    public CentralRiesgoEntity(Integer numeroCliente,  String fechaConsultaMasReciente, String resultadoConsultaMasReciente, String vbVigenteParaSerConsultado) {
        this.numeroCliente = numeroCliente;
        this.fechaConsultaMasReciente = fechaConsultaMasReciente;
        this.resultadoConsultaMasReciente = resultadoConsultaMasReciente;
        this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;

    }
}
