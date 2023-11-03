package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constans.Constans;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.contract.V1ClienteFIC;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClienteFICController implements V1ClienteFIC {

    public static final Logger LOG = LoggerFactory.getLogger(ClienteFICController.class);
    @Inject
    ClienteFICServiceImpl clienteFICServiceImpl;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    public ClienteFICController(ClienteFICServiceImpl clienteFICService, ClienteFICValidator clienteFICValidator) {
        this.clienteFICValidator = clienteFICValidator;
        this.clienteFICServiceImpl = clienteFICService;
    }

    @Override
    public Response consultarAlerta(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {

        LOG.info("Inicia consulta de Alerta");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<AlertaType> listaAlertas = clienteFICServiceImpl.getListaAlertas(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de Alerta");
            return listaAlertas.size() != 0 ? Response.status(Response.Status.OK).entity(listaAlertas).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_REGISTROS).build(); //204 Not Content

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de Alerta - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "getListaAlertas en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "getListaAlertas, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarCentralDeRiesgo(Integer numeroCliente) {

        LOG.info("Inicia consulta de CentralRiesgo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);

            List<CentralRiesgoType> list = clienteFICServiceImpl.getListaCentralRiesgo(numeroCliente);
            LOG.info("Finaliza consulta de CentralRiesgo");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_REGISTROS).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de CentralRiesgo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarCentralDeRiesgo en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarCentralDeRiesgo, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarClienteFICPorNombre(String nombre, String apellido, String razonSocial) {

        LOG.info("Inicia consulta de Cliente FIC por Nombre");
        try {
            clienteFICValidator.validarConsultaPorNombre(nombre, apellido, razonSocial);
            ConsultarClientePorNombreOutputEntity cliente = clienteFICServiceImpl.getClienteByNombre(nombre,1,15);

            LOG.info("Finaliza consulta de Cliente FIC por Nombre");
            return cliente.getTotalClientes() != 0 ? Response.status(Response.Status.OK).entity(cliente).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_CLIENTES).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de consulta cliente FIC por nombre - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarClienteFICPorNombre en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarClienteFICPorNombre, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarConyuge(Integer numeroCliente) {

        LOG.info("Inicia consulta de Conyuge");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            ConyugeType conyuge = clienteFICServiceImpl.getConyuge(numeroCliente);

            LOG.info("Finaliza consulta de Conyuge");
            return conyuge.getNumeroCliente() != null ? Response.status(Response.Status.OK).entity(conyuge).build() :
                    Response.status(Response.Status.OK).entity(Constans.CONYUGE_NO_EXISTE).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de consultar conyuge - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarConyuge en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarConyuge, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarCupoRotativo(Integer numeroCliente) {

        LOG.info("Inicia consulta de Cupo Rotativo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<CupoRotativoType> list = clienteFICServiceImpl.getCupoRotativo(numeroCliente);

            LOG.info("Finaliza consulta de Cupo Rotativo");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_REGISTROS).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de cupo rotativo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarCupoRotativo en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarCupoRotativo, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarHistorialContacto(Integer numeroCliente) {

        LOG.info("Inicia consulta de Historial Contacto");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<ContactoType> list = clienteFICServiceImpl.getContacto(numeroCliente);

            LOG.info("Finaliza consulta de Historial Contacto");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_CONTACTO).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de Contacto - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarHistorialContacto en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarHistorialContacto, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarOferta(Integer numeroCliente) {

        LOG.info("Inicia consulta de Oferta");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<OfertaType> list = clienteFICServiceImpl.getOferta(numeroCliente);

            LOG.info("Finaliza consulta de Oferta");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_OFERTAS).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de oferta - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarOferta en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarOferta, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarPQR(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {

        LOG.info("Inicia consulta de PQR");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<PQRType> list = clienteFICServiceImpl.getPQR(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de PQR");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_PQR).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de consulta PQR - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarPQR en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarPQR, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<PasivoType> list = clienteFICServiceImpl.getPasivo(numeroCliente);

            LOG.info("Finaliza consulta Pasivo");
            return list.size() != 0 ? Response.status(Response.Status.OK).entity(list).build() :
                    Response.status(Response.Status.OK).entity(Constans.SIN_PASIVO).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de consultar pasivo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consultarPasivo en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consultarPasivo, exception: " + e.getMessage()).build();
        }

    }

    @Override
    public Response consutaClientePorIdentificacion(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {

        LOG.info("Inicia consulta de Cliente FIC por Identificacion. ");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);

            ClienteFICDTO cliente = clienteFICServiceImpl.getClienteByIdentificacion(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de Cliente FIC por Identificacion");
            return cliente != null ? Response.status(Response.Status.OK).entity(cliente).build() :
                    Response.status(Response.Status.OK).entity(Constans.CLIENTE_NO_EXISTE).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en Validaciones de consuta cliente por identificacion - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "consutaClientePorIdentificacion en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constans.SERVICIO_INTERNAL + "consutaClientePorIdentificacion, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response crearClienteFIC(ClienteFICType clienteFICType) {

        LOG.info("Inicia crearClienteFIC en ClienteFICController");
        try {
            clienteFICValidator.verificarClienteFIC(clienteFICType);
            ClienteFICEntity clienteFIC = clienteFICMapper.clienteFICToEntity(clienteFICType);
            clienteFICType = clienteFICServiceImpl.crearClienteFICType(clienteFIC);

            LOG.info("Finaliza crearClienteFIC en ClienteFICController");
            return Response.status(Response.Status.CREATED).entity(clienteFICType).build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en validaciones de creacion de cliente FIC - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constans.SERVICIO_INTERNAL + "crearClienteFIC en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Constans.SERVICIO_INTERNAL + "crearClienteFIC, exception: " + e.getMessage()).build();
        }
    }


}
