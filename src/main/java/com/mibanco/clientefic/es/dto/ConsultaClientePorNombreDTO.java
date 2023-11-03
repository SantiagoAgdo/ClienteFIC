package com.mibanco.clientefic.es.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RegisterForReflection
public class ConsultaClientePorNombreDTO {

    private String tipoIdentidad;
    private String numeroIdentificacion;
    private String nombreCompleto;

}
