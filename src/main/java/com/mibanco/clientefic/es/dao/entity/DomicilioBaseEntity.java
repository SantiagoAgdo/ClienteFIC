package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class DomicilioBaseEntity {
    private Integer numeroCliente;
    private String direcccion;
    private String telefono1;
    private String telefono2;
    private TipoViviendaEnum tipoVivienda;
}
