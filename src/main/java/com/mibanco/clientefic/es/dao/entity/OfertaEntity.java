package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
