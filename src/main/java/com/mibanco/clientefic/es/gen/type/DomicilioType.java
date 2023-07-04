package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("DomicilioType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-07-04T10:53:53.775738-05:00[America/Bogota]")
public class DomicilioType {
    private @Valid Integer numeroCliente;
    private @Valid TipoViviendaEnum tipoVivienda;

    /**
     *
     **/
    public DomicilioType numeroCliente(Integer numeroCliente) {
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

    /**
     *
     **/
    public DomicilioType tipoVivienda(TipoViviendaEnum tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
        return this;
    }


    @JsonProperty("tipoVivienda")
    public TipoViviendaEnum getTipoVivienda() {
        return tipoVivienda;
    }

    @JsonProperty("tipoVivienda")
    public void setTipoVivienda(TipoViviendaEnum tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DomicilioType domicilioType = (DomicilioType) o;
        return Objects.equals(this.numeroCliente, domicilioType.numeroCliente) &&
                Objects.equals(this.tipoVivienda, domicilioType.tipoVivienda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCliente, tipoVivienda);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DomicilioType {\n");

        sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
        sb.append("    tipoVivienda: ").append(toIndentedString(tipoVivienda)).append("\n");
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

