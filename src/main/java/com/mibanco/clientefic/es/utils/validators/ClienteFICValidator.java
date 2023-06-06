package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    private String msmError = "";

    public Response verificarClienteFIC(ClienteFICType clienteFICType) throws ClienteFICException {

        if (!validarObjeto(clienteFICType)) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getAlerta())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getClienteBase())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getCentralRiesgo())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getContacto())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getConyuge())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getCupoRotativo())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getDomicilioEmpresa())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }

        if (!validarObjeto(clienteFICType.getNegocio())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getOferta())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getPasivo())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        if (!validarObjeto(clienteFICType.getPQR())) {
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + msmError
            );
        }
        logger.info("Validacion realizadas correctamente");
        return Response.ok().build();
    }

    public Response validarAlerta(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) throws ClienteFICException {
        if (numeroDocumento == null || numeroDocumento.isEmpty()){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + "Alerta, numeroDocumento invalido"
            );
        }
        if (digitoVerificacion == null || digitoVerificacion.isEmpty()){
            throw new ClienteFICException(
                    Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + "Alerta, digitoVerificacion invalido"
            );
        }
        for (TipoDocumentoEnum enumValue : TipoDocumentoEnum.values()) {
            if (enumValue.name().equals(tipoDocumento)) {
                logger.info("Validacion realizadas correctamente");
                return Response.ok().build();
            }
        }
        throw new ClienteFICException(
                Response.Status.BAD_REQUEST.getStatusCode(), ErrorCts.VALIDACION + "Alertar, tipoDocumento invalido"
        );
    }


    public boolean validarObjeto(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] atributos = objClass.getDeclaredFields();
        msmError = objClass.getSimpleName() + " en ";
        boolean isValidateSuccess = true;

        for (Field atr : atributos) {
            atr.setAccessible(true);
            try {
                Object value = atr.get(obj);

                if (value == null || value.toString().isEmpty()) {
                    msmError += atr.getName() + ", ";
                    isValidateSuccess = false;
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (!isValidateSuccess) {
            msmError = msmError.substring(0, msmError.length() - 2);
        }

        return isValidateSuccess;
    }


}
