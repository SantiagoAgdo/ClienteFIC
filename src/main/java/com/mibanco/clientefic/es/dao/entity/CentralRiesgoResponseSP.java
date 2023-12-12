package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class CentralRiesgoResponseSP {

    private int numeroCliente;
    private String fechaVigenciaDesde;
    private String zonaViabilidad;
    private String s_vbclienteparaconsulta;

}
