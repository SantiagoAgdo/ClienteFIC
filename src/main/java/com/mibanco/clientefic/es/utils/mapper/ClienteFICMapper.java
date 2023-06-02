package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteFICMapper {

    public ClienteFICType clienteFICToType(ClienteFICEntity novedadesEntity){
        return new ModelMapper().map(novedadesEntity, ClienteFICType.class);
    }

    public ClienteFICEntity clienteFICToEntity(ClienteFICType novedadCDTDigitalType){
        return new ModelMapper().map(novedadCDTDigitalType, ClienteFICEntity.class);
    }
}
