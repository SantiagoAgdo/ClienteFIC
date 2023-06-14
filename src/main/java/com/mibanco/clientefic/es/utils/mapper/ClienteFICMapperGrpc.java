package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.CrearClienteFICGrpc;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteFICMapperGrpc {

    public ClienteFICEntity clienteGrpcToEntity(CrearClienteFICGrpc grpc) {
        return new ModelMapper().map(grpc, ClienteFICEntity.class);
    }

}
