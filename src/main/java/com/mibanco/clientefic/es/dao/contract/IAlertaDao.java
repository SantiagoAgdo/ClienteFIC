package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.AlertaEntity;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import java.util.List;

public interface IAlertaDao {


    List<AlertaEntity> listaAlertas(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion);
}
