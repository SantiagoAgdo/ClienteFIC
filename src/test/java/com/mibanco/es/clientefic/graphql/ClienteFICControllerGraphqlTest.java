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
    public void consultaCentralDeRiesgoTest() {
        given()
                .contentType("application/json")
                .body("{ \"query\": \"{ ConsultaCentralRiesgo(TipoDocumento: CC_CEDULA_DE_CIUDADAN_A, numeroDocumento: 10002, digitoVerificacion: 0) { tipoDocumento numeroDocumento digitoVerificacion } }\" }")
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaClientePorNombreTest() {
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

    @Test
    public void consultaConyugeTest() {
        String query = """
                query ConsultaConyuge {
                    consultaConyuge(numeroCliente: 10002) {
                        numeroCliente
                        numeroDocumento
                        primerApellido
                        primerNombre
                        segundoApellido
                        segundoNombre
                        tipoDocumento
                    }
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaCupoRotativoTest() {
        String query = """
                query ConsultaCupoRotativo {
                    consultaCupoRotativo(numeroCliente: 10002) {
                        estado
                        fechaDeVencimiento
                        montoCupoCredito
                        montoUtilizado
                        numeroCliente
                        numeroCupo
                        saldoDisponible
                    }
                }""";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaHistorialContactoTest() {
        String query = """
                query ConsultaHistorialContacto {
                    consultaHistorialContacto(numeroCliente: 10002) {
                        fecha
                        numeroCliente
                        resultadoComentarios
                        tipoContacto
                    }
                }""";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaOfertaTest() {
        String query = """
                query ConsultaOferta {
                    consultaOferta(numeroCliente: 10002) {
                        condicionGarantia
                        monto
                        numeroCliente
                        numeroOferta
                        plazo
                        tipoDeLiga
                        tipoLead
                        tipoOferta
                    }
                }""";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaPQRTest() {
        String query = """
                query ConsultaPQR {
                    consultaPQR(
                        TipoDocumento: CC
                        numeroDocumento: 10002
                        digitoVerificacion: 0
                    ) {
                        comentario
                        digitoVerificacion
                        fecha
                        motivo
                        numeroDocumento
                        numeroPQR
                        resultadoPQR
                        tipoDocumento
                    }
                }""";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

    @Test
    public void consultaPasivoTest() {
        String query = """
                query ConsultaPasivo {
                    consultaPasivo(numeroCliente: 10002) {
                        capital
                        estadoPasivo
                        fechaApertura
                        fechaCierre
                        intereses
                        numeroCliente
                        numeroProducto
                        otros
                        saldoTotal
                        subProducto
                        tipoProducto
                    }
                }""";

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200);
    }

}
