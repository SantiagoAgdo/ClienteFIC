package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.contract.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.contract.ClienteFICService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteFICServiceImpl implements ClienteFICService {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICServiceImpl.class);


    @Inject
    ClienteFICDAO clienteFICDAO;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Override
    @Transactional
    public ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC) {

        logger.info("Inicia Creacion de cliente FIC en ClienteFICServiceImpl");

        try {
            ClienteFICType clienteFICMapp = clienteFICMapper.clienteFICToType(clienteFIC);
            clienteFICDAO.crearClienteFIC(clienteFIC);
            logger.info("Termina creacion de cliente FIC en ClienteFICServiceImpl");
            return clienteFICMapp;
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.VALIDACION + " " + e.getMessage() + " en ClienteFICServiceImpl ");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }

    }

    @Override
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData dataCliente) {
        logger.info("Inicia consulta de cliente por identificacion");
        try {
            ClienteFICEntity rpt = clienteFICDAO.getClienteByIdentificacion(dataCliente);
            logger.info("Termina consulta de cliente por identificacion");
            return rpt;
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public ConyugeType getConyuge(Integer numeroCliente) {
        logger.info("Inicia consulta de conyuge");
        try {
            ConyugeType rpt = clienteFICDAO.getConyuge(numeroCliente);
            logger.info("Termina consulta de conyuge");
            return rpt;
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<CupoRotativoType> getCupoRotativo(Integer numeroCliente) {
        logger.info("Inicia consulta de cupo rotativo");
        try {
            List<CupoRotativoEntity> list = clienteFICDAO.getCupoRotativo(numeroCliente);
            logger.info("Termina consulta de cupo rotativo");
            return list.stream().map(clienteFICMapper::cupoRotativoFICToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<ConsultarDireccionTelefonoType> getDirrecionTelefono(Integer numeroCliente) {
        logger.info("Inicia consulta de Dirreccion Telefono");
        try {
            List<ConsultarDirrecionTelefonoEntity> list = clienteFICDAO.getDirrecionTelefono(numeroCliente);
            logger.info("Termina consulta de Dirreccion Telefono");
            return list.stream().map(clienteFICMapper::consultaDirrecionTelelfonoToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<ContactoType> getContacto(Integer numeroCliente) {
        logger.info("Inicia consulta de Historial Contacto");
        try {
            List<ContactoEntity> list = clienteFICDAO.getContacto(numeroCliente);
            logger.info("Termina consulta de Historial Contacto\"");
            return list.stream().map(clienteFICMapper::contactoToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<OfertaType> getOferta(Integer numeroCliente) {
        logger.info("Inicia consulta de Oferta");
        try {
            List<OfertaEntity> list = clienteFICDAO.getOferta(numeroCliente);
            logger.info("Termina consulta de Oferta");
            return list.stream().map(clienteFICMapper::ofertaToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<PasivoType> getPasivo(Integer numeroCliente) {
        logger.info("Inicia consulta Pasivo");
        try {
            List<PasivoEntity> list = clienteFICDAO.getPasivo(numeroCliente);
            logger.info("Termina consulta Pasivo");
            return list.stream().map(clienteFICMapper::pasivoToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }

    @Override
    public List<PQRType> getPQR(ConsultaClienteByData dataCliente) {
        logger.info("Inicia consulta de PQR");
        try {
            List<PQREntity> list = clienteFICDAO.getPQR(dataCliente);
            logger.info("Termina consulta de PRQ");
            return list.stream().map(clienteFICMapper::pqrToType)
                    .collect(Collectors.toList());
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en ClienteFICServiceImpl exception: " + e.getMessage());
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO);
        }
    }


}
