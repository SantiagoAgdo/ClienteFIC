package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.contract.V1ClienteFIC;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
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
    ClienteFICMapper clienteFICMapper;

    @Override
    public List<ClienteFICType> crearClienteFICType(ClienteFICType clienteFICType) {

        logger.info("Inicia crearClienteFIC en ClienteFICController");

        try{
            ClienteFICEntity clienteFIC = clienteFICMapper.clienteFICToEntity(clienteFICType);
            clienteFICType = clienteFICServiceImpl.crearClienteFICType(clienteFIC);

            logger.info("Finaliza crearClienteFIC en ClienteFICController");
            return List.of(clienteFICType);

        }catch (ClienteFICException e){
            logger.info("Finaliza crearClienteFIC en ClienteFICController");
            throw new ClienteFICException(ErrorCts.SERVICIO+ e.getMessage() + " en ClienteFICController" + Response.status(404));
        }
    }


}
