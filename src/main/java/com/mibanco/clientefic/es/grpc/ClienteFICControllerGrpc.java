package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.mibanco.clientefic.es.TipoDocumentoEnum.CC_CEDULA_DE_CIUDADANIA;
import static com.mibanco.clientefic.es.TipoRelacionEnum.TITULAR;
import static com.mibanco.clientefic.es.TipoReporteXmlEnum.CONSULTA_DETALLADA;

@GrpcService
public class ClienteFICControllerGrpc extends ClienteFICServiceGrpcGrpc.ClienteFICServiceGrpcImplBase {

    public static final Logger logger = LoggerFactory.getLogger(ClienteFICController.class);

    @Inject
    ClienteFICServiceImpl clienteFICService;

    @Inject
    ClienteFICMapperGrpc mapper;

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
            logger.error(ErrorCts.SERVICIO + " Creacion Novedad Grpc");
            throw new ClienteFICException(ErrorCts.SERVICIO + " Creacion Novedad Grpc - Exception: " + e.getMessage());
        }
    }

    @Override
    @Blocking
    public void consultarAlerta(ConsultaClienteByData request, StreamObserver<ResponseAlerta> responseObs) {

        logger.info("Inicia consulta alerta por GRPC");
        try {
//            throw new Exception();
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<AlertaType> list = clienteFICService.getListaAlertas(entity);

            List<com.mibanco.clientefic.es.AlertaType> lista = new ArrayList<>();
            for (AlertaType alert : list) {
                lista.add(com.mibanco.clientefic.es.AlertaType.newBuilder()
                        .setTipoAlerta(alert.getTipoAlerta())
                        .setBanco(alert.getBanco())
                        .setFecha(alert.getFecha().toString())
                        .setTipoDocumento(CC_CEDULA_DE_CIUDADANIA)
                        .setNumeroDocumento(alert.getNumeroDocumento())
                        .setDigitoVerificacion(alert.getDigitoVerificacion())
                        .build());

            }
            ResponseAlerta y = ResponseAlerta.newBuilder().addAllObj(lista).build();
            logger.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(y);

            responseObs.onCompleted();

        } catch (Exception e) {
            Status status = Status.fromThrowable(new StatusRuntimeException(Status.ABORTED));
//            String message = status.getDescription() "ERRRORRRRRRR CCCCCXXXXX";
            responseObs.onError(new StatusRuntimeException(status));
            responseObs.onCompleted();
            logger.error(ErrorCts.SERVICIO_GRPC + "consultarAlerta en GRPC");
            throw new ClienteFICException(ErrorCts.SERVICIO + " Creacion Novedad Grpc - Exception: " + e.getMessage());
        }
    }

    @Override
    @Blocking
    public void consultarCentralDeRiesgo(ConsultaClienteByData request, StreamObserver<ResponseCentralDeRiesgo> responseObs) {

        logger.info("Inicia consulta central Riesgo por GRPC");
        try {
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<CentralRiesgoType> list = clienteFICService.getListaCentralRiesgo(entity);

            com.mibanco.clientefic.es.CentralRiesgoType items = null;
            for (CentralRiesgoType i : list) {
                items = com.mibanco.clientefic.es.CentralRiesgoType.newBuilder()
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
                        .setTipoDocumento(CC_CEDULA_DE_CIUDADANIA)
                        .setTipoRelacion(TITULAR)
                        .setTipoReporte(CONSULTA_DETALLADA)
                        .setVbVigenteParaSerConsultado(i.getVbVigenteParaSerConsultado())
                        .setDigitoVerificacion(i.getDigitoVerificacion())
                        .build();
            }
            ResponseCentralDeRiesgo itemList = ResponseCentralDeRiesgo.newBuilder().setObj(items).build();
            logger.info("Finaliza creacion Cliente FIC por GRPC");

            responseObs.onNext(itemList);
            responseObs.onCompleted();

        } catch (Exception e) {

            logger.error(ErrorCts.SERVICIO_GRPC + "consultarAlerta en GRPC ");
            throw new ClienteFICException(ErrorCts.SERVICIO + " Creacion Novedad Grpc - Exception: " + e.getMessage());
        }
    }

}
