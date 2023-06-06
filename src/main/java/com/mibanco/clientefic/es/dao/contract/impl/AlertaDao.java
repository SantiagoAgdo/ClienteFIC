package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IAlertaDao;
import com.mibanco.clientefic.es.dao.entity.AlertaEntity;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlertaDao implements IAlertaDao {

    List<AlertaEntity> alertaList = new ArrayList<>();


    @Override
    public List<AlertaEntity> listaAlertas(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion) {
        alertaMock();
        return alertaList.stream()
                .filter(x -> x.getTipoDocumento() == tipoDocumentoEnum)
                .filter(x -> x.getNumeroDocumento().equals(numeroDeDocumento))
                .filter(x -> x.getDigitoVerificacion().equals(digitoVerificacion))
                .collect(Collectors.toList());
    }

    void alertaMock(){
        Date fechaInicial = new Date();
        AlertaEntity alerta = new AlertaEntity("1", "Davivienda", fechaInicial, TipoDocumentoEnum.CE_CEDULA_DE_EXTRANJER_A, "1000984321","1");
        alertaList.add(alerta);
        AlertaEntity alerta2 = new AlertaEntity("2", "Davivienda",fechaInicial,  TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, "1000984322","1");
        alertaList.add(alerta2);
        AlertaEntity alerta3 = new AlertaEntity("3", "Davivienda",fechaInicial,  TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, "1000984322","1");
        alertaList.add(alerta3);
        AlertaEntity alerta4 = new AlertaEntity("3", "Davivienda",fechaInicial,  TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, "1000984322","1");
        alertaList.add(alerta4);
    }
}
