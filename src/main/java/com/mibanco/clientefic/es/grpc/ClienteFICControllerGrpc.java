package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICExceptionValidation;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

import static com.mibanco.clientefic.es.TipoDocumentoEnum.CC;
import static com.mibanco.clientefic.es.TipoRelacionEnum.TITULAR;
import static com.mibanco.clientefic.es.TipoReporteXmlEnum.CONSULTA_DETALLADA;

@GrpcService
public class ClienteFICControllerGrpc extends ClienteFICServiceGrpcGrpc.ClienteFICServiceGrpcImplBase {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICController.class);

    @Inject
    ClienteFICServiceImpl clienteFICService;

    @Inject
    ClienteFICMapperGrpc mapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    @Override
    @Blocking
    public void clienteFIC(CrearClienteFICGrpc request, StreamObserver<ResponseClienteFIC> responseObs) {

        logger.info("Inicia Creacion Cliente FIC por GRPC");

        try {
            ClienteFICEntity entity = mapper.clienteGrpcToEntity(request);
            clienteFICService.crearClienteFICType(entity);

            ResponseClienteFIC response = ResponseClienteFIC.newBuilder().setObj(request.toBuilder()).build();
            logger.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (Exception e) {
            Status status = Status.INTERNAL;
            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), "Fallo servicio creacion cliente FIC");

            StatusException statusException = status.asException(metadata);
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarAlerta(ConsultaClienteByData request, StreamObserver<ResponseAlerta> responseObs) {

        logger.info("Inicia consulta alerta por GRPC");
        try {

            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<AlertaType> list = clienteFICService.getListaAlertas(entity);

            List<com.mibanco.clientefic.es.AlertaType> lista = new ArrayList<>();
            for (AlertaType alert : list) {
                lista.add(com.mibanco.clientefic.es.AlertaType.newBuilder()
                        .setTipoAlerta(alert.getTipoAlerta())
                        .setBanco(alert.getBanco())
                        .setFecha(alert.getFecha().toString())
                        .setTipoDocumento(CC)
                        .setNumeroDocumento(alert.getNumeroDocumento())
                        .setDigitoVerificacion(alert.getDigitoVerificacion())
                        .build());
            }

            ResponseAlerta response = ResponseAlerta.newBuilder().addAllObj(lista).build();
            logger.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ClienteFICExceptionValidation e) {
            Status status = Status.INVALID_ARGUMENT;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        } catch (Exception e) {
            Status status = Status.INTERNAL;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), "Pruebaaaaaaaaaa");
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarCentralDeRiesgo(ConsultaClienteByData request, StreamObserver<ResponseCentralDeRiesgo> responseObs) {

        logger.info("Inicia consulta central Riesgo por GRPC");
        try {
            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<CentralRiesgoType> list = clienteFICService.getListaCentralRiesgo(entity);

            List<com.mibanco.clientefic.es.CentralRiesgoType> lista = new ArrayList<>();
            for (CentralRiesgoType i : list) {
                lista.add(com.mibanco.clientefic.es.CentralRiesgoType.newBuilder()
                        .setAntiguedadUbicacion(i.getAntiguedadUbicacion())
                        .setConsultaDetallada(i.getConsultaDetallada())
                        .setEstadoDocumento(i.getEstadoDocumento())
                        .setFechaConsultaMasReciente(i.getFechaConsultaMasReciente().toString())
                        .setFechaExpedicion(i.getFechaExpedicion().toString())
                        .setGenero(i.getGenero())
                        .setHistoricoEndeudamiento(i.getHistoricoEndeudamiento())
                        .setLugarExpedicion(i.getLugarExpedicion())
                        .setNumeroDocumento(i.getNumeroDocumento())
                        .setRangoEdad(i.getRangoEdad())
                        .setResultadoConsultaMasReciente(i.getResultadoConsultaMasReciente())
                        .setTieneRUT(i.getTieneRUT())
                        .setTipoDocumento(CC)
                        .setTipoRelacion(TITULAR)
                        .setTipoReporte(CONSULTA_DETALLADA)
                        .setVbVigenteParaSerConsultado(i.getVbVigenteParaSerConsultado())
                        .setDigitoVerificacion(i.getDigitoVerificacion())
                        .build());
            }
            ResponseCentralDeRiesgo response = ResponseCentralDeRiesgo.newBuilder().addAllObj(lista).build();
            logger.info("Finaliza consulta centralRiesgo por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ClienteFICExceptionValidation e) {
            Status status = Status.INVALID_ARGUMENT;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        } catch (Exception e) {
            Status status = Status.INTERNAL;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarPQR(ConsultaClienteByData request, StreamObserver<ResponsePQR> responseObs) {
        logger.info("Inicia consulta PQR por GRPC");
        try {
            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<PQRType> list = clienteFICService.getPQR(entity);

            List<com.mibanco.clientefic.es.PQRType> lista = new ArrayList<>();
            for (PQRType i : list) {
                lista.add(com.mibanco.clientefic.es.PQRType.newBuilder()
                        .setFecha(i.getFecha().toString())
                        .setNumeroPQR(i.getNumeroPQR())
                        .setMotivo(i.getMotivo())
                        .setResultadoPQR(i.getResultadoPQR())
                        .setComentario(i.getComentario())
                        .setDigitoVerificacion(i.getDigitoVerificacion())
                        .setTipoDocumento(CC)
                        .setNumeroDocumento(i.getNumeroDocumento())
                        .build());
            }
            ResponsePQR response = ResponsePQR.newBuilder().addAllObj(lista).build();
            logger.info("Finaliza consulta PQR por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ClienteFICExceptionValidation e) {
            Status status = Status.INVALID_ARGUMENT;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        } catch (Exception e) {
            Status status = Status.INTERNAL;

            Metadata metadata = new Metadata();
            metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
            StatusException statusException = status.asException(metadata);

            responseObs.onError(statusException);
        }
    }

}
