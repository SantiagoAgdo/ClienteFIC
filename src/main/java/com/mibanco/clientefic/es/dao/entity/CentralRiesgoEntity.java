package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoRelacionEnum;
import com.mibanco.clientefic.es.gen.type.TipoReporteXmlEnum;
import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@AllArgsConstructor
public class CentralRiesgoEntity {

    private String antiguedadUbicacion;
    private String consultaDetallada;
    private String estadoDocumento;
    private String fechaConsultaMasReciente;
    private String fechaExpedicion;
    private String genero;
    private String historicoEndeudamiento;
    private String lugarExpedicion;
    private String numeroDocumento;
    private String rangoEdad;
    private String resultadoConsultaMasReciente;
    private Boolean tieneRUT;
    private TipoDocumentoEnum tipoDocumento;
    private TipoRelacionEnum tipoRelacion;
    private TipoReporteXmlEnum tipoReporte;
    private Boolean vbVigenteParaSerConsultado;
    private String digitoVerificacion;


}
