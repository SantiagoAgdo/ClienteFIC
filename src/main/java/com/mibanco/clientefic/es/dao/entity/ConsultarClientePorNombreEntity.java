package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultarClientePorNombreEntity {

    private TipoDocumentoEnum tipoDocumento;
    private Integer numeroDocumento;
    private String nombreCompleto;
}
