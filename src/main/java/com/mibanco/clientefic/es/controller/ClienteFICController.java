package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constants.Constants;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.dao.entity.ContactoEntity;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.contract.V1ClienteFIC;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RegisterForReflection(targets = {AlertaType.class, ClienteBaseType.class, CentralRiesgoType.class,
        ReporteCentralRiesgoType.class, ContactoEntity.class, ConyugeType.class, CupoRotativoType.class,
        DomicilioEmpresaType.class, NegocioType.class, OfertaType.class,
        PasivoType.class, PQRType.class})
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
            List<AlertaType> listaAlertas = clienteFICServiceImpl.consultarAlerta(new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de Alerta");
            return listaAlertas.size() != 0 ? Response.status(Response.Status.OK).entity(listaAlertas).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_REGISTROS).build(); //204 Not Content

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de Alerta - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "getListaAlertas en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "getListaAlertas, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarCentralDeRiesgo(Integer numeroCliente) {

        LOG.info("Inicia consulta de CentralRiesgo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);

            List<CentralRiesgoType> listaCentralRiesgo = clienteFICServiceImpl.consultarCentralRiesgo(numeroCliente);
            LOG.info("Finaliza consulta de CentralRiesgo");
            return listaCentralRiesgo.size() != 0 ? Response.status(Response.Status.OK).entity(listaCentralRiesgo).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_REGISTROS).build();

        } catch (ApplicationException e) {

            LOG.error("Error en validaciones de CentralRiesgo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarCentralDeRiesgo en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarCentralDeRiesgo, excepción: " + e.getMessage()).build();
        }
    }


    @Override
    public Response consultarClienteFICPorNombre(Integer page, Integer pageSize, String regex) {

        LOG.info("Inicia consulta de Cliente FIC por Nombre");
        try {
            clienteFICValidator.validarConsultaPorNombre(regex);
            ConsultarClientePorNombreOutputEntity consultarClientePorNombreOutputEntity = clienteFICServiceImpl.consultarClienteFicPorNombre(regex, page, pageSize);

            LOG.info("Finaliza consulta de Cliente FIC por Nombre");
            return consultarClientePorNombreOutputEntity.getTotalClientes() != 0 ? Response.status(Response.Status.OK).entity(consultarClientePorNombreOutputEntity).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_CLIENTES).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de consulta cliente FIC por nombre - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarClienteFICPorNombre en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarClienteFICPorNombre, exception: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarConyuge(Integer numeroCliente) {

        LOG.info("Inicia consulta de Cónyuge");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            ConyugeType conyugeType = clienteFICServiceImpl.consultarConyuge(numeroCliente);

            LOG.info("Finaliza consulta de Cónyuge");
            return conyugeType.getNumeroCliente() != null ? Response.status(Response.Status.OK).entity(conyugeType).build() :
                    Response.status(Response.Status.OK).entity(Constants.CONYUGE_NO_EXISTE).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de consultar Cónyuge - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarConyuge en ClienteFICServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarConyuge, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarCupoRotativo(Integer numeroCliente) {

        LOG.info("Inicia consulta de Cupo Rotativo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<CupoRotativoType> cupoRotativoTypeLista = clienteFICServiceImpl.consultarCupoRotativo(numeroCliente);

            LOG.info("Finaliza consulta de Cupo Rotativo");
            return cupoRotativoTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(cupoRotativoTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_REGISTROS).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de cupo rotativo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarCupoRotativo en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarCupoRotativo, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarHistorialContacto(Integer numeroCliente) {

        LOG.info("Inicia consulta de Historial Contacto");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<ContactoType> contactoTypeLista = clienteFICServiceImpl.consultarHistorialContacto(numeroCliente);

            LOG.info("Finaliza consulta de Historial Contacto");
            return contactoTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(contactoTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_CONTACTO).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de Contacto - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarHistorialContacto en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarHistorialContacto, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarOferta(Integer numeroCliente) {

        LOG.info("Inicia consulta de Oferta");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<OfertaType> ofertaTypeLista = clienteFICServiceImpl.consultarOferta(numeroCliente);

            LOG.info("Finaliza consulta de Oferta");
            return ofertaTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(ofertaTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_OFERTAS).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de oferta - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarOferta en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarOferta, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarPQR(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {

        LOG.info("Inicia consulta de PQR");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            List<PQRType> pqrTypeLista = clienteFICServiceImpl.consultarPQR(new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de PQR");
            return pqrTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(pqrTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_PQR).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de consulta PQR - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarPQR en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarPQR, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response consultarPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<PasivoType> pasivoTypeLista = clienteFICServiceImpl.consultarPasivo(numeroCliente);

            LOG.info("Finaliza consulta Pasivo");
            return pasivoTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(pasivoTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_PASIVO).build();
            // Política 20 Cuando el cliente no tenga ninguna alerta, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE ALERTAS A LA FECHA'

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de consultar pasivo - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "consultarPasivo en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultarPasivo, excepción: " + e.getMessage()).build();
        }

    }

    @Override
    public Response consultaClientePorIdentificacion(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) {

        LOG.info("Inicia consulta de Cliente FIC por Identificación. ");
        try {
            clienteFICValidator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);

            ClienteFICDTO clienteFICDTO = clienteFICServiceImpl.consultarClientePorIdentificacion(new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de Cliente FIC por Identificación");
            return clienteFICDTO != null ? Response.status(Response.Status.OK).entity(clienteFICDTO).build() :
                    Response.status(Response.Status.OK).entity(Constants.CLIENTE_NO_EXISTE).build();

        } catch (ApplicationException e) {

            LOG.error("Error en Validaciones de consulta cliente por Identificación - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "Identificación en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.SERVICIO_INTERNAL + "consultaClientePorIdentificacion, excepción: " + e.getMessage()).build();
        }
    }

    @Override
    public Response crearUsuarioClienteFic(ClienteFICType clienteFICType) {

        LOG.info("Inicia crearUsuarioClienteFic en ClienteFICController");
        try {
            clienteFICValidator.verificarClienteFIC(clienteFICType);
            ClienteFICEntity clienteFIC = clienteFICMapper.clienteFICToEntity(clienteFICType);
            clienteFICType = clienteFICServiceImpl.crearUsuarioClienteFic(clienteFIC);

            LOG.info("Finaliza crearUsuarioClienteFic en ClienteFICController");
            return Response.status(Response.Status.CREATED).entity(clienteFICType).build();

        } catch (ApplicationException e) {

            LOG.error("Error en validaciones de creacion de cliente FIC - ClienteFICController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {

            LOG.error(Constants.SERVICIO_INTERNAL + "crearUsuarioClienteFic en ClienteFICServiceImpl excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Constants.SERVICIO_INTERNAL + "crearUsuarioClienteFic, excepción: " + e.getMessage()).build();
        }
    }

}
