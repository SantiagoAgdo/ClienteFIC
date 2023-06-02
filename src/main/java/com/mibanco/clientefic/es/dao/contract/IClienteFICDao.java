package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;

import java.util.List;

public interface IClienteFICDao {

    void crearClienteFIC(ClienteFICEntity clienteFIC);

    List<ClienteFICEntity> getClienteFIC();

}
