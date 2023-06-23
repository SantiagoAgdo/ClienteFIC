package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ContactoType;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.CupoRotativoType;
import com.mibanco.clientefic.es.gen.type.OfertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.gen.type.PasivoType;
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

import static com.mibanco.clientefic.es.BarrioEnum.SINDATA;
import static com.mibanco.clientefic.es.CiudadEnum._05001;
import static com.mibanco.clientefic.es.DepartamentoEnum._12;
import static com.mibanco.clientefic.es.SubProductoEnum.REMA_AAFC_APORTES_AFC_CENTRALIZADO;
import static com.mibanco.clientefic.es.TipoDireccionEnum.EMPR_EMPRESA;
import static com.mibanco.clientefic.es.TipoDocumentoEnum.CC;
import static com.mibanco.clientefic.es.TipoProductoEnum.BONO_BONOS_;
import static com.mibanco.clientefic.es.TipoRelacionEnum.TITULAR;
import static com.mibanco.clientefic.es.TipoReporteXmlEnum.CONSULTA_DETALLADA;
import static com.mibanco.clientefic.es.TipoViviendaEnum.PROPIO_SIN_HIPOTECA;

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

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarAlerta(ConsultaClienteByData request, StreamObserver<ResponseAlerta> responseObs) {

        LOG.info("Inicia consulta alerta por GRPC");
        try {

            clienteFICValidator.validaConsulta(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
            List<AlertaType> alertaListType = clienteFICService.getListaAlertas(entity);

            List<com.mibanco.clientefic.es.AlertaType> alertaResponse = new ArrayList<>();
            for (AlertaType alert : alertaListType) {
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

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {

            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarCentralDeRiesgo(ConsultaClienteByData request, StreamObserver<ResponseCentralDeRiesgo> responseObs) {

        LOG.info("Inicia consulta central Riesgo por GRPC");
        try {
            clienteFICValidator.validaConsulta(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
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

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    @Override
    @Blocking
    public void consultarPQR(ConsultaClienteByData request, StreamObserver<ResponsePQR> responseObs) {
        LOG.info("Inicia consulta PQR por GRPC");
        try {
            clienteFICValidator.validaConsulta(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
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

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObs.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObs.onError(statusException);
        }
    }

    //    @Override
//    @Blocking
//    public void consutaClientePorIdentificacion(ConsultaClienteByData request, StreamObserver<ResponseCliente> responseObs) {
//
//        LOG.info("Inicia consulta cliente por identificacion GRPC");
//        try {
//
//            clienteFICValidator.validaConsulta(request.getTipoDocumento(), request.getNumeroDocumento(), request.getDigitoVerificacion());
//            com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData entity = mapper.dataGrpcToEntity(request);
//            ClienteFICEntity cliente = clienteFICService.getClienteByIdentificacion(entity);
//
//
//            CrearClienteFICGrpc clienteFICTypeToGRPC = mapper.pars(cliente);
//            ResponseCliente clienteResponse = ResponseCliente.newBuilder().setCliente(clienteFICTypeToGRPC. ) .build();
//
//            LOG.info("Finaliza consulta cliente por identificacion GRPC");
//
//            responseObs.onNext(clienteResponse);
//            responseObs.onCompleted();
//
//        } catch (ApplicationExceptionValidation e) {
//
//            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
//            responseObs.onError(statusException);
//
//        } catch (Exception e) {
//
//            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
//            responseObs.onError(statusException);
//        }
//    }
    @Override
    @Blocking
    public void consultarConyuge(NumeroCliente request, StreamObserver<ResponseConyuge> responseObs) {
        LOG.info("Inicia consulta conyuge por GRPC");
        try {
            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            ConyugeType conyuge = clienteFICService.getConyuge(request.getNumeroCliente());

            ResponseConyuge response = ResponseConyuge.newBuilder().setObj(
                    ResponseConyuge.newBuilder().getObj().toBuilder()
                            .setTipoDocumento(CC)
                            .setNumeroCliente(conyuge.getNumeroCliente())
                            .setNumeroDocumento(conyuge.getNumeroDocumento())
                            .setPrimerNombre(conyuge.getPrimerNombre())
                            .setSegundoNombre(conyuge.getSegundoNombre())
                            .setSegundoApellido(conyuge.getSegundoApellido())
                            .setPrimerApellido(conyuge.getPrimerApellido())

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
            List<CupoRotativoType> cupoList = clienteFICService.getCupoRotativo(request.getNumeroCliente());

            List<com.mibanco.clientefic.es.CupoRotativoType> cupoListResponse = new ArrayList<>();
            for (CupoRotativoType cupoItem : cupoList) {
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
    public void consultarDireccionTelefono(NumeroCliente request, StreamObserver<ResponseDirrecionTelefono> responseObs) {
        LOG.info("Inicia consultarDireccionTelefono por GRPC");
        try {
            clienteFICValidator.validarNumeroCliente(request.getNumeroCliente());
            List<ConsultarDireccionTelefonoType> consultaList = clienteFICService.getDirrecionTelefono(request.getNumeroCliente());

            List<com.mibanco.clientefic.es.DirrecionTelefonoType> consultaListResponse = new ArrayList<>();
            for (ConsultarDireccionTelefonoType item : consultaList) {
                consultaListResponse.add(com.mibanco.clientefic.es.DirrecionTelefonoType.newBuilder()
                        .setDireccion(item.getDireccion())
                        .setTelefono1(item.getTelefono1())
                        .setTelefono2(item.getTelefono2())
                        .setTipoDireccion(EMPR_EMPRESA)
                        .setTipoLocal(PROPIO_SIN_HIPOTECA)
                        .setTipoVivienda(PROPIO_SIN_HIPOTECA)
                        .setCodigoBarrio(SINDATA)
                        .setCodigoDepartamento(_12)
                        .setCodigoMunicipio(_05001)
                        .build());
            }
            ResponseDirrecionTelefono response = ResponseDirrecionTelefono.newBuilder().addAllObj(consultaListResponse).build();
            LOG.info("Finaliza consultarDireccionTelefono por GRPC");

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
            List<ContactoType> consultaList = clienteFICService.getContacto(request.getNumeroCliente());

            List<com.mibanco.clientefic.es.ContactoType> contactoListResponse = new ArrayList<>();
            for (ContactoType item : consultaList) {
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
            List<OfertaType> consultaList = clienteFICService.getOferta(request.getNumeroCliente());

            List<com.mibanco.clientefic.es.OfertaType> ofertaListResponse = new ArrayList<>();
            for (OfertaType oferta : consultaList) {
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
            List<PasivoType> consultaList = clienteFICService.getPasivo(request.getNumeroCliente());

            List<com.mibanco.clientefic.es.PasivoType> ofertaListResponse = new ArrayList<>();
            for (PasivoType pasivo : consultaList) {
                ofertaListResponse.add(com.mibanco.clientefic.es.PasivoType.newBuilder()
                        .setNumeroProducto(pasivo.getNumeroProducto())
                        .setTipoProducto(BONO_BONOS_)
                        .setSubProducto(REMA_AAFC_APORTES_AFC_CENTRALIZADO)
                        .setEstadoPasivo(pasivo.getEstadoPasivo())
                        .setFechaApertura(pasivo.getFechaApertura().toString())
                        .setFechaCierre(pasivo.getFechaCierre().toString())
                        .setCapital(pasivo.getCapital())
                        .setIntereses(pasivo.getIntereses())
                        .setOtros(pasivo.getOtros())
                        .setSaldoTotal(pasivo.getSaldoTotal())
                        .setNumeroCliente(pasivo.getNumeroCliente())
                        .build());
            }
            ResponsePasivo response = ResponsePasivo.newBuilder().addAllObj(ofertaListResponse).build();

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

        LOG.error(exceptionMessage + "Exception: " + exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        return statusCode.asException(metadata);
    }

}
