package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import lombok.Data;

@Data
public class DomicilioEmpresaEntity {

    private Integer numeroCliente;
    private TipoActividadCIIUEnum tipoActividadCIIU;
    private String tipoLocal;
}
