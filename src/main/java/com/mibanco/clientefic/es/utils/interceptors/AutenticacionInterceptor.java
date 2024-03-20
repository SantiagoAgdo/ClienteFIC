package com.mibanco.clientefic.es.utils.interceptors;

import com.mibanco.clientefic.es.facade.IAutenticacionMS;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

@Provider
public class AutenticacionInterceptor implements ContainerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AutenticacionInterceptor.class);

    @RestClient
    jakarta.inject.Provider<IAutenticacionMS> autenticacion;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String jwt = requestContext.getHeaderString("jwt");
        String resourceRequest = obtenerRutaBase(requestContext.getUriInfo().getPath());
        String clientAction = requestContext.getMethod();

        try (Response response = autenticacion.get().verificarAcceso(jwt, resourceRequest, clientAction)) {
            if (response.getStatus() == 200) {
                log.info("Autenticación exitosa para jwt={}, resource={}, action={}", jwt, resourceRequest, clientAction);
            }
        } catch (WebApplicationException e) {
            handleAuthenticationException(requestContext, e);
        }
    }

    public static String obtenerRutaBase(String input) {
        Path path = Paths.get(input);
        int elements = Math.min(path.getNameCount(), 3);
        Path subPath = path.subpath(0, elements);
        return subPath.toString().replace('\\', '/');
    }

    private void handleAuthenticationException(ContainerRequestContext requestContext, WebApplicationException e) {
        log.error("Autenticacion fallida: error={}", e.getMessage());
        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity("No estás autorizado. Inicia sesión.").build());
    }
}