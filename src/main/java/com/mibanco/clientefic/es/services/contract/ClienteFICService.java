package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface ClienteFICService {

    ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC);

    ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData dataCliente);

    ConyugeType getConyuge(Integer numeroCliente);

    List<CupoRotativoType> getCupoRotativo(Integer numeroCliente);

    List<ConsultarDireccionTelefonoType> getDirrecionTelefono(Integer numeroCliente);

    List<ContactoType> getContacto(Integer numeroCliente);

    List<OfertaType> getOferta(Integer numeroCliente);

    List<PasivoType> getPasivo(Integer numeroCliente);

    List<PQRType> getPQR(ConsultaClienteByData numeroCliente);

}
