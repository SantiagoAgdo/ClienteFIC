package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IConsultarClientePorNombre;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsultarClientePorNombreDao implements IConsultarClientePorNombre {

    ConsultarClientePorNombreEntity cliente = new ConsultarClientePorNombreEntity(TipoDocumentoEnum.CC_CEDULA_DE_CIUDADAN_A, 100093213, "Pablo Emilio Escobar Gaviria");
    ConsultarClientePorNombreOutputEntity clienteOut = new ConsultarClientePorNombreOutputEntity(1, cliente);

    @Override
    public ConsultarClientePorNombreOutputEntity getCliente(String nombre) {
        if (nombre.equals(clienteOut.getClientes().getNombreCompleto())) {
            return clienteOut;
        }
        return null;
    }
}
