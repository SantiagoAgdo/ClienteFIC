package com.mibanco.clientefic.es.services.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface ClienteFICService {


    AlertasOutput consultarAlerta(Integer page, Integer pageSize, ConsultaClienteEntity dataCliente);

    List<CentralRiesgoType> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente);

    ClienteFICEntity consultarClientePorIdentificacion(ConsultaClienteEntity dataCliente);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeEntity consultarConyuge(Integer numeroCliente);

    ConsultarCupoRotativoOutput consultarCupoRotativo(Integer page, Integer pageSize, Integer numeroCliente);

    ConsultarHistorialContactoOutput consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    OfertasOutput consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    ConsultarPasivoOutput consultarPasivo(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<PQRType> consultarPQR(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

}
