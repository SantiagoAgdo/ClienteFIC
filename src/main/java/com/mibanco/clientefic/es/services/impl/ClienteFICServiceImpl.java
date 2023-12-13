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
    public ClienteFICType crearUsuarioClienteFic(ClienteFICEntity clienteFIC) throws ApplicationException {

        LOG.info("Inicia Creación de cliente FIC en ClienteFICServiceImpl");
        ClienteFICType clienteMapper = clienteFICMapper.clienteFICToType(clienteFIC);
        clienteFICDAO.crearUsuarioClienteFic(clienteFIC);

        LOG.info("Termina creación de cliente FIC en ClienteFICServiceImpl");
        return clienteMapper;
    }

    @Override
    public List<AlertaType> consultarAlerta(ConsultaClienteEntity consultaClienteEntity) throws ApplicationException {

        LOG.info("Inicia consulta de Alertas");
        List<AlertaEntity> listAlertasResponse = clienteFICDAO.consultarAlerta(consultaClienteEntity);

        LOG.info("Termina consulta de Alertas");
        return listAlertasResponse.stream().map(clienteFICMapper::alertaToType).collect(Collectors.toList());
    }

    @Override
    public List<CentralRiesgoType> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        List<CentralRiesgoEntity> listCentralRiesgoResponse = clienteFICDAO.consultarCentralRiesgo( page,  pageSize,numeroCliente);

        LOG.info("Termina consulta de cliente por identificación");
        return listCentralRiesgoResponse.stream().map(clienteFICMapper::centralRiesgoFICToType).collect(Collectors.toList());
    }

    @Override
    public ClienteBaseEntity consultarClientePorIdentificacion(ConsultaClienteEntity dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        ClienteBaseEntity rptClienteByIdentificacion = clienteFICDAO.consultarClientePorIdentificacion(dataCliente);

        LOG.info("Termina consulta de cliente por identificación");
        return rptClienteByIdentificacion;
    }

    @Override
    public ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina) throws ApplicationException {

        LOG.info("Inicia consulta Cliente por nombre");
        return clienteFICDAO.consultarClienteFicPorNombre(nombre, pagina, tamanoPagina);
    }

    @Override
    public ConyugeEntity consultarConyuge(Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de conyuge");
        ConyugeEntity rptConyuge = clienteFICDAO.consultarConyuge(numeroCliente);

        LOG.info("Termina consulta de conyuge");
        return rptConyuge;
    }

    @Override
    public List<CupoRotativoType> consultarCupoRotativo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        LOG.info("Inicia consulta de cupo rotativo");
        List<CupoRotativoEntity> listCupoRotativo = clienteFICDAO.consultarCupoRotativo(pagina, tamanoPagina,numeroCliente);

        LOG.info("Termina consulta de cupo rotativo");
        return listCupoRotativo.stream().map(clienteFICMapper::cupoRotativoFICToType).collect(Collectors.toList());
    }

    @Override
    public List<ContactoType> consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Historial Contacto");
        List<ContactoEntity> listContacto = clienteFICDAO.consultarHistorialContacto(pagina, tamanoPagina,numeroCliente);

        LOG.info("Termina consulta de Historial Contacto");
        return listContacto.stream().map(clienteFICMapper::contactoToType).collect(Collectors.toList());
    }

    @Override
    public List<OfertaType> consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Oferta");
        List<OfertaEntity> listOferta = clienteFICDAO.consultarOferta(pagina, tamanoPagina, numeroCliente);

        LOG.info("Termina consulta de Oferta");
        return listOferta.stream().map(clienteFICMapper::ofertaToType).collect(Collectors.toList());
    }

    @Override
    public List<PasivoType> consultarPasivo(Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        List<PasivoEntity> listPasivoResponse = clienteFICDAO.consultarPasivo(numeroCliente);

        LOG.info("Termina consulta Pasivo");
        return listPasivoResponse.stream().map(clienteFICMapper::pasivoToType).collect(Collectors.toList());
    }

    @Override
    public List<PQRType> consultarPQR(ConsultaClienteEntity dataCliente) throws ApplicationException {

        LOG.info("Inicia consulta de PQR");
        List<PQREntity> listPqrResponse = clienteFICDAO.consultarPQR(dataCliente);

        LOG.info("Termina consulta de PQR");
        return listPqrResponse.stream().map(clienteFICMapper::pqrToType).collect(Collectors.toList());
    }
}
