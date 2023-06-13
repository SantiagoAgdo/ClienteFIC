package com.mibanco.clientefic.es.grpc;

import com.mibanco.clientefic.es.ClienteFICServiceGrpcGrpc;
import com.mibanco.clientefic.es.CrearClienteFICGrpc;
import com.mibanco.clientefic.es.Parameter;
import com.mibanco.clientefic.es.constans.ErrorCts;
import com.mibanco.clientefic.es.controller.ClienteFICController;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.ResponseClienteFIC;
import com.mibanco.clientefic.es.services.impl.ClienteFICServiceImpl;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

        ClienteFICEntity entity = mapper.clienteGrpcToEntity(request);

        try {
            ClienteFICType type = clienteFICService.crearClienteFICType(entity);
            ResponseClienteFIC response = ResponseClienteFIC.newBuilder()
                    .setClienteFICRpt(mapper.clienteGrpcToGrpc(type)).build();

            responseObs.onNext(response);

            logger.info("Finaliza creacion Cliente FIC por GRPC");
            responseObs.onCompleted();
        } catch (ClienteFICException e) {
            logger.error(ErrorCts.SERVICIO + " Creacion Novedad Grpc");
            throw new ClienteFICException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ErrorCts.SERVICIO + " Creacion Novedad Grpc - Exception: " + e.getMessage());
        }
    }


}
