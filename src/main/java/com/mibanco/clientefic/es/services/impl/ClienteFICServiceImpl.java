package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.dao.contract.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.contract.ClienteFICService;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
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
    public ClienteFICType crearClienteFICType(ClienteFICEntity clienteFIC) throws ApplicationException {

        LOG.info("Inicia Creacion de cliente FIC en ClienteFICServiceImpl");
        ClienteFICType clienteMapper = clienteFICMapper.clienteFICToType(clienteFIC);
        clienteFICDAO.crearClienteFIC(clienteFIC);

        LOG.info("Termina creacion de cliente FIC en ClienteFICServiceImpl");
        return clienteMapper;

    }

    @Override
    public List<AlertaType> getListaAlertas(ConsultaClienteByData data) throws ApplicationException {

        LOG.info("Inicia consulta de Alertas");
        List<AlertaEntity> listAlertasResponse = clienteFICDAO.getListaAlertas(data);

        LOG.info("Termina consulta de Alertas");
        return listAlertasResponse.stream().map(clienteFICMapper::alertaToType).collect(Collectors.toList());

    }

    @Override
    public List<CentralRiesgoType> getListaCentralRiesgo(ConsultaClienteByData data) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificacion");
        List<CentralRiesgoEntity> listCentralRiesgoResponse = clienteFICDAO.getListaCentralRiesgo(data);

        LOG.info("Termina consulta de cliente por identificacion");
        return listCentralRiesgoResponse.stream().map(clienteFICMapper::centralRiesgoFICToType).collect(Collectors.toList());

    }

    @Override
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificacion");
        ClienteFICEntity rptClienteByIdentificacion = clienteFICDAO.getClienteByIdentificacion(dataCliente);

        LOG.info("Termina consulta de cliente por identificacion");
        return rptClienteByIdentificacion;

    }

    @Override
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(String nombre) throws ApplicationException {

        LOG.info("Inicia consulta Cliente por nombre");
        ConsultarClientePorNombreOutputEntity clienteResponse = clienteFICDAO.getClienteByNombre(nombre);

        LOG.info("Termina consulta Cliente por nombre");
        return clienteResponse;
    }

    @Override
    public ConyugeType getConyuge(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de conyuge");
        ConyugeType rptConyuge = clienteFICDAO.getConyuge(numeroCliente);

        LOG.info("Termina consulta de conyuge");
        return rptConyuge;
    }

    @Override
    public List<CupoRotativoType> getCupoRotativo(Integer numeroCliente) {

        LOG.info("Inicia consulta de cupo rotativo");
        List<CupoRotativoEntity> listCupoRotativo = clienteFICDAO.getCupoRotativo(numeroCliente);

        LOG.info("Termina consulta de cupo rotativo");
        return listCupoRotativo.stream().map(clienteFICMapper::cupoRotativoFICToType).collect(Collectors.toList());

    }

    @Override
    public List<ConsultarDireccionTelefonoType> getDirrecionTelefono(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Dirreccion Telefono");
        List<ConsultarDirrecionTelefonoEntity> listDirrecionTelefonoByNumeroCliente = clienteFICDAO.getDirrecionTelefono(numeroCliente);

        LOG.info("Termina consulta de Dirreccion Telefono");
        return listDirrecionTelefonoByNumeroCliente.stream().map(clienteFICMapper::consultaDirrecionTelelfonoToType).collect(Collectors.toList());

    }

    @Override
    public List<ContactoType> getContacto(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Historial Contacto");
        List<ContactoEntity> listContacto = clienteFICDAO.getContacto(numeroCliente);

        LOG.info("Termina consulta de Historial Contacto");
        return listContacto.stream().map(clienteFICMapper::contactoToType).collect(Collectors.toList());
    }

    @Override
    public List<OfertaType> getOferta(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Oferta");
        List<OfertaEntity> listOferta = clienteFICDAO.getOferta(numeroCliente);

        LOG.info("Termina consulta de Oferta");
        return listOferta.stream().map(clienteFICMapper::ofertaToType).collect(Collectors.toList());

    }

    @Override
    public List<PasivoType> getPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        List<PasivoEntity> listPasivoResponse = clienteFICDAO.getPasivo(numeroCliente);

        LOG.info("Termina consulta Pasivo");
        return listPasivoResponse.stream().map(clienteFICMapper::pasivoToType).collect(Collectors.toList());
    }

    @Override
    public List<PQRType> getPQR(ConsultaClienteByData dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de PQR");
        List<PQREntity> listPqrResponse = clienteFICDAO.getPQR(dataCliente);

        LOG.info("Termina consulta de PRQ");
        return listPqrResponse.stream().map(clienteFICMapper::pqrToType).collect(Collectors.toList());
    }
}
