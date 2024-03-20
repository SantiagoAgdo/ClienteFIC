package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.ClienteBaseType;
import com.mibanco.clientefic.es.gen.type.DomicilioBaseType;
import com.mibanco.clientefic.es.gen.type.DomicilioEmpresaType;
import com.mibanco.clientefic.es.gen.type.NegocioType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ClienteFICType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-02-22T09:33:21.194046200-05:00[America/Bogota]")
public class ClienteFICType   {
  private @Valid ClienteBaseType clienteBase;
  private @Valid DomicilioBaseType domicilio;
  private @Valid DomicilioEmpresaType domicilioEmpresa;
  private @Valid String funcionarioUltimaActualizacion;
  private @Valid NegocioType negocio;
  private @Valid String numeroDocumentoRepresentanteLegal;
  private @Valid String nombreRepresentanteLegal;
  private @Valid String razonSocial;
  private @Valid String seRequiereActualizacion;
  private @Valid TipoDocumentoEnum tipoDocumentoRepresentanteLegal;
  private @Valid Float totalActivos;
  private @Valid String ultimaFechaActualizacion;
  private @Valid Integer digitoVerificacion;
  private @Valid String nombreCompleto;
  private @Valid String estadoCivil;

  /**
   **/
  public ClienteFICType clienteBase(ClienteBaseType clienteBase) {
    this.clienteBase = clienteBase;
    return this;
  }

  
  @JsonProperty("clienteBase")
  public ClienteBaseType getClienteBase() {
    return clienteBase;
  }

  @JsonProperty("clienteBase")
  public void setClienteBase(ClienteBaseType clienteBase) {
    this.clienteBase = clienteBase;
  }

