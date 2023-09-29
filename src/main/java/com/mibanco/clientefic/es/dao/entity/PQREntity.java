package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PQREntity {

    private String fecha;
    private Integer numeroPQR;
    private String motivo;
    private String resultadoPQR;
    private String comentario;
    private String digitoVerificacion;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
}
