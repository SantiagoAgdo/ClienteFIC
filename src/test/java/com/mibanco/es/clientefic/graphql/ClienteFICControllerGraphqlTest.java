package com.mibanco.es.clientefic.graphql;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ClienteFICControllerGraphqlTest {


    @Test
    public void consultaAlertaTest() {
        given()
                .contentType("application/json")
                .body("{ \"query\": \"{ consultaAlerta(TipoDocumento: CC_CEDULA_DE_CIUDADAN_A, numeroDocumento: 10002, digitoVerificacion: 0) { tipoDocumento numeroDocumento digitoVerificacion } }\" }")
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaCentralDeRiesgo() {
        given()
                .contentType("application/json")
                .body("{ \"query\": \"{ ConsultaCentralRiesgo(TipoDocumento: CC_CEDULA_DE_CIUDADAN_A, numeroDocumento: 10002, digitoVerificacion: 0) { tipoDocumento numeroDocumento digitoVerificacion } }\" }")
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaClientePorNombre() {
        String query = "query ConsultaClientePorNombre { " +
                "consultaClientePorNombre(nombre: \"Pablo\") { " +
                "totalClientes " +
                "clientes { " +
                "nombreCompleto " +
                "numeroDocumento " +
                "tipoDocumento " +
                "} " +
                "} " +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

}
