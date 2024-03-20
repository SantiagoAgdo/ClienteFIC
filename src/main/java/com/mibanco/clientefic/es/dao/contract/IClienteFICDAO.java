package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.*;

import java.util.List;

public interface IClienteFICDAO {

    AlertasOutput consultarAlerta(Integer page, Integer pageSize, ConsultaClienteEntity data);

    List<CentralRiesgoEntity> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente);

    ClienteFICEntity consultarClientePorIdentificacion(ConsultaClienteEntity data);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeEntity consultarConyuge(Integer numeroCliente);

    ConsultarCupoRotativoOutput consultarCupoRotativo(Integer page, Integer pageSize, Integer numeroCliente);

    ConsultarHistorialContactoOutput consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    OfertasOutput consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    ConsultarPasivoOutput consultarPasivo(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<PQREntity> consultarPQR(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

}
