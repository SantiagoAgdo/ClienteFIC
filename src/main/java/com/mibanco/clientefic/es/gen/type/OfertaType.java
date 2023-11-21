package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("OfertaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-21T10:49:21.159201500-05:00[America/Bogota]")
public class OfertaType   {
  private @Valid Integer numeroOferta;
  private @Valid String tipoLead;
  private @Valid String tipoOferta;
  private @Valid Float monto;
  private @Valid Integer plazo;
  private @Valid Integer numeroCliente;
  private @Valid String tipoDeLiga;
  private @Valid String condicionGarantia;

  /**
   **/
  public OfertaType numeroOferta(Integer numeroOferta) {
    this.numeroOferta = numeroOferta;
    return this;
  }

  
  @JsonProperty("numeroOferta")
  public Integer getNumeroOferta() {
    return numeroOferta;
  }

  @JsonProperty("numeroOferta")
  public void setNumeroOferta(Integer numeroOferta) {
    this.numeroOferta = numeroOferta;
  }

  /**
   **/
  public OfertaType tipoLead(String tipoLead) {
    this.tipoLead = tipoLead;
    return this;
  }

  
  @JsonProperty("tipoLead")
  public String getTipoLead() {
    return tipoLead;
  }

  @JsonProperty("tipoLead")
  public void setTipoLead(String tipoLead) {
    this.tipoLead = tipoLead;
  }

  /**
   **/
  public OfertaType tipoOferta(String tipoOferta) {
    this.tipoOferta = tipoOferta;
    return this;
  }

  
  @JsonProperty("tipoOferta")
  public String getTipoOferta() {
    return tipoOferta;
  }

  @JsonProperty("tipoOferta")
  public void setTipoOferta(String tipoOferta) {
    this.tipoOferta = tipoOferta;
  }

  /**
   **/
  public OfertaType monto(Float monto) {
    this.monto = monto;
    return this;
  }

  
  @JsonProperty("monto")
  public Float getMonto() {
    return monto;
  }

  @JsonProperty("monto")
  public void setMonto(Float monto) {
    this.monto = monto;
  }

  /**
   **/
  public OfertaType plazo(Integer plazo) {
    this.plazo = plazo;
    return this;
  }

  
  @JsonProperty("plazo")
  public Integer getPlazo() {
    return plazo;
  }

  @JsonProperty("plazo")
  public void setPlazo(Integer plazo) {
    this.plazo = plazo;
  }

  /**
   **/
  public OfertaType numeroCliente(Integer numeroCliente) {
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
  public OfertaType tipoDeLiga(String tipoDeLiga) {
    this.tipoDeLiga = tipoDeLiga;
    return this;
  }

  
  @JsonProperty("tipoDeLiga")
  public String getTipoDeLiga() {
    return tipoDeLiga;
  }

  @JsonProperty("tipoDeLiga")
  public void setTipoDeLiga(String tipoDeLiga) {
    this.tipoDeLiga = tipoDeLiga;
  }

  /**
   **/
  public OfertaType condicionGarantia(String condicionGarantia) {
    this.condicionGarantia = condicionGarantia;
    return this;
  }

  
  @JsonProperty("condicionGarantia")
  public String getCondicionGarantia() {
    return condicionGarantia;
  }

  @JsonProperty("condicionGarantia")
  public void setCondicionGarantia(String condicionGarantia) {
    this.condicionGarantia = condicionGarantia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfertaType ofertaType = (OfertaType) o;
    return Objects.equals(this.numeroOferta, ofertaType.numeroOferta) &&
        Objects.equals(this.tipoLead, ofertaType.tipoLead) &&
        Objects.equals(this.tipoOferta, ofertaType.tipoOferta) &&
        Objects.equals(this.monto, ofertaType.monto) &&
        Objects.equals(this.plazo, ofertaType.plazo) &&
        Objects.equals(this.numeroCliente, ofertaType.numeroCliente) &&
        Objects.equals(this.tipoDeLiga, ofertaType.tipoDeLiga) &&
        Objects.equals(this.condicionGarantia, ofertaType.condicionGarantia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroOferta, tipoLead, tipoOferta, monto, plazo, numeroCliente, tipoDeLiga, condicionGarantia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfertaType {\n");
    
    sb.append("    numeroOferta: ").append(toIndentedString(numeroOferta)).append("\n");
    sb.append("    tipoLead: ").append(toIndentedString(tipoLead)).append("\n");
    sb.append("    tipoOferta: ").append(toIndentedString(tipoOferta)).append("\n");
    sb.append("    monto: ").append(toIndentedString(monto)).append("\n");
    sb.append("    plazo: ").append(toIndentedString(plazo)).append("\n");
    sb.append("    numeroCliente: ").append(toIndentedString(numeroCliente)).append("\n");
    sb.append("    tipoDeLiga: ").append(toIndentedString(tipoDeLiga)).append("\n");
    sb.append("    condicionGarantia: ").append(toIndentedString(condicionGarantia)).append("\n");
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

