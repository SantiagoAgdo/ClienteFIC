package com.mibanco.clientefic.es.dao.contract;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.*;

import java.util.List;

public interface IClienteFICDao {

    void crearClienteFIC(ClienteFICEntity clienteFIC);

    List<AlertaEntity> getListaAlertas(ConsultaClienteByData data);

    List<CentralRiesgoEntity> getListaCentralRiesgo(Integer numeroCliente);

    ClienteFICDTO getClienteByIdentificacion(ConsultaClienteByData data);

    ConsultarClientePorNombreOutputEntity getClienteByNombre(String nombre, int pagina, int tamanoPagina);

    ConyugeType getConyuge(Integer numeroCliente);

    List<CupoRotativoEntity> getCupoRotativo(Integer numeroCliente);

    List<ContactoEntity> getContacto(Integer numeroCliente);

    List<OfertaEntity> getOferta(Integer numeroCliente);

    List<PasivoEntity> getPasivo(Integer numeroCliente);

    List<PQREntity> getPQR(ConsultaClienteByData numeroCliente);

}
