package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDao;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
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
    public List<AlertaEntity> getListaAlertas(ConsultaClienteByData data) {
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
    public List<CentralRiesgoEntity> getListaCentralRiesgo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CentralRiesgoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CentralRiesgoEntity dataCentral = new CentralRiesgoEntity(cli.getCentralRiesgo().getNumeroCliente(), cli.getCentralRiesgo().getResultadoConsultaMasReciente(), cli.getCentralRiesgo().getVbVigenteParaSerConsultado(), cli.getCentralRiesgo().getFechaConsultaMasReciente());
            query.add(dataCentral);
        }
        return query;
    }

    @Override
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData data) {

        return list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).findFirst().orElse(null);
    }

    @Override
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(String nombre) {

        ClienteFICEntity cliente = list.stream().filter(x -> x.getClienteBase().getPrimerNombre().equals(nombre)).findFirst().orElse(null);

        ConsultarClientePorNombreEntity query = new ConsultarClientePorNombreEntity();
        if (cliente != null) {
            query = new ConsultarClientePorNombreEntity(cliente.getClienteBase().getTipoDocumento(), cliente.getClienteBase().getNumeroDocumento(), cliente.getClienteBase().getPrimerNombre() + " " + cliente.getClienteBase().getPrimerApellido());
        } else {
            return new ConsultarClientePorNombreOutputEntity(0, query);
        }
        return new ConsultarClientePorNombreOutputEntity(1, query);
    }

    @Override
    public ConyugeType getConyuge(Integer numeroCliente) {
        ClienteFICEntity conyuge = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).findFirst().orElse(null);
        if (conyuge != null) {
            return conyuge.getConyuge();
        }
        return new ConyugeType();
    }

    @Override
    public List<CupoRotativoEntity> getCupoRotativo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CupoRotativoEntity> cupoRotativoList = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CupoRotativoEntity cup = new CupoRotativoEntity(cli.getCupoRotativo().getEstado(), cli.getCupoRotativo().getFechaDeVencimiento(), cli.getCupoRotativo().getMontoCupoCredito(), cli.getCupoRotativo().getMontoUtilizado(), cli.getCupoRotativo().getNumeroCliente(), cli.getCupoRotativo().getNumeroCupo(), cli.getCupoRotativo().getSaldoDisponible());
            cupoRotativoList.add(cup);
        }
        return cupoRotativoList;
    }

    @Override
    public List<ContactoEntity> getContacto(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<ContactoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            ContactoEntity data = new ContactoEntity(cli.getContacto().getFecha(), cli.getContacto().getTipoContacto(), cli.getContacto().getResultadoComentarios(), cli.getContacto().getNumeroCliente());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<OfertaEntity> getOferta(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<OfertaEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            OfertaEntity data = new OfertaEntity(cli.getOferta().getNumeroOferta(), cli.getOferta().getTipoLead(), cli.getOferta().getTipoOferta(), cli.getOferta().getMonto(), cli.getOferta().getPlazo(), cli.getOferta().getNumeroCliente(), cli.getOferta().getTipoDeLiga(), cli.getOferta().getCondicionGarantia());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PasivoEntity> getPasivo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<PasivoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PasivoEntity data = new PasivoEntity(cli.getPasivo().getNumeroCliente(), cli.getPasivo().getNumeroProducto(), cli.getPasivo().getTipoProducto(), cli.getPasivo().getDetalleProducto(), cli.getPasivo().getEstadoPasivo(), cli.getPasivo().getFechaApertura(), cli.getPasivo().getFechaCierre(), cli.getPasivo().getCapital(), cli.getPasivo().getIntereses(), cli.getPasivo().getOtros(), cli.getPasivo().getSaldoTotal());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PQREntity> getPQR(ConsultaClienteByData data) {

        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento()).filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion())).toList();

        List<PQREntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PQREntity pqr = new PQREntity(cli.getPQR().getNumeroCliente(), cli.getPQR().getFecha(), cli.getPQR().getNumeroPQR(), cli.getPQR().getMotivo(), cli.getPQR().getResultadoPQR(), cli.getPQR().getComentario());
            query.add(pqr);
        }
        return query;
    }

    public void getSP() {
        Log.info("Inicia Proceso de consumo SP");
        try( Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorNombre(?,?,?,?)}");
            callableStatement.setString(1,"test");
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.setInt(3,1);
            callableStatement.setInt(4,20);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String codigo = resultSet.getString("s_codigo_tipo_ident");
                String numero = resultSet.getString("s_numero_identificacion");
                Log.info("Codigo: " + codigo + ", Numero: " + numero);
            }
            callableStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Log.info("Termina Consulta");
        }
    }
}
