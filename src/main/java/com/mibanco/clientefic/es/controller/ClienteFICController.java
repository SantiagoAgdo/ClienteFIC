package com.mibanco.clientefic.es.controller;

import com.mibanco.clientefic.es.constants.Constants;
import com.mibanco.clientefic.es.dao.entity.*;
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
            //17. ALERTA. Cuando el cliente no tenga ninguna alerta, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE ALERTAS A LA FECHA' :
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
    public Response consultarCentralDeRiesgo(Integer page, Integer pageSize, Integer numeroCliente) {

        LOG.info("Inicia consulta de CentralRiesgo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);

            List<CentralRiesgoType> listaCentralRiesgo = clienteFICServiceImpl.consultarCentralRiesgo(page, pageSize, numeroCliente);
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
            // 03. Para la consulta por Nombres y Apellidos / Razón Social si no existe ningún cliente con el texto ingresado, el sistema deberá mostrar el siguiente mensaje de error: 'NO EXISTEN CLIENTES CON EL TEXTO INGRESADO EN MI BANCO COLOMBIA' :
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
            ConyugeEntity conyugeType = clienteFICServiceImpl.consultarConyuge(numeroCliente);

            LOG.info("Finaliza consulta de Cónyuge");
            // 11. En la sección INFORMACIÓN DEL CÓNYUGE en el caso donde no se obtenga la Información del Cónyuge asociado al Cliente Consultado, el sistema deberá mostrar el siguiente mensaje: 'NO EXISTE INFORMACIÓN REGISTRADA PARA EL CÓNYUGE'
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
    public Response consultarCupoRotativo(Integer page, Integer pageSize, Integer numeroCliente) {

        LOG.info("Inicia consulta de Cupo Rotativo");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<CupoRotativoType> cupoRotativoTypeLista = clienteFICServiceImpl.consultarCupoRotativo(page, pageSize, numeroCliente);

            LOG.info("Finaliza consulta de Cupo Rotativo");
            //52. CUPO ROTATIVO. Cuando el cliente no tenga Cupos Rotativos, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE CUPOS ROTATIVOS A LA FECHA'
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
    public Response consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        LOG.info("Inicia consulta de Historial Contacto");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<ContactoType> contactoTypeLista = clienteFICServiceImpl.consultarHistorialContacto(pagina, tamanoPagina, numeroCliente);

            LOG.info("Finaliza consulta de Historial Contacto");
            //58. HISTORIAL DE CONTACTOS. Cuando el cliente no tenga información en el historial de Contactos, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE INFORMACIÓN EN EL HISTORIAL DE CONTACTOS A LA FECHA'
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
    public Response consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        LOG.info("Inicia consulta de Oferta");
        try {
            clienteFICValidator.validarNumeroCliente(numeroCliente);
            List<OfertaType> ofertaTypeLista = clienteFICServiceImpl.consultarOferta(pagina, tamanoPagina, numeroCliente);

            LOG.info("Finaliza consulta de Oferta");
            //16. OFERTA. Cuando el cliente no tenga ninguna oferta, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE OFERTAS A LA FECHA'
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
            //61. PQR. Cuando el cliente no tenga PQRs, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE PQRs A LA FECHA'
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
            // Política 20 Cuando el cliente no tenga ninguna alerta, el sistema debe mostrar el siguiente mensaje: 'CLIENTE NO TIENE ALERTAS A LA FECHA'
            return pasivoTypeLista.size() != 0 ? Response.status(Response.Status.OK).entity(pasivoTypeLista).build() :
                    Response.status(Response.Status.OK).entity(Constants.SIN_PASIVO).build();


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

            ClienteBaseEntity clienteFICDTO = clienteFICServiceImpl.consultarClientePorIdentificacion(new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            LOG.info("Finaliza consulta de Cliente FIC por Identificación");
            /*Politíca 01: si el cliente no existe, el sistema deberá mostrar el siguiente mensaje de error: 'CLIENTE NO EXISTE EN MI BANCO COLOMBIA'*/
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
