package com.mibanco.clientefic.es.dao.contract;


import com.mibanco.clientefic.es.dao.entity.CentralRiesgoEntity;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import java.util.List;

public interface ICentralRiesgoDao {

    List<CentralRiesgoEntity> listaAlertas(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion);

}
