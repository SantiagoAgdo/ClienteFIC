package com.mibanco.es.clientefic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@QuarkusTest
public class ClienteFICControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private ClienteFICServiceImpl clienteFICService;
    @Mock
    private ClienteFICValidator clienteFICValidator;

    private ClienteFICController clienteFICController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        clienteFICService = mock(ClienteFICServiceImpl.class);
        clienteFICValidator = mock(ClienteFICValidator.class);
        clienteFICController = new ClienteFICController(clienteFICService, clienteFICValidator);
    }


    @Test
    @Ignore
    void crearClienteFICTest() throws IOException {

        when(mockObjectMapper.readValue(any(byte[].class), any(Class.class))).thenReturn(new ClienteFICType());

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/es-clienteFIC-json.json")), StandardCharsets.UTF_8);
        ClienteFICType clienteType = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteType)
                .when()
                .post("v1/es/cliente-fic/usuario")
                .then()
                .statusCode(201);
    }

    @Test
    void consultarCentralRiesgoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-centralriesgo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/central-riesgo/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarConyugeTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-conyuge-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/conyuge/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarCupoRotativoTest() throws IOException {

         byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-cuporotativo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/cupo-rotativo/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarHistorialContactoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-historialcontacto-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/historial-contacto/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarOfertaTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-oferta-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/oferta/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarPasivoTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-pasivo-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/pasivo/10002")
                .then()
                .statusCode(200);
    }

    @Test
    void consultarPQRTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-pqr-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/pqr/CC/10002/0")
                .then()
                .statusCode(200);
    }

    @Test
    void consultaClienteByNombreTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-consultabynombre-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/nombre/Pablo/emilio/independiente")
                .then()
                .statusCode(200);
    }

    @Test
    void consultaClienteByIdentificacionTest() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-consultabyidentificacion-api.json"));
        String jsonString = new String(jsonData);

        ClienteFICType clienteFIC = objectMapper.readValue(jsonString, ClienteFICType.class);

        given()
                .contentType(ContentType.JSON)
                .body(clienteFIC)
                .when()
                .get("v1/es/cliente-fic/CC/10002/0")
                .then()
                .statusCode(200);
    }


    @Test
    public void testConsultarAlerta() throws ApplicationExceptionValidation {
        // Mock de datos de entrada
        TipoDocumentoEnum tipoDocumento = TipoDocumentoEnum.CC;
        Integer numeroDocumento = 10002;
        Integer digitoVerificacion = 0;

        // Mock de datos de salida
        AlertaType alerta = new AlertaType();
        // Configurar los valores de alerta según sea necesario
        ConsultaClienteByData x = new ConsultaClienteByData(TipoDocumentoEnum.CC, 10002, 0);
        // Configuración de los mocks
        when(clienteFICService.obtenerListaAlertas(x)).thenReturn(Collections.singletonList(alerta));

        // Llamada al método bajo prueba
        Response response = clienteFICController.consultarAlerta(tipoDocumento, numeroDocumento, digitoVerificacion);
        System.out.println(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus()); // Verificar el código de estado de la respuesta

    }


}