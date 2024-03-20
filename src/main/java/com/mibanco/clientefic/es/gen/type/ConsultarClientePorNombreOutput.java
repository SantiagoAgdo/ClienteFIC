package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.ClienteFiltroType;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ConsultarClientePorNombreOutput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-02-22T09:33:21.194046200-05:00[America/Bogota]")
public class ConsultarClientePorNombreOutput   {
  private @Valid Integer totalClientes;
  private @Valid ClienteFiltroType clientes;
  private @Valid Integer pagina;
  private @Valid Integer tamanoPagina;

  /**
   **/
  public ConsultarClientePorNombreOutput totalClientes(Integer totalClientes) {
    this.totalClientes = totalClientes;
    return this;
  }

  
  @JsonProperty("totalClientes")
  @NotNull
  public Integer getTotalClientes() {
    return totalClientes;
  }

  @JsonProperty("totalClientes")
  public void setTotalClientes(Integer totalClientes) {
    this.totalClientes = totalClientes;
  }

  /**
   **/
  public ConsultarClientePorNombreOutput clientes(ClienteFiltroType clientes) {
    this.clientes = clientes;
    return this;
  }

  
  @JsonProperty("clientes")
  @NotNull
  public ClienteFiltroType getClientes() {
    return clientes;
  }

  @JsonProperty("clientes")
  public void setClientes(ClienteFiltroType clientes) {
    this.clientes = clientes;
  }

  /**
   **/
  public ConsultarClientePorNombreOutput pagina(Integer pagina) {
    this.pagina = pagina;
    return this;
  }

  
  @JsonProperty("pagina")
  public Integer getPagina() {
    return pagina;
  }

  @JsonProperty("pagina")
  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }

  /**
   **/
  public ConsultarClientePorNombreOutput tamanoPagina(Integer tamanoPagina) {
    this.tamanoPagina = tamanoPagina;
    return this;
  }

  
  @JsonProperty("tamanoPagina")
  public Integer getTamanoPagina() {
    return tamanoPagina;
  }

  @JsonProperty("tamanoPagina")
  public void setTamanoPagina(Integer tamanoPagina) {
    this.tamanoPagina = tamanoPagina;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsultarClientePorNombreOutput consultarClientePorNombreOutput = (ConsultarClientePorNombreOutput) o;
    return Objects.equals(this.totalClientes, consultarClientePorNombreOutput.totalClientes) &&
        Objects.equals(this.clientes, consultarClientePorNombreOutput.clientes) &&
        Objects.equals(this.pagina, consultarClientePorNombreOutput.pagina) &&
        Objects.equals(this.tamanoPagina, consultarClientePorNombreOutput.tamanoPagina);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalClientes, clientes, pagina, tamanoPagina);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsultarClientePorNombreOutput {\n");
    
    sb.append("    totalClientes: ").append(toIndentedString(totalClientes)).append("\n");
    sb.append("    clientes: ").append(toIndentedString(clientes)).append("\n");
    sb.append("    pagina: ").append(toIndentedString(pagina)).append("\n");
    sb.append("    tamanoPagina: ").append(toIndentedString(tamanoPagina)).append("\n");
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

