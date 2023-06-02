package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteBaseType;
import com.mibanco.clientefic.es.gen.type.ContactoType;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.CupoRotativoType;
import com.mibanco.clientefic.es.gen.type.DomicilioEmpresaType;
import com.mibanco.clientefic.es.gen.type.DomicilioType;
import com.mibanco.clientefic.es.gen.type.EstadoCivilEnum;
import com.mibanco.clientefic.es.gen.type.NegocioType;
import com.mibanco.clientefic.es.gen.type.OfertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.gen.type.PasivoType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ClienteFICType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-02T11:50:18.213230-05:00[America/Bogota]")
public class ClienteFICType   {
  private @Valid AlertaType alerta;
  private @Valid ClienteBaseType clienteBase;
  private @Valid CentralRiesgoType centralRiesgo;
  private @Valid ContactoType contacto;
  private @Valid ConyugeType conyuge;
  private @Valid CupoRotativoType cupoRotativo;
  private @Valid Integer digitoVerificacion;
  private @Valid DomicilioType domicilio;
  private @Valid DomicilioEmpresaType domicilioEmpresa;
  private @Valid EstadoCivilEnum estadoCivil;
  private @Valid String funcionarioUltimaActualizacion = null;
  private @Valid NegocioType negocio;
  private @Valid String numeroDocumentoRepresentanteLegal = null;
  private @Valid OfertaType oferta;
  private @Valid PasivoType pasivo;
  private @Valid PQRType PQR;
  private @Valid String prestamo = null;
  private @Valid String primerApellidoRepresentanteLegal = null;
  private @Valid String primerNombreRepresentanteLegal = null;
  private @Valid String razonSocial = null;
  private @Valid String segundoApellidoRepresentanteLegal = null;
  private @Valid String segundoNombreRepresentanteLegal = null;
  private @Valid Boolean seRequiereActualizacion;
  private @Valid TipoDocumentoEnum tipoDocumentoRepresentanteLegal;
  private @Valid Float totalActivos;
  private @Valid String ultimaFechaActualizacion = null;

  /**
   **/
  public ClienteFICType alerta(AlertaType alerta) {
    this.alerta = alerta;
    return this;
  }

  
  @JsonProperty("alerta")
  public AlertaType getAlerta() {
    return alerta;
  }

  @JsonProperty("alerta")
  public void setAlerta(AlertaType alerta) {
    this.alerta = alerta;
  }

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
  public ClienteFICType centralRiesgo(CentralRiesgoType centralRiesgo) {
    this.centralRiesgo = centralRiesgo;
    return this;
  }

  
  @JsonProperty("centralRiesgo")
  public CentralRiesgoType getCentralRiesgo() {
    return centralRiesgo;
  }

  @JsonProperty("centralRiesgo")
  public void setCentralRiesgo(CentralRiesgoType centralRiesgo) {
    this.centralRiesgo = centralRiesgo;
  }

  /**
   **/
  public ClienteFICType contacto(ContactoType contacto) {
    this.contacto = contacto;
    return this;
  }

  
  @JsonProperty("contacto")
  public ContactoType getContacto() {
    return contacto;
  }

  @JsonProperty("contacto")
  public void setContacto(ContactoType contacto) {
    this.contacto = contacto;
  }

  /**
   **/
  public ClienteFICType conyuge(ConyugeType conyuge) {
    this.conyuge = conyuge;
    return this;
  }

  
  @JsonProperty("conyuge")
  public ConyugeType getConyuge() {
    return conyuge;
  }

  @JsonProperty("conyuge")
  public void setConyuge(ConyugeType conyuge) {
    this.conyuge = conyuge;
  }

  /**
   **/
  public ClienteFICType cupoRotativo(CupoRotativoType cupoRotativo) {
    this.cupoRotativo = cupoRotativo;
    return this;
  }

  
  @JsonProperty("cupoRotativo")
  public CupoRotativoType getCupoRotativo() {
    return cupoRotativo;
  }

