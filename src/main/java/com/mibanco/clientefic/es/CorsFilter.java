package com.mibanco.clientefic.es;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @ConfigProperty(name = "allowedOriginPattern")
    String allowedOriginPattern;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        requestContext.getHeaders().add("Access-Control-Allow-Origin", allowedOriginPattern);
        requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD");
        requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        String originHeader = requestContext.getHeaderString("Origin");
        if (originHeader != null && originHeader.matches("(.*\\.mibanco\\.com\\.co)|(localhost)")) {
            responseContext.getHeaders().add("Access-Control-Allow-Origin", originHeader);
        }

        // Si es una petición OPTIONS, no retornar las cabeceras CORS
        if ("OPTIONS".equalsIgnoreCase(requestContext.getMethod())) {
            responseContext.setStatus(Response.Status.OK.getStatusCode());
            // Evitar que la petición OPTIONS continúe al siguiente filtro
            requestContext.abortWith(Response.ok().build());
        }
    }
}
