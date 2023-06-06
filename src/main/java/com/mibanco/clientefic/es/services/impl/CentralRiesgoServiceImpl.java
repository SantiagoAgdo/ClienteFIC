package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.contract.impl.CentralRiesgoDao;
import com.mibanco.clientefic.es.dao.entity.CentralRiesgoEntity;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.services.contract.CentralRiesgoService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.CentralRiesgoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class CentralRiesgoServiceImpl implements CentralRiesgoService {

    public static final Logger logger = LoggerFactory.getLogger(AlertaServiceImpl.class);

    @Inject
    CentralRiesgoDao centralRiesgoDao;

    @Inject
    CentralRiesgoMapper centralRiesgoMapper;

    @Override
    public List<CentralRiesgoType> getListAlerts(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de central de riesgo");
        try {
            List<CentralRiesgoEntity> list = centralRiesgoDao.listaAlertas(tipoDocumentoEnum,numeroDeDocumento,digitoVerificacion);
            logger.info("Termina consulta de central de riesgo");
            return  list.stream().map(centralRiesgoMapper::centralToType)
                    .collect(Collectors.toList());
        }catch (ClienteFICException e){
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en CentralRiesgoServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }
}
