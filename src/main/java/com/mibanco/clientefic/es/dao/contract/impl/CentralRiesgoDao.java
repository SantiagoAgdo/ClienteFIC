package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.ICentralRiesgoDao;
import com.mibanco.clientefic.es.dao.entity.CentralRiesgoEntity;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoRelacionEnum;
import com.mibanco.clientefic.es.gen.type.TipoReporteXmlEnum;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CentralRiesgoDao implements ICentralRiesgoDao {

    List<CentralRiesgoEntity> centralRiesgoEntityList = new ArrayList<>();

    @Override
    public List<CentralRiesgoEntity> listaAlertas(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion) {
        centralRiesgoMock();
        return centralRiesgoEntityList.stream()
                .filter(x -> x.getTipoDocumento() == tipoDocumentoEnum)
                .filter(x -> x.getNumeroDocumento().equals(numeroDeDocumento))
                .filter(x -> x.getDigitoVerificacion().equals(digitoVerificacion))
                .collect(Collectors.toList());
    }

    void centralRiesgoMock(){
        Date fechaInicial = new Date();
        CentralRiesgoEntity alerta = new CentralRiesgoEntity("string", "string", "string", fechaInicial, fechaInicial, "string", "string", "1000987654", "string", "string", true, TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, TipoRelacionEnum._01_TITULAR, TipoReporteXmlEnum.CONSULTA_DETALLADA, true, "1" );
        centralRiesgoEntityList.add(alerta);
        CentralRiesgoEntity alerta2 = new CentralRiesgoEntity("string", "string", "string", fechaInicial, fechaInicial, "string", "string", "1000987654", "string", "string", true, TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, TipoRelacionEnum._01_TITULAR, TipoReporteXmlEnum.CONSULTA_DETALLADA, true, "1" );
        centralRiesgoEntityList.add(alerta2);
        CentralRiesgoEntity alerta3 = new CentralRiesgoEntity("string", "string", "string", fechaInicial, fechaInicial, "string", "string", "1000987653", "string", "string", true, TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, TipoRelacionEnum._01_TITULAR, TipoReporteXmlEnum.CONSULTA_DETALLADA, true, "2" );
        centralRiesgoEntityList.add(alerta3);

    }
}
