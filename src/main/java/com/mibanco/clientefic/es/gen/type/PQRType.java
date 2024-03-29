package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("PQRType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-02-22T09:33:21.194046200-05:00[America/Bogota]")
public class PQRType   {
  private @Valid Integer numeroCliente;
  private @Valid String fecha;
  private @Valid Integer numeroPQR;
  private @Valid String motivo;
  private @Valid String resultadoPQR;
  private @Valid String comentario;

  /**
   **/
  public PQRType numeroCliente(Integer numeroCliente) {
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
  public PQRType fecha(String fecha) {
    this.fecha = fecha;
    return this;
  }

  
  @JsonProperty("fecha")
  public String getFecha() {
    return fecha;
  }

  @JsonProperty("fecha")
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   **/
  public PQRType numeroPQR(Integer numeroPQR) {
    this.numeroPQR = numeroPQR;
    return this;
  }

  
  @JsonProperty("numeroPQR")
  public Integer getNumeroPQR() {
    return numeroPQR;
  }

  @JsonProperty("numeroPQR")
  public void setNumeroPQR(Integer numeroPQR) {
    this.numeroPQR = numeroPQR;
  }

  /**
   **/
  public PQRType motivo(String motivo) {
    this.motivo = motivo;
    return this;
  }

  
  @JsonProperty("motivo")
  public String getMotivo() {
    return motivo;
  }

  @JsonProperty("motivo")
  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  /**
   **/
  public PQRType resultadoPQR(String resultadoPQR) {
    this.resultadoPQR = resultadoPQR;
    return this;
  }

  
  @JsonProperty("resultadoPQR")
  public String getResultadoPQR() {
    return resultadoPQR;
  }

  @JsonProperty("resultadoPQR")
  public void setResultadoPQR(String resultadoPQR) {
    this.resultadoPQR = resultadoPQR;
  }

  /**
   **/
  public PQRType comentario(String comentario) {
    this.comentario = comentario;
    return this;
  }

  
  @JsonProperty("comentario")
  public String getComentario() {
    return comentario;
  }

  @JsonProperty("comentario")
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PQRType pqRType = (PQRType) o;
    return Objects.equals(this.numeroCliente, pqRType.numeroCliente) &&
        Objects.equals(this.fecha, pqRType.fecha) &&
        Objects.equals(this.numeroPQR, pqRType.numeroPQR) &&
        Objects.equals(this.motivo, pqRType.motivo) &&
        Objects.equals(this.resultadoPQR, pqRType.resultadoPQR) &&
        Objects.equals(this.comentario, pqRType.comentario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCliente, fecha, numeroPQR, motivo, resultadoPQR, comentario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PQRType {\n");
    
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    numeroPQR: ").append(toIndentedString(numeroPQR)).append("\n");
    sb.append("    motivo: ").append(toIndentedString(motivo)).append("\n");
    sb.append("    resultadoPQR: ").append(toIndentedString(resultadoPQR)).append("\n");
    sb.append("    comentario: ").append(toIndentedString(comentario)).append("\n");
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

