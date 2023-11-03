package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class DomicilioBaseEntity {
    private Integer numeroCliente;
    private TipoViviendaEnum tipoVivienda;
}
