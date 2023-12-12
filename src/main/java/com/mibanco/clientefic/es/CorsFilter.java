package com.mibanco.clientefic.es;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOG = LoggerFactory.getLogger(CorsFilter.class);
    @ConfigProperty(name = "allowedOriginPattern")
    String allowedOriginPattern;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        LOG.info("Inicia CorsFilter es-ClienteFIC");

        requestContext.getHeaders().add("Access-Control-Allow-Origin", allowedOriginPattern);
        requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, jwt");
        requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
        requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Content-Type", "application/json");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, jwt");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
        responseContext.getHeaders().add("X-Content-Type-Options", "nosniff");

        // Agregar cabeceras de seguridad adicionales
        responseContext.getHeaders().add("X-Frame-Options", "DENY");
        responseContext.getHeaders().add("X-XSS-Protection", "1");
        responseContext.getHeaders().add("Strict-Transport-Security", "max-age=31536000");
        responseContext.getHeaders().add("Referrer-Policy", "strict-origin-when-cross-origin");

        LOG.info("Termina CorsFilter es-ClienteFIC");
    }
}
