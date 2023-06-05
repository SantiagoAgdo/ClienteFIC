package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.Error;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    public Response verificarClienteFIC(ClienteFICType clienteFICType) throws ClienteFICException {

        if (clienteFICType.getAlerta() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " Alerta no puede ser null"
            );
        }

        if (clienteFICType.getAlerta().getBanco() == null || clienteFICType.getAlerta().getBanco() == "" ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " banco  no pueder ser null"
            );
        }

        if (clienteFICType.getAlerta().getFecha() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " fecha  no pueder ser null"
            );
        }

        if (clienteFICType.getAlerta().getTipoDocumento() == null){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " tipo documento  no pueder null"
            );
        }

        if (clienteFICType.getAlerta().getNumeroDocumento() == null || clienteFICType.getAlerta().getNumeroDocumento() == ""){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " numero documento  no pueder null"
            );
        }

        if (clienteFICType.getAlerta().getDigitoVerificacion() == null || clienteFICType.getAlerta().getDigitoVerificacion() == ""){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " digito verificacion  no pueder null"
            );
        }


        if (clienteFICType.getClienteBase() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " clienteBase no puede ser null"
            );
        }

        if (clienteFICType.getCentralRiesgo() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " centralRiesgo no puede ser null"
            );
        }

        if (clienteFICType.getContacto() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " contacto no puede ser null"
            );
        }

        if (clienteFICType.getCupoRotativo() == null ){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + " cupo Rotativo no puede ser null"
            );
        }


        logger.info("Validacion realizadas correctamente");

        return Response.ok().build();
    }
}
