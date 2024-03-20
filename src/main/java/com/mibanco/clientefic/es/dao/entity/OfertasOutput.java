package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@RegisterForReflection(targets = OfertaEntity.class)
public class OfertasOutput {

    private Integer totalClientes;
    private List<OfertaEntity> clientes;
}
