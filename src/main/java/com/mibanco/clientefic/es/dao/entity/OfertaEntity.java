package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class OfertaEntity {

    private Integer numeroOferta;
    private String tipoLead;
    private String tipoOferta;
    private Float monto;
    private Integer plazo;
    private Integer numeroCliente;
    private String tipoDeLiga;
    private String condicionGarantia;
}
