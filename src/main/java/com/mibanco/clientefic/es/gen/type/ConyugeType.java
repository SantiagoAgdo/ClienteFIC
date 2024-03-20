package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ConyugeType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-02-22T09:33:21.194046200-05:00[America/Bogota]")
public class ConyugeType   {
  private @Valid TipoDocumentoEnum tipoDocumento;
  private @Valid String numeroDocumento;
  private @Valid String nombre;
  private @Valid Integer numeroCliente;

  /**
   **/
  public ConyugeType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
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
  public ConyugeType numeroDocumento(String numeroDocumento) {
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
  public ConyugeType nombre(String nombre) {
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
  public ConyugeType numeroCliente(Integer numeroCliente) {
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
    ConyugeType conyugeType = (ConyugeType) o;
    return Objects.equals(this.tipoDocumento, conyugeType.tipoDocumento) &&
        Objects.equals(this.numeroDocumento, conyugeType.numeroDocumento) &&
        Objects.equals(this.nombre, conyugeType.nombre) &&
        Objects.equals(this.numeroCliente, conyugeType.numeroCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoDocumento, numeroDocumento, nombre, numeroCliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConyugeType {\n");
    
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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

