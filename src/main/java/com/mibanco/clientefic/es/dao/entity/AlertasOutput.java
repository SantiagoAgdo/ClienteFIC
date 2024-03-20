package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@RegisterForReflection(targets = AlertaEntity.class)
public class AlertasOutput {

    private Integer totalClientes;
    private List<AlertaEntity> clientes;
}
