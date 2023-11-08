package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteByData;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface ClienteFICService {

    ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC);

    List<AlertaType> obtenerListaAlertas(ConsultaClienteByData dataCliente);

    List<CentralRiesgoType> obtenerListaCentralRiesgo(Integer numeroCliente);

    ClienteFICDTO obtenerClienteByIdentificacion(ConsultaClienteByData dataCliente);

    ConsultarClientePorNombreOutputEntity obtenerClienteByNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeType obtenerConyuge(Integer numeroCliente);

    List<CupoRotativoType> obtenerCupoRotativo(Integer numeroCliente);

    List<ContactoType> obtenerContacto(Integer numeroCliente);

    List<OfertaType> obtenerOferta(Integer numeroCliente);

    List<PasivoType> obtenerPasivo(Integer numeroCliente);

    List<PQRType> obtenerPQR(ConsultaClienteByData numeroCliente);

}
