package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.dto.ClienteFICDTO;
import com.mibanco.clientefic.es.gen.type.ConyugeType;
import com.mibanco.clientefic.es.gen.type.EstadoCivilEnum;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import com.mibanco.clientefic.es.gen.type.TipoPersonaEnum;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
    public List<CentralRiesgoEntity> consultarCentralRiesgo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        Log.info("Inicia Proceso de consumo sp_fic_consultarCentralRiesgo");

        List<CentralRiesgoEntity> centralRiesgoEntityArrayList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarCentralRiesgo(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                CentralRiesgoEntity centralRiesgoResponseSP = new CentralRiesgoEntity(
                        numeroCliente,
                        eliminarCaracteresEspeciales(resultSet.getString("fechaVigenciaDesde")), //fechaConsultaMasReciente
                        eliminarCaracteresEspeciales(resultSet.getString("zonaViabilidad")), //resultadoConsultaMasReciente
                        eliminarCaracteresEspeciales(resultSet.getString("s_vbclienteparaconsulta")) //vbVigenteParaSerConsultado
                );
                centralRiesgoEntityArrayList.add(centralRiesgoResponseSP);
            }
            resultSet.close();
        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());

        } finally {
            Log.info("Termina Consulta");
        }

        if (centralRiesgoEntityArrayList.size() != 0) {
            int inicioDeIndice = pagina == 1 ? 1 : pagina * tamanoPagina;
            int finalDeIndice = inicioDeIndice + tamanoPagina;

            return new ArrayList<>(
                    centralRiesgoEntityArrayList.subList(inicioDeIndice - 1, finalDeIndice - 1)
            );
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public ClienteBaseEntity consultarClientePorIdentificacion(ConsultaClienteEntity data) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorIdentificacion");

        ClienteBaseEntity clienteFIC = new ClienteBaseEntity();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorIdentificacion(?,?,?,?)}");
            callableStatement.setString(1, data.getTipoDocumento().toString());
            callableStatement.setString(2, data.getNumeroDocumento().toString());
            callableStatement.setString(3, data.getDigitoVerificacion().toString());
            callableStatement.registerOutParameter(4, Types.DECIMAL);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                clienteFIC = new ClienteBaseEntity(
                        resultSet.getInt("i_identificacion_cliente"),
                        resultSet.getString("s_nombre_completo").split(" ")[1],
                        resultSet.getString("s_nombre_completo").split(" ")[2],
                        resultSet.getString("s_nombre_completo").split(" ")[3],
                        resultSet.getString("s_nombre_completo").split(" ")[4],
                        mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                        resultSet.getString("s_numero_identificacion"),
                        1,
                        TipoPersonaEnum._1_JURIDICA,
                        resultSet.getString("s_correo_electronico"),
                        resultSet.getInt("s_telefono_celular")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Log.info("Termina Consulta");
        }

        if (clienteFIC.getNumeroCliente() != null) {
            return clienteFIC;
        } else {
            return null;
        }

    }

    @Override
    public ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorNombre");

        List<ClienteFiltroType> consultarClientePorNombreList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorNombre(?,?,?,?)}");
            callableStatement.setString(1, nombre);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.setInt(3, pagina);
            callableStatement.setInt(4, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                ClienteFiltroType resultadoConsultaCliente = new ClienteFiltroType(
                        mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                        eliminarCaracteresEspeciales(resultSet.getString("s_numero_identificacion")),
                        eliminarCaracteresEspeciales(resultSet.getString("s_nombre_completo")),
                        eliminarCaracteresEspeciales(resultSet.getString("d_fecha_ult_actualizacion")),
                        eliminarCaracteresEspeciales(resultSet.getString("s_pais_origen")),
                        "XXXXX"
                );
                consultarClientePorNombreList.add(resultadoConsultaCliente);
            }
            resultSet.close();
        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta: " + e.getMessage());

        } finally {
            Log.info("Termina Consulta");
        }

        int inicioDeIndice = pagina == 1 ? 1 : pagina * tamanoPagina;
        int finalDeIndice = inicioDeIndice + tamanoPagina;

        List<ClienteFiltroType> consultarClientePorNombreListPaginado = new ArrayList<>(
                consultarClientePorNombreList.subList(inicioDeIndice - 1, finalDeIndice - 1)
        );

        for (ClienteFiltroType clienteFiltroType : consultarClientePorNombreListPaginado) {
            Log.warn("=== Datos Extraidos ===");
            Log.info(clienteFiltroType.getTipoDocumento().toString());
            Log.info(clienteFiltroType.getNumeroDocumento().toString());
            Log.info(clienteFiltroType.getNombreCompleto().toString());
            Log.info(clienteFiltroType.getFechaUltimaActualizacion().toString());
            Log.info(clienteFiltroType.getPaisOrigen().toString());
            Log.info("-----------------------");
        }

        return new ConsultarClientePorNombreOutputEntity(consultarClientePorNombreList.size(), consultarClientePorNombreListPaginado);
    }

    @Override
    public ConyugeEntity consultarConyuge(Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultaInformacionConyugeCliente");

        ConyugeEntity conyuge = new ConyugeEntity();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaInformacionConyugeCliente(?,?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.VARCHAR);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                conyuge = new ConyugeEntity(
                        mapper.stringATipoDocumento(resultSet.getString("@tipo_docto_fam_pers")),
                        resultSet.getString("@nro_docum_fam_pers"),
                        resultSet.getString("@@nombre_fam_pers"),
                        numeroCliente
                );
            }

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
        } finally {
            Log.info("Termina Consulta");
        }

        return conyuge;
    }

    @Override
    public List<CupoRotativoEntity> consultarCupoRotativo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarCupoRotativo");

        List<CupoRotativoEntity> cupoRotativoEntityList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarCupoRotativo(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                CupoRotativoEntity centralRiesgoResponseSP = new CupoRotativoEntity(
                        resultSet.getString("s_estado_cupo"),
                        resultSet.getString("d_fecha_vcto_cupo"),
                        resultSet.getFloat("m_valor_cupo"),
                        resultSet.getFloat("m_monto_utilizado"),
                        numeroCliente,
                        resultSet.getString("s_cod_producto_core"),
                        resultSet.getFloat("m_saldo_cupo")
                );
                cupoRotativoEntityList.add(centralRiesgoResponseSP);
            }
            resultSet.close();

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCupoRotativo: " + e.getMessage());
        } finally {
            Log.info("Termina Consulta");
        }

        if (cupoRotativoEntityList.size() != 0) {
            int inicioDeIndice = pagina == 1 ? 1 : pagina * tamanoPagina;
            int finalDeIndice = inicioDeIndice + tamanoPagina;

            return new ArrayList<>(cupoRotativoEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ContactoEntity> consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarHistorialContacto");

        List<ContactoEntity> contactoEntityList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarHistorialContacto(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                ContactoEntity centralRiesgoResponseSP = new ContactoEntity(
                        numeroCliente,
                        resultSet.getString("d_fecha_contacto"),
                        resultSet.getString("s_accion"),
                        resultSet.getString("Resultado / Comentarios")
                );
                contactoEntityList.add(centralRiesgoResponseSP);
            }
            resultSet.close();

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
        } finally {
            Log.info("Termina Consulta");
        }

        if (contactoEntityList.size() != 0) {
            int inicioDeIndice = pagina == 1 ? 1 : pagina * tamanoPagina;
            int finalDeIndice = inicioDeIndice + tamanoPagina;

            return new ArrayList<>(contactoEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1));
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public List<OfertaEntity> consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        Log.info("Inicia Proceso de consumo sp_fic_consultarOferta");

        List<OfertaEntity> ofertaEntityList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarOferta(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                OfertaEntity centralRiesgoResponseSP = new OfertaEntity(
                        numeroCliente,
                        resultSet.getInt("numOferta"),
                        resultSet.getString("campaña"),
                        resultSet.getString("tipoOferta"),
                        resultSet.getFloat("monto"),
                        resultSet.getInt("plazo"),
                        "TipoLiga",
                        "condiciongarantia"
                );
                ofertaEntityList.add(centralRiesgoResponseSP);
            }

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
        } finally {
            Log.info("Termina Consulta");
        }

        if (ofertaEntityList.size() != 0) {
            int inicioDeIndice = pagina == 1 ? 1 : pagina * tamanoPagina;
            int finalDeIndice = inicioDeIndice + tamanoPagina;

            return new ArrayList<>(ofertaEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1));
        } else {
            return new ArrayList<>();
        }

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

    public static String eliminarCaracteresEspeciales(String cadena) {
        String cadenaSinEspeciales = cadena.replaceAll("[^a-zA-Z0-9]", " ");
        return cadenaSinEspeciales;
    }


}
