package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class NegocioEntity {

    private Integer numeroCliente;
    private String direccion;
    private String telefono;
    private String tipoActividadCIIU;
    private String descripcionActividadCIIU;
}
