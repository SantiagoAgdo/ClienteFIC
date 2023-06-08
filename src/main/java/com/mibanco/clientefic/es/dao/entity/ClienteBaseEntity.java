package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoPersonaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ClienteBaseEntity {

    private Long id;
    private Integer numeroCliente;
    private TipoPersonaEnum tipoPersona;
    private TipoDocumentoEnum tipoDocumento;
    private Integer numeroDocumento;
    private Date fechaExpedicionDocumento;
    private String primerNombre;
    private Integer numeroCelular;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;

}
