package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoPersonaEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ClienteBaseEntity {

    private Integer numeroCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private Integer fechaExpedicionDocumento;
    private TipoPersonaEnum tipoPersona;
    private String correoElectronico;
    private String numeroCelular;

}
