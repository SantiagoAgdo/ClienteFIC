package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.SubProductoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PasivoEntity {

    private String numeroProducto;
    private SubProductoEnum subProducto;
    private String estadoPasivo;
    private Date fechaApertura;
    private Date fechaCierre;
    private Float capital;
    private Float intereses;
    private Float otros;
    private Float saldoTotal;
    private Integer numeroCliente;

}
