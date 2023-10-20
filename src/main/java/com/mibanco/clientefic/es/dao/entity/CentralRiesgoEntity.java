package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoRelacionEnum;
import com.mibanco.clientefic.es.gen.type.TipoReporteXmlEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class CentralRiesgoEntity {

    private Integer numeroCliente;
    private String resultadoConsultaMasReciente;
    private String vbVigenteParaSerConsultado;
    private Date fechaConsultaMasReciente;


}
