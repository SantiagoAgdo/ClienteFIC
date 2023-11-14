package com.mibanco.clientefic.es.utils.mapper;

import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.mibanco.clientefic.es.*;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByDataEntity;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.io.IOException;

@ApplicationScoped
public class ClienteFICMapperGrpc {

    private Gson obj = new Gson();

    public ClienteFICEntity clienteGrpcToEntity(CrearClienteFICGrpc grpc) {
        return new ModelMapper().map(grpc, ClienteFICEntity.class);
    }

    public ConsultaClienteByDataEntity dataGrpcToEntity(ConsultaClienteByData grpc) {
        return new ModelMapper().map(grpc, ConsultaClienteByDataEntity.class);
    }

    public AlertaType alertaToGrpc(com.mibanco.clientefic.es.gen.type.AlertaType alerta) throws IOException {
        AlertaType.Builder structBuilder = AlertaType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(alerta), structBuilder);
        return structBuilder.build();
    }

    public ConyugeType conyugeToGrpc(com.mibanco.clientefic.es.gen.type.ConyugeType conyugeType) throws IOException {
        ConyugeType.Builder structBuilder = ConyugeType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(conyugeType), structBuilder);
        return structBuilder.build();
    }

    public CrearClienteFICGrpc clienteToGrpc(com.mibanco.clientefic.es.gen.type.ClienteFICType clienteType) throws IOException {
        CrearClienteFICGrpc.Builder structBuilder = CrearClienteFICGrpc.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(clienteType), structBuilder);
        return structBuilder.build();
    }

    public OfertaType ofertaToGrpc(com.mibanco.clientefic.es.gen.type.OfertaType ofertaType) throws InvalidProtocolBufferException {
        OfertaType.Builder structBuilder = OfertaType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(ofertaType), structBuilder);
        return structBuilder.build();
    }

    public ContactoType contactoToGrpc(com.mibanco.clientefic.es.gen.type.ContactoType historialType) throws InvalidProtocolBufferException {
        ContactoType.Builder structBuilder = ContactoType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(historialType), structBuilder);
        return structBuilder.build();
    }

    public CupoRotativoType cupoRotativoToGrpc(com.mibanco.clientefic.es.gen.type.CupoRotativoType cupoType) throws InvalidProtocolBufferException {
        CupoRotativoType.Builder structBuilder = CupoRotativoType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(cupoType), structBuilder);
        return structBuilder.build();
    }

    public CentralRiesgoType centralToGrpc(com.mibanco.clientefic.es.gen.type.CentralRiesgoType centralType) throws InvalidProtocolBufferException {
        CentralRiesgoType.Builder structBuilder = CentralRiesgoType.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(centralType), structBuilder);
        return structBuilder.build();
    }
}
