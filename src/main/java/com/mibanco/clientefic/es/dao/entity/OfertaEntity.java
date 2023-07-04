package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
