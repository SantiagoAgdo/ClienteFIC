package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("NegocioType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-05T11:23:37.436663-05:00[America/Bogota]")
public class NegocioType   {
  private @Valid String direccion = null;
  private @Valid Integer telefono;
  private @Valid TipoActividadCIIUEnum tipoActividadCIIU;
  private @Valid Integer numeroCliente;

  /**
   **/
  public NegocioType direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  
  @JsonProperty("direccion")
  public String getDireccion() {
    return direccion;
  }

  @JsonProperty("direccion")
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   **/
  public NegocioType telefono(Integer telefono) {
    this.telefono = telefono;
    return this;
  }

  
  @JsonProperty("telefono")
  public Integer getTelefono() {
    return telefono;
  }

  @JsonProperty("telefono")
  public void setTelefono(Integer telefono) {
    this.telefono = telefono;
  }

  /**
   **/
  public NegocioType tipoActividadCIIU(TipoActividadCIIUEnum tipoActividadCIIU) {
    this.tipoActividadCIIU = tipoActividadCIIU;
    return this;
  }

  
  @JsonProperty("tipoActividadCIIU")
  public TipoActividadCIIUEnum getTipoActividadCIIU() {
    return tipoActividadCIIU;
  }

  @JsonProperty("tipoActividadCIIU")
  public void setTipoActividadCIIU(TipoActividadCIIUEnum tipoActividadCIIU) {
    this.tipoActividadCIIU = tipoActividadCIIU;
  }

  /**
   **/
  public NegocioType numeroCliente(Integer numeroCliente) {
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
    NegocioType negocioType = (NegocioType) o;
    return Objects.equals(this.direccion, negocioType.direccion) &&
        Objects.equals(this.telefono, negocioType.telefono) &&
        Objects.equals(this.tipoActividadCIIU, negocioType.tipoActividadCIIU) &&
        Objects.equals(this.numeroCliente, negocioType.numeroCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direccion, telefono, tipoActividadCIIU, numeroCliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NegocioType {\n");
    
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    tipoActividadCIIU: ").append(toIndentedString(tipoActividadCIIU)).append("\n");
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

