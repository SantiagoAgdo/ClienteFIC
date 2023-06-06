package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoRelacionEnum;
import com.mibanco.clientefic.es.gen.type.TipoReporteXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("CentralRiesgoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-06T12:10:12.590977-05:00[America/Bogota]")
public class CentralRiesgoType   {
  private @Valid String antiguedadUbicacion;
  private @Valid String consultaDetallada;
  private @Valid String estadoDocumento;
  private @Valid Date fechaConsultaMasReciente;
  private @Valid Date fechaExpedicion;
  private @Valid String genero;
  private @Valid String lugarExpedicion;
  private @Valid String numeroDocumento;
  private @Valid String rangoEdad;
  private @Valid String resultadoConsultaMasReciente;
  private @Valid Boolean tieneRUT;
  private @Valid TipoDocumentoEnum tipoDocumento;
  private @Valid TipoRelacionEnum tipoRelacion;
  private @Valid TipoReporteXmlEnum tipoReporte;
  private @Valid Boolean vbVigenteParaSerConsultado;
  private @Valid String digitoVerificacion;

  /**
   **/
  public CentralRiesgoType antiguedadUbicacion(String antiguedadUbicacion) {
    this.antiguedadUbicacion = antiguedadUbicacion;
    return this;
  }

  
  @JsonProperty("antiguedadUbicacion")
  public String getAntiguedadUbicacion() {
    return antiguedadUbicacion;
  }

  @JsonProperty("antiguedadUbicacion")
  public void setAntiguedadUbicacion(String antiguedadUbicacion) {
    this.antiguedadUbicacion = antiguedadUbicacion;
  }

  /**
   **/
  public CentralRiesgoType consultaDetallada(String consultaDetallada) {
    this.consultaDetallada = consultaDetallada;
    return this;
  }

  
  @JsonProperty("consultaDetallada")
  public String getConsultaDetallada() {
    return consultaDetallada;
  }

  @JsonProperty("consultaDetallada")
  public void setConsultaDetallada(String consultaDetallada) {
    this.consultaDetallada = consultaDetallada;
  }

  /**
   **/
  public CentralRiesgoType estadoDocumento(String estadoDocumento) {
    this.estadoDocumento = estadoDocumento;
    return this;
  }

  
  @JsonProperty("estadoDocumento")
  public String getEstadoDocumento() {
    return estadoDocumento;
  }

  @JsonProperty("estadoDocumento")
  public void setEstadoDocumento(String estadoDocumento) {
    this.estadoDocumento = estadoDocumento;
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
  public CentralRiesgoType fechaExpedicion(Date fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
    return this;
  }

  
  @JsonProperty("fechaExpedicion")
  public Date getFechaExpedicion() {
    return fechaExpedicion;
  }

  @JsonProperty("fechaExpedicion")
  public void setFechaExpedicion(Date fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
  }

  /**
   **/
  public CentralRiesgoType genero(String genero) {
    this.genero = genero;
    return this;
  }

  
  @JsonProperty("genero")
  public String getGenero() {
    return genero;
  }

  @JsonProperty("genero")
  public void setGenero(String genero) {
    this.genero = genero;
  }

  /**
   **/
  public CentralRiesgoType lugarExpedicion(String lugarExpedicion) {
    this.lugarExpedicion = lugarExpedicion;
    return this;
  }

  
  @JsonProperty("lugarExpedicion")
  public String getLugarExpedicion() {
    return lugarExpedicion;
  }

  @JsonProperty("lugarExpedicion")
  public void setLugarExpedicion(String lugarExpedicion) {
    this.lugarExpedicion = lugarExpedicion;
  }

  /**
   **/
  public CentralRiesgoType numeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
    return this;
  }

  
  @JsonProperty("numeroDocumento")
  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  @JsonProperty("numeroDocumento")
  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  /**
   **/
  public CentralRiesgoType rangoEdad(String rangoEdad) {
    this.rangoEdad = rangoEdad;
    return this;
  }

  
  @JsonProperty("rangoEdad")
  public String getRangoEdad() {
    return rangoEdad;
  }

  @JsonProperty("rangoEdad")
  public void setRangoEdad(String rangoEdad) {
    this.rangoEdad = rangoEdad;
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
  public CentralRiesgoType tieneRUT(Boolean tieneRUT) {
    this.tieneRUT = tieneRUT;
    return this;
  }

  
  @JsonProperty("tieneRUT")
  public Boolean getTieneRUT() {
    return tieneRUT;
  }

  @JsonProperty("tieneRUT")
  public void setTieneRUT(Boolean tieneRUT) {
    this.tieneRUT = tieneRUT;
  }

  /**
   **/
  public CentralRiesgoType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
    return this;
  }

  
  @JsonProperty("tipoDocumento")
  public TipoDocumentoEnum getTipoDocumento() {
    return tipoDocumento;
  }

  @JsonProperty("tipoDocumento")
  public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  /**
   **/
  public CentralRiesgoType tipoRelacion(TipoRelacionEnum tipoRelacion) {
    this.tipoRelacion = tipoRelacion;
    return this;
  }

  
  @JsonProperty("tipoRelacion")
  public TipoRelacionEnum getTipoRelacion() {
    return tipoRelacion;
  }

