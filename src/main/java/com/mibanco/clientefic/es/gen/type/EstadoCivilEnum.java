package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoCivilEnum
 */
public enum EstadoCivilEnum {
  
  _1("SOLTERA(O)"),
  
  _2("CASADA(O)"),
  
  _3("DIVORCIADA(O)"),
  
  _4("VIUDA(O)"),
  
  _5("UNION LIBRE"),
  
  _6("OTRO");

  private String value;

  EstadoCivilEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static EstadoCivilEnum fromString(String s) {
      for (EstadoCivilEnum b : EstadoCivilEnum.values()) {
        // using Objects.toString() to be safe if value type non-object type
        // because types like 'int' etc. will be auto-boxed
        if (java.util.Objects.toString(b.value).equals(s)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EstadoCivilEnum fromValue(String value) {
    for (EstadoCivilEnum b : EstadoCivilEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


