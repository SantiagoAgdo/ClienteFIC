package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import com.mibanco.clientefic.es.gen.type.TipoLocalEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("DomicilioEmpresaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-09T11:34:41.559532-05:00[America/Bogota]")
public class DomicilioEmpresaType   {
  private @Valid Integer numeroCliente;
  private @Valid String direccion;
  private @Valid Integer telefono1;
  private @Valid Integer telefono2;
  private @Valid TipoActividadCIIUEnum tipoActividadCIIU;
  private @Valid TipoLocalEnum tipoLocal;

  /**
   **/
  public DomicilioEmpresaType numeroCliente(Integer numeroCliente) {
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
  public DomicilioEmpresaType direccion(String direccion) {
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
  public DomicilioEmpresaType telefono1(Integer telefono1) {
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
  public DomicilioEmpresaType telefono2(Integer telefono2) {
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
  public DomicilioEmpresaType tipoActividadCIIU(TipoActividadCIIUEnum tipoActividadCIIU) {
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
  public DomicilioEmpresaType tipoLocal(TipoLocalEnum tipoLocal) {
    this.tipoLocal = tipoLocal;
    return this;
  }

  
  @JsonProperty("tipoLocal")
  public TipoLocalEnum getTipoLocal() {
    return tipoLocal;
  }

  @JsonProperty("tipoLocal")
  public void setTipoLocal(TipoLocalEnum tipoLocal) {
    this.tipoLocal = tipoLocal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomicilioEmpresaType domicilioEmpresaType = (DomicilioEmpresaType) o;
    return Objects.equals(this.numeroCliente, domicilioEmpresaType.numeroCliente) &&
        Objects.equals(this.direccion, domicilioEmpresaType.direccion) &&
        Objects.equals(this.telefono1, domicilioEmpresaType.telefono1) &&
        Objects.equals(this.telefono2, domicilioEmpresaType.telefono2) &&
        Objects.equals(this.tipoActividadCIIU, domicilioEmpresaType.tipoActividadCIIU) &&
        Objects.equals(this.tipoLocal, domicilioEmpresaType.tipoLocal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCliente, direccion, telefono1, telefono2, tipoActividadCIIU, tipoLocal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioEmpresaType {\n");
    
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono1: ").append(toIndentedString(telefono1)).append("\n");
    sb.append("    telefono2: ").append(toIndentedString(telefono2)).append("\n");
    sb.append("    tipoActividadCIIU: ").append(toIndentedString(tipoActividadCIIU)).append("\n");
    sb.append("    tipoLocal: ").append(toIndentedString(tipoLocal)).append("\n");
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

