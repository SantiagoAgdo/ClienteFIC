package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.contract.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.services.contract.ClienteFICService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ClienteFICServiceImpl implements ClienteFICService {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICServiceImpl.class);


    @Inject
    ClienteFICDAO clienteFICDAO;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    @Override
    @Transactional
    public ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC) {

        logger.info("Inicia Creacion de cliente FIC en ClienteFICServiceImpl");

        try{
            ClienteFICType clienteFICMapp = clienteFICMapper.clienteFICToType(clienteFIC);
            clienteFICValidator.verificarClienteFIC(clienteFICMapp);

            clienteFICDAO.crearClienteFIC(clienteFIC);

            logger.info("Temrina creacion de cliente FIC en ClienteFICServiceImpl");

            return clienteFICMapp;

        }catch (ClienteFICException e) {
            logger.error(ErrorCts.VALIDACION + " " + e.getMessage()  + " en ClienteFICServiceImpl ");
            throw  new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }

    }
}
