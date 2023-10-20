package com.mibanco.clientefic.es.gen.type;

import com.mibanco.clientefic.es.gen.type.ConsultarClientePorNombreType;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ConsultarClientePorNombreOutput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-20T12:58:53.012310-05:00[America/Bogota]")
public class ConsultarClientePorNombreOutput   {
  private @Valid Integer totalClientes;
  private @Valid ConsultarClientePorNombreType clientes;

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
  public ConsultarClientePorNombreOutput clientes(ConsultarClientePorNombreType clientes) {
    this.clientes = clientes;
    return this;
  }

  
  @JsonProperty("clientes")
  @NotNull
  public ConsultarClientePorNombreType getClientes() {
    return clientes;
  }

  @JsonProperty("clientes")
  public void setClientes(ConsultarClientePorNombreType clientes) {
    this.clientes = clientes;
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
        Objects.equals(this.clientes, consultarClientePorNombreOutput.clientes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalClientes, clientes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsultarClientePorNombreOutput {\n");
    
    sb.append("    totalClientes: ").append(toIndentedString(totalClientes)).append("\n");
    sb.append("    clientes: ").append(toIndentedString(clientes)).append("\n");
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

