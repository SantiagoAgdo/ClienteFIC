package com.mibanco.clientefic.es.utils.validators;

import com.mibanco.clientefic.es.constants.Constants;
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

    private void verificarAtributoNoNulo(Object atributo, String nombreAtributo) throws ApplicationExceptionValidation {
        if (atributo == null || tieneAtributosNulos(atributo)) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.SERVICIO_INTERNAL + "La petición no puede presentar " + nombreAtributo + " nulo o con atributos nulos."
            );
        }
    }

    public void validarConsultaPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " Nombre inválido"
            );
        }

        // Expresión regular que valida la ausencia de los caracteres especiales
        String patronEspecial = ".*[$%<>*&#].*";
        if (nombre.matches(patronEspecial)) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " El nombre no debe contener caracteres especiales como $, %, <, >, *, &, #"
            );
        }

        logger.info("Validación realizada correctamente");
    }

    public void validarNumeroCliente(Integer numeroCliente) {
        if (numeroCliente == null || numeroCliente <= 0) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " Número de Cliente inválido"
            );
        }

        logger.info("Validación del número de cliente realizada correctamente");
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

    public void validarConsulta(TipoDocumentoEnum tipoDocumento, String numeroDocumento, Integer digitoVerificacion) throws ApplicationExceptionValidation {
        validarDocumento(numeroDocumento, digitoVerificacion, tipoDocumento);
        logger.info("Validación realizada correctamente");
    }

    public void validarConsultaGrpc(String tipoDocumento, String numeroDocumento, Integer digitoVerificacion) throws ApplicationExceptionValidation {
        validarDocumento(numeroDocumento, digitoVerificacion, tipoDocumento);
        logger.info("Validación realizada correctamente");
    }

    //02. Campo Tipo de Documento y Número de Documento es obligatorio para la consulta Número de Documento. : Public <<FunctionalRequirement>>
    private void validarDocumento(String numeroDocumento, Integer digitoVerificacion, Object tipoDocumento) throws ApplicationExceptionValidation {
        if (numeroDocumento == null || numeroDocumento == "") {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " Número de Documento inválido"
            );
        }
        if (digitoVerificacion == null || digitoVerificacion < 0 || digitoVerificacion > 99) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " Dígito de Verificación inválido"
            );
        }
        if (tipoDocumento == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.VALIDACION + " Tipo de Documento inválido"
            );
        }
    }

}
