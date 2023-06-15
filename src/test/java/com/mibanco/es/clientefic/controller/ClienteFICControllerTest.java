package com.mibanco.es.clientefic.controller;

import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@QuarkusTest
public class ClienteFICControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void crearClienteFICTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/es-ClienteFIc-json.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .post("v1/es/clienteFIC")
                .then()
                .statusCode(201);
    }

    @Test
    void consultarCentralRiesgoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-centralriesgo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/centralRiesgo/CC CEDULA DE CIUDADANÍA/10002/0")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarConyugeTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-conyuge-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/conyuge/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarCupoRotativoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-cuporotativo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cupoRotativo/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarHistorialContactoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-historialcontacto-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/historialContacto/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarOfertaTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-oferta-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/oferta/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarPasivoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-pasivo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/pasivo/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarPQRTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-pqr-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/pqr/CC CEDULA DE CIUDADANÍA/10002/0")
                .then()
                .statusCode(200);
    }

    @Test
    void consultaClienteByNombreTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-consultabynombre-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/clienteFIC/Pablo")
                .then()
                .statusCode(200);
    }

    @Test
    void consultaClienteByIdentificacionTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-consultabyidentificacion-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/clienteFIC/CC CEDULA DE CIUDADANÍA/10002/0")
                .then()
                .statusCode(200);
    }

}
