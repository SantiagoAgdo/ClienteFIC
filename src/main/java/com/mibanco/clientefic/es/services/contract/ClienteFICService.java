package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.gen.type.ClienteFICType;

public interface ClienteFICService {

    ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC);

}
