package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.SubProductoEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("PasivoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-06T12:10:12.590977-05:00[America/Bogota]")
public class PasivoType   {
  private @Valid String numeroProducto;
  private @Valid SubProductoEnum subProducto;
  private @Valid String estadoPasivo;
  private @Valid Date fechaApertura;
  private @Valid Date fechaCierre;
  private @Valid Float capital;
  private @Valid Float intereses;
  private @Valid Float otros;
  private @Valid Float saldoTotal;
  private @Valid Integer numeroCliente;

  /**
   **/
  public PasivoType numeroProducto(String numeroProducto) {
    this.numeroProducto = numeroProducto;
    return this;
  }

  
  @JsonProperty("numeroProducto")
  public String getNumeroProducto() {
    return numeroProducto;
  }

  @JsonProperty("numeroProducto")
  public void setNumeroProducto(String numeroProducto) {
    this.numeroProducto = numeroProducto;
  }

  /**
   **/
  public PasivoType subProducto(SubProductoEnum subProducto) {
    this.subProducto = subProducto;
    return this;
  }

  
  @JsonProperty("subProducto")
  public SubProductoEnum getSubProducto() {
    return subProducto;
  }

  @JsonProperty("subProducto")
  public void setSubProducto(SubProductoEnum subProducto) {
    this.subProducto = subProducto;
  }

  /**
   **/
  public PasivoType estadoPasivo(String estadoPasivo) {
    this.estadoPasivo = estadoPasivo;
    return this;
  }

  
  @JsonProperty("estadoPasivo")
  public String getEstadoPasivo() {
    return estadoPasivo;
  }

  @JsonProperty("estadoPasivo")
  public void setEstadoPasivo(String estadoPasivo) {
    this.estadoPasivo = estadoPasivo;
  }

  /**
   **/
  public PasivoType fechaApertura(Date fechaApertura) {
    this.fechaApertura = fechaApertura;
    return this;
  }

  
  @JsonProperty("fechaApertura")
  public Date getFechaApertura() {
    return fechaApertura;
  }

  @JsonProperty("fechaApertura")
  public void setFechaApertura(Date fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  /**
   **/
  public PasivoType fechaCierre(Date fechaCierre) {
    this.fechaCierre = fechaCierre;
    return this;
  }

  
  @JsonProperty("fechaCierre")
  public Date getFechaCierre() {
    return fechaCierre;
  }

  @JsonProperty("fechaCierre")
  public void setFechaCierre(Date fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  /**
   **/
  public PasivoType capital(Float capital) {
    this.capital = capital;
    return this;
  }

  
  @JsonProperty("capital")
  public Float getCapital() {
    return capital;
  }

  @JsonProperty("capital")
  public void setCapital(Float capital) {
    this.capital = capital;
  }

  /**
   **/
  public PasivoType intereses(Float intereses) {
    this.intereses = intereses;
    return this;
  }

  
  @JsonProperty("intereses")
  public Float getIntereses() {
    return intereses;
  }

  @JsonProperty("intereses")
  public void setIntereses(Float intereses) {
    this.intereses = intereses;
  }

  /**
   **/
  public PasivoType otros(Float otros) {
    this.otros = otros;
    return this;
  }

  
  @JsonProperty("otros")
  public Float getOtros() {
    return otros;
  }

  @JsonProperty("otros")
  public void setOtros(Float otros) {
    this.otros = otros;
  }

  /**
   **/
  public PasivoType saldoTotal(Float saldoTotal) {
    this.saldoTotal = saldoTotal;
    return this;
  }

  
  @JsonProperty("saldoTotal")
  public Float getSaldoTotal() {
    return saldoTotal;
  }

  @JsonProperty("saldoTotal")
  public void setSaldoTotal(Float saldoTotal) {
    this.saldoTotal = saldoTotal;
  }

  /**
   **/
  public PasivoType numeroCliente(Integer numeroCliente) {
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
    PasivoType pasivoType = (PasivoType) o;
    return Objects.equals(this.numeroProducto, pasivoType.numeroProducto) &&
        Objects.equals(this.subProducto, pasivoType.subProducto) &&
        Objects.equals(this.estadoPasivo, pasivoType.estadoPasivo) &&
        Objects.equals(this.fechaApertura, pasivoType.fechaApertura) &&
        Objects.equals(this.fechaCierre, pasivoType.fechaCierre) &&
        Objects.equals(this.capital, pasivoType.capital) &&
        Objects.equals(this.intereses, pasivoType.intereses) &&
        Objects.equals(this.otros, pasivoType.otros) &&
        Objects.equals(this.saldoTotal, pasivoType.saldoTotal) &&
        Objects.equals(this.numeroCliente, pasivoType.numeroCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroProducto, subProducto, estadoPasivo, fechaApertura, fechaCierre, capital, intereses, otros, saldoTotal, numeroCliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasivoType {\n");
    
    sb.append("    numeroProducto: ").append(toIndentedString(numeroProducto)).append("\n");
    sb.append("    subProducto: ").append(toIndentedString(subProducto)).append("\n");
    sb.append("    estadoPasivo: ").append(toIndentedString(estadoPasivo)).append("\n");
    sb.append("    fechaApertura: ").append(toIndentedString(fechaApertura)).append("\n");
    sb.append("    fechaCierre: ").append(toIndentedString(fechaCierre)).append("\n");
    sb.append("    capital: ").append(toIndentedString(capital)).append("\n");
    sb.append("    intereses: ").append(toIndentedString(intereses)).append("\n");
    sb.append("    otros: ").append(toIndentedString(otros)).append("\n");
    sb.append("    saldoTotal: ").append(toIndentedString(saldoTotal)).append("\n");
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

