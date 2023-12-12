package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("DomicilioBaseType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-12-12T10:23:40.602639800-05:00[America/Bogota]")
public class DomicilioBaseType   {
  private @Valid Integer numeroCliente;
  private @Valid String direcccion;
  private @Valid Integer telefono1;
  private @Valid Integer telefono2;
  private @Valid TipoViviendaEnum tipoVivienda;

  /**
   **/
  public DomicilioBaseType numeroCliente(Integer numeroCliente) {
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
   **/
  public DomicilioBaseType direcccion(String direcccion) {
    this.direcccion = direcccion;
    return this;
  }

  
  @JsonProperty("direcccion")
  public String getDirecccion() {
    return direcccion;
  }

  @JsonProperty("direcccion")
  public void setDirecccion(String direcccion) {
    this.direcccion = direcccion;
  }

  /**
   **/
  public DomicilioBaseType telefono1(Integer telefono1) {
    this.telefono1 = telefono1;
    return this;
  }

  
  @JsonProperty("telefono1")
  public Integer getTelefono1() {
    return telefono1;
  }

  @JsonProperty("telefono1")
  public void setTelefono1(Integer telefono1) {
    this.telefono1 = telefono1;
  }

  /**
   **/
  public DomicilioBaseType telefono2(Integer telefono2) {
    this.telefono2 = telefono2;
    return this;
  }

  
  @JsonProperty("telefono2")
  public Integer getTelefono2() {
    return telefono2;
  }

  @JsonProperty("telefono2")
  public void setTelefono2(Integer telefono2) {
    this.telefono2 = telefono2;
  }

  /**
   **/
  public DomicilioBaseType tipoVivienda(TipoViviendaEnum tipoVivienda) {
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
    DomicilioBaseType domicilioBaseType = (DomicilioBaseType) o;
    return Objects.equals(this.numeroCliente, domicilioBaseType.numeroCliente) &&
        Objects.equals(this.direcccion, domicilioBaseType.direcccion) &&
        Objects.equals(this.telefono1, domicilioBaseType.telefono1) &&
        Objects.equals(this.telefono2, domicilioBaseType.telefono2) &&
        Objects.equals(this.tipoVivienda, domicilioBaseType.tipoVivienda);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCliente, direcccion, telefono1, telefono2, tipoVivienda);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioBaseType {\n");
    
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    direcccion: ").append(toIndentedString(direcccion)).append("\n");
    sb.append("    telefono1: ").append(toIndentedString(telefono1)).append("\n");
    sb.append("    telefono2: ").append(toIndentedString(telefono2)).append("\n");
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

