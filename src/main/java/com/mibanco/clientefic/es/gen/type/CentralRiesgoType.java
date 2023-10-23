package com.mibanco.clientefic.es.gen.type;

import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("CentralRiesgoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-23T10:28:57.971809-05:00[America/Bogota]")
public class CentralRiesgoType   {
  private @Valid Integer numeroCliente = null;
  private @Valid Date fechaConsultaMasReciente = null;
  private @Valid String resultadoConsultaMasReciente = null;
  private @Valid String vbVigenteParaSerConsultado = null;

  /**
   **/
  public CentralRiesgoType numeroCliente(Integer numeroCliente) {
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
  public CentralRiesgoType fechaConsultaMasReciente(Date fechaConsultaMasReciente) {
    this.fechaConsultaMasReciente = fechaConsultaMasReciente;
    return this;
  }

  
  @JsonProperty("fechaConsultaMasReciente")
  public Date getFechaConsultaMasReciente() {
    return fechaConsultaMasReciente;
  }

  @JsonProperty("fechaConsultaMasReciente")
  public void setFechaConsultaMasReciente(Date fechaConsultaMasReciente) {
    this.fechaConsultaMasReciente = fechaConsultaMasReciente;
  }

  /**
   **/
  public CentralRiesgoType resultadoConsultaMasReciente(String resultadoConsultaMasReciente) {
    this.resultadoConsultaMasReciente = resultadoConsultaMasReciente;
    return this;
  }

  
  @JsonProperty("resultadoConsultaMasReciente")
  public String getResultadoConsultaMasReciente() {
    return resultadoConsultaMasReciente;
  }

  @JsonProperty("resultadoConsultaMasReciente")
  public void setResultadoConsultaMasReciente(String resultadoConsultaMasReciente) {
    this.resultadoConsultaMasReciente = resultadoConsultaMasReciente;
  }

  /**
   **/
  public CentralRiesgoType vbVigenteParaSerConsultado(String vbVigenteParaSerConsultado) {
    this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
    return this;
  }

  
  @JsonProperty("vbVigenteParaSerConsultado")
  public String getVbVigenteParaSerConsultado() {
    return vbVigenteParaSerConsultado;
  }

  @JsonProperty("vbVigenteParaSerConsultado")
  public void setVbVigenteParaSerConsultado(String vbVigenteParaSerConsultado) {
    this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CentralRiesgoType centralRiesgoType = (CentralRiesgoType) o;
    return Objects.equals(this.numeroCliente, centralRiesgoType.numeroCliente) &&
        Objects.equals(this.fechaConsultaMasReciente, centralRiesgoType.fechaConsultaMasReciente) &&
        Objects.equals(this.resultadoConsultaMasReciente, centralRiesgoType.resultadoConsultaMasReciente) &&
        Objects.equals(this.vbVigenteParaSerConsultado, centralRiesgoType.vbVigenteParaSerConsultado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCliente, fechaConsultaMasReciente, resultadoConsultaMasReciente, vbVigenteParaSerConsultado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CentralRiesgoType {\n");
    
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    fechaConsultaMasReciente: ").append(toIndentedString(fechaConsultaMasReciente)).append("\n");
    sb.append("    resultadoConsultaMasReciente: ").append(toIndentedString(resultadoConsultaMasReciente)).append("\n");
    sb.append("    vbVigenteParaSerConsultado: ").append(toIndentedString(vbVigenteParaSerConsultado)).append("\n");
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

