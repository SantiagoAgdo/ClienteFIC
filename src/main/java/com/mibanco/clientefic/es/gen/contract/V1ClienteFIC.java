package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.ClienteFICType;

import jakarta.ws.rs.*;
import java.util.List;
import jakarta.validation.Valid;

@Path("/v1/es/clienteFIC")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-02T11:50:18.213230-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    List<ClienteFICType> crearClienteFICType(@Valid ClienteFICType clienteFICType);
}
