package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SubProductoEnum
 */
public enum SubProductoEnum {

    REMA_AAFC_APORTES_AFC_CENTRALIZADO("REMA AAFC APORTES AFC - CENTRALIZADO"),

    REMA_AARL_APORTES_ARL_CENTRALIZADO("REMA AARL APORTES ARL - CENTRALIZADO"),

    REMC_ABOG_ANTICIPO_ABOGADOS_CENTRALIZADO("REMC ABOG ANTICIPO ABOGADOS - CENTRALIZADO"),

    REMA_AFP_AFP_PENSIONES_CENTRALIZADO("REMA AFP AFP PENSIONES - CENTRALIZADO"),

    REMC_ANTC_ANTICIPOS_LABORALES_CENTRALIZADO("REMC ANTC ANTICIPOS LABORALES - CENTRALIZADO"),

    GRFG_ASDI_GARANTIA_ASDI("GRFG ASDI GARANTIA ASDI"),

    REMC_AUTO_FALTANTE_EN_CAJERO_AUTOMATICO_OFICINAS("REMC AUTO FALTANTE EN CAJERO AUTOMATICO - OFICINAS"),

    REMA_BDEG_SEGURO_BIENES_DADOS_EN_GRTIA_CENTRALIZADO("REMA BDEG SEGURO BIENES DADOS EN GRTIA  - CENTRALIZADO"),

    BONO_BN01_BONO_18_MESES_DTF("BONO BN01 BONO < 18 MESES DTF"),

    BONO_BN02_BONO_18_MESES_DTF("BONO BN02 BONO > 18 MESES DTF"),

    BONO_BN03_BONO_18_MESES_IBR("BONO BN03 BONO < 18 MESES IBR");

    private String value;

    SubProductoEnum(String value) {
        this.value = value;
    }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
    public static SubProductoEnum fromString(String s) {
        for (SubProductoEnum b : SubProductoEnum.values()) {
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
    public static SubProductoEnum fromValue(String value) {
        for (SubProductoEnum b : SubProductoEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}


