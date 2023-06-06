package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.contract.V1ClienteFIC;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.services.impl.AlertaServiceImpl;
import com.mibanco.clientefic.es.services.impl.CentralRiesgoServiceImpl;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClienteFICController implements V1ClienteFIC {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICController.class);

    @Inject
    ClienteFICServiceImpl clienteFICServiceImpl;

    @Inject
    AlertaServiceImpl alertaServiceImpl;

    @Inject
    CentralRiesgoServiceImpl centralRiesgoServiceImpl;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    @Override
    public Response crearClienteFICType(ClienteFICType clienteFICType) {
        logger.info("Inicia crearClienteFIC en ClienteFICController");
        try {
            clienteFICValidator.verificarClienteFIC(clienteFICType);
            ClienteFICEntity clienteFIC = clienteFICMapper.clienteFICToEntity(clienteFICType);
            clienteFICType = clienteFICServiceImpl.crearClienteFICType(clienteFIC);
            logger.info("Finaliza crearClienteFIC en ClienteFICController");
            return Response.status(Response.Status.OK).entity(clienteFICType).build();

        } catch (ClienteFICException e) {
            logger.info("Finaliza crearClienteFIC en ClienteFICController");
            throw new ClienteFICException(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage());
        }
    }

    @Override
    public Response v1EsAlertaGet(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de Alerta");
        try {
            clienteFICValidator.validarAlerta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<AlertaType> listaAlertas = alertaServiceImpl.getListAlerts(tipoDocumento, numeroDocumento, digitoVerificacion);
            logger.info("Finaliza consulta de Alerta");
            return Response.status(Response.Status.OK).entity(listaAlertas).build();
        } catch (ClienteFICException e) {
            logger.info("Finaliza consulta de Alerta");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response v1EsCentralRiesgoGet(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de CentralRiesgo");
        try {
            List<CentralRiesgoType> listaAlertas = centralRiesgoServiceImpl.getListAlerts(tipoDocumento, numeroDocumento, digitoVerificacion);
            logger.info("Finaliza consulta de CentralRiesgo");
            return Response.status(Response.Status.OK).entity(listaAlertas).build();
        } catch (ClienteFICException e) {
            logger.info("Finaliza consulta de CentralRiesgo");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }


}
