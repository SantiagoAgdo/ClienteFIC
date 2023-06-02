package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICExceptionObj;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    public Response verificarClienteFIC(ClienteFICType novedadCDTDigitalType) throws ClienteFICExceptionObj {



        logger.info("Validacion realizadas correctamente");

        return Response.ok().build();
    }
}
