package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface ClienteFICService {

    ClienteFICType crearUsuarioClienteFic(ClienteFICEntity clienteFIC);

    List<AlertaType> consultarAlerta(ConsultaClienteEntity dataCliente);

    List<CentralRiesgoType> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente);

    ClienteBaseEntity consultarClientePorIdentificacion(ConsultaClienteEntity dataCliente);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeEntity consultarConyuge(Integer numeroCliente);

    List<CupoRotativoType> consultarCupoRotativo(Integer page, Integer pageSize, Integer numeroCliente);

    List<ContactoType> consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<OfertaType> consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<PasivoType> consultarPasivo(Integer numeroCliente);

    List<PQRType> consultarPQR(ConsultaClienteEntity numeroCliente);

}