  /**
   **/
  public ClienteFICType domicilio(DomicilioBaseType domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  
  @JsonProperty("domicilio")
  public DomicilioBaseType getDomicilio() {
    return domicilio;
  }

  @JsonProperty("domicilio")
  public void setDomicilio(DomicilioBaseType domicilio) {
    this.domicilio = domicilio;
  }

  /**
   **/
  public ClienteFICType domicilioEmpresa(DomicilioEmpresaType domicilioEmpresa) {
    this.domicilioEmpresa = domicilioEmpresa;
    return this;
  }

  
  @JsonProperty("domicilioEmpresa")
  public DomicilioEmpresaType getDomicilioEmpresa() {
    return domicilioEmpresa;
  }

  @JsonProperty("domicilioEmpresa")
  public void setDomicilioEmpresa(DomicilioEmpresaType domicilioEmpresa) {
    this.domicilioEmpresa = domicilioEmpresa;
  }

  /**
   **/
  public ClienteFICType funcionarioUltimaActualizacion(String funcionarioUltimaActualizacion) {
    this.funcionarioUltimaActualizacion = funcionarioUltimaActualizacion;
    return this;
  }

  
  @JsonProperty("funcionarioUltimaActualizacion")
  public String getFuncionarioUltimaActualizacion() {
    return funcionarioUltimaActualizacion;
  }

  @JsonProperty("funcionarioUltimaActualizacion")
  public void setFuncionarioUltimaActualizacion(String funcionarioUltimaActualizacion) {
    this.funcionarioUltimaActualizacion = funcionarioUltimaActualizacion;
  }

  /**
   **/
  public ClienteFICType negocio(NegocioType negocio) {
    this.negocio = negocio;
    return this;
  }

  
  @JsonProperty("negocio")
  public NegocioType getNegocio() {
    return negocio;
  }

  @JsonProperty("negocio")
  public void setNegocio(NegocioType negocio) {
    this.negocio = negocio;
  }

  /**
   **/
  public ClienteFICType numeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
    this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("numeroDocumentoRepresentanteLegal")
  public String getNumeroDocumentoRepresentanteLegal() {
    return numeroDocumentoRepresentanteLegal;
  }

  @JsonProperty("numeroDocumentoRepresentanteLegal")
  public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
    this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType nombreRepresentanteLegal(String nombreRepresentanteLegal) {
    this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("nombreRepresentanteLegal")
  public String getNombreRepresentanteLegal() {
    return nombreRepresentanteLegal;
  }

  @JsonProperty("nombreRepresentanteLegal")
  public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
    this.nombreRepresentanteLegal = nombreRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType razonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
    return this;
  }

  
  @JsonProperty("razonSocial")
  public String getRazonSocial() {
    return razonSocial;
  }

  @JsonProperty("razonSocial")
  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  /**
   **/
  public ClienteFICType seRequiereActualizacion(String seRequiereActualizacion) {
    this.seRequiereActualizacion = seRequiereActualizacion;
    return this;
  }

  
  @JsonProperty("seRequiereActualizacion")
  public String getSeRequiereActualizacion() {
    return seRequiereActualizacion;
  }

  @JsonProperty("seRequiereActualizacion")
  public void setSeRequiereActualizacion(String seRequiereActualizacion) {
    this.seRequiereActualizacion = seRequiereActualizacion;
  }

  /**
   **/
  public ClienteFICType tipoDocumentoRepresentanteLegal(TipoDocumentoEnum tipoDocumentoRepresentanteLegal) {
    this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("tipoDocumentoRepresentanteLegal")
  public TipoDocumentoEnum getTipoDocumentoRepresentanteLegal() {
    return tipoDocumentoRepresentanteLegal;
  }

  @JsonProperty("tipoDocumentoRepresentanteLegal")
  public void setTipoDocumentoRepresentanteLegal(TipoDocumentoEnum tipoDocumentoRepresentanteLegal) {
    this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType totalActivos(Float totalActivos) {
    this.totalActivos = totalActivos;
    return this;
  }

  
  @JsonProperty("totalActivos")
  public Float getTotalActivos() {
    return totalActivos;
  }

  @JsonProperty("totalActivos")
  public void setTotalActivos(Float totalActivos) {
    this.totalActivos = totalActivos;
  }

  /**
   **/
  public ClienteFICType ultimaFechaActualizacion(String ultimaFechaActualizacion) {
    this.ultimaFechaActualizacion = ultimaFechaActualizacion;
    return this;
  }

  
  @JsonProperty("ultimaFechaActualizacion")
  public String getUltimaFechaActualizacion() {
    return ultimaFechaActualizacion;
  }

  @JsonProperty("ultimaFechaActualizacion")
  public void setUltimaFechaActualizacion(String ultimaFechaActualizacion) {
    this.ultimaFechaActualizacion = ultimaFechaActualizacion;
  }

  /**
   **/
  public ClienteFICType digitoVerificacion(Integer digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
    return this;
  }

  
  @JsonProperty("digitoVerificacion")
  public Integer getDigitoVerificacion() {
    return digitoVerificacion;
  }

  @JsonProperty("digitoVerificacion")
  public void setDigitoVerificacion(Integer digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
  }

  /**
   **/
  public ClienteFICType nombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
    return this;
  }

  
  @JsonProperty("nombreCompleto")
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  @JsonProperty("nombreCompleto")
  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  /**
   **/
  public ClienteFICType estadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
    return this;
  }

  
  @JsonProperty("estadoCivil")
  public String getEstadoCivil() {
    return estadoCivil;
  }

  @JsonProperty("estadoCivil")
  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClienteFICType clienteFICType = (ClienteFICType) o;
    return Objects.equals(this.clienteBase, clienteFICType.clienteBase) &&
        Objects.equals(this.domicilio, clienteFICType.domicilio) &&
        Objects.equals(this.domicilioEmpresa, clienteFICType.domicilioEmpresa) &&
        Objects.equals(this.funcionarioUltimaActualizacion, clienteFICType.funcionarioUltimaActualizacion) &&
        Objects.equals(this.negocio, clienteFICType.negocio) &&
        Objects.equals(this.numeroDocumentoRepresentanteLegal, clienteFICType.numeroDocumentoRepresentanteLegal) &&
        Objects.equals(this.nombreRepresentanteLegal, clienteFICType.nombreRepresentanteLegal) &&
        Objects.equals(this.razonSocial, clienteFICType.razonSocial) &&
        Objects.equals(this.seRequiereActualizacion, clienteFICType.seRequiereActualizacion) &&
        Objects.equals(this.tipoDocumentoRepresentanteLegal, clienteFICType.tipoDocumentoRepresentanteLegal) &&
        Objects.equals(this.totalActivos, clienteFICType.totalActivos) &&
        Objects.equals(this.ultimaFechaActualizacion, clienteFICType.ultimaFechaActualizacion) &&
        Objects.equals(this.digitoVerificacion, clienteFICType.digitoVerificacion) &&
        Objects.equals(this.nombreCompleto, clienteFICType.nombreCompleto) &&
        Objects.equals(this.estadoCivil, clienteFICType.estadoCivil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clienteBase, domicilio, domicilioEmpresa, funcionarioUltimaActualizacion, negocio, numeroDocumentoRepresentanteLegal, nombreRepresentanteLegal, razonSocial, seRequiereActualizacion, tipoDocumentoRepresentanteLegal, totalActivos, ultimaFechaActualizacion, digitoVerificacion, nombreCompleto, estadoCivil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClienteFICType {\n");
    
    sb.append("    clienteBase: ").append(toIndentedString(clienteBase)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    domicilioEmpresa: ").append(toIndentedString(domicilioEmpresa)).append("\n");
    sb.append("    funcionarioUltimaActualizacion: ").append(toIndentedString(funcionarioUltimaActualizacion)).append("\n");
    sb.append("    negocio: ").append(toIndentedString(negocio)).append("\n");
    sb.append("    numeroDocumentoRepresentanteLegal: ").append(toIndentedString(numeroDocumentoRepresentanteLegal)).append("\n");
    sb.append("    nombreRepresentanteLegal: ").append(toIndentedString(nombreRepresentanteLegal)).append("\n");
    sb.append("    razonSocial: ").append(toIndentedString(razonSocial)).append("\n");
    sb.append("    seRequiereActualizacion: ").append(toIndentedString(seRequiereActualizacion)).append("\n");
    sb.append("    tipoDocumentoRepresentanteLegal: ").append(toIndentedString(tipoDocumentoRepresentanteLegal)).append("\n");
    sb.append("    totalActivos: ").append(toIndentedString(totalActivos)).append("\n");
    sb.append("    ultimaFechaActualizacion: ").append(toIndentedString(ultimaFechaActualizacion)).append("\n");
    sb.append("    digitoVerificacion: ").append(toIndentedString(digitoVerificacion)).append("\n");
    sb.append("    nombreCompleto: ").append(toIndentedString(nombreCompleto)).append("\n");
    sb.append("    estadoCivil: ").append(toIndentedString(estadoCivil)).append("\n");
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

