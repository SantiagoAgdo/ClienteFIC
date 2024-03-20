package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoProductoEnum
 */
public enum TipoProductoEnum {
  
  BCA1("BONO MENOR 5 AÑOS COSTO AMORTIZADO"),
  
  BCA2("BONOS MENOR 5 AÑOS COST AMORT VINCULADOS"),
  
  BONO("BONOS"),
  
  CACN("CUENTA AHORROS CONTRACTUAL"),
  
  CAEL("CUENTA AHORRO ELECTRONICA"),
  
  CAFC("CUENTA AHORROS AFC"),
  
  CAPR("CUENTA AHORRO PROGRAMADO"),
  
  CATR("CUENTA AHORRO TRADICIONAL"),
  
  CCCG("CUENTAS DE CHEQUES DE GERENCIA"),
  
  CCNR("CUENTA CORRIENTE NO REMUNERADA"),
  
  CCRE("CUENTA CORRIENTE REMUNERADA"),
  
  CDTE("RESIDENTE EN EXTRANJERO RTE FTE 20 PORC"),
  
  CDTS("CDTS BANCOMPARTIR"),
  
  CRDL("LINEAS DE CREDITO BANCOMPARTIR"),
  
  CTCB("CUENTA CORRIENTE CORRESPONSAL BANCARIO"),
  
  GRFG("GARANTIAS FONDOS DE GARANTIA BANCOMPARTIR"),
  
  GRHI("GARANTIAS HIPOTECARIAS BANCOMPARTIR"),
  
  GRPR("GARANTIA PRENDARIA BANCOMPARTIR"),
  
  INTA("INTANGIBLES"),
  
  PCOM("COMERCIAL BANCOMPARTIR"),
  
  PCON("CONSUMO BANCOMPARTIR"),
  
  PLQD("LIQUIDEZ BANCOMPARTIR"),
  
  PMIC("MICROCREDITO BANCOMPARTIR"),
  
  PRDS("REDESCUENTO BANCOMPARTIR"),
  
  PSOB("SOBREGIRO BANCOMPARTIR"),
  
  PVIV("VIVIENDA BANCOMPARTIR"),
  
  REMA("REMANENTES POR PAGAR"),
  
  REMC("REMANENTES POR COBRAR"),
  
  REMK("REMANENTES CASTIGADOS"),
  
  ROTC("CREDILINEAS CONSUMO BANCOMPARTIR"),
  
  ROTL("CUPO ROTATIVO COMERCIAL"),
  
  ROTM("CUPO ROTATIVO MICROCREDITO"),
  
  RUCM("ROTATIVO UTILIZACIONES COMERCIAL"),
  
  RUMC("ROTATIVO UTILIZACIONES MICROCREDITO");

  private String value;

  TipoProductoEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoProductoEnum fromString(String s) {
      for (TipoProductoEnum b : TipoProductoEnum.values()) {
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
  public static TipoProductoEnum fromValue(String value) {
    for (TipoProductoEnum b : TipoProductoEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


