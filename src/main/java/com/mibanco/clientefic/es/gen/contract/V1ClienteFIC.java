package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.AlertaType;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import com.mibanco.clientefic.es.gen.type.ConsultarClientePorNombreOutput;
import com.mibanco.clientefic.es.gen.type.ContactoType;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.CupoRotativoType;
import com.mibanco.clientefic.es.gen.type.Error;
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
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-12-12T10:23:40.602639800-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @GET
    @Path("/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultaClientePorIdentificacion(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") Integer numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/alerta/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultarAlerta(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") Integer numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/central-riesgo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCentralDeRiesgo(@QueryParam("page") @NotNull @Min(1) @Max(100) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(100) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/nombre/{regex}")
    @Produces({ "application/json" })
    Response consultarClienteFICPorNombre(@QueryParam("page") @NotNull @Min(1) @Max(100) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(100) @DefaultValue("20")   Integer pageSize,@PathParam("regex") String regex);

    @GET
    @Path("/conyuge/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarConyuge(@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/cupo-rotativo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCupoRotativo(@QueryParam("page") @NotNull @Min(1) @Max(100) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(100) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/historial-contacto/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarHistorialContacto(@QueryParam("page") @NotNull @Min(1) @Max(100) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(100) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/oferta/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarOferta(@QueryParam("page") @NotNull @Min(1) @Max(100) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(100) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/pqr/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultarPQR(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") Integer numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/pasivo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarPasivo(@PathParam("numeroCliente") Integer numeroCliente);

    @POST
    @Path("/usuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearUsuarioClienteFic(@Valid ClienteFICType clienteFICType);
}
