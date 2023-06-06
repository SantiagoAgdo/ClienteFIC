package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.dao.entity.AlertaEntity;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.AlertaType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class AlertaMapper {

    public AlertaType alertaToType(AlertaEntity alertaEntity){
        return new ModelMapper().map(alertaEntity, AlertaType.class);
    }

}
