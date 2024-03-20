package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class DomicilioEmpresaEntity {

    private Integer numeroCliente;
    private String dirrecion;
    private String telefono1;
    private String telefono2;
    private String tipoActividadCIIU;
    private String descripcionActividadCIIU;
    private String tipoLocal;
}
