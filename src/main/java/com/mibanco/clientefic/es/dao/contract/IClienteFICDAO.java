package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.ConyugeType;

import java.util.List;

public interface IClienteFICDAO {

    void crearUsuarioClienteFic(ClienteFICEntity clienteFIC);

    List<AlertaEntity> consultarAlerta(ConsultaClienteEntity data);

    List<CentralRiesgoEntity> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente);

    ClienteFICDTO consultarClientePorIdentificacion(ConsultaClienteEntity data);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeEntity consultarConyuge(Integer numeroCliente);

    List<CupoRotativoEntity> consultarCupoRotativo(Integer page, Integer pageSize, Integer numeroCliente);

    List<ContactoEntity> consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<OfertaEntity> consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente);

    List<PasivoEntity> consultarPasivo(Integer numeroCliente);

    List<PQREntity> consultarPQR(ConsultaClienteEntity numeroCliente);

}
