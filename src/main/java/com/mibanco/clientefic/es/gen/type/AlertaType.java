package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("AlertaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-02T11:50:18.213230-05:00[America/Bogota]")
public class AlertaType   {
  private @Valid String tipoAlerta = null;
  private @Valid String banco = null;
  private @Valid String fecha = null;
  private @Valid TipoDocumentoEnum tipoDocumento;
  private @Valid String numeroDocumento = null;
  private @Valid String digitoVerificacion = null;

  /**
   **/
  public AlertaType tipoAlerta(String tipoAlerta) {
    this.tipoAlerta = tipoAlerta;
    return this;
  }

  
  @JsonProperty("tipoAlerta")
  public String getTipoAlerta() {
    return tipoAlerta;
  }

  @JsonProperty("tipoAlerta")
  public void setTipoAlerta(String tipoAlerta) {
    this.tipoAlerta = tipoAlerta;
  }

  /**
   **/
  public AlertaType banco(String banco) {
    this.banco = banco;
    return this;
  }

  
  @JsonProperty("banco")
  public String getBanco() {
    return banco;
  }

  @JsonProperty("banco")
  public void setBanco(String banco) {
    this.banco = banco;
  }

  /**
   **/
  public AlertaType fecha(String fecha) {
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
  public AlertaType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
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
  public AlertaType numeroDocumento(String numeroDocumento) {
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
  public AlertaType digitoVerificacion(String digitoVerificacion) {
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
    AlertaType alertaType = (AlertaType) o;
    return Objects.equals(this.tipoAlerta, alertaType.tipoAlerta) &&
        Objects.equals(this.banco, alertaType.banco) &&
        Objects.equals(this.fecha, alertaType.fecha) &&
        Objects.equals(this.tipoDocumento, alertaType.tipoDocumento) &&
        Objects.equals(this.numeroDocumento, alertaType.numeroDocumento) &&
        Objects.equals(this.digitoVerificacion, alertaType.digitoVerificacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoAlerta, banco, fecha, tipoDocumento, numeroDocumento, digitoVerificacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlertaType {\n");
    
    sb.append("    tipoAlerta: ").append(toIndentedString(tipoAlerta)).append("\n");
    sb.append("    banco: ").append(toIndentedString(banco)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
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

