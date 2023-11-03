package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarClientePorNombreEntity {

    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
}
