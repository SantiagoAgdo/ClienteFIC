package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import lombok.Data;

@Data
public class DomicilioEmpresaEntity {

    private Integer numeroCliente;
    private String dirrecion;
    private Integer telefono1;
    private Integer telefono2;
    private TipoActividadCIIUEnum tipoActividadCIIU;
    private String tipoLocal;
}
