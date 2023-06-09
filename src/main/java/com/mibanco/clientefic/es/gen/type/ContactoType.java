package com.mibanco.clientefic.es.gen.type;

import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("ContactoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-07-04T10:53:53.775738-05:00[America/Bogota]")
public class ContactoType {
    private @Valid Date fecha;
    private @Valid String tipoContacto;
    private @Valid String resultadoComentarios;
    private @Valid Integer numeroCliente;

    /**
     *
     **/
    public ContactoType fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }


    @JsonProperty("fecha")
    public Date getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     **/
    public ContactoType tipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
        return this;
    }


    @JsonProperty("tipoContacto")
    public String getTipoContacto() {
        return tipoContacto;
    }

    @JsonProperty("tipoContacto")
    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    /**
     *
     **/
    public ContactoType resultadoComentarios(String resultadoComentarios) {
        this.resultadoComentarios = resultadoComentarios;
        return this;
    }


    @JsonProperty("resultadoComentarios")
    public String getResultadoComentarios() {
        return resultadoComentarios;
    }

    @JsonProperty("resultadoComentarios")
    public void setResultadoComentarios(String resultadoComentarios) {
        this.resultadoComentarios = resultadoComentarios;
    }

    /**
     *
     **/
    public ContactoType numeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
        return this;
    }


    @JsonProperty("numeroCliente")
    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    @JsonProperty("numeroCliente")
    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactoType contactoType = (ContactoType) o;
        return Objects.equals(this.fecha, contactoType.fecha) &&
                Objects.equals(this.tipoContacto, contactoType.tipoContacto) &&
                Objects.equals(this.resultadoComentarios, contactoType.resultadoComentarios) &&
                Objects.equals(this.numeroCliente, contactoType.numeroCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tipoContacto, resultadoComentarios, numeroCliente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContactoType {\n");

        sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
        sb.append("    tipoContacto: ").append(toIndentedString(tipoContacto)).append("\n");
        sb.append("    resultadoComentarios: ").append(toIndentedString(resultadoComentarios)).append("\n");
        sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}