  @JsonProperty("tipoRelacion")
  public void setTipoRelacion(TipoRelacionEnum tipoRelacion) {
    this.tipoRelacion = tipoRelacion;
  }

  /**
   **/
  public CentralRiesgoType tipoReporte(TipoReporteXmlEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
    return this;
  }

  
  @JsonProperty("tipoReporte")
  public TipoReporteXmlEnum getTipoReporte() {
    return tipoReporte;
  }

  @JsonProperty("tipoReporte")
  public void setTipoReporte(TipoReporteXmlEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
  }

  /**
   **/
  public CentralRiesgoType vbVigenteParaSerConsultado(Boolean vbVigenteParaSerConsultado) {
    this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
    return this;
  }

  
  @JsonProperty("vbVigenteParaSerConsultado")
  public Boolean getVbVigenteParaSerConsultado() {
    return vbVigenteParaSerConsultado;
  }

  @JsonProperty("vbVigenteParaSerConsultado")
  public void setVbVigenteParaSerConsultado(Boolean vbVigenteParaSerConsultado) {
    this.vbVigenteParaSerConsultado = vbVigenteParaSerConsultado;
  }

  /**
   **/
  public CentralRiesgoType digitoVerificacion(String digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
    return this;
  }

  
  @JsonProperty("digitoVerificacion")
  public String getDigitoVerificacion() {
    return digitoVerificacion;
  }

  @JsonProperty("digitoVerificacion")
  public void setDigitoVerificacion(String digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
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
    return Objects.equals(this.antiguedadUbicacion, centralRiesgoType.antiguedadUbicacion) &&
        Objects.equals(this.consultaDetallada, centralRiesgoType.consultaDetallada) &&
        Objects.equals(this.estadoDocumento, centralRiesgoType.estadoDocumento) &&
        Objects.equals(this.fechaConsultaMasReciente, centralRiesgoType.fechaConsultaMasReciente) &&
        Objects.equals(this.fechaExpedicion, centralRiesgoType.fechaExpedicion) &&
        Objects.equals(this.genero, centralRiesgoType.genero) &&
        Objects.equals(this.lugarExpedicion, centralRiesgoType.lugarExpedicion) &&
        Objects.equals(this.numeroDocumento, centralRiesgoType.numeroDocumento) &&
        Objects.equals(this.rangoEdad, centralRiesgoType.rangoEdad) &&
        Objects.equals(this.resultadoConsultaMasReciente, centralRiesgoType.resultadoConsultaMasReciente) &&
        Objects.equals(this.tieneRUT, centralRiesgoType.tieneRUT) &&
        Objects.equals(this.tipoDocumento, centralRiesgoType.tipoDocumento) &&
        Objects.equals(this.tipoRelacion, centralRiesgoType.tipoRelacion) &&
        Objects.equals(this.tipoReporte, centralRiesgoType.tipoReporte) &&
        Objects.equals(this.vbVigenteParaSerConsultado, centralRiesgoType.vbVigenteParaSerConsultado) &&
        Objects.equals(this.digitoVerificacion, centralRiesgoType.digitoVerificacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(antiguedadUbicacion, consultaDetallada, estadoDocumento, fechaConsultaMasReciente, fechaExpedicion, genero, lugarExpedicion, numeroDocumento, rangoEdad, resultadoConsultaMasReciente, tieneRUT, tipoDocumento, tipoRelacion, tipoReporte, vbVigenteParaSerConsultado, digitoVerificacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CentralRiesgoType {\n");
    
    sb.append("    antiguedadUbicacion: ").append(toIndentedString(antiguedadUbicacion)).append("\n");
    sb.append("    consultaDetallada: ").append(toIndentedString(consultaDetallada)).append("\n");
    sb.append("    estadoDocumento: ").append(toIndentedString(estadoDocumento)).append("\n");
    sb.append("    fechaConsultaMasReciente: ").append(toIndentedString(fechaConsultaMasReciente)).append("\n");
    sb.append("    fechaExpedicion: ").append(toIndentedString(fechaExpedicion)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    lugarExpedicion: ").append(toIndentedString(lugarExpedicion)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
    sb.append("    rangoEdad: ").append(toIndentedString(rangoEdad)).append("\n");
    sb.append("    resultadoConsultaMasReciente: ").append(toIndentedString(resultadoConsultaMasReciente)).append("\n");
    sb.append("    tieneRUT: ").append(toIndentedString(tieneRUT)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    tipoRelacion: ").append(toIndentedString(tipoRelacion)).append("\n");
    sb.append("    tipoReporte: ").append(toIndentedString(tipoReporte)).append("\n");
    sb.append("    vbVigenteParaSerConsultado: ").append(toIndentedString(vbVigenteParaSerConsultado)).append("\n");
    sb.append("    digitoVerificacion: ").append(toIndentedString(digitoVerificacion)).append("\n");
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

