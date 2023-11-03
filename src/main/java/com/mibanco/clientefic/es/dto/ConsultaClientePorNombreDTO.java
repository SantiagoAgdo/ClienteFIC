package com.mibanco.clientefic.es.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaClientePorNombreDTO {

    private String tipoIdentidad;
    private String numeroIdentificacion;
    private String nombreCompleto;

}
