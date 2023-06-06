package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import java.util.List;

public interface CentralRiesgoService {

    List<CentralRiesgoType> getListAlerts(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion);

}
