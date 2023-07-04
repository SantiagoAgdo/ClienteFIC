package com.mibanco.es.clientefic.grpc;

import com.mibanco.clientefic.es.AlertaType;
import com.mibanco.clientefic.es.ConsultaClienteByData;
import com.mibanco.clientefic.es.ResponseAlerta;
import com.mibanco.clientefic.es.grpc.ClienteFICControllerGrpc;

import io.grpc.stub.StreamObserver;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.mibanco.clientefic.es.TipoDocumentoEnum.CC;

@QuarkusTest
public class ClienteFICControllerGRPCTest {
    @Test
    public void consultaAlertaGRPCTest() {

        ConsultaClienteByData request = ConsultaClienteByData.newBuilder()
                .setTipoDocumento(CC).setNumeroDocumento(10002).setDigitoVerificacion(0)
                .build();

        List<AlertaType> alertaResponse = new ArrayList<>();
        alertaResponse.add(com.mibanco.clientefic.es.AlertaType.newBuilder()
                .setTipoAlerta("dsad")
                .setBanco("dsadsa")
                .setFecha("2032-21-11")
                .setTipoDocumento(CC)
                .setNumeroDocumento("10002")
                .setDigitoVerificacion("0")
                .build());
        ResponseAlerta expectedResponse = ResponseAlerta.newBuilder().addAllObj(alertaResponse).build();

        ClienteFICControllerGrpc clienteGrpcController = Mockito.mock(ClienteFICControllerGrpc.class);
        StreamObserver<ResponseAlerta> responseObserverMock = Mockito.mock(StreamObserver.class);

        Mockito.doAnswer(invocation -> {

            StreamObserver<ResponseAlerta> actualResponseObserver = invocation.getArgument(1);
            actualResponseObserver.onNext(expectedResponse);
            actualResponseObserver.onCompleted();

            return null;
        }).when(clienteGrpcController).consultarAlerta(request, responseObserverMock);

        clienteGrpcController.consultarAlerta(request, responseObserverMock);

        Mockito.verify(responseObserverMock).onNext(expectedResponse);
        Mockito.verify(responseObserverMock).onCompleted();
    }
}
