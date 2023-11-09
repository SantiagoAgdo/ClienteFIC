package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.dao.contract.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
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

        LOG.info("Inicia Creación de cliente FIC en ClienteFICServiceImpl");
        ClienteFICType clienteMapper = clienteFICMapper.clienteFICToType(clienteFIC);
        clienteFICDAO.crearClienteFIC(clienteFIC);

        LOG.info("Termina creación de cliente FIC en ClienteFICServiceImpl");
        return clienteMapper;
    }

    @Override
    public List<AlertaType> obtenerListaAlertas(ConsultaClienteByData data) throws ApplicationException {

        LOG.info("Inicia consulta de Alertas");
        List<AlertaEntity> listAlertasResponse = clienteFICDAO.obtenerListaAlertas(data);

        LOG.info("Termina consulta de Alertas");
        return listAlertasResponse.stream().map(clienteFICMapper::alertaToType).collect(Collectors.toList());
    }

    @Override
    public List<CentralRiesgoType> obtenerListaCentralRiesgo(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        List<CentralRiesgoEntity> listCentralRiesgoResponse = clienteFICDAO.obtenerListaCentralRiesgo(numeroCliente);

        LOG.info("Termina consulta de cliente por identificación");
        return listCentralRiesgoResponse.stream().map(clienteFICMapper::centralRiesgoFICToType).collect(Collectors.toList());
    }

    @Override
    public ClienteFICDTO obtenerClienteByIdentificacion(ConsultaClienteByData dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        ClienteFICDTO rptClienteByIdentificacion = clienteFICDAO.obtenerClienteByIdentificacion(dataCliente);

        LOG.info("Termina consulta de cliente por identificación");
        return rptClienteByIdentificacion;
    }

    @Override
    public ConsultarClientePorNombreOutputEntity obtenerClienteByNombre(String nombre, int pagina, int tamanoPagina) throws ApplicationException {

        LOG.info("Inicia consulta Cliente por nombre");
        return clienteFICDAO.obtenerClienteByNombre(nombre, pagina, tamanoPagina);
    }

    @Override
    public ConyugeType obtenerConyuge(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de conyuge");
        ConyugeType rptConyuge = clienteFICDAO.obtenerConyuge(numeroCliente);

        LOG.info("Termina consulta de conyuge");
        return rptConyuge;
    }

    @Override
    public List<CupoRotativoType> obtenerCupoRotativo(Integer numeroCliente) {

        LOG.info("Inicia consulta de cupo rotativo");
        List<CupoRotativoEntity> listCupoRotativo = clienteFICDAO.obtenerCupoRotativo(numeroCliente);

        LOG.info("Termina consulta de cupo rotativo");
        return listCupoRotativo.stream().map(clienteFICMapper::cupoRotativoFICToType).collect(Collectors.toList());
    }

    @Override
    public List<ContactoType> obtenerContacto(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Historial Contacto");
        List<ContactoEntity> listContacto = clienteFICDAO.obtenerContacto(numeroCliente);

        LOG.info("Termina consulta de Historial Contacto");
        return listContacto.stream().map(clienteFICMapper::contactoToType).collect(Collectors.toList());
    }

    @Override
    public List<OfertaType> obtenerOferta(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Oferta");
        List<OfertaEntity> listOferta = clienteFICDAO.obtenerOferta(numeroCliente);

        LOG.info("Termina consulta de Oferta");
        return listOferta.stream().map(clienteFICMapper::ofertaToType).collect(Collectors.toList());
    }

    @Override
    public List<PasivoType> obtenerPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        List<PasivoEntity> listPasivoResponse = clienteFICDAO.obtenerPasivo(numeroCliente);

        LOG.info("Termina consulta Pasivo");
        return listPasivoResponse.stream().map(clienteFICMapper::pasivoToType).collect(Collectors.toList());
    }

    @Override
    public List<PQRType> obtenerPQR(ConsultaClienteByData dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de PQR");
        List<PQREntity> listPqrResponse = clienteFICDAO.obtenerPQR(dataCliente);

        LOG.info("Termina consulta de PQR");
        return listPqrResponse.stream().map(clienteFICMapper::pqrToType).collect(Collectors.toList());
    }
}
