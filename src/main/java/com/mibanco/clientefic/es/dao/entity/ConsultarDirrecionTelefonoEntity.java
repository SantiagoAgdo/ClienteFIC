package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.*;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RegisterForReflection
public class ConsultarDirrecionTelefonoEntity {

    private String direccion;
    private Integer telefono1;
    private TipoViviendaEnum tipoVivienda;
    private TipoLocalEnum tipoLocal;
    private TipoDireccionEnum tipoDireccion;
    private DepartamentoEnum codigoDepartamento;
    private CiudadEnum codigoMunicipio;
    private BarrioEnum codigoBarrio;
    private Integer telefono2;

}
