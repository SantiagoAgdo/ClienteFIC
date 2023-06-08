package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import lombok.Data;

@Data
public class DomicilioEntity {
    private Integer numeroCliente;
    private TipoViviendaEnum tipoVivienda;
}
