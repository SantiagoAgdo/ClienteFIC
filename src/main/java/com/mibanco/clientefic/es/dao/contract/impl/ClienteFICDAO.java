package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.EstadoCivilEnum;
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
public class ClienteFICDAO implements IClienteFICDAO {

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
    public void crearUsuarioClienteFic(ClienteFICEntity clienteFIC) {
        list.add(clienteFIC);
    }

    @Override
    public List<AlertaEntity> consultarAlerta(ConsultaClienteEntity data) {
        List<ClienteFICEntity> clienteFICEntityList = list.stream().filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento()).filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento())).filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion())).toList();

        List<AlertaEntity> consultaCliente = new ArrayList<>();

        if (clienteFICEntityList.size() != 0) {
            for (ClienteFICEntity clienteFIC : clienteFICEntityList) {
                AlertaEntity dataAlert = new AlertaEntity(clienteFIC.getAlerta().getTipoAlerta(), clienteFIC.getAlerta().getBanco(), clienteFIC.getAlerta().getFecha(), clienteFIC.getAlerta().getTipoDocumento(), clienteFIC.getAlerta().getNumeroDocumento(), clienteFIC.getAlerta().getDigitoVerificacion());
                consultaCliente.add(dataAlert);
            }
        } else {
            return consultaCliente;
        }

        return consultaCliente;
    }

    @Override
    public List<CentralRiesgoEntity> consultarCentralRiesgo(Integer numeroCliente) {
        List<ClienteFICEntity> clienteFICEntityList = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CentralRiesgoEntity> consultaCliente = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityList) {
            CentralRiesgoEntity centralRiesgoEntity = new CentralRiesgoEntity(clienteFIC.getCentralRiesgo().getNumeroCliente(), clienteFIC.getCentralRiesgo().getResultadoConsultaMasReciente(), clienteFIC.getCentralRiesgo().getVbVigenteParaSerConsultado(), clienteFIC.getCentralRiesgo().getFechaConsultaMasReciente());
            consultaCliente.add(centralRiesgoEntity);
        }
        return consultaCliente;
    }

    @Override
    public ClienteFICDTO consultarClientePorIdentificacion(ConsultaClienteEntity data) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorIdentificacion");

        ClienteFICDTO clienteFIC = new ClienteFICDTO();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorIdentificacion(?,?,?,?)}");
            callableStatement.setString(1, data.getTipoDocumento().toString());
            callableStatement.setString(2, data.getNumeroDocumento().toString());
            callableStatement.setString(3, data.getDigitoVerificacion().toString());
            callableStatement.registerOutParameter(4, Types.DECIMAL);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                clienteFIC = new ClienteFICDTO(
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
                        mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                        resultSet.getString("m_total_activos"),
                        resultSet.getString("d_fecha_ult_actualizacion")
                );
            }
            connection.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Log.info("Termina Consulta");
        }

        return clienteFIC;
    }

    @Override
    public ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorNombre");

        List<ConsultarClientePorNombreEntity> consultarClientePorNombreList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorNombre(?,?,?,?)}");
            callableStatement.setString(1, nombre);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.setInt(3, pagina);
            callableStatement.setInt(4, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                ConsultarClientePorNombreEntity resultconsultaCliente = new ConsultarClientePorNombreEntity(
                        mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                        resultSet.getString("s_numero_identificacion"),
                        resultSet.getString("s_nombre_completo")
                );

                consultarClientePorNombreList.add(resultconsultaCliente);
            }
            connection.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Log.info("Termina Consulta");
        }

        return new ConsultarClientePorNombreOutputEntity(consultarClientePorNombreList.size(), consultarClientePorNombreList);
    }

    @Override
    public ConyugeType consultarConyuge(Integer numeroCliente) {
        ClienteFICEntity clienteFICEntity = list.stream().filter(x -> x.getClienteBase().getNumeroCliente().equals(numeroCliente)).findFirst().orElse(null);
        if (clienteFICEntity != null) {
            return clienteFICEntity.getConyuge();
        }
        return new ConyugeType();
    }

    @Override
    public List<CupoRotativoEntity> consultarCupoRotativo(Integer numeroCliente) {
        List<ClienteFICEntity> clienteFICEntityLista = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<CupoRotativoEntity> cupoRotativoList = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityLista) {
            cupoRotativoList.add(new CupoRotativoEntity(
                    clienteFIC.getCupoRotativo().getEstado(),
                    clienteFIC.getCupoRotativo().getFechaDeVencimiento(),
                    clienteFIC.getCupoRotativo().getMontoCupoCredito(),
                    clienteFIC.getCupoRotativo().getMontoUtilizado(),
                    clienteFIC.getCupoRotativo().getNumeroCliente(),
                    clienteFIC.getCupoRotativo().getNumeroCupo(),
                    clienteFIC.getCupoRotativo().getSaldoDisponible()));
        }
        return cupoRotativoList;
    }

    @Override
    public List<ContactoEntity> consultarHistorialContacto(Integer numeroCliente) {
        List<ClienteFICEntity> clienteFICEntityLista = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<ContactoEntity> consultaCliente = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityLista) {
            consultaCliente.add(new ContactoEntity(
                    clienteFIC.getContacto().getFecha(),
                    clienteFIC.getContacto().getTipoContacto(),
                    clienteFIC.getContacto().getResultadoComentarios(),
                    clienteFIC.getContacto().getNumeroCliente())
            );
        }
        return consultaCliente;
    }

    @Override
    public List<OfertaEntity> consultarOferta(Integer numeroCliente) {
        List<ClienteFICEntity> clienteFICEntityLista = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<OfertaEntity> consultaCliente = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityLista) {
            consultaCliente.add(new OfertaEntity(
                    clienteFIC.getOferta().getNumeroOferta(),
                    clienteFIC.getOferta().getTipoLead(),
                    clienteFIC.getOferta().getTipoOferta(),
                    clienteFIC.getOferta().getMonto(),
                    clienteFIC.getOferta().getPlazo(),
                    clienteFIC.getOferta().getNumeroCliente(),
                    clienteFIC.getOferta().getTipoDeLiga(),
                    clienteFIC.getOferta().getCondicionGarantia())
            );
        }
        return consultaCliente;
    }

    @Override
    public List<PasivoEntity> consultarPasivo(Integer numeroCliente) {
        List<ClienteFICEntity> clienteFICEntityLista = list.stream().filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente)).toList();

        List<PasivoEntity> consultaCliente = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityLista) {
            consultaCliente.add(new PasivoEntity(clienteFIC.getPasivo().getNumeroCliente(),
                    clienteFIC.getPasivo().getNumeroProducto(),
                    clienteFIC.getPasivo().getTipoProducto(),
                    clienteFIC.getPasivo().getDetalleProducto(),
                    clienteFIC.getPasivo().getEstadoPasivo(),
                    clienteFIC.getPasivo().getFechaApertura(),
                    clienteFIC.getPasivo().getFechaCierre(),
                    clienteFIC.getPasivo().getCapital(),
                    clienteFIC.getPasivo().getIntereses(),
                    clienteFIC.getPasivo().getOtros(),
                    clienteFIC.getPasivo().getSaldoTotal())
            );
        }
        return consultaCliente;
    }

    @Override
    public List<PQREntity> consultarPQR(ConsultaClienteEntity data) {

        List<ClienteFICEntity> clienteFICEntityLista = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento())
                .filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion()))
                .toList();

        List<PQREntity> consultaCliente = new ArrayList<>();
        for (ClienteFICEntity clienteFIC : clienteFICEntityLista) {

            consultaCliente.add(new PQREntity(
                    clienteFIC.getPQR().getNumeroCliente(),
                    clienteFIC.getPQR().getFecha(),
                    clienteFIC.getPQR().getNumeroPQR(),
                    clienteFIC.getPQR().getMotivo(),
                    clienteFIC.getPQR().getResultadoPQR(),
                    clienteFIC.getPQR().getComentario())
            );
        }

        return consultaCliente;
    }

}
