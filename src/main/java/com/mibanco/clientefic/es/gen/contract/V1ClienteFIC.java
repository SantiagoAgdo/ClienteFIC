package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.ConsultarClientePorNombreOutput;
import com.mibanco.clientefic.es.gen.type.ContactoType;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.CupoRotativoType;
import com.mibanco.clientefic.es.gen.type.Error;

import java.util.List;

import com.mibanco.clientefic.es.gen.type.OfertaType;
import com.mibanco.clientefic.es.gen.type.PQRType;
import com.mibanco.clientefic.es.gen.type.PasivoType;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es/cliente-fic")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-25T12:59:46.564774-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @GET
    @Path("/alerta/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultarAlerta(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") Integer numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/central-riesgo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCentralDeRiesgo(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/nombre/{nombre}/{apellido}/{razonSocial}")
    @Produces({ "application/json" })
    Response consultarClienteFICPorNombre(@PathParam("nombre") String nombre,@PathParam("apellido") String apellido,@PathParam("razonSocial") String razonSocial);

    @GET
    @Path("/conyuge/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarConyuge(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/cupo-rotativo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCupoRotativo(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/historial-contacto/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarHistorialContacto(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/oferta/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarOferta(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/pqr/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({"application/json"})
    Response consultarPQR(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento, @PathParam("numeroDocumento") Integer numeroDocumento, @PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/pasivo/{numeroCliente}")
    @Produces({"application/json"})
    Response consultarPasivo(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/testProcedure")
    @Produces({"application/json"})
    Response consultarProcediemitnoAlmacenado();

    @GET
    @Path("/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({"application/json"})
    Response consutaClientePorIdentificacion(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento, @PathParam("numeroDocumento") Integer numeroDocumento, @PathParam("digitoVerificacion") Integer digitoVerificacion);

    @POST
    @Path("/usuario")
    @Consumes({"application/json"})
    Response crearClienteFIC(@Valid ClienteFICType clienteFICType);
}
