package com.mibanco.clientefic.es.gen.contract;

import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
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
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-02-22T09:33:21.194046200-05:00[America/Bogota]")
public interface V1ClienteFIC {

    @GET
    @Path("/alerta/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultarAlerta(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") String numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/central-riesgo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCentralRiesgo(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/nombre/{regex}")
    @Produces({ "application/json" })
    Response consultarClienteFICPorNombre(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("regex") String regex);

    @GET
    @Path("/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
    @Produces({ "application/json" })
    Response consultarClientePorIdentificacion(@HeaderParam("jwt") @NotNull   String jwt,@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") String numeroDocumento,@PathParam("digitoVerificacion") Integer digitoVerificacion);

    @GET
    @Path("/conyuge/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarConyuge(@HeaderParam("jwt") @NotNull   String jwt,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/cupo-rotativo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarCupoRotativo(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/historial-contacto/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarHistorialContacto(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/oferta/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarOferta(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/pqr/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarPQR(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);

    @GET
    @Path("/pasivo/{numeroCliente}")
    @Produces({ "application/json" })
    Response consultarPasivo(@HeaderParam("jwt") @NotNull   String jwt,@QueryParam("page") @NotNull @Min(1) @Max(10000) @DefaultValue("1")   Integer page,@QueryParam("pageSize") @NotNull @Min(1) @Max(10000) @DefaultValue("20")   Integer pageSize,@PathParam("numeroCliente") Integer numeroCliente);
}
