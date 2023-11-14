package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.ConyugeType;

import java.util.List;

public interface IClienteFICDao {

    void crearClienteFIC(ClienteFICEntity clienteFIC);

    List<AlertaEntity> obtenerListaAlertas(ConsultaClienteByDataEntity data);

    List<CentralRiesgoEntity> obtenerListaCentralRiesgo(Integer numeroCliente);

    ClienteFICDTO obtenerClienteIdentificacion(ConsultaClienteByDataEntity data);

    ConsultarClientePorNombreOutputEntity obtenerClienteNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeType obtenerConyuge(Integer numeroCliente);

    List<CupoRotativoEntity> obtenerCupoRotativo(Integer numeroCliente);

    List<ContactoEntity> obtenerContacto(Integer numeroCliente);

    List<OfertaEntity> obtenerOferta(Integer numeroCliente);

    List<PasivoEntity> obtenerPasivo(Integer numeroCliente);

    List<PQREntity> obtenerPQR(ConsultaClienteByDataEntity numeroCliente);

}
