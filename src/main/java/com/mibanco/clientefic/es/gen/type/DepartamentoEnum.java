package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets DepartamentoEnum
 */
public enum DepartamentoEnum {
  
  _05_ANTIOQUIA("05 ANTIOQUIA"),
  
  _08_ATLANTICO("08 ATLANTICO"),
  
  _11_BOGOTA_D_C_("11 BOGOTA D.C."),
  
  _12_FUERA_DEL_PAIS("12 FUERA DEL PAIS"),
  
  _13_BOLIVAR("13 BOLIVAR"),
  
  _15_BOYACA("15 BOYACA"),
  
  _17_CALDAS("17 CALDAS"),
  
  _18_CAQUETA("18 CAQUETA"),
  
  _19_CAUCA("19 CAUCA"),
  
  _20_CESAR("20 CESAR"),
  
  _23_CORDOBA("23 CORDOBA"),
  
  _25_CUNDINAMARCA("25 CUNDINAMARCA");

  private String value;

  DepartamentoEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static DepartamentoEnum fromString(String s) {
      for (DepartamentoEnum b : DepartamentoEnum.values()) {
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
  public static DepartamentoEnum fromValue(String value) {
    for (DepartamentoEnum b : DepartamentoEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


