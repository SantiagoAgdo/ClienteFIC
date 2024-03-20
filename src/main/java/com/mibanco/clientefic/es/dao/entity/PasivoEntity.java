package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoProductoEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class PasivoEntity {

    private Integer numeroCliente;
    private String numeroProducto;
    private TipoProductoEnum tipoProducto;
    private String detalleProducto;
    private String estadoPasivo;
    private String fechaApertura;
    private String fechaCierre;
    private Float capital;
    private String intereses;
    private Float otros;
    private Float saldoTotal;

}
