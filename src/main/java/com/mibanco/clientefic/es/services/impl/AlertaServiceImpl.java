package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.contract.impl.AlertaDao;
import com.mibanco.clientefic.es.dao.entity.AlertaEntity;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.services.contract.AlertaService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.AlertaMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlertaServiceImpl implements AlertaService {

    public static final Logger logger = LoggerFactory.getLogger(AlertaServiceImpl.class);

    @Inject
    AlertaDao alertaDao;

    @Inject
    AlertaMapper alertaMapper;

    @Override
    public List<AlertaType> getListAlerts(TipoDocumentoEnum tipoDocumentoEnum, String numeroDeDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de lista de Alertas");
        try {
            List<AlertaEntity> list = alertaDao.listaAlertas(tipoDocumentoEnum,numeroDeDocumento,digitoVerificacion);
            logger.info("Termina consulta de lista de Alertas");
            return  list.stream().map(alertaMapper::alertaToType)
                    .collect(Collectors.toList());
        }catch (ClienteFICException e){
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en AlertaServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }
}
