package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("ConyugeType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-29T09:35:48.752340-05:00[America/Bogota]")
public class ConyugeType {
    private @Valid TipoDocumentoEnum tipoDocumento;
    private @Valid String numeroDocumento;
    private @Valid String primerNombre;
    private @Valid String segundoNombre;
    private @Valid String primerApellido;
    private @Valid String segundoApellido;
    private @Valid Integer numeroCliente;

    /**
     *
     **/
    public ConyugeType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }


    @JsonProperty("tipoDocumento")
    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    @JsonProperty("tipoDocumento")
    public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     *
     **/
    public ConyugeType numeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }


    @JsonProperty("numeroDocumento")
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    @JsonProperty("numeroDocumento")
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     *
     **/
    public ConyugeType primerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }


    @JsonProperty("primerNombre")
    public String getPrimerNombre() {
        return primerNombre;
    }

    @JsonProperty("primerNombre")
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     *
     **/
    public ConyugeType segundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }


    @JsonProperty("segundoNombre")
    public String getSegundoNombre() {
        return segundoNombre;
    }

    @JsonProperty("segundoNombre")
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     *
     **/
    public ConyugeType primerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }


    @JsonProperty("primerApellido")
    public String getPrimerApellido() {
        return primerApellido;
    }

    @JsonProperty("primerApellido")
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     *
     **/
    public ConyugeType segundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }


    @JsonProperty("segundoApellido")
    public String getSegundoApellido() {
        return segundoApellido;
    }

    @JsonProperty("segundoApellido")
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     *
     **/
    public ConyugeType numeroCliente(Integer numeroCliente) {
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
        ConyugeType conyugeType = (ConyugeType) o;
        return Objects.equals(this.tipoDocumento, conyugeType.tipoDocumento) &&
                Objects.equals(this.numeroDocumento, conyugeType.numeroDocumento) &&
                Objects.equals(this.primerNombre, conyugeType.primerNombre) &&
                Objects.equals(this.segundoNombre, conyugeType.segundoNombre) &&
                Objects.equals(this.primerApellido, conyugeType.primerApellido) &&
                Objects.equals(this.segundoApellido, conyugeType.segundoApellido) &&
                Objects.equals(this.numeroCliente, conyugeType.numeroCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, numeroCliente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConyugeType {\n");

        sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
        sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
        sb.append("    primerNombre: ").append(toIndentedString(primerNombre)).append("\n");
        sb.append("    segundoNombre: ").append(toIndentedString(segundoNombre)).append("\n");
        sb.append("    primerApellido: ").append(toIndentedString(primerApellido)).append("\n");
        sb.append("    segundoApellido: ").append(toIndentedString(segundoApellido)).append("\n");
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

