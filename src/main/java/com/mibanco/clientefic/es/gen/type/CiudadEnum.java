package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CiudadEnum
 */
public enum CiudadEnum {

    _05001_MEDELLIN("05001 MEDELLIN"),

    _05002_ABEJORRAL("05002 ABEJORRAL"),

    _05004_ABRIAQUI("05004 ABRIAQUI"),

    _05021_ALEJANDRIA("05021 ALEJANDRIA"),

    _05030_AMAGA("05030 AMAGA"),

    _05031_AMALFI("05031 AMALFI"),

    _05034_ANDES("05034 ANDES"),

    _05036_ANGELOPOLIS("05036 ANGELOPOLIS"),

    _05038_ANGOSTURA("05038 ANGOSTURA"),

    _05040_ANORI("05040 ANORI");

    private String value;

    CiudadEnum(String value) {
        this.value = value;
    }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
    public static CiudadEnum fromString(String s) {
        for (CiudadEnum b : CiudadEnum.values()) {
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
    public static CiudadEnum fromValue(String value) {
        for (CiudadEnum b : CiudadEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}


