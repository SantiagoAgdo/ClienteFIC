package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoActividadCIIUEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("DomicilioEmpresaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-05T13:54:01.725107-05:00[America/Bogota]")
public class DomicilioEmpresaType   {
  private @Valid Integer numeroCliente;
  private @Valid TipoActividadCIIUEnum tipoActividadCIIU;
  private @Valid String tipoLocal;

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
  public DomicilioEmpresaType tipoLocal(String tipoLocal) {
    this.tipoLocal = tipoLocal;
    return this;
  }

  
  @JsonProperty("tipoLocal")
  public String getTipoLocal() {
    return tipoLocal;
  }

  @JsonProperty("tipoLocal")
  public void setTipoLocal(String tipoLocal) {
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
        Objects.equals(this.tipoActividadCIIU, domicilioEmpresaType.tipoActividadCIIU) &&
        Objects.equals(this.tipoLocal, domicilioEmpresaType.tipoLocal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCliente, tipoActividadCIIU, tipoLocal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioEmpresaType {\n");
    
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
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

