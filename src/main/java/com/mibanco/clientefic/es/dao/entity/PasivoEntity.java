package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.SubProductoEnum;
import com.mibanco.clientefic.es.gen.type.TipoProductoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PasivoEntity {

    private String numeroProducto;
    private SubProductoEnum subProducto;
    private TipoProductoEnum tipoProducto;
    private String estadoPasivo;
    private String fechaApertura;
    private String fechaCierre;
    private Float capital;
    private Float intereses;
    private Float otros;
    private Float saldoTotal;
    private Integer numeroCliente;

}