  @JsonProperty("cupoRotativo")
  public void setCupoRotativo(CupoRotativoType cupoRotativo) {
    this.cupoRotativo = cupoRotativo;
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
  public ClienteFICType domicilio(DomicilioType domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  
  @JsonProperty("domicilio")
  public DomicilioType getDomicilio() {
    return domicilio;
  }

  @JsonProperty("domicilio")
  public void setDomicilio(DomicilioType domicilio) {
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
  public ClienteFICType estadoCivil(EstadoCivilEnum estadoCivil) {
    this.estadoCivil = estadoCivil;
    return this;
  }

  
  @JsonProperty("estadoCivil")
  public EstadoCivilEnum getEstadoCivil() {
    return estadoCivil;
  }

  @JsonProperty("estadoCivil")
  public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
    this.estadoCivil = estadoCivil;
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
  public ClienteFICType oferta(OfertaType oferta) {
    this.oferta = oferta;
    return this;
  }

  
  @JsonProperty("oferta")
  public OfertaType getOferta() {
    return oferta;
  }

  @JsonProperty("oferta")
  public void setOferta(OfertaType oferta) {
    this.oferta = oferta;
  }

  /**
   **/
  public ClienteFICType pasivo(PasivoType pasivo) {
    this.pasivo = pasivo;
    return this;
  }

  
  @JsonProperty("pasivo")
  public PasivoType getPasivo() {
    return pasivo;
  }

  @JsonProperty("pasivo")
  public void setPasivo(PasivoType pasivo) {
    this.pasivo = pasivo;
  }

  /**
   **/
  public ClienteFICType PQR(PQRType PQR) {
    this.PQR = PQR;
    return this;
  }

  
  @JsonProperty("PQR")
  public PQRType getPQR() {
    return PQR;
  }

  @JsonProperty("PQR")
  public void setPQR(PQRType PQR) {
    this.PQR = PQR;
  }

  /**
   **/
  public ClienteFICType prestamo(String prestamo) {
    this.prestamo = prestamo;
    return this;
  }

  
  @JsonProperty("prestamo")
  public String getPrestamo() {
    return prestamo;
  }

  @JsonProperty("prestamo")
  public void setPrestamo(String prestamo) {
    this.prestamo = prestamo;
  }

  /**
   **/
  public ClienteFICType primerApellidoRepresentanteLegal(String primerApellidoRepresentanteLegal) {
    this.primerApellidoRepresentanteLegal = primerApellidoRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("primerApellidoRepresentanteLegal")
  public String getPrimerApellidoRepresentanteLegal() {
    return primerApellidoRepresentanteLegal;
  }

  @JsonProperty("primerApellidoRepresentanteLegal")
  public void setPrimerApellidoRepresentanteLegal(String primerApellidoRepresentanteLegal) {
    this.primerApellidoRepresentanteLegal = primerApellidoRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType primerNombreRepresentanteLegal(String primerNombreRepresentanteLegal) {
    this.primerNombreRepresentanteLegal = primerNombreRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("primerNombreRepresentanteLegal")
  public String getPrimerNombreRepresentanteLegal() {
    return primerNombreRepresentanteLegal;
  }

  @JsonProperty("primerNombreRepresentanteLegal")
  public void setPrimerNombreRepresentanteLegal(String primerNombreRepresentanteLegal) {
    this.primerNombreRepresentanteLegal = primerNombreRepresentanteLegal;
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
  public ClienteFICType segundoApellidoRepresentanteLegal(String segundoApellidoRepresentanteLegal) {
    this.segundoApellidoRepresentanteLegal = segundoApellidoRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("segundoApellidoRepresentanteLegal")
  public String getSegundoApellidoRepresentanteLegal() {
    return segundoApellidoRepresentanteLegal;
  }

  @JsonProperty("segundoApellidoRepresentanteLegal")
  public void setSegundoApellidoRepresentanteLegal(String segundoApellidoRepresentanteLegal) {
    this.segundoApellidoRepresentanteLegal = segundoApellidoRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType segundoNombreRepresentanteLegal(String segundoNombreRepresentanteLegal) {
    this.segundoNombreRepresentanteLegal = segundoNombreRepresentanteLegal;
    return this;
  }

  
  @JsonProperty("segundoNombreRepresentanteLegal")
  public String getSegundoNombreRepresentanteLegal() {
    return segundoNombreRepresentanteLegal;
  }

  @JsonProperty("segundoNombreRepresentanteLegal")
  public void setSegundoNombreRepresentanteLegal(String segundoNombreRepresentanteLegal) {
    this.segundoNombreRepresentanteLegal = segundoNombreRepresentanteLegal;
  }

  /**
   **/
  public ClienteFICType seRequiereActualizacion(Boolean seRequiereActualizacion) {
    this.seRequiereActualizacion = seRequiereActualizacion;
    return this;
  }

  
  @JsonProperty("seRequiereActualizacion")
  public Boolean getSeRequiereActualizacion() {
    return seRequiereActualizacion;
  }

  @JsonProperty("seRequiereActualizacion")
  public void setSeRequiereActualizacion(Boolean seRequiereActualizacion) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClienteFICType clienteFICType = (ClienteFICType) o;
    return Objects.equals(this.alerta, clienteFICType.alerta) &&
        Objects.equals(this.clienteBase, clienteFICType.clienteBase) &&
        Objects.equals(this.centralRiesgo, clienteFICType.centralRiesgo) &&
        Objects.equals(this.contacto, clienteFICType.contacto) &&
        Objects.equals(this.conyuge, clienteFICType.conyuge) &&
        Objects.equals(this.cupoRotativo, clienteFICType.cupoRotativo) &&
        Objects.equals(this.digitoVerificacion, clienteFICType.digitoVerificacion) &&
        Objects.equals(this.domicilio, clienteFICType.domicilio) &&
        Objects.equals(this.domicilioEmpresa, clienteFICType.domicilioEmpresa) &&
        Objects.equals(this.estadoCivil, clienteFICType.estadoCivil) &&
        Objects.equals(this.funcionarioUltimaActualizacion, clienteFICType.funcionarioUltimaActualizacion) &&
        Objects.equals(this.negocio, clienteFICType.negocio) &&
        Objects.equals(this.numeroDocumentoRepresentanteLegal, clienteFICType.numeroDocumentoRepresentanteLegal) &&
        Objects.equals(this.oferta, clienteFICType.oferta) &&
        Objects.equals(this.pasivo, clienteFICType.pasivo) &&
        Objects.equals(this.PQR, clienteFICType.PQR) &&
        Objects.equals(this.prestamo, clienteFICType.prestamo) &&
        Objects.equals(this.primerApellidoRepresentanteLegal, clienteFICType.primerApellidoRepresentanteLegal) &&
        Objects.equals(this.primerNombreRepresentanteLegal, clienteFICType.primerNombreRepresentanteLegal) &&
        Objects.equals(this.razonSocial, clienteFICType.razonSocial) &&
        Objects.equals(this.segundoApellidoRepresentanteLegal, clienteFICType.segundoApellidoRepresentanteLegal) &&
        Objects.equals(this.segundoNombreRepresentanteLegal, clienteFICType.segundoNombreRepresentanteLegal) &&
        Objects.equals(this.seRequiereActualizacion, clienteFICType.seRequiereActualizacion) &&
        Objects.equals(this.tipoDocumentoRepresentanteLegal, clienteFICType.tipoDocumentoRepresentanteLegal) &&
        Objects.equals(this.totalActivos, clienteFICType.totalActivos) &&
        Objects.equals(this.ultimaFechaActualizacion, clienteFICType.ultimaFechaActualizacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alerta, clienteBase, centralRiesgo, contacto, conyuge, cupoRotativo, digitoVerificacion, domicilio, domicilioEmpresa, estadoCivil, funcionarioUltimaActualizacion, negocio, numeroDocumentoRepresentanteLegal, oferta, pasivo, PQR, prestamo, primerApellidoRepresentanteLegal, primerNombreRepresentanteLegal, razonSocial, segundoApellidoRepresentanteLegal, segundoNombreRepresentanteLegal, seRequiereActualizacion, tipoDocumentoRepresentanteLegal, totalActivos, ultimaFechaActualizacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClienteFICType {\n");
    
    sb.append("    alerta: ").append(toIndentedString(alerta)).append("\n");
    sb.append("    clienteBase: ").append(toIndentedString(clienteBase)).append("\n");
    sb.append("    centralRiesgo: ").append(toIndentedString(centralRiesgo)).append("\n");
    sb.append("    contacto: ").append(toIndentedString(contacto)).append("\n");
    sb.append("    conyuge: ").append(toIndentedString(conyuge)).append("\n");
    sb.append("    cupoRotativo: ").append(toIndentedString(cupoRotativo)).append("\n");
    sb.append("    digitoVerificacion: ").append(toIndentedString(digitoVerificacion)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    domicilioEmpresa: ").append(toIndentedString(domicilioEmpresa)).append("\n");
    sb.append("    estadoCivil: ").append(toIndentedString(estadoCivil)).append("\n");
    sb.append("    funcionarioUltimaActualizacion: ").append(toIndentedString(funcionarioUltimaActualizacion)).append("\n");
    sb.append("    negocio: ").append(toIndentedString(negocio)).append("\n");
    sb.append("    numeroDocumentoRepresentanteLegal: ").append(toIndentedString(numeroDocumentoRepresentanteLegal)).append("\n");
    sb.append("    oferta: ").append(toIndentedString(oferta)).append("\n");
    sb.append("    pasivo: ").append(toIndentedString(pasivo)).append("\n");
    sb.append("    PQR: ").append(toIndentedString(PQR)).append("\n");
    sb.append("    prestamo: ").append(toIndentedString(prestamo)).append("\n");
    sb.append("    primerApellidoRepresentanteLegal: ").append(toIndentedString(primerApellidoRepresentanteLegal)).append("\n");
    sb.append("    primerNombreRepresentanteLegal: ").append(toIndentedString(primerNombreRepresentanteLegal)).append("\n");
    sb.append("    razonSocial: ").append(toIndentedString(razonSocial)).append("\n");
    sb.append("    segundoApellidoRepresentanteLegal: ").append(toIndentedString(segundoApellidoRepresentanteLegal)).append("\n");
    sb.append("    segundoNombreRepresentanteLegal: ").append(toIndentedString(segundoNombreRepresentanteLegal)).append("\n");
    sb.append("    seRequiereActualizacion: ").append(toIndentedString(seRequiereActualizacion)).append("\n");
    sb.append("    tipoDocumentoRepresentanteLegal: ").append(toIndentedString(tipoDocumentoRepresentanteLegal)).append("\n");
    sb.append("    totalActivos: ").append(toIndentedString(totalActivos)).append("\n");
    sb.append("    ultimaFechaActualizacion: ").append(toIndentedString(ultimaFechaActualizacion)).append("\n");
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

