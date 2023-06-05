package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.Error;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-05T11:23:37.436663-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @POST
    @Path("/clienteFIC")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteFICType(@Valid ClienteFICType clienteFICType);

    @GET
    @Path("/alerta")
    @Produces({ "application/json" })
    Response v1EsAlertaGet(@QueryParam("tipoDocumento")   String tipoDocumento,@QueryParam("numeroDocumento")   Integer numeroDocumento,@QueryParam("digitoVerificacion")   Integer digitoVerificacion);

    @GET
    @Path("/centralRiesgo")
    @Produces({ "application/json" })
    Response v1EsCentralRiesgoGet(@QueryParam("tipoDocumento")   String tipoDocumento,@QueryParam("numeroDocumento")   Integer numeroDocumento,@QueryParam("digitoVerificacion")   Integer digitoVerificacion);
}
