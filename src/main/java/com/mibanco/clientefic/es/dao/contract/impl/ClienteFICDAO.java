package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDao;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteFICDAO implements IClienteFICDao {

    List<ClienteFICEntity> list = new ArrayList<>();

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
            PasivoEntity data = new PasivoEntity(cli.getPasivo().getNumeroProducto(), cli.getPasivo().getSubProducto(), cli.getPasivo().getTipoProducto(), cli.getPasivo().getEstadoPasivo(), cli.getPasivo().getFechaApertura(), cli.getPasivo().getFechaCierre(), cli.getPasivo().getCapital(), cli.getPasivo().getIntereses(), cli.getPasivo().getOtros(), cli.getPasivo().getSaldoTotal(), cli.getPasivo().getNumeroCliente());
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PQREntity> getPQR(ConsultaClienteByData data) {

        List<ClienteFICEntity> cliente = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento()).filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion())).toList();

        List<PQREntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PQREntity pqr = new PQREntity(cli.getPQR().getFecha(), cli.getPQR().getNumeroPQR(), cli.getPQR().getMotivo(), cli.getPQR().getResultadoPQR(), cli.getPQR().getComentario(), cli.getPQR().getDigitoVerificacion(), cli.getPQR().getTipoDocumento(), cli.getPQR().getNumeroDocumento());
            query.add(pqr);
        }
        return query;
    }

    public void getSP() {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "1234");

            // Llamar al procedimiento almacenado
            CallableStatement callableStatement = connection.prepareCall("{call sp_obtener_usuarios()}");

            ResultSet resultSet = callableStatement.executeQuery();

            // Procesar el resultado si es necesario
            while (resultSet.next()) {
                // Acceder a los resultados, por ejemplo, si el procedimiento retorna una columna llamada 'resultado'
                int edad = resultSet.getInt("edad");
                String nombre = resultSet.getString("nombre");
                // Realizar operaciones con el resultado
                System.out.println("Nombre: " + nombre + "edad" + edad);
                Log.info("Nombre: " + nombre + "edad" + edad);
            }

            // Cerrar recursos
            callableStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
