package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDao;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.dto.ConsultaClientePorNombreDTO;
import com.mibanco.clientefic.es.gen.type.*;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteFICDAO implements IClienteFICDao {

    List<ClienteFICEntity> list = new ArrayList<>();

    @Inject
    ClienteFICMapper mapper;

    @Inject
    DataSource dataSource;

    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String url;
    @ConfigProperty(name = "quarkus.datasource.username")
    String user;
    @ConfigProperty(name = "quarkus.datasource.password")
    String pass;

    @Override
    public void crearClienteFIC(ClienteFICEntity clienteFIC) {
        list.add(clienteFIC);
    }

    @Override
    public List<AlertaEntity> obtenerListaAlertas(ConsultaClienteByData data) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento()).filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion())).toList();

        List<AlertaEntity> query = new ArrayList<>();

        if (cliente.size() != 0) {
            for (ClienteFICEntity cli : cliente) {
                AlertaEntity dataAlert = new AlertaEntity(cli.getAlerta().getTipoAlerta(), cli.getAlerta().getBanco(), cli.getAlerta().getFecha(), cli.getAlerta().getTipoDocumento(), cli.getAlerta().getNumeroDocumento(), cli.getAlerta().getDigitoVerificacion());
                query.add(dataAlert);
            }
        } else {
            return query;
        }

        return query;
    }

    @Override
    public List<CentralRiesgoEntity> obtenerListaCentralRiesgo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CentralRiesgoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CentralRiesgoEntity dataCentral = new CentralRiesgoEntity(cli.getCentralRiesgo().getNumeroCliente(), cli.getCentralRiesgo().getResultadoConsultaMasReciente(), cli.getCentralRiesgo().getVbVigenteParaSerConsultado(), cli.getCentralRiesgo().getFechaConsultaMasReciente());
            query.add(dataCentral);
        }
        return query;
    }

    @Override
    public ClienteFICDTO obtenerClienteByIdentificacion(ConsultaClienteByData data) {

        Log.info("Inicia Proceso de consumo SP FICConsultaClientePorIdentificacion");

        ClienteFICDTO dataResponse = new ClienteFICDTO();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorIdentificacion(?,?,?,?)}");
            callableStatement.setString(1, data.getTipoDocumento().toString());
            callableStatement.setString(2, data.getNumeroDocumento().toString());
            callableStatement.setString(3, data.getDigitoVerificacion().toString());
            callableStatement.registerOutParameter(4, Types.DECIMAL);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                dataResponse = new ClienteFICDTO(
                        new AlertaEntity(),
                        new ClienteBaseEntity(),
                        new CentralRiesgoEntity(),
                        new ReporteCentralRiesgoEntity(),
                        new ContactoEntity(),
                        new ConyugeEntity(),
                        new CupoRotativoEntity(),
                        1,
                        new DomicilioBaseEntity(),
                        new DomicilioEmpresaEntity(),
                        EstadoCivilEnum._1_SOLTERA_O_,
                        resultSet.getString("nombre_completo_funcionario_ult_act"),
                        new NegocioEntity(),
                        "10002",
                        new OfertaEntity(),
                        new PasivoEntity(),
                        new PQREntity(),
                        "",
                        "",
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_estado_cliente"),
                        mapper.stringToDoc(resultSet.getString("s_codigo_tipo_ident")),
                        resultSet.getString("m_total_activos"),
                        resultSet.getString("d_fecha_ult_actualizacion")
                );
            }
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Log.info("Termina Consulta");
        }

        return dataResponse;
    }

    @Override
    public ConsultarClientePorNombreOutputEntity obtenerClienteByNombre(String nombre, int pagina, int tamanoPagina) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorNombre");

        List<ConsultarClientePorNombreEntity> dataResponse = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorNombre(?,?,?,?)}");
            callableStatement.setString(1, nombre);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.setInt(3, pagina);
            callableStatement.setInt(4, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                ConsultarClientePorNombreEntity resultQuery = new ConsultarClientePorNombreEntity(
                        mapper.stringToDoc(resultSet.getString("s_codigo_tipo_ident")),
                        resultSet.getString("s_numero_identificacion"),
                        resultSet.getString("s_nombre_completo")
                );

                dataResponse.add(resultQuery);
            }

            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Log.info("Termina Consulta");
        }

        return new ConsultarClientePorNombreOutputEntity(dataResponse.size(), dataResponse);
    }

    @Override
    public ConyugeType obtenerConyuge(Integer numeroCliente) {
        ClienteFICEntity conyuge = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).findFirst().orElse(null);
        if (conyuge != null) {
            return conyuge.getConyuge();
        }
        return new ConyugeType();
    }

    @Override
    public List<CupoRotativoEntity> obtenerCupoRotativo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CupoRotativoEntity> cupoRotativoList = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CupoRotativoEntity cup = new CupoRotativoEntity(cli.getCupoRotativo().getEstado(), cli.getCupoRotativo().getFechaDeVencimiento(), cli.getCupoRotativo().getMontoCupoCredito(), cli.getCupoRotativo().getMontoUtilizado(), cli.getCupoRotativo().getNumeroCliente(), cli.getCupoRotativo().getNumeroCupo(), cli.getCupoRotativo().getSaldoDisponible());
            cupoRotativoList.add(cup);
        }
        return cupoRotativoList;
    }

    @Override
    public List<ContactoEntity> obtenerContacto(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<ContactoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            ContactoEntity data = new ContactoEntity(cli.getContacto().getFecha(), cli.getContacto().getTipoContacto(), cli.getContacto().getResultadoComentarios(), cli.getContacto().getNumeroCliente());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<OfertaEntity> obtenerOferta(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<OfertaEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            OfertaEntity data = new OfertaEntity(cli.getOferta().getNumeroOferta(), cli.getOferta().getTipoLead(), cli.getOferta().getTipoOferta(), cli.getOferta().getMonto(), cli.getOferta().getPlazo(), cli.getOferta().getNumeroCliente(), cli.getOferta().getTipoDeLiga(), cli.getOferta().getCondicionGarantia());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PasivoEntity> obtenerPasivo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<PasivoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PasivoEntity data = new PasivoEntity(cli.getPasivo().getNumeroCliente(), cli.getPasivo().getNumeroProducto(), cli.getPasivo().getTipoProducto(), cli.getPasivo().getDetalleProducto(), cli.getPasivo().getEstadoPasivo(), cli.getPasivo().getFechaApertura(), cli.getPasivo().getFechaCierre(), cli.getPasivo().getCapital(), cli.getPasivo().getIntereses(), cli.getPasivo().getOtros(), cli.getPasivo().getSaldoTotal());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PQREntity> obtenerPQR(ConsultaClienteByData data) {

        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento()).filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion())).toList();

        List<PQREntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PQREntity pqr = new PQREntity(cli.getPQR().getNumeroCliente(), cli.getPQR().getFecha(), cli.getPQR().getNumeroPQR(), cli.getPQR().getMotivo(), cli.getPQR().getResultadoPQR(), cli.getPQR().getComentario());
            query.add(pqr);
        }
        return query;
    }

}
