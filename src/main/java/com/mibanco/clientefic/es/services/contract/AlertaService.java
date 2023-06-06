package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import java.util.List;

public interface AlertaService {

    List<AlertaType> getListAlerts(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion);

}
