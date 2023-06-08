package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;

public interface ClientePorNombreService {


    ConsultarClientePorNombreOutputEntity cliente(String nombre);

}
