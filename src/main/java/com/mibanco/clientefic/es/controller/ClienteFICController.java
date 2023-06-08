package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.contract.V1ClienteFIC;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.impl.AlertaServiceImpl;
import com.mibanco.clientefic.es.services.impl.CentralRiesgoServiceImpl;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.services.impl.ClientePorNombreServiceImpl;
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
    ClientePorNombreServiceImpl clientePorNombreServiceImpl;

    @Inject
    CentralRiesgoServiceImpl centralRiesgoServiceImpl;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    @Override
    public Response consultarAlerta(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de Alerta");
        try {
            clienteFICValidator.validarAlerta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<AlertaType> listaAlertas = alertaServiceImpl.getListAlerts(tipoDocumento, numeroDocumento, digitoVerificacion);
            logger.info("Finaliza consulta de Alerta");
            return Response.status(Response.Status.OK).entity(listaAlertas).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Alerta - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarCentralDeRiesgo(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        logger.info("Inicia consulta de CentralRiesgo");
        try {
            List<CentralRiesgoType> listaAlertas = centralRiesgoServiceImpl.getListAlerts(tipoDocumento, numeroDocumento, digitoVerificacion);
            logger.info("Finaliza consulta de CentralRiesgo");
            return Response.status(Response.Status.OK).entity(listaAlertas).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de CentralRiesgo -  ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarClienteFICPorNombre(String nombre) {
        logger.info("Inicia consulta de Cliente FIC por Nombre");
        try {
            clienteFICValidator.validarNombre(nombre);
            ConsultarClientePorNombreOutputEntity cliente = clientePorNombreServiceImpl.cliente(nombre);
            logger.info("Finaliza consulta de Cliente FIC por Nombre");
            return Response.status(Response.Status.OK).entity(cliente).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Cliente FIC por Nombre - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarConyuge(Integer numeroCliente) {
        logger.info("Inicia consulta de Conyuge");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            ConyugeType conyuge = clienteFICServiceImpl.getConyuge(numeroCliente);
            logger.info("Finaliza consulta de Conyuge");
            return Response.status(Response.Status.OK).entity(conyuge).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Conyuge - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarCupoRotativo(Integer numeroCliente) {
        logger.info("Inicia consulta de Cupo Rotativo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<CupoRotativoType> cupo = clienteFICServiceImpl.getCupoRotativo(numeroCliente);
            logger.info("Finaliza consulta de Cupo Rotativo");
            return Response.status(Response.Status.OK).entity(cupo).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Cupo Rotativo - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarDireccionTelefono(Integer numeroCliente) {
        logger.info("Inicia consulta de Dirrecion y Telefono");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<ConsultarDireccionTelefonoType> query = clienteFICServiceImpl.getDirrecionTelefono(numeroCliente);
            logger.info("Finaliza consulta de Dirrecion y Telefono");
            return Response.status(Response.Status.OK).entity(query).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Dirrecion y Telefono - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarHistorialContacto(Integer numeroCliente) {
        logger.info("Inicia consulta de Historial Contacto");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<ContactoType> query = clienteFICServiceImpl.getContacto(numeroCliente);
            logger.info("Finaliza consulta de Historial Contacto");
            return Response.status(Response.Status.OK).entity(query).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Historial Contacto - ClienteFICController");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarOferta(Integer numeroCliente) {
        logger.info("Inicia consulta de Oferta");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<OfertaType> query = clienteFICServiceImpl.getOferta(numeroCliente);
            logger.info("Finaliza consulta de Oferta");
            return Response.status(Response.Status.OK).entity(query).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Oferta - ClienteFICController ");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarPQR(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {
        logger.info("Inicia consulta de PQR");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<PQRType> query = clienteFICServiceImpl.getPQR(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));
            logger.info("Finaliza consulta de PQR");
            return Response.status(Response.Status.OK).entity(query).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de PQR - ClienteFICController ");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consultarPasivo(Integer numeroCliente) {
        logger.info("Inicia consulta Pasivo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<PasivoType> query = clienteFICServiceImpl.getPasivo(numeroCliente);
            logger.info("Finaliza consulta Pasivo");
            return Response.status(Response.Status.OK).entity(query).build();
        } catch (ClienteFICException e) {
            logger.error("Error en consulta de Pasivo - ClienteFICController ");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response consutaClientePorIdentificacion(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {
        logger.info("Inicia consulta de Cliente FIC por Identificacion ");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            ClienteFICEntity cliente = clienteFICServiceImpl.getClienteByIdentificacion(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));
            logger.info("Finaliza consulta de Cliente FIC por Identificacion");
            return Response.status(Response.Status.OK).entity(cliente).build();
        } catch (ClienteFICException e) {
            logger.error("Ocurrio un error en consulta de Cliente FIC por Identificacion");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " - " + e.getMessage());
        }
    }

    @Override
    public Response crearClienteFIC(ClienteFICType clienteFICType) {
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

}
