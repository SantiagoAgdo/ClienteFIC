package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.dao.entity.CentralRiesgoEntity;
import com.mibanco.clientefic.es.gen.type.CentralRiesgoType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class CentralRiesgoMapper {

    public CentralRiesgoType centralToType(CentralRiesgoEntity centralRiesgo){
        return new ModelMapper().map(centralRiesgo, CentralRiesgoType.class);
    }
}
