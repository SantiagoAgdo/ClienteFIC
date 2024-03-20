package com.mibanco.clientefic.es.services.impl;

import com.mibanco.clientefic.es.dao.impl.ClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.services.contract.ClienteFICService;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    public AlertasOutput consultarAlerta(Integer page, Integer pageSize, ConsultaClienteEntity consultaClienteEntity) throws ApplicationException {

        LOG.info("Inicia consulta de Alertas");
        AlertasOutput listAlertasResponse = clienteFICDAO.consultarAlerta(page, pageSize, consultaClienteEntity);

        LOG.info("Termina consulta de Alertas");
        return listAlertasResponse;
    }

    @Override
    public List<CentralRiesgoType> consultarCentralRiesgo(Integer page, Integer pageSize, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        List<CentralRiesgoEntity> listCentralRiesgoResponse = clienteFICDAO.consultarCentralRiesgo( page,  pageSize,numeroCliente);

        LOG.info("Termina consulta de cliente por identificación");
        return listCentralRiesgoResponse.stream().map(clienteFICMapper::centralRiesgoFICToType).collect(Collectors.toList());
    }

    @Override
    public ClienteFICEntity consultarClientePorIdentificacion(ConsultaClienteEntity consultaClienteEntity) throws ApplicationException {

        LOG.info("Inicia consulta de cliente por identificación");
        ClienteFICEntity rptClienteByIdentificacion = clienteFICDAO.consultarClientePorIdentificacion(consultaClienteEntity);

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
    public ConsultarCupoRotativoOutput consultarCupoRotativo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        LOG.info("Inicia consulta de cupo rotativo");
        ConsultarCupoRotativoOutput listCupoRotativo = clienteFICDAO.consultarCupoRotativo(pagina, tamanoPagina,numeroCliente);

        LOG.info("Termina consulta de cupo rotativo");
        return listCupoRotativo;
    }

    @Override
    public ConsultarHistorialContactoOutput consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Historial Contacto");
        ConsultarHistorialContactoOutput listContacto = clienteFICDAO.consultarHistorialContacto(pagina, tamanoPagina,numeroCliente);

        LOG.info("Termina consulta de Historial Contacto");
        return listContacto;
    }

    @Override
    public OfertasOutput consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de Oferta");
        OfertasOutput listOferta = clienteFICDAO.consultarOferta(pagina, tamanoPagina, numeroCliente);

        LOG.info("Termina consulta de Oferta");
        return listOferta;
    }

    @Override
    public ConsultarPasivoOutput consultarPasivo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        LOG.info("Inicia consulta Pasivo");
        ConsultarPasivoOutput listPasivoResponse = clienteFICDAO.consultarPasivo(pagina, tamanoPagina, numeroCliente);

        LOG.info("Termina consulta Pasivo");
        return listPasivoResponse;
    }

    @Override
    public List<PQRType> consultarPQR(Integer pagina, Integer tamanoPagina, Integer numeroCliente) throws ApplicationException {

        LOG.info("Inicia consulta de PQR");
        List<PQREntity> listPqrResponse = clienteFICDAO.consultarPQR(pagina, tamanoPagina, numeroCliente);

        LOG.info("Termina consulta de PQR");
        return listPqrResponse.stream().map(clienteFICMapper::pqrToType).collect(Collectors.toList());
    }
}
