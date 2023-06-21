package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
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

    public static final Logger LOG = LoggerFactory.getLogger(ClienteFICController.class);

    @Inject
    ClienteFICServiceImpl clienteFICService;

    @Inject
    ClienteFICMapperGrpc mapper;

    @Inject
    ClienteFICValidator clienteFICValidator;

    @Override
    @Blocking
    public void clienteFIC(CrearClienteFICGrpc request, StreamObserver<ResponseClienteFIC> responseObs) {

        LOG.info("Inicia Creacion Cliente FIC por GRPC");

        try {
            ClienteFICEntity entity = mapper.clienteGrpcToEntity(request);
            clienteFICService.crearClienteFICType(entity);

            ResponseClienteFIC response = ResponseClienteFIC.newBuilder().setObj(request.toBuilder()).build();
            LOG.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (Exception e) {

            StatusException statusException = responseExpetionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarAlerta(ConsultaClienteByData request, StreamObserver<ResponseAlerta> responseObs) {

        LOG.info("Inicia consulta alerta por GRPC");
        try {

            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<AlertaType> AlertaListType = clienteFICService.getListaAlertas(entity);

            List<com.mibanco.clientefic.es.AlertaType> alertaResponse = new ArrayList<>();
            for (AlertaType alert : AlertaListType) {
                alertaResponse.add(com.mibanco.clientefic.es.AlertaType.newBuilder()
                        .setTipoAlerta(alert.getTipoAlerta())
                        .setBanco(alert.getBanco())
                        .setFecha(alert.getFecha().toString())
                        .setTipoDocumento(CC)
                        .setNumeroDocumento(alert.getNumeroDocumento())
                        .setDigitoVerificacion(alert.getDigitoVerificacion())
                        .build());
            }

            ResponseAlerta response = ResponseAlerta.newBuilder().addAllObj(alertaResponse).build();
            LOG.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExpetionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {

            StatusException statusException = responseExpetionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarCentralDeRiesgo(ConsultaClienteByData request, StreamObserver<ResponseCentralDeRiesgo> responseObs) {

        LOG.info("Inicia consulta central Riesgo por GRPC");
        try {
            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<CentralRiesgoType> centralRiesgoList = clienteFICService.getListaCentralRiesgo(entity);

            List<com.mibanco.clientefic.es.CentralRiesgoType> centralRiesgoResponse = new ArrayList<>();
            for (CentralRiesgoType centralRiesgoItem : centralRiesgoList) {
                centralRiesgoResponse.add(com.mibanco.clientefic.es.CentralRiesgoType.newBuilder()
                        .setAntiguedadUbicacion(centralRiesgoItem.getAntiguedadUbicacion())
                        .setConsultaDetallada(centralRiesgoItem.getConsultaDetallada())
                        .setEstadoDocumento(centralRiesgoItem.getEstadoDocumento())
                        .setFechaConsultaMasReciente(centralRiesgoItem.getFechaConsultaMasReciente().toString())
                        .setFechaExpedicion(centralRiesgoItem.getFechaExpedicion().toString())
                        .setGenero(centralRiesgoItem.getGenero())
                        .setHistoricoEndeudamiento(centralRiesgoItem.getHistoricoEndeudamiento())
                        .setLugarExpedicion(centralRiesgoItem.getLugarExpedicion())
                        .setNumeroDocumento(centralRiesgoItem.getNumeroDocumento())
                        .setRangoEdad(centralRiesgoItem.getRangoEdad())
                        .setResultadoConsultaMasReciente(centralRiesgoItem.getResultadoConsultaMasReciente())
                        .setTieneRUT(centralRiesgoItem.getTieneRUT())
                        .setTipoDocumento(CC)
                        .setTipoRelacion(TITULAR)
                        .setTipoReporte(CONSULTA_DETALLADA)
                        .setVbVigenteParaSerConsultado(centralRiesgoItem.getVbVigenteParaSerConsultado())
                        .setDigitoVerificacion(centralRiesgoItem.getDigitoVerificacion())
                        .build());
            }
            ResponseCentralDeRiesgo response = ResponseCentralDeRiesgo.newBuilder().addAllObj(centralRiesgoResponse).build();
            LOG.info("Finaliza consulta centralRiesgo por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExpetionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExpetionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarPQR(ConsultaClienteByData request, StreamObserver<ResponsePQR> responseObs) {
        LOG.info("Inicia consulta PQR por GRPC");
        try {
            clienteFICValidator.validarConsultaGRPC(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<PQRType> pqrList = clienteFICService.getPQR(entity);

            List<com.mibanco.clientefic.es.PQRType> pqrListResponse = new ArrayList<>();
            for (PQRType pqrItem : pqrList) {
                pqrListResponse.add(com.mibanco.clientefic.es.PQRType.newBuilder()
                        .setFecha(pqrItem.getFecha().toString())
                        .setNumeroPQR(pqrItem.getNumeroPQR())
                        .setMotivo(pqrItem.getMotivo())
                        .setResultadoPQR(pqrItem.getResultadoPQR())
                        .setComentario(pqrItem.getComentario())
                        .setDigitoVerificacion(pqrItem.getDigitoVerificacion())
                        .setTipoDocumento(CC)
                        .setNumeroDocumento(pqrItem.getNumeroDocumento())
                        .build());
            }
            ResponsePQR response = ResponsePQR.newBuilder().addAllObj(pqrListResponse).build();
            LOG.info("Finaliza consulta PQR por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExpetionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExpetionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    private StatusException responseExpetionGrpc(Status statusCode, String exceptionMessage) {

        LOG.error(exceptionMessage + "Exception: " + exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        return statusCode.asException(metadata);
    }

}
