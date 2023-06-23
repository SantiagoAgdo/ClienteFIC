package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.constans.Constans;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    private String msmError = "";

    public void verificarClienteFIC(ClienteFICType clienteFICType) throws ApplicationExceptionValidation {

        if (validarObjeto(clienteFICType)) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getAlerta())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getClienteBase())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getCentralRiesgo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }

        if (validarObjeto(clienteFICType.getContacto())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getConyuge())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getCupoRotativo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getDomicilioEmpresa())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getNegocio())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getOferta())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getPasivo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }
        if (validarObjeto(clienteFICType.getPQR())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO + msmError + " es obligatorio"
            );
        }

        logger.info("Validacion realizadas correctamente");
        Response.ok().build();
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

        return !isValidateSuccess;
    }

    public void validarNombre(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " digitoVerificacion invalido"
            );
        }

        logger.info("Validacion realizadas correctamente");
        Response.ok().build();

    }

    public void validarNumeroCliente(Integer num) {

        if (num == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " numero de Cliente invalido"
            );
        }

        logger.info("Validacion realizadas correctamente");
        Response.ok().build();

    }

    public void validarConsulta(TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) throws ApplicationExceptionValidation {
        if (numeroDocumento == null || numeroDocumento < 0) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " numeroDocumento invalido"
            );
        }
        if (digitoVerificacion == null || digitoVerificacion < 0 || digitoVerificacion > 99) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " digitoVerificacion invalido"
            );
        }
        for (TipoDocumentoEnum enumValue : TipoDocumentoEnum.values()) {
            if (enumValue.name().equals(tipoDocumento.name())) {
                logger.info("Validacion realizadas correctamente");
                Response.ok().build();
                return;
            }
        }

        throw new ApplicationExceptionValidation(
                Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " tipoDocumento invalido"
        );
    }

    public void validaConsulta(com.mibanco.clientefic.es.TipoDocumentoEnum tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) throws ApplicationExceptionValidation {

        if (numeroDocumento == null || numeroDocumento < 0) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " numeroDocumento invalido"
            );
        }
        if (digitoVerificacion == null || digitoVerificacion < 0 || digitoVerificacion > 99) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " digitoVerificacion invalido"
            );
        }
        for (TipoDocumentoEnum enumValue : TipoDocumentoEnum.values()) {
            if (enumValue.name().equals(tipoDocumento.name())) {
                logger.info("Validacion realizadas correctamente");
                Response.ok().build();
                return;
            }
        }

        throw new ApplicationExceptionValidation(
                Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " tipoDocumento invalido"
        );
    }
}
