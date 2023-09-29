package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CupoRotativoEntity {

    private String estado;
    private String fechaDeVencimiento;
    private Float montoCupoCredito;
    private Float montoUtilizado;
    private Integer numeroCliente;
    private String numeroCupo;
    private Float saldoDisponible;
}
