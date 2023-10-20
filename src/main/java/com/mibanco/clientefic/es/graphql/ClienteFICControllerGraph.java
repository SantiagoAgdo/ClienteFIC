package com.mibanco.clientefic.es.graphql;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
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

        logger.info("Inicia consulta alerta en Graphql");

        try {
            List<AlertaType> alerta = clienteFICService.getListaAlertas(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));
            logger.info("Termina consulta alerta en Graphql");
            return alerta;
        } catch (ApplicationException e) {
            logger.error("Ocurrio un error en getAlerta Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCentralRiesgo")
    @Description("Consulta de central de riesgo")
    public List<CentralRiesgoType> getCentral(@Name("numeroDocumento") Integer numeroCliente) {

        logger.info("Inicia consulta alerta en Graphql");
        try {
            List<CentralRiesgoType> list = clienteFICService.getListaCentralRiesgo(numeroCliente);

            logger.info("Termina consulta alerta en Graphql");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getCentral Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPQR")
    @Description("Consulta de PQR")
    public List<PQRType> getPQR(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta PQR en Graphql");
        try {
            List<PQRType> list = clienteFICService.getPQR(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consulta PQR en Graphql");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getPQR Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorIdentificacion")
    @Description("Consulta de cliente por identificacion")
    public ClienteFICEntity getClienteByIdentificacion(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta cliente en Graphql");
        try {
            ClienteFICEntity list = clienteFICService.getClienteByIdentificacion(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));

            logger.info("Termina consulta cliente en Graphql");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getClienteByIdentificacion Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaConyuge")
    @Description("Consulta de conyuge por numero de cliente")
    public ConyugeType getConyuge(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta conyuge en Graphql");
        try {
            ConyugeType data = clienteFICService.getConyuge(numeroCliente);

            logger.info("Termina consulta conyuge en Graphql");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getConyuge Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaCupoRotativo")
    @Description("Consulta de conyuge por numero de cliente")
    public List<CupoRotativoType> getCupoRotativo(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta cupo rotativo en Graphql");
        try {
            List<CupoRotativoType> list = clienteFICService.getCupoRotativo(numeroCliente);
            logger.info("Termina consulta cupo rotativo en Graphql");
            return list;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getCupoRotativo Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaHistorialContacto")
    @Description("Consulta de Dirreccion y telefono de cliente")
    public List<ContactoType> getHistorialContacto(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta contacto en Graphql");
        try {
            List<ContactoType> data = clienteFICService.getContacto(numeroCliente);

            logger.info("Termina consulta contacto en Graphql");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getHistorialContacto Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaOferta")
    @Description("Consulta de Dirreccion y telefono de cliente")
    public List<OfertaType> getOferta(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta oferta en Graphql");
        try {
            List<OfertaType> data = clienteFICService.getOferta(numeroCliente);

            logger.info("Termina consulta oferta en Graphql");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getOferta Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaClientePorNombre")
    @Description("Consulta de Cliente FIC por nombre")
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(@Name("nombre") String nombre) {

        logger.info("Inicia consulta cliente por nombre en Graphql");
        try {
            ConsultarClientePorNombreOutputEntity data = clienteFICService.getClienteByNombre(nombre);

            logger.info("Termina consulta cliente por nombreen Graphql");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getClienteByNombre Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

    @Query("consultaPasivo")
    @Description("Consulta de pasivo de cliente")
    public List<PasivoType> getPasivo(@Name("numeroCliente") Integer numeroCliente) {

        logger.info("Inicia consulta pasivo en Graphql");
        try {
            List<PasivoType> data = clienteFICService.getPasivo(numeroCliente);

            logger.info("Termina consulta pasivo en Graphql");
            return data;
        } catch (ApplicationException e) {

            logger.error("Ocurrio un error en getPasivo Graphql");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

}
