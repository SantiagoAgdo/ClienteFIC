package com.mibanco.clientefic.es.utils.contract;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IAutenticacion {

    @GET
    Response verificarAcceso(
            @HeaderParam("jwt") String jwt,
            @HeaderParam("resourceRequest") String resourceRequest,
            @HeaderParam("clientAction") String clientAction
    );
}




