package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ContactoType;
import com.mibanco.clientefic.es.gen.type.CupoRotativoType;
import com.mibanco.clientefic.es.gen.type.OfertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import com.mibanco.clientefic.es.utils.validators.ClienteFICValidator;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


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
    public void consultarAlerta(ConsultaClienteGrpc request, StreamObserver<ResponseAlerta> responseObs) {

        LOG.info("Inicia consulta alerta por GRPC");
        try {

            clienteFICValidator.validarConsultaGrpc(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            ConsultaClienteEntity consultaClienteEntity = mapper.dataGrpcToEntity(request);
            AlertasOutput alertaListType = clienteFICService.consultarAlerta(1,1000,consultaClienteEntity);

            List<com.mibanco.clientefic.es.AlertaType> alertaResponse = new ArrayList<>();
            for (AlertaEntity alert : alertaListType.getClientes()) {
                alertaResponse.add(com.mibanco.clientefic.es.AlertaType.newBuilder()
                        .setTipoAlerta(alert.getTipoAlerta())
                        .setBanco(alert.getBanco())
                        .setFecha(alert.getFecha().toString())
                        .setTipoDocumento(alert.getTipoDocumento().toString())
                        .setNumeroDocumento(alert.getNumeroDocumento())
                        .setDigitoVerificacion(alert.getDigitoVerificacion())
                        .build());
            }

            ResponseAlerta responseAlerta = ResponseAlerta.newBuilder().addAllObj(alertaResponse).build();
            LOG.info("Finaliza creación Cliente FIC por GRPC");

            responseObs.onNext(responseAlerta);
            responseObs.onCompleted();

        } catch (ApplicationException e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {

            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarCentralDeRiesgo(NumeroCliente request, StreamObserver<ResponseCentralDeRiesgo> responseObs) {

        LOG.info("Inicia consulta central Riesgo por GRPC");
        try {
            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            List<CentralRiesgoType> centralRiesgoList = clienteFICService.consultarCentralRiesgo(1,1000, request.getNumeroCliente());

            List<com.mibanco.clientefic.es.CentralRiesgoType> centralRiesgoResponse = new ArrayList<>();
            for (CentralRiesgoType centralRiesgoItem : centralRiesgoList) {
                centralRiesgoResponse.add(com.mibanco.clientefic.es.CentralRiesgoType.newBuilder()
                        .setNumeroCliente(centralRiesgoItem.getNumeroCliente())
                        .setResultadoConsultaMasReciente(centralRiesgoItem.getResultadoConsultaMasReciente())
                        .setVbVigenteParaSerConsultado(centralRiesgoItem.getVbVigenteParaSerConsultado())
                        .setFechaConsultaMasReciente(centralRiesgoItem.getFechaConsultaMasReciente().toString())
                        .build());
            }
            ResponseCentralDeRiesgo response = ResponseCentralDeRiesgo.newBuilder().addAllObj(centralRiesgoResponse).build();
            LOG.info("Finaliza consulta central Riesgo por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarPQR(ConsultaClienteGrpc request, StreamObserver<ResponsePQR> responseObs) {
        LOG.info("Inicia consulta PQR por GRPC");
        try {
            clienteFICValidator.validarConsultaGrpc(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            ConsultaClienteEntity consultaClienteEntity = mapper.dataGrpcToEntity(request);
            List<PQRType> pqrList = clienteFICService.consultarPQR(1,1000,0);//test

            List<com.mibanco.clientefic.es.PQRType> pqrListResponse = new ArrayList<>();
            for (PQRType pqrItem : pqrList) {
                pqrListResponse.add(com.mibanco.clientefic.es.PQRType.newBuilder()
                        .setNumeroCliente(pqrItem.getNumeroCliente())
                        .setFecha(pqrItem.getFecha().toString())
                        .setNumeroPQR(pqrItem.getNumeroPQR())
                        .setMotivo(pqrItem.getMotivo())
                        .setResultadoPQR(pqrItem.getResultadoPQR())
                        .setComentario(pqrItem.getComentario())
                        .build());
            }
            ResponsePQR response = ResponsePQR.newBuilder().addAllObj(pqrListResponse).build();
            LOG.info("Finaliza consulta PQR por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarConyuge(NumeroCliente request, StreamObserver<ResponseConyuge> responseObs) {
        LOG.info("Inicia consulta conyuge por GRPC");
        try {
            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            ConyugeEntity conyuge = clienteFICService.consultarConyuge(request.getNumeroCliente());

            ResponseConyuge response = ResponseConyuge.newBuilder().setObj(
                    ResponseConyuge.newBuilder().getObj().toBuilder()
                            .setTipoDocumento(conyuge.getTipoDocumento().toString())
                            .setNumeroCliente(conyuge.getNumeroCliente())
                            .setNumeroDocumento(conyuge.getNumeroDocumento())
                            .setNombre(conyuge.getNombre())
            ).build();
            LOG.info("Finaliza consulta conyuge por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarCupoRotativo(NumeroCliente request, StreamObserver<ResponseCupoRotativo> responseObs) {
        LOG.info("Inicia consulta cupo rotativo por GRPC");
        try {
            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            ConsultarCupoRotativoOutput cupoList = clienteFICService.consultarCupoRotativo(1,1000, request.getNumeroCliente());

            List<com.mibanco.clientefic.es.CupoRotativoType> cupoListResponse = new ArrayList<>();
            for (CupoRotativoEntity cupoItem : cupoList.getCupoRotativo()) {
                cupoListResponse.add(com.mibanco.clientefic.es.CupoRotativoType.newBuilder()
                        .setEstado(cupoItem.getEstado())
                        .setFechaDeVencimiento(cupoItem.getFechaDeVencimiento().toString())
                        .setMontoCupoCredito(cupoItem.getMontoCupoCredito())
                        .setMontoUtilizado(cupoItem.getMontoUtilizado())
                        .setNumeroCliente(cupoItem.getNumeroCliente())
                        .setNumeroCupo(cupoItem.getNumeroCupo())
                        .setSaldoDisponible(cupoItem.getSaldoDisponible()).build());
            }
            ResponseCupoRotativo response = ResponseCupoRotativo.newBuilder().addAllObj(cupoListResponse).build();
            LOG.info("Finaliza consulta cupo rotativo por GRPC");

            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarHistorialContacto(NumeroCliente request, StreamObserver<ResponseHistorialContacto> responseObs) {

        LOG.info("Inicia consultarHistorialContacto por GRPC");
        try {

            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            ConsultarHistorialContactoOutput consultaList = clienteFICService.consultarHistorialContacto(1,1000,request.getNumeroCliente());

            List<com.mibanco.clientefic.es.ContactoType> contactoListResponse = new ArrayList<>();
            for (ContactoEntity item : consultaList.getContacto()) {
                contactoListResponse.add(com.mibanco.clientefic.es.ContactoType.newBuilder()
                        .setFecha(item.getFecha().toString())
                        .setTipoContacto(item.getTipoContacto())
                        .setResultadoComentarios(item.getResultadoComentarios())
                        .setNumeroCliente(item.getNumeroCliente())
                        .build());
            }
            ResponseHistorialContacto response = ResponseHistorialContacto.newBuilder().addAllObj(contactoListResponse).build();

            LOG.info("Finaliza consultarHistorialContacto por GRPC");
            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);
        } catch (Exception e) {

            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarOferta(NumeroCliente request, StreamObserver<ResponseOferta> responseObs) {

        LOG.info("Inicia consultarOferta por GRPC");
        try {

            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            OfertasOutput consultaList = clienteFICService.consultarOferta(1, 1000, request.getNumeroCliente());

            List<com.mibanco.clientefic.es.OfertaType> ofertaListResponse = new ArrayList<>();
            for (OfertaEntity oferta : consultaList.getClientes()) {
                ofertaListResponse.add(com.mibanco.clientefic.es.OfertaType.newBuilder()
                        .setNumeroOferta(oferta.getNumeroOferta())
                        .setTipoLead(oferta.getTipoLead())
                        .setTipoOferta(oferta.getTipoOferta())
                        .setMonto(oferta.getMonto())
                        .setPlazo(oferta.getPlazo())
                        .setNumeroCliente(oferta.getNumeroCliente())
                        .setTipoDeLiga(oferta.getTipoDeLiga())
                        .setCondicionGarantia(oferta.getCondicionGarantia())
                        .build());
            }
            ResponseOferta response = ResponseOferta.newBuilder().addAllObj(ofertaListResponse).build();

            LOG.info("Finaliza consultarOferta por GRPC");
            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);
        } catch (Exception e) {

            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarPasivo(NumeroCliente request, StreamObserver<ResponsePasivo> responseObs) {

        LOG.info("Inicia consultarPasivo por GRPC");
        try {

            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            ConsultarPasivoOutput consultaList = clienteFICService.consultarPasivo(1,1000,request.getNumeroCliente());

            List<com.mibanco.clientefic.es.PasivoType> pasivoListResponse = new ArrayList<>();
            for (PasivoEntity pasivo : consultaList.getPasivo()) {
                pasivoListResponse.add(com.mibanco.clientefic.es.PasivoType.newBuilder()
                        .setNumeroProducto(pasivo.getNumeroProducto())
                        .setTipoProducto(pasivo.getTipoProducto().toString())
                        .setDetalleProducto(pasivo.getDetalleProducto())
                        .setEstadoPasivo(pasivo.getEstadoPasivo())
                        .setFechaApertura(pasivo.getFechaApertura().toString())
                        .setFechaCierre(pasivo.getFechaCierre().toString())
                        .setCapital(pasivo.getCapital())
                        .setOtros(pasivo.getOtros()) //falta intereses a espera de model
                        .setSaldoTotal(pasivo.getSaldoTotal())
                        .setNumeroCliente(pasivo.getNumeroCliente())
                        .build());
            }
            ResponsePasivo response = ResponsePasivo.newBuilder().addAllObj(pasivoListResponse).build();

            LOG.info("Finaliza consultarPasivo por GRPC");
            responseObs.onNext(response);
            responseObs.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);
        } catch (Exception e) {

            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    private StatusException responseExceptionGrpc(Status statusCode, String exceptionMessage) {
        LOG.error("Exception: " + exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        return statusCode.asException(metadata);
    }


}
