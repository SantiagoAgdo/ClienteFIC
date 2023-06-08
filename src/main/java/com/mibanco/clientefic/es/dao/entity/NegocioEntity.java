package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import lombok.Data;

@Data
public class NegocioEntity {
    private String direccion;
    private Integer telefono;
    private TipoActividadCIIUEnum tipoActividadCIIU;
    private Integer numeroCliente;
}
