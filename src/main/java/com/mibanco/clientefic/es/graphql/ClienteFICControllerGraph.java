package com.mibanco.clientefic.es.graphql;

import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
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

    @Query("consultaNovedadPorNumeroDocumento")
    @Description("Consulta de novedades por numero de documento")
    public List<AlertaType> getAlerta(@Name("TipoDocumento") TipoDocumentoEnum tipoDocumento, @Name("numeroDocumento") Integer numeroDocumento, @Name("digitoVerificacion") Integer digitoVerificacion) {

        logger.info("Inicia consulta alerta en Graphql");

        try {
            List<AlertaType> alerta = clienteFICService.getListaAlertas(new ConsultaClienteByData(tipoDocumento, numeroDocumento, digitoVerificacion));
            logger.info("Termina consulta alerta en Graphql");
            return alerta;
        } catch (ClienteFICException e) {
            logger.error("Ocurrio un error en getNovedadPorDocuemnto Graphql");
            throw new ClienteFICException(Response.Status.NOT_FOUND.getStatusCode(), "ERROR_SERVICIO: " + e.getMessage() + " en ClienteFICControllerGraph");
        }
    }

}
