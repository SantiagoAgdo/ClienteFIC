package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoProductoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class PasivoEntity {

    private Integer numeroCliente;
    private String numeroProducto;
    private TipoProductoEnum tipoProducto;
    private String detalleProducto;
    private String estadoPasivo;
    private String fechaApertura;
    private String fechaCierre;
    private Float capital;
    private Float intereses;
    private Float otros;
    private Float saldoTotal;

}
