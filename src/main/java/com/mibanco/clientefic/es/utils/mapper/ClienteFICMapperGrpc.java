package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.CrearClienteFICGrpc;
import com.mibanco.clientefic.es.Parameter;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteFICMapperGrpc {

    public ClienteFICEntity clienteGrpcToEntity(CrearClienteFICGrpc grpc) {
        return new ModelMapper().map(grpc, ClienteFICEntity.class);
    }

    public CrearClienteFICGrpc clienteGrpcToGrpc(ClienteFICType type) {
        return new ModelMapper().map(type, CrearClienteFICGrpc.class);
    }

//
//    public ClienteFICEntity cNovedadGrpcToEntity(CrearClienteFICGrpc grpc){
//        return new ModelMapper().map(grpc, ClienteFICEntity.class);
//    }


}
