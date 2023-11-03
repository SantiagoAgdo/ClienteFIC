package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ConsultarClientePorNombreEntity {

    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
}
