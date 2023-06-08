package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultarClientePorNombreOutputEntity {

    private Integer totalClientes;
    private ConsultarClientePorNombreEntity clientes;

}
