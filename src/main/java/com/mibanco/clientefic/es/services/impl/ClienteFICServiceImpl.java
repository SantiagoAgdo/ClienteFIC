package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.dao.contract.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.contract.ClienteFICService;
import com.mibanco.clientefic.es.utils.Exceptions.ClienteFICException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteFICServiceImpl implements ClienteFICService {

    public static final Logger LOG = LoggerFactory.getLogger(ClienteFICServiceImpl.class);


    @Inject
    ClienteFICDAO clienteFICDAO;

    @Inject
    ClienteFICMapper clienteFICMapper;

    @Override
    @Transactional
    public ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC) throws ClienteFICException {

        LOG.info("Inicia Creacion de cliente FIC en ClienteFICServiceImpl");
        ClienteFICType clienteMapper = clienteFICMapper.clienteFICToType(clienteFIC);
        clienteFICDAO.crearClienteFIC(clienteFIC);

        LOG.info("Termina creacion de cliente FIC en ClienteFICServiceImpl");
        return clienteMapper;

    }

    @Override
    public List<AlertaType> getListaAlertas(ConsultaClienteByData data) throws ClienteFICException {

        LOG.info("Inicia consulta de Alertas");
        List<AlertaEntity> list = clienteFICDAO.getListaAlertas(data);

        LOG.info("Termina consulta de Alertas");
        return list.stream().map(clienteFICMapper::alertaToType).collect(Collectors.toList());

    }

    @Override
    public List<CentralRiesgoType> getListaCentralRiesgo(ConsultaClienteByData data) throws ClienteFICException {

        LOG.info("Inicia consulta de cliente por identificacion");
        List<CentralRiesgoEntity> list = clienteFICDAO.getListaCentralRiesgo(data);

        LOG.info("Termina consulta de cliente por identificacion");
        return list.stream().map(clienteFICMapper::centralRiesgoFICToType).collect(Collectors.toList());

    }

    @Override
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData dataCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de cliente por identificacion");
        ClienteFICEntity rpt = clienteFICDAO.getClienteByIdentificacion(dataCliente);

        LOG.info("Termina consulta de cliente por identificacion");
        return rpt;

    }

    @Override
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(String nombre) throws ClienteFICException {

        LOG.info("Inicia consulta Cliente por nombre");
        ConsultarClientePorNombreOutputEntity rpt = clienteFICDAO.getClienteByNombre(nombre);

        LOG.info("Termina consulta Cliente por nombre");
        return rpt;
    }

    @Override
    public ConyugeType getConyuge(Integer numeroCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de conyuge");
        ConyugeType rpt = clienteFICDAO.getConyuge(numeroCliente);

        LOG.info("Termina consulta de conyuge");
        return rpt;
    }

    @Override
    public List<CupoRotativoType> getCupoRotativo(Integer numeroCliente) {

        LOG.info("Inicia consulta de cupo rotativo");
        List<CupoRotativoEntity> list = clienteFICDAO.getCupoRotativo(numeroCliente);

        LOG.info("Termina consulta de cupo rotativo");
        return list.stream().map(clienteFICMapper::cupoRotativoFICToType).collect(Collectors.toList());

    }

    @Override
    public List<ConsultarDireccionTelefonoType> getDirrecionTelefono(Integer numeroCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de Dirreccion Telefono");
        List<ConsultarDirrecionTelefonoEntity> list = clienteFICDAO.getDirrecionTelefono(numeroCliente);

        LOG.info("Termina consulta de Dirreccion Telefono");
        return list.stream().map(clienteFICMapper::consultaDirrecionTelelfonoToType).collect(Collectors.toList());

    }

    @Override
    public List<ContactoType> getContacto(Integer numeroCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de Historial Contacto");
        List<ContactoEntity> list = clienteFICDAO.getContacto(numeroCliente);

        LOG.info("Termina consulta de Historial Contacto");
        return list.stream().map(clienteFICMapper::contactoToType).collect(Collectors.toList());
    }

    @Override
    public List<OfertaType> getOferta(Integer numeroCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de Oferta");
        List<OfertaEntity> list = clienteFICDAO.getOferta(numeroCliente);

        LOG.info("Termina consulta de Oferta");
        return list.stream().map(clienteFICMapper::ofertaToType).collect(Collectors.toList());

    }

    @Override
    public List<PasivoType> getPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        List<PasivoEntity> list = clienteFICDAO.getPasivo(numeroCliente);

        LOG.info("Termina consulta Pasivo");
        return list.stream().map(clienteFICMapper::pasivoToType).collect(Collectors.toList());
    }

    @Override
    public List<PQRType> getPQR(ConsultaClienteByData dataCliente) throws ClienteFICException {

        LOG.info("Inicia consulta de PQR");
        List<PQREntity> list = clienteFICDAO.getPQR(dataCliente);

        LOG.info("Termina consulta de PRQ");
        return list.stream().map(clienteFICMapper::pqrToType).collect(Collectors.toList());
    }
}
