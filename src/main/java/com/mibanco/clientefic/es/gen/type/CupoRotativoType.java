package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("CupoRotativoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-12-12T10:23:40.602639800-05:00[America/Bogota]")
public class CupoRotativoType   {
  private @Valid String estado;
  private @Valid String fechaDeVencimiento;
  private @Valid Float montoCupoCredito;
  private @Valid Float montoUtilizado;
  private @Valid Integer numeroCliente;
  private @Valid String numeroCupo;
  private @Valid Float saldoDisponible;

  /**
   **/
  public CupoRotativoType estado(String estado) {
    this.estado = estado;
    return this;
  }

  
  @JsonProperty("estado")
  public String getEstado() {
    return estado;
  }

  @JsonProperty("estado")
  public void setEstado(String estado) {
    this.estado = estado;
  }

  /**
   **/
  public CupoRotativoType fechaDeVencimiento(String fechaDeVencimiento) {
    this.fechaDeVencimiento = fechaDeVencimiento;
    return this;
  }

  
  @JsonProperty("fechaDeVencimiento")
  public String getFechaDeVencimiento() {
    return fechaDeVencimiento;
  }

  @JsonProperty("fechaDeVencimiento")
  public void setFechaDeVencimiento(String fechaDeVencimiento) {
    this.fechaDeVencimiento = fechaDeVencimiento;
  }

  /**
   **/
  public CupoRotativoType montoCupoCredito(Float montoCupoCredito) {
    this.montoCupoCredito = montoCupoCredito;
    return this;
  }

  
  @JsonProperty("montoCupoCredito")
  public Float getMontoCupoCredito() {
    return montoCupoCredito;
  }

  @JsonProperty("montoCupoCredito")
  public void setMontoCupoCredito(Float montoCupoCredito) {
    this.montoCupoCredito = montoCupoCredito;
  }

  /**
   **/
  public CupoRotativoType montoUtilizado(Float montoUtilizado) {
    this.montoUtilizado = montoUtilizado;
    return this;
  }

  
  @JsonProperty("montoUtilizado")
  public Float getMontoUtilizado() {
    return montoUtilizado;
  }

  @JsonProperty("montoUtilizado")
  public void setMontoUtilizado(Float montoUtilizado) {
    this.montoUtilizado = montoUtilizado;
  }

  /**
   **/
  public CupoRotativoType numeroCliente(Integer numeroCliente) {
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
  public CupoRotativoType numeroCupo(String numeroCupo) {
    this.numeroCupo = numeroCupo;
    return this;
  }

  
  @JsonProperty("numeroCupo")
  public String getNumeroCupo() {
    return numeroCupo;
  }

  @JsonProperty("numeroCupo")
  public void setNumeroCupo(String numeroCupo) {
    this.numeroCupo = numeroCupo;
  }

  /**
   **/
  public CupoRotativoType saldoDisponible(Float saldoDisponible) {
    this.saldoDisponible = saldoDisponible;
    return this;
  }

  
  @JsonProperty("saldoDisponible")
  public Float getSaldoDisponible() {
    return saldoDisponible;
  }

  @JsonProperty("saldoDisponible")
  public void setSaldoDisponible(Float saldoDisponible) {
    this.saldoDisponible = saldoDisponible;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CupoRotativoType cupoRotativoType = (CupoRotativoType) o;
    return Objects.equals(this.estado, cupoRotativoType.estado) &&
        Objects.equals(this.fechaDeVencimiento, cupoRotativoType.fechaDeVencimiento) &&
        Objects.equals(this.montoCupoCredito, cupoRotativoType.montoCupoCredito) &&
        Objects.equals(this.montoUtilizado, cupoRotativoType.montoUtilizado) &&
        Objects.equals(this.numeroCliente, cupoRotativoType.numeroCliente) &&
        Objects.equals(this.numeroCupo, cupoRotativoType.numeroCupo) &&
        Objects.equals(this.saldoDisponible, cupoRotativoType.saldoDisponible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(estado, fechaDeVencimiento, montoCupoCredito, montoUtilizado, numeroCliente, numeroCupo, saldoDisponible);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CupoRotativoType {\n");
    
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    fechaDeVencimiento: ").append(toIndentedString(fechaDeVencimiento)).append("\n");
    sb.append("    montoCupoCredito: ").append(toIndentedString(montoCupoCredito)).append("\n");
    sb.append("    montoUtilizado: ").append(toIndentedString(montoUtilizado)).append("\n");
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    numeroCupo: ").append(toIndentedString(numeroCupo)).append("\n");
    sb.append("    saldoDisponible: ").append(toIndentedString(saldoDisponible)).append("\n");
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

