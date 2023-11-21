package com.mibanco.es.clientefic.grpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@QuarkusTest
public class ClienteFICControllerGRPCTest {

    @GrpcClient
    ClienteFICServiceGrpc client;

    @Inject
    ClienteFICServiceImpl serviceImpl;
    @Inject
    ObjectMapper objectMapper;

    @Inject
    ClienteFICMapperGrpc mapperGRPC;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    public void createClienteMock() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-cliente-api.json")), StandardCharsets.UTF_8);
        ClienteFICEntity cliente = objectMapper.readValue(jsonString, ClienteFICEntity.class);

        serviceImpl.crearUsuarioClienteFic(cliente);
    }

    @Test
    public void consultaConyugeGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        ConyugeType conyugeBuffer = this.getConyuge();

        CompletableFuture<ConyugeType> message = new CompletableFuture<>();

        NumeroCliente numeroCLiente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        client.consultarConyuge(numeroCLiente)
                .subscribe()
                .with(reply -> message.complete(reply.getObj()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS).getNumeroDocumento()).isEqualTo(conyugeBuffer.getNumeroDocumento());

    }

    @Test
    public void crearClienteFICGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<CrearClienteFICGrpc> message = new CompletableFuture<>();

        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-cliente-api.json")), StandardCharsets.UTF_8);
        ClienteFICType clienteType = objectMapper.readValue(jsonString, ClienteFICType.class);


        client.clienteFIC(mapperGRPC.clienteToGrpc(clienteType))
                .subscribe()
                .with(reply -> message.complete(reply.getObj()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS).getClienteBase().getNumeroCliente()).isEqualTo(clienteType.getClienteBase().getNumeroCliente());

    }

    @Test
    public void consultaAlertaGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<AlertaType>> message = new CompletableFuture<>();

        ConsultaClienteGrpc consultaClienteGrpc = ConsultaClienteGrpc.newBuilder()
                .setTipoDocumento("CC")
                .setNumeroDocumento(10002)
                .setDigitoVerificacion(1)
                .build();

        client.consultarAlerta(consultaClienteGrpc)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    @Test
    public void consultaCentralGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();
        NumeroCliente numeroCliente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        CompletableFuture<List<CentralRiesgoType>> message = new CompletableFuture<>();
        client.consultarCentralDeRiesgo(numeroCliente)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();
    }

    @Test
    public void consultaCupoRotativoGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<CupoRotativoType>> message = new CompletableFuture<>();

        NumeroCliente numeroCLiente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        client.consultarCupoRotativo(numeroCLiente)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    @Test
    public void consultaContactoGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<ContactoType>> message = new CompletableFuture<>();

        NumeroCliente numeroCliente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        client.consultarHistorialContacto(numeroCliente)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    @Test
    public void consultaOfertaGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<OfertaType>> message = new CompletableFuture<>();

        NumeroCliente numeroCLiente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        client.consultarOferta(numeroCLiente)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    @Test
    public void consultaPasivoGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<PasivoType>> message = new CompletableFuture<>();

        NumeroCliente numeroCliente = NumeroCliente.newBuilder().setNumeroCliente(10002).build();

        client.consultarPasivo(numeroCliente)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    @Test
    public void consultaPqrGRPCTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        this.createClienteMock();

        CompletableFuture<List<PQRType>> message = new CompletableFuture<>();

        ConsultaClienteGrpc data = ConsultaClienteGrpc.newBuilder()
                .setTipoDocumento("CC")
                .setNumeroDocumento(10002)
                .setDigitoVerificacion(1)
                .build();

        client.consultarPQR(data)
                .subscribe()
                .with(reply -> message.complete(reply.getObjList()));

        Assertions.assertThat(message.get(5, TimeUnit.SECONDS)).asList();

    }

    public ConyugeType getConyuge() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonmocks/es-conyuge-api.json")), StandardCharsets.UTF_8);
        com.mibanco.clientefic.es.gen.type.ConyugeType clienteType =
                objectMapper.readValue(jsonString, com.mibanco.clientefic.es.gen.type.ConyugeType.class);

        return mapperGRPC.conyugeToGrpc(clienteType);
    }


}

