package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class CupoRotativoEntity {

    private String estado;
    private String fechaDeVencimiento;
    private Float montoCupoCredito;
    private Float montoUtilizado;
    private Integer numeroCliente;
    private String numeroCupo;
    private Float saldoDisponible;
}
