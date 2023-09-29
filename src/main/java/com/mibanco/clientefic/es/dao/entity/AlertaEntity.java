package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertaEntity {

    private String tipoAlerta;
    private String banco;
    private String fecha;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificacion;


}
