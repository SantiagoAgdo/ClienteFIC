package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.ConyugeType;

import java.util.List;

public interface IClienteFICDAO {

    void crearUsuarioClienteFic(ClienteFICEntity clienteFIC);

    List<AlertaEntity> consultarAlerta(ConsultaClienteEntity data);

    List<CentralRiesgoEntity> consultarCentralRiesgo(Integer numeroCliente);

    ClienteFICDTO consultarClientePorIdentificacion(ConsultaClienteEntity data);

    ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeType consultarConyuge(Integer numeroCliente);

    List<CupoRotativoEntity> consultarCupoRotativo(Integer numeroCliente);

    List<ContactoEntity> consultarHistorialContacto(Integer numeroCliente);

    List<OfertaEntity> consultarOferta(Integer numeroCliente);

    List<PasivoEntity> consultarPasivo(Integer numeroCliente);

    List<PQREntity> consultarPQR(ConsultaClienteEntity numeroCliente);

}
