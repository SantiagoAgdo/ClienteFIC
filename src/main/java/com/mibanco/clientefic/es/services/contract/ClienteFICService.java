package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.ClienteFICEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultaClienteEntity;
import com.mibanco.clientefic.es.dao.entity.ConsultarClientePorNombreOutputEntity;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface ClienteFICService {

    ClienteFICType crearUsuarioClienteFic(ClienteFICEntity clienteFIC);

    List<AlertaType> consultarAlerta(ConsultaClienteEntity dataCliente);

    List<CentralRiesgoType> consultarCentralRiesgo(Integer numeroCliente);

    ClienteFICDTO consultarClientePorIdentificacion(ConsultaClienteEntity dataCliente);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeType consultarConyuge(Integer numeroCliente);

    List<CupoRotativoType> consultarCupoRotativo(Integer numeroCliente);

    List<ContactoType> consultarHistorialContacto(Integer numeroCliente);

    List<OfertaType> consultarOferta(Integer numeroCliente);

    List<PasivoType> consultarPasivo(Integer numeroCliente);

    List<PQRType> consultarPQR(ConsultaClienteEntity numeroCliente);

}
