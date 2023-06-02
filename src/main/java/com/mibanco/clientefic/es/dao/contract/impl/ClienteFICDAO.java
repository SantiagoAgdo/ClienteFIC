package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDao;
import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteFICDAO implements IClienteFICDao {

    List<ClienteFICEntity> list = new ArrayList<>();

    @Override
    public void crearClienteFIC(ClienteFICEntity clienteFIC) {
        list.add(clienteFIC);
    }

    @Override
    public List<ClienteFICEntity> getClienteFIC() {
        return null;
    }
}
