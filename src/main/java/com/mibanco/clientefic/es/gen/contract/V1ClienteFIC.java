package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.Error;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-06T12:10:12.590977-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @POST
    @Path("/clienteFIC")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteFICType(@Valid ClienteFICType clienteFICType);

    @GET
    @Path("/alerta")
    @Produces({ "application/json" })
    Response v1EsAlertaGet(@QueryParam("tipoDocumento")   TipoDocumentoEnum tipoDocumento,@QueryParam("numeroDocumento")   String numeroDocumento,@QueryParam("digitoVerificacion")   String digitoVerificacion);

    @GET
    @Path("/centralRiesgo")
    @Produces({ "application/json" })
    Response v1EsCentralRiesgoGet(@QueryParam("tipoDocumento")   TipoDocumentoEnum tipoDocumento,@QueryParam("numeroDocumento")   String numeroDocumento,@QueryParam("digitoVerificacion")   String digitoVerificacion);
}
