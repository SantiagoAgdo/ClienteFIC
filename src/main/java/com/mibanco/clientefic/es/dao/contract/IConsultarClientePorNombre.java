package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.gen.type.ConsultarClientePorNombreOutput;

public interface IConsultarClientePorNombre {

    ConsultarClientePorNombreOutputEntity getCliente(String nombre);
}
