package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoProductoEnum
 */
public enum TipoProductoEnum {

    BCA1_BONO_MENOR_5_A_OS_COSTO_AMORTIZADO("BCA1 BONO MENOR 5 AÑOS COSTO AMORTIZADO"),

    BCA2_BONOS_MENOR_5_A_OS_COST_AMORT_VINCULADOS("BCA2 BONOS MENOR 5 AÑOS COST AMORT VINCULADOS"),

    BONO_BONOS("BONO BONOS"),

    CACN_CUENTA_AHORROS_CONTRACTUAL("CACN CUENTA AHORROS CONTRACTUAL"),

    CAEL_CUENTA_AHORRO_ELECTRONICA("CAEL CUENTA AHORRO ELECTRONICA"),

    CAFC_CUENTA_AHORROS_AFC("CAFC CUENTA AHORROS AFC"),

    CAPR_CUENTA_AHORRO_PROGRAMADO("CAPR CUENTA AHORRO PROGRAMADO"),

    CATR_CUENTA_AHORRO_TRADICIONAL("CATR CUENTA AHORRO TRADICIONAL"),

    CCCG_CUENTAS_DE_CHEQUES_DE_GERENCIA("CCCG CUENTAS DE CHEQUES DE GERENCIA"),

    CCNR_CUENTA_CORRIENTE_NO_REMUNERADA("CCNR CUENTA CORRIENTE NO REMUNERADA"),

    CCRE_CUENTA_CORRIENTE_REMUNERADA("CCRE CUENTA CORRIENTE REMUNERADA"),

    CDTE_RESIDENTE_EN_EXTRANJERO_RTE_FTE_20_PORC("CDTE RESIDENTE EN EXTRANJERO RTE FTE 20 PORC"),

    CDTS_CDTS_BANCOMPARTIR("CDTS CDTS BANCOMPARTIR"),

    CRDL_LINEAS_DE_CREDITO_BANCOMPARTIR("CRDL LINEAS DE CREDITO BANCOMPARTIR"),

    CTCB_CUENTA_CORRIENTE_CORRESPONSAL_BANCARIO("CTCB CUENTA CORRIENTE CORRESPONSAL BANCARIO"),

    GRFG_GARANTIAS_FONDOS_DE_GARANTIA_BANCOMPARTIR("GRFG GARANTIAS FONDOS DE GARANTIA BANCOMPARTIR"),

    GRHI_GARANTIAS_HIPOTECARIAS_BANCOMPARTIR("GRHI GARANTIAS HIPOTECARIAS BANCOMPARTIR"),

    GRPR_GARANTIA_PRENDARIA_BANCOMPARTIR("GRPR GARANTIA PRENDARIA BANCOMPARTIR"),

    INTA_INTANGIBLES("INTA INTANGIBLES"),

    PCOM_COMERCIAL_BANCOMPARTIR("PCOM COMERCIAL BANCOMPARTIR"),

    PCON_CONSUMO_BANCOMPARTIR("PCON CONSUMO BANCOMPARTIR"),

    PLQD_LIQUIDEZ_BANCOMPARTIR("PLQD LIQUIDEZ BANCOMPARTIR"),

    PMIC_MICROCREDITO_BANCOMPARTIR("PMIC MICROCREDITO BANCOMPARTIR"),

    PRDS_REDESCUENTO_BANCOMPARTIR("PRDS REDESCUENTO BANCOMPARTIR"),

    PSOB_SOBREGIRO_BANCOMPARTIR("PSOB SOBREGIRO BANCOMPARTIR"),

    PVIV_VIVIENDA_BANCOMPARTIR("PVIV VIVIENDA BANCOMPARTIR"),

    REMA_REMANENTES_POR_PAGAR("REMA REMANENTES POR PAGAR"),

    REMC_REMANENTES_POR_COBRAR("REMC REMANENTES POR COBRAR"),

    REMK_REMANENTES_CASTIGADOS("REMK REMANENTES CASTIGADOS"),

    ROTC_CREDILINEAS_CONSUMO_BANCOMPARTIR("ROTC CREDILINEAS CONSUMO BANCOMPARTIR"),

    ROTL_CUPO_ROTATIVO_COMERCIAL("ROTL CUPO ROTATIVO COMERCIAL"),

    ROTM_CUPO_ROTATIVO_MICROCREDITO("ROTM CUPO ROTATIVO MICROCREDITO"),

    RUCM_ROTATIVO_UTILIZACIONES_COMERCIAL("RUCM ROTATIVO UTILIZACIONES COMERCIAL"),

    RUMC_ROTATIVO_UTILIZACIONES_MICROCREDITO("RUMC ROTATIVO UTILIZACIONES MICROCREDITO");

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


