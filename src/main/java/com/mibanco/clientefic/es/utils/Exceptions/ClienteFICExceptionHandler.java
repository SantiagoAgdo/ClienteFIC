package com.mibanco.clientefic.es.utils.Exceptions;

import com.mibanco.clientefic.es.utils.dto.ErrorMessage;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ClienteFICExceptionHandler implements ExceptionMapper<ClienteFICException> {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICExceptionHandler.class);


    @Override
    public Response toResponse(ClienteFICException e) {
        logger.error("Exception: " + e.getMessage());
        ErrorMessage error = new ErrorMessage();
        error.setStatus(e.getStatus());
        error.setMessage(e.getMessage());
        return Response
                .serverError()
                .status(e.getStatus())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
