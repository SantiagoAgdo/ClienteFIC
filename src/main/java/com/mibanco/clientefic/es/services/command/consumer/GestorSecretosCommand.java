package com.mibanco.clientefic.es.services.command.consumer;

import com.mibanco.clientefic.es.Respuesta;
import com.mibanco.clientefic.es.SecretoTypeGrpc;
import com.mibanco.clientefic.es.SolicitarCredencialesGrpc;
import com.mibanco.clientefic.es.dao.entity.SecretoEntity;
import com.mibanco.clientefic.es.services.command.ICommand;
import com.mibanco.clientefic.es.services.command.IParam;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@RegisterForReflection(targets = {SecretoTypeGrpc.class, Respuesta.class})
public class GestorSecretosCommand implements ICommand {

    public static final Logger LOG = LoggerFactory.getLogger(GestorSecretosCommand.class);

    @ConfigProperty(name = "puertoQuarkus")
    Integer puertoQuarkus;

    @ConfigProperty(name = "hostQuarkus")
    String hostQuarkus;


    @Override
    public Object execute(IParam parametro) {
        LOG.info("Iniciando comando GestorSecretosCommand en ClienteFIC");
        if (!(parametro instanceof SecretoEntity)) {
            throw new IllegalArgumentException("El parámetro debe ser de tipo SecretoEntity");
        }

        SecretoEntity secreto = (SecretoEntity) parametro;

        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress(hostQuarkus, puertoQuarkus)
                    .usePlaintext()
                    .build();

            SolicitarCredencialesGrpc.SolicitarCredencialesBlockingStub stub = SolicitarCredencialesGrpc.newBlockingStub(channel);

            SecretoTypeGrpc request = SecretoTypeGrpc.newBuilder()
                    .setNombreBaul(secreto.getNombreBaul())
                    .setNombreSecreto(secreto.getNombreSecreto())
                    .build();

            Respuesta response = stub.solicitarCredenciales(request);

            LOG.info("Finaliza comando GestorSecretosCommand en ClienteFIC");
            return response;
        } catch (io.grpc.StatusRuntimeException e) {
            LOG.error("Error al enviar mensaje al Gestor de Secretos - Status: {}", e.getStatus().getCode());
            LOG.error("Descripción del error: {}", e.getStatus().getDescription());

            // Puedes agregar registros adicionales según tus necesidades
            LOG.error("Detalles adicionales del error", e);

            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "error inesperado al enviar mensaje al Gestor de Secretos en clienteFIC");
        } catch (Exception e) {
            LOG.error("Error inesperado al enviar mensaje al Gestor de Secretos", e);

            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "error inesperado al enviar mensaje al Gestor de Secretos en clienteFIC");
        }
        finally {
            assert channel != null;
            channel.shutdown();
        }
    }
}
