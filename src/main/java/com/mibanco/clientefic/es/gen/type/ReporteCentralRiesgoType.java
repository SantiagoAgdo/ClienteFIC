package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoRelacionEnum;
import com.mibanco.clientefic.es.gen.type.TipoReporteXmlEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ReporteCentralRiesgoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-21T10:49:21.159201500-05:00[America/Bogota]")
public class ReporteCentralRiesgoType   {
  private @Valid String antiguedadUbicacion;
  private @Valid String consultaDetallada;
  private @Valid String estadoDocumento;
  private @Valid String fechaExpedicion;
  private @Valid String fechaConsulta;
  private @Valid String nombre;
  private @Valid String genero;
  private @Valid String historicoEndeudamiento;
  private @Valid String lugarExpedicion;
  private @Valid String numeroDocumento;
  private @Valid String rangoEdad;
  private @Valid Boolean tieneRUT;
  private @Valid TipoDocumentoEnum tipoDocumento;
  private @Valid TipoRelacionEnum tipoRelacion;
  private @Valid TipoReporteXmlEnum tipoReporte;
  private @Valid String digitoVerificacion;

  /**
   **/
  public ReporteCentralRiesgoType antiguedadUbicacion(String antiguedadUbicacion) {
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
  public ReporteCentralRiesgoType consultaDetallada(String consultaDetallada) {
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
  public ReporteCentralRiesgoType estadoDocumento(String estadoDocumento) {
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
  public ReporteCentralRiesgoType fechaExpedicion(String fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
    return this;
  }

  
  @JsonProperty("fechaExpedicion")
  public String getFechaExpedicion() {
    return fechaExpedicion;
  }

  @JsonProperty("fechaExpedicion")
  public void setFechaExpedicion(String fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
  }

  /**
   **/
  public ReporteCentralRiesgoType fechaConsulta(String fechaConsulta) {
    this.fechaConsulta = fechaConsulta;
    return this;
  }

  
  @JsonProperty("fechaConsulta")
  public String getFechaConsulta() {
    return fechaConsulta;
  }

  @JsonProperty("fechaConsulta")
  public void setFechaConsulta(String fechaConsulta) {
    this.fechaConsulta = fechaConsulta;
  }

  /**
   **/
  public ReporteCentralRiesgoType nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  @JsonProperty("nombre")
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   **/
  public ReporteCentralRiesgoType genero(String genero) {
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
  public ReporteCentralRiesgoType historicoEndeudamiento(String historicoEndeudamiento) {
    this.historicoEndeudamiento = historicoEndeudamiento;
    return this;
  }

  
  @JsonProperty("historicoEndeudamiento")
  public String getHistoricoEndeudamiento() {
    return historicoEndeudamiento;
  }

  @JsonProperty("historicoEndeudamiento")
  public void setHistoricoEndeudamiento(String historicoEndeudamiento) {
    this.historicoEndeudamiento = historicoEndeudamiento;
  }

  /**
   **/
  public ReporteCentralRiesgoType lugarExpedicion(String lugarExpedicion) {
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
  public ReporteCentralRiesgoType numeroDocumento(String numeroDocumento) {
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
  public ReporteCentralRiesgoType rangoEdad(String rangoEdad) {
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
  public ReporteCentralRiesgoType tieneRUT(Boolean tieneRUT) {
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
  public ReporteCentralRiesgoType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
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
  public ReporteCentralRiesgoType tipoRelacion(TipoRelacionEnum tipoRelacion) {
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
  public ReporteCentralRiesgoType tipoReporte(TipoReporteXmlEnum tipoReporte) {
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
  public ReporteCentralRiesgoType digitoVerificacion(String digitoVerificacion) {
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
    ReporteCentralRiesgoType reporteCentralRiesgoType = (ReporteCentralRiesgoType) o;
    return Objects.equals(this.antiguedadUbicacion, reporteCentralRiesgoType.antiguedadUbicacion) &&
        Objects.equals(this.consultaDetallada, reporteCentralRiesgoType.consultaDetallada) &&
        Objects.equals(this.estadoDocumento, reporteCentralRiesgoType.estadoDocumento) &&
        Objects.equals(this.fechaExpedicion, reporteCentralRiesgoType.fechaExpedicion) &&
        Objects.equals(this.fechaConsulta, reporteCentralRiesgoType.fechaConsulta) &&
        Objects.equals(this.nombre, reporteCentralRiesgoType.nombre) &&
        Objects.equals(this.genero, reporteCentralRiesgoType.genero) &&
        Objects.equals(this.historicoEndeudamiento, reporteCentralRiesgoType.historicoEndeudamiento) &&
        Objects.equals(this.lugarExpedicion, reporteCentralRiesgoType.lugarExpedicion) &&
        Objects.equals(this.numeroDocumento, reporteCentralRiesgoType.numeroDocumento) &&
        Objects.equals(this.rangoEdad, reporteCentralRiesgoType.rangoEdad) &&
        Objects.equals(this.tieneRUT, reporteCentralRiesgoType.tieneRUT) &&
        Objects.equals(this.tipoDocumento, reporteCentralRiesgoType.tipoDocumento) &&
        Objects.equals(this.tipoRelacion, reporteCentralRiesgoType.tipoRelacion) &&
        Objects.equals(this.tipoReporte, reporteCentralRiesgoType.tipoReporte) &&
        Objects.equals(this.digitoVerificacion, reporteCentralRiesgoType.digitoVerificacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(antiguedadUbicacion, consultaDetallada, estadoDocumento, fechaExpedicion, fechaConsulta, nombre, genero, historicoEndeudamiento, lugarExpedicion, numeroDocumento, rangoEdad, tieneRUT, tipoDocumento, tipoRelacion, tipoReporte, digitoVerificacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReporteCentralRiesgoType {\n");
    
    sb.append("    antiguedadUbicacion: ").append(toIndentedString(antiguedadUbicacion)).append("\n");
    sb.append("    consultaDetallada: ").append(toIndentedString(consultaDetallada)).append("\n");
    sb.append("    estadoDocumento: ").append(toIndentedString(estadoDocumento)).append("\n");
    sb.append("    fechaExpedicion: ").append(toIndentedString(fechaExpedicion)).append("\n");
    sb.append("    fechaConsulta: ").append(toIndentedString(fechaConsulta)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    historicoEndeudamiento: ").append(toIndentedString(historicoEndeudamiento)).append("\n");
    sb.append("    lugarExpedicion: ").append(toIndentedString(lugarExpedicion)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
    sb.append("    rangoEdad: ").append(toIndentedString(rangoEdad)).append("\n");
    sb.append("    tieneRUT: ").append(toIndentedString(tieneRUT)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    tipoRelacion: ").append(toIndentedString(tipoRelacion)).append("\n");
    sb.append("    tipoReporte: ").append(toIndentedString(tipoReporte)).append("\n");
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

