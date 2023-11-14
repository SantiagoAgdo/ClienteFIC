package com.mibanco.clientefic.es.graphql;

import com.mibanco.clientefic.es.dao.entity.ConsultaClienteDataEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
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
    public List<AlertaType> getAlerta(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta de alerta en GraphQL");

        try {
            List<AlertaType> alerta = clienteFICService.obtenerListaAlertas(new ConsultaClienteDataEntity(tipoDocumento, numeroDocumento, digitoVerificacion));
            logger.info("Termina consulta de alerta en GraphQL");
            return alerta;
        } catch (ApplicationException e) {
            logger.error("Ocurrió un error en getAlerta GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCentralRiesgo")
    @Description("Consulta de central de riesgo")
    public List<CentralRiesgoType> getCentral(@Name("numeroDocumento") Integer numeroCliente) {

        logger.info("Inicia consulta de central de riesgo en GraphQL");
        try {
            List<CentralRiesgoType> list = clienteFICService.obtenerListaCentralRiesgo(numeroCliente);

            logger.info("Termina consulta de central de riesgo en GraphQL");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getCentral GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPQR")
    @Description("Consulta de PQR")
    public List<PQRType> getPQR(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta de PQR en GraphQL");
        try {
            List<PQRType> list = clienteFICService.obtenerPQR(new ConsultaClienteDataEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consulta de PQR en GraphQL");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getPQR GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorIdentificacion")
    @Description("Consulta de cliente por identificación")
    public ClienteFICDTO getClienteByIdentificacion(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta de cliente en GraphQL");
        try {
            ClienteFICDTO list = clienteFICService.obtenerClienteIdentificacion(new ConsultaClienteDataEntity(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consulta de cliente en GraphQL");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getClienteByIdentificacion GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaConyuge")
    @Description("Consulta de cónyuge por número de cliente")
    public ConyugeType getConyuge(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta de cónyuge en GraphQL");
        try {
            ConyugeType data = clienteFICService.obtenerConyuge(numeroCliente);

            logger.info("Termina consulta de cónyuge en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getConyuge GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCupoRotativo")
    @Description("Consulta de cupo rotativo por número de cliente")
    public List<CupoRotativoType> getCupoRotativo(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta cupo rotativo en GraphQL");
        try {
            List<CupoRotativoType> list = clienteFICService.obtenerCupoRotativo(numeroCliente);
            logger.info("Termina consulta cupo rotativo en GraphQL");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getCupoRotativo GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaHistorialContacto")
    @Description("Consulta de dirección y teléfono de cliente")
    public List<ContactoType> getHistorialContacto(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta contacto en GraphQL");
        try {
            List<ContactoType> data = clienteFICService.obtenerContacto(numeroCliente);

            logger.info("Termina consulta contacto en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getHistorialContacto GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaOferta")
    @Description("Consulta de dirección y teléfono de cliente")
    public List<OfertaType> getOferta(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta oferta en GraphQL");
        try {
            List<OfertaType> data = clienteFICService.obtenerOferta(numeroCliente);

            logger.info("Termina consulta oferta en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getOferta GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorNombre")
    @Description("Consulta de Cliente FIC por nombre")
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(@Name("nombre") String nombre) {

        logger.info("Inicia consulta cliente por nombre en GraphQL");
        try {
            ConsultarClientePorNombreOutputEntity data = clienteFICService.obtenerClienteNombre(nombre, 1, 15);

            logger.info("Termina consulta cliente por nombre en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getClienteByNombre GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPasivo")
    @Description("Consulta de pasivo de cliente")
    public List<PasivoType> getPasivo(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta pasivo en GraphQL");
        try {
            List<PasivoType> data = clienteFICService.obtenerPasivo(numeroCliente);

            logger.info("Termina consulta pasivo en GraphQL");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrió un error en getPasivo GraphQL");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

}
