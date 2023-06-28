package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.constans.Constans;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    private String msmError = "";

    public void verificarClienteFIC(ClienteFICType clienteFICType) throws ApplicationExceptionValidation {

        if (tieneAtributosNulos(clienteFICType)) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getAlerta())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getClienteBase())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getCentralRiesgo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }

        if (tieneAtributosNulos(clienteFICType.getContacto())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getConyuge())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getCupoRotativo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getDomicilioEmpresa())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getNegocio())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getOferta())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getPasivo())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }
        if (tieneAtributosNulos(clienteFICType.getPQR())) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + msmError + " obligatorios"
            );
        }

        logger.info("Validacion realizadas correctamente");
        Response.ok().build();
    }


    public boolean tieneAtributosNulos(Object obj) {
        boolean isValidateSuccess = true;
        try {
            BeanInfo bean = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] descripcionDePropiedades = bean.getPropertyDescriptors();

            for (PropertyDescriptor atr : descripcionDePropiedades) {
                Object valor = atr.getReadMethod().invoke(obj);
                if (valor == null) {
                    isValidateSuccess = false;
                }
            }
        } catch (IntrospectionException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        if (!isValidateSuccess) {
            msmError = "Se encontro datos nulos o vacios, verifique los datos";
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
