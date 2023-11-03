package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoPersonaEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ClienteBaseEntity {

    private Long id;
    private Integer numeroCliente;
    private TipoPersonaEnum tipoPersona;
    private TipoDocumentoEnum tipoDocumento;
    private Integer numeroDocumento;
    private String fechaExpedicionDocumento;
    private String primerNombre;
    private Integer numeroCelular;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;

}
