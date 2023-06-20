package com.mibanco.clientefic.es.utils.Exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ClienteFICExceptionGRPC implements ExceptionMapper<GrpcExceptions> {

    @Override
    public Response toResponse(GrpcExceptions grpcExceptions) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("==== ERROR GRPC =====")
                .build();
    }
}
