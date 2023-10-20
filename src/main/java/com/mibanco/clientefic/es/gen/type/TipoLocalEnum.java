package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoLocalEnum
 */
public enum TipoLocalEnum {
  
  PROPIO_SIN_HIPOTECA("PROPIO SIN HIPOTECA"),
  
  PROPIO_CON_HIPOTECA("PROPIO CON HIPOTECA"),
  
  FAMILIAR("FAMILIAR"),
  
  ARRENDADO("ARRENDADO");

  private String value;

  TipoLocalEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoLocalEnum fromString(String s) {
      for (TipoLocalEnum b : TipoLocalEnum.values()) {
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
  public static TipoLocalEnum fromValue(String value) {
    for (TipoLocalEnum b : TipoLocalEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


