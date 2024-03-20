package com.mibanco.clientefic.es.graphql;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GraphQLApi
public class ClienteFICControllerGraph {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICControllerGraph.class);

    @Inject
    ClienteFICServiceImpl clienteFICService;

    @Query("consultaAlerta")
    @Description("Consulta de Alertas")
    public AlertasOutput consultaAlerta(@Name("page") Integer page, @Name("pageSize") Integer pageSize, @Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") String numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta de alerta en GraphQL");
        try {
            AlertasOutput alertaTypeList = clienteFICService.consultarAlerta(page, pageSize, new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consulta de alerta en GraphQL");
            return alertaTypeList;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaAlerta GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaAlerta GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCentralRiesgo")
    @Description("Consulta de central de riesgo")
    public List<CentralRiesgoType> consultaCentralRiesgo(@Name("page") Integer page, @Name("pageSize") Integer pageSize, @Name("numeroDocumento") Integer numeroCliente) {

        logger.info("Inicia consulta de central de riesgo en GraphQL");
        try {
            List<CentralRiesgoType> centralRiesgoTypesList = clienteFICService.consultarCentralRiesgo( page, pageSize,numeroCliente);

            logger.info("Termina consulta de central de riesgo en GraphQL");
            return centralRiesgoTypesList;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getCentral GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPQR")
    @Description("Consulta de PQR")
    public List<PQRType> consultaPQR(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta de PQR en GraphQL");
        try {
            List<PQRType> pqrTypeList = clienteFICService.consultarPQR(1,100,numeroCliente);

            logger.info("Termina consulta de PQR en GraphQL");
            return pqrTypeList;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaPQR GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaPQR GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorIdentificacion")
    @Description("Consulta de cliente por identificación")
    public ClienteFICEntity consultaClientePorIdentificacion(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") String numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consultaClientePorIdentificacion en GraphQL");
        try {
            ClienteFICEntity clienteFICDTO = clienteFICService.consultarClientePorIdentificacion(new ConsultaClienteEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consultaClientePorIdentificacion en GraphQL");
            return clienteFICDTO;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaClientePorIdentificacion GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaClientePorIdentificacion GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaConyuge")
    @Description("Consulta de cónyuge por número de cliente")
    public ConyugeEntity consultaConyuge(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta de cónyuge en GraphQL");
        try {
            ConyugeEntity data = clienteFICService.consultarConyuge(numeroCliente);

            logger.info("Termina consulta de cónyuge en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaConyuge GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaConyuge GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCupoRotativo")
    @Description("Consulta de cupo rotativo por número de cliente")
    public ConsultarCupoRotativoOutput consultaCupoRotativo(@Name("page") Integer page, @Name("pageSize") Integer pageSize, @Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta cupo rotativo en GraphQL");
        try {
            ConsultarCupoRotativoOutput list = clienteFICService.consultarCupoRotativo(page, pageSize, numeroCliente);
            logger.info("Termina consulta cupo rotativo en GraphQL");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaCupoRotativo GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaCupoRotativo GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaHistorialContacto")
    @Description("Consulta de dirección y teléfono de cliente")
    public ConsultarHistorialContactoOutput consultaHistorialContacto(@Name("page") Integer page, @Name("pageSize") Integer pageSize, @Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta contacto en GraphQL");
        try {
            ConsultarHistorialContactoOutput data = clienteFICService.consultarHistorialContacto(page, pageSize, numeroCliente);

            logger.info("Termina consulta contacto en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaHistorialContacto GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaHistorialContacto GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaOferta")
    @Description("Consulta de dirección y teléfono de cliente")
    public OfertasOutput consultaOferta(@Name("page") Integer page, @Name("pageSize") Integer pageSize, @Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta oferta en GraphQL");
        try {
            OfertasOutput data = clienteFICService.consultarOferta(page, pageSize, numeroCliente);

            logger.info("Termina consulta oferta en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaOferta GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaOferta GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorNombre")
    @Description("Consulta de Cliente FIC por nombre")
    public ConsultarClientePorNombreOutputEntity consultaClientePorNombre(@Name("nombre") String nombre) {

        logger.info("Inicia consulta cliente por nombre en GraphQL");
        try {
            ConsultarClientePorNombreOutputEntity data = clienteFICService.consultarClienteFicPorNombre(nombre, 1, 15);

            logger.info("Termina consulta cliente por nombre en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaClientePorNombre GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaClientePorNombre GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPasivo")
    @Description("Consulta de pasivo de cliente")
    public ConsultarPasivoOutput consultaPasivo(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta pasivo en GraphQL");
        try {
            ConsultarPasivoOutput data = clienteFICService.consultarPasivo(1,1000,numeroCliente);

            logger.info("Termina consulta pasivo en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en consultaPasivo GraphQL");
            throw new ApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        } catch (Exception e){

            logger.error("Ocurrió un error en consultaPasivo GraphQL");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

}
