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
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ClienteFICValidator {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICValidator.class);

    private String msmError = "";

    public void verificarClienteFIC(ClienteFICType clienteFICType) throws ApplicationExceptionValidation {

        if (clienteFICType == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar dato null."
            );
        }

        if (clienteFICType.getAlerta() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar alertas null."
            );
        }

        if (clienteFICType.getClienteBase() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar cliente base null."
            );
        }

        if (clienteFICType.getCentralRiesgo() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar central de riesgo null."
            );
        }

        if (clienteFICType.getContacto() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar contacto null."
            );
        }

        if (clienteFICType.getConyuge() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar conyuge null."
            );
        }

        if (clienteFICType.getCupoRotativo() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar cupo rotativo null."
            );
        }

        if (clienteFICType.getOferta() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar oferta null."
            );
        }

        if (clienteFICType.getPQR() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.SERVICIO_INTERNAL + "la peticion no puede presentar PQR null."
            );
        }

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

    public void validarNombre(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " nombre invalido"
            );
        }

        logger.info("Validacion realizadas correctamente");
        Response.ok().build();

    }

    public void validarConsultaPorNombre(String nombre, String apellido, String razonSocial) {

        if (nombre == null || nombre.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " nombre invalido"
            );
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " apellido invalido"
            );
        }

        if (razonSocial == null || razonSocial.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " razonSocial invalido"
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

    void x() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()

                .map(n -> n * 2)

                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
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

    public void validaConsulta(String tipoDocumento, Integer numeroDocumento, Integer digitoVerificacion) throws ApplicationExceptionValidation {

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
        if (tipoDocumento == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constans.VALIDACION + " tipoDocumento invalido"
            );
        }

    }
}
