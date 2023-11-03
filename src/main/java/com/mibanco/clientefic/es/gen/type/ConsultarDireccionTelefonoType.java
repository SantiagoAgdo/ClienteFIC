package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.BarrioEnum;
import com.mibanco.clientefic.es.gen.type.CiudadEnum;
import com.mibanco.clientefic.es.gen.type.DepartamentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoDireccionEnum;
import com.mibanco.clientefic.es.gen.type.TipoLocalEnum;
import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ConsultarDireccionTelefonoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-03T10:54:18.743671-05:00[America/Bogota]")
public class ConsultarDireccionTelefonoType   {
  private @Valid String direccion;
  private @Valid Integer telefono1;
  private @Valid TipoViviendaEnum tipoVivienda;
  private @Valid TipoLocalEnum tipoLocal;
  private @Valid TipoDireccionEnum tipoDireccion;
  private @Valid DepartamentoEnum codigoDepartamento;
  private @Valid CiudadEnum codigoMunicipio;
  private @Valid BarrioEnum codigoBarrio;
  private @Valid Integer telefono2;

  /**
   **/
  public ConsultarDireccionTelefonoType direccion(String direccion) {
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
  public ConsultarDireccionTelefonoType telefono1(Integer telefono1) {
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
  public ConsultarDireccionTelefonoType tipoVivienda(TipoViviendaEnum tipoVivienda) {
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

  /**
   **/
  public ConsultarDireccionTelefonoType tipoLocal(TipoLocalEnum tipoLocal) {
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

  /**
   **/
  public ConsultarDireccionTelefonoType tipoDireccion(TipoDireccionEnum tipoDireccion) {
    this.tipoDireccion = tipoDireccion;
    return this;
  }

  
  @JsonProperty("tipoDireccion")
  public TipoDireccionEnum getTipoDireccion() {
    return tipoDireccion;
  }

  @JsonProperty("tipoDireccion")
  public void setTipoDireccion(TipoDireccionEnum tipoDireccion) {
    this.tipoDireccion = tipoDireccion;
  }

  /**
   **/
  public ConsultarDireccionTelefonoType codigoDepartamento(DepartamentoEnum codigoDepartamento) {
    this.codigoDepartamento = codigoDepartamento;
    return this;
  }

  
  @JsonProperty("codigoDepartamento")
  public DepartamentoEnum getCodigoDepartamento() {
    return codigoDepartamento;
  }

  @JsonProperty("codigoDepartamento")
  public void setCodigoDepartamento(DepartamentoEnum codigoDepartamento) {
    this.codigoDepartamento = codigoDepartamento;
  }

  /**
   **/
  public ConsultarDireccionTelefonoType codigoMunicipio(CiudadEnum codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
    return this;
  }

  
  @JsonProperty("codigoMunicipio")
  public CiudadEnum getCodigoMunicipio() {
    return codigoMunicipio;
  }

  @JsonProperty("codigoMunicipio")
  public void setCodigoMunicipio(CiudadEnum codigoMunicipio) {
    this.codigoMunicipio = codigoMunicipio;
  }

  /**
   **/
  public ConsultarDireccionTelefonoType codigoBarrio(BarrioEnum codigoBarrio) {
    this.codigoBarrio = codigoBarrio;
    return this;
  }

  
  @JsonProperty("codigoBarrio")
  public BarrioEnum getCodigoBarrio() {
    return codigoBarrio;
  }

  @JsonProperty("codigoBarrio")
  public void setCodigoBarrio(BarrioEnum codigoBarrio) {
    this.codigoBarrio = codigoBarrio;
  }

  /**
   **/
  public ConsultarDireccionTelefonoType telefono2(Integer telefono2) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsultarDireccionTelefonoType consultarDireccionTelefonoType = (ConsultarDireccionTelefonoType) o;
    return Objects.equals(this.direccion, consultarDireccionTelefonoType.direccion) &&
        Objects.equals(this.telefono1, consultarDireccionTelefonoType.telefono1) &&
        Objects.equals(this.tipoVivienda, consultarDireccionTelefonoType.tipoVivienda) &&
        Objects.equals(this.tipoLocal, consultarDireccionTelefonoType.tipoLocal) &&
        Objects.equals(this.tipoDireccion, consultarDireccionTelefonoType.tipoDireccion) &&
        Objects.equals(this.codigoDepartamento, consultarDireccionTelefonoType.codigoDepartamento) &&
        Objects.equals(this.codigoMunicipio, consultarDireccionTelefonoType.codigoMunicipio) &&
        Objects.equals(this.codigoBarrio, consultarDireccionTelefonoType.codigoBarrio) &&
        Objects.equals(this.telefono2, consultarDireccionTelefonoType.telefono2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direccion, telefono1, tipoVivienda, tipoLocal, tipoDireccion, codigoDepartamento, codigoMunicipio, codigoBarrio, telefono2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsultarDireccionTelefonoType {\n");
    
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono1: ").append(toIndentedString(telefono1)).append("\n");
    sb.append("    tipoVivienda: ").append(toIndentedString(tipoVivienda)).append("\n");
    sb.append("    tipoLocal: ").append(toIndentedString(tipoLocal)).append("\n");
    sb.append("    tipoDireccion: ").append(toIndentedString(tipoDireccion)).append("\n");
    sb.append("    codigoDepartamento: ").append(toIndentedString(codigoDepartamento)).append("\n");
    sb.append("    codigoMunicipio: ").append(toIndentedString(codigoMunicipio)).append("\n");
    sb.append("    codigoBarrio: ").append(toIndentedString(codigoBarrio)).append("\n");
    sb.append("    telefono2: ").append(toIndentedString(telefono2)).append("\n");
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

