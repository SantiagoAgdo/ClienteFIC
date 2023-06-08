package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.contract.impl.ConsultarClientePorNombreDao;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.services.contract.ClientePorNombreService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ClientePorNombreServiceImpl implements ClientePorNombreService {

    public static final Logger logger = LoggerFactory.getLogger(ClientePorNombreServiceImpl.class);

    @Inject
    ConsultarClientePorNombreDao clienteDao;

    @Override
    public ConsultarClientePorNombreOutputEntity cliente(String nombre) {
        logger.info("Inicia consulta de clientes por nombre");
        try {
            ConsultarClientePorNombreOutputEntity cliente = clienteDao.getCliente(nombre);
            logger.info("Termina consulta de clientes por nombre");
            return cliente;
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClientePorNombreServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }
}
