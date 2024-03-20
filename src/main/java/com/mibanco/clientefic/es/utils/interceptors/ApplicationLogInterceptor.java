package com.mibanco.clientefic.es.utils.interceptors;

import com.mibanco.clientefic.es.LogRendimientoTypeGrpc;
import com.mibanco.clientefic.es.RegistrarLogGrpc;
import com.mibanco.clientefic.es.dto.LogAuditoriaDTO;
import com.mibanco.clientefic.es.dto.LogRendimientoDTO;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapperGrpc;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Provider
@Priority(1)
@RegisterForReflection(targets = {LogRendimientoTypeGrpc.class, RegistrarLogGrpc.class})
public class ApplicationLogInterceptor implements ContainerRequestFilter, ContainerResponseFilter {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ApplicationLogInterceptor.class);

    @GrpcClient("registrarlog")
    jakarta.inject.Provider<RegistrarLogGrpc.RegistrarLogBlockingStub> registrarLog;

    @Inject
    ClienteFICMapperGrpc mapper;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        try {
            LogRendimientoDTO logRendimiento = createLogRendimiento(requestContext);
            requestContext.setProperty("logRendimiento", logRendimiento);
            LogAuditoriaDTO logAuditoria = createLogAuditoria(requestContext);
            requestContext.setProperty("logAuditoria", logAuditoria);
            invokeAuditoriaLog(logAuditoria);
        } catch (Exception e) {
            LOG.error("Error al registrar logs en el filterContainer: {}", e.getMessage());
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        try {
            LogRendimientoDTO logRendimiento = (LogRendimientoDTO) requestContext.getProperty("logRendimiento");
            updateLogRendimiento(logRendimiento);

            LogAuditoriaDTO logAuditoria = (LogAuditoriaDTO) requestContext.getProperty("logAuditoria");
            updateLogAuditoria(logAuditoria, responseContext);

            invokeRendimientoLog(logRendimiento);
            invokeAuditoriaLog(logAuditoria);
        } catch (Exception e) {
            LOG.error("Error al registrar logs en el filterContainer: {}", e.getMessage());
        }
    }

    private LogRendimientoDTO createLogRendimiento(ContainerRequestContext requestContext) {
        LogRendimientoDTO logRendimiento = new LogRendimientoDTO();
        logRendimiento.setCorrelationId(generateCorrelationId());
        logRendimiento.setRecurso(requestContext.getUriInfo().getRequestUri().toString());
        logRendimiento.setHoraFechaInicio(new Date());
        return logRendimiento;
    }

    private LogAuditoriaDTO createLogAuditoria(ContainerRequestContext requestContext) {
        String direccionIP = requestContext.getHeaderString("ip");
        Date currentDate = new Date();

        LogAuditoriaDTO logAuditoria = new LogAuditoriaDTO();
        logAuditoria.setCorrelationId(generateCorrelationId());
        logAuditoria.setDireccionIP(direccionIP);
        logAuditoria.setRecurso(requestContext.getUriInfo().getRequestUri().toString());
        logAuditoria.setFecha(currentDate);
        logAuditoria.setAccion(requestContext.getMethod());
        logAuditoria.setHora(new SimpleDateFormat("HH:mm:ss").format(currentDate));

        return logAuditoria;
    }

    private void updateLogRendimiento(LogRendimientoDTO logRendimiento) {
        logRendimiento.setHoraFechaFin(new Date());
        logRendimiento.setDuracionTotal((int) (logRendimiento.getHoraFechaFin().getTime() - logRendimiento.getHoraFechaInicio().getTime()));
    }

    private void updateLogAuditoria(LogAuditoriaDTO logAuditoria, ContainerResponseContext responseContext) {
        Date currentDate = new Date();
        logAuditoria.setFecha(currentDate);
        logAuditoria.setHora(new SimpleDateFormat("HH:mm:ss").format(currentDate));
        logAuditoria.setResultadoAccion(responseContext.getStatus() == 200 ? "Exito" : "No Exitoso - Error");
    }

    private void invokeRendimientoLog(LogRendimientoDTO logRendimiento) {
        registrarLog.get().registrarLogRendimiento(mapper.logRendimientoDTOToGrpc(logRendimiento));
    }

    private void invokeAuditoriaLog(LogAuditoriaDTO logAuditoria) {
        registrarLog.get().registrarLogAuditoria(mapper.logAuditoriaDTOToGrpc(logAuditoria));
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
