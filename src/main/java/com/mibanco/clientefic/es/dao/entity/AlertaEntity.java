package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import lombok.Data;


import java.util.Date;

@Data
public class AlertaEntity {

    private String tipoAlerta;
    private String banco;
    private Date fecha;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificacion;

    public AlertaEntity(String tipoAlerta, String banco, Date fecha, TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        this.tipoAlerta = tipoAlerta;
        this.banco = banco;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.digitoVerificacion = digitoVerificacion;
    }
}
