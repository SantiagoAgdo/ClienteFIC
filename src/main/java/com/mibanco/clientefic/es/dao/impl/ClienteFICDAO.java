package com.mibanco.clientefic.es.dao.impl;

import com.mibanco.clientefic.es.constants.Constants;
import com.mibanco.clientefic.es.dao.contract.IClienteFICDAO;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.EstadoCivilEnum;
import com.mibanco.clientefic.es.gen.type.TipoViviendaEnum;
import com.mibanco.clientefic.es.utils.configs.ConnectionDB;
import com.mibanco.clientefic.es.utils.exceptions.ApplicationException;
import com.mibanco.clientefic.es.utils.mapper.ClienteFICMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ClienteFICDAO implements IClienteFICDAO {

    private static final Logger Log = org.slf4j.LoggerFactory.getLogger(ClienteFICDAO.class);

    private Connection connection;
    @Inject
    ClienteFICMapper mapper;

    @Inject
    ConnectionDB connectionDB;


    @Override
    public AlertasOutput consultarAlerta(Integer pagina, Integer tamanoPagina, ConsultaClienteEntity consultaClienteEntity) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarAlerta");

        List<AlertaEntity> alertaEntityList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();

            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarAlerta(?,?,?,?,?)}");
            callableStatement.setString(1, consultaClienteEntity.getTipoDocumento().toString());
            callableStatement.setString(2, consultaClienteEntity.getNumeroDocumento());
            callableStatement.setInt(3, consultaClienteEntity.getDigitoVerificacion());
            callableStatement.registerOutParameter(4, Types.DECIMAL);
            callableStatement.registerOutParameter(5, Types.DECIMAL);

            //73. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                AlertaEntity centralRiesgoResponseSP = new AlertaEntity(
                        resultSet.getString("TipoAlerta"),
                        resultSet.getString("Banco"),
                        resultSet.getString("Fecha"),
                        consultaClienteEntity.getTipoDocumento(),
                        consultaClienteEntity.getNumeroDocumento(),
                        consultaClienteEntity.getDigitoVerificacion().toString()
                );
                alertaEntityList.add(centralRiesgoResponseSP);
            }
            resultSet.close();
        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Constants.ERROR_BD);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = alertaEntityList.size();
        //Condicion para controlar si excede pagina limite
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            List<AlertaEntity> consultarClientePorNombreListPaginado = new ArrayList<>(
                    alertaEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1)
            );

            return new AlertasOutput(arraySize, consultarClientePorNombreListPaginado);
        } else {
            return new AlertasOutput(0, new ArrayList<>());
        }
    }

    @Override
    public List<CentralRiesgoEntity> consultarCentralRiesgo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        Log.info("Inicia Proceso de consumo sp_fic_consultarCentralRiesgo");

        List<CentralRiesgoEntity> centralRiesgoEntityArrayList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarCentralRiesgo(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            //73. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                CentralRiesgoEntity centralRiesgoResponseSP = new CentralRiesgoEntity(
                        numeroCliente,
                        resultSet.getString("fechaVigenciaDesde"), //fechaConsultaMasReciente
                        resultSet.getString("zonaViabilidad"),//resultadoConsultaMasReciente
                        resultSet.getString("s_vbclienteparaconsulta") //vbVigenteParaSerConsultado
                );
                centralRiesgoEntityArrayList.add(centralRiesgoResponseSP);
            }
            resultSet.close();
        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = centralRiesgoEntityArrayList.size();
        //exede pagina
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        //esta vacio
        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }
            return new ArrayList<>(
                    centralRiesgoEntityArrayList.subList(inicioDeIndice - 1, finalDeIndice - 1)
            );
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public ClienteFICEntity consultarClientePorIdentificacion(ConsultaClienteEntity consultaClienteEntity) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorIdentificacion");

        ClienteFICEntity clienteFIC = new ClienteFICEntity();


        String tipoPersona = "NATURAL";
        //valor defector tipo persona
        if (Objects.equals(consultaClienteEntity.getTipoDocumento().toString(), "NIT") || Objects.equals(consultaClienteEntity.getTipoDocumento().toString(), "TE")) {
            tipoPersona = "JURIDICA";
        }


        try {
            connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorIdentificacion(?,?,?,?)}");
            callableStatement.setString(1, consultaClienteEntity.getTipoDocumento().toString());
            callableStatement.setString(2, consultaClienteEntity.getNumeroDocumento());
            callableStatement.setString(3, consultaClienteEntity.getDigitoVerificacion().toString());
            callableStatement.registerOutParameter(4, Types.DECIMAL);

            ResultSet resultSet = callableStatement.executeQuery();
            //67. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, para una persona Natural
            //14. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, para una persona Jurídica
            clienteFIC = busquedaClientePorIdentificacion(resultSet, consultaClienteEntity, tipoPersona);

        } catch (SQLException e) {
            Log.error("");
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Columna No Identificada: " + e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        if (clienteFIC.getClienteBase() == null) {
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Constants.CLIENTE_NO_EXISTE);
        } else {
            return clienteFIC;
        }

    }

    @Override
    public ConsultarClientePorNombreOutputEntity consultarClienteFicPorNombre(String nombre, int pagina, int tamanoPagina) {

        Log.info("Inicia Proceso de consumo sp_fic_consultaClientePorNombre");

        List<ClienteFiltroType> consultarClientePorNombreList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaClientePorNombre(?,?,?,?)}")) {
                callableStatement.setString(1, nombre);
                callableStatement.registerOutParameter(2, Types.DECIMAL);
                callableStatement.setInt(3, pagina);
                callableStatement.setInt(4, tamanoPagina);

                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    while (resultSet.next()) {
                        ClienteFiltroType resultadoConsultaCliente = crearClienteFiltroTypeDesdeResultSet(resultSet);
                        consultarClientePorNombreList.add(resultadoConsultaCliente);
                    }
                }
            }
        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta: " + e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = consultarClientePorNombreList.size();
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            List<ClienteFiltroType> consultarClientePorNombreListPaginado = new ArrayList<>(
                    consultarClientePorNombreList.subList(inicioDeIndice - 1, finalDeIndice - 1)
            );

            return new ConsultarClientePorNombreOutputEntity(arraySize, consultarClientePorNombreListPaginado);
        } else {
            return new ConsultarClientePorNombreOutputEntity(0, new ArrayList<>());
        }
    }

    @Override
    public ConyugeEntity consultarConyuge(Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultaInformacionConyugeCliente");

        ConyugeEntity conyuge = new ConyugeEntity();

        try {
            connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultaInformacionConyugeCliente(?,?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.VARCHAR);

            //69. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, del conyugue:
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                conyuge = new ConyugeEntity(
                        mapper.stringATipoDocumento(resultSet.getString("TIPO_DOCTO_FAM_PERS")),
                        resultSet.getString("NRO_DOCUM_FAM_PERS"),
                        resultSet.getString("NOMBRE_FAM_PERS"),
                        numeroCliente
                );
            }

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        return conyuge;
    }

    @Override
    public ConsultarCupoRotativoOutput consultarCupoRotativo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarCupoRotativo");

        List<CupoRotativoEntity> cupoRotativoEntityList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
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
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = cupoRotativoEntityList.size();
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            return new ConsultarCupoRotativoOutput(arraySize, new ArrayList<>(cupoRotativoEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1)));
        } else {
            return new ConsultarCupoRotativoOutput(0, new ArrayList<>());
        }

    }

    @Override
    public ConsultarHistorialContactoOutput consultarHistorialContacto(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarHistorialContacto");

        List<ContactoEntity> contactoEntityList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
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
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = contactoEntityList.size();
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            return new ConsultarHistorialContactoOutput(arraySize, new ArrayList<>(contactoEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1)));
        } else {
            return new ConsultarHistorialContactoOutput(0, new ArrayList<>());
        }

    }

    @Override
    public OfertasOutput consultarOferta(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {

        Log.info("Inicia Proceso de consumo sp_fic_consultarOferta");

        List<OfertaEntity> ofertaEntityList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarOferta(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            //70. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, de una oferta:
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                OfertaEntity centralRiesgoResponseSP = new OfertaEntity(
                        numeroCliente,
                        resultSet.getInt("numOferta"),
                        resultSet.getString("campaña"),
                        resultSet.getString("tipoOferta"),
                        resultSet.getFloat("monto"),
                        resultSet.getInt("plazo"),
                        resultSet.getString("tipo_liga"),
                        resultSet.getString("s_estrategia_final")
                );
                ofertaEntityList.add(centralRiesgoResponseSP);
            }

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarCentralRiesgo: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = ofertaEntityList.size();
        //Condicion para controlar si excede pagina limite
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            List<OfertaEntity> ofertasOutputList = new ArrayList<>(
                    ofertaEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1)
            );

            return new OfertasOutput(arraySize, ofertasOutputList);
        } else {
            return new OfertasOutput(0, new ArrayList<>());
        }

    }

    @Override
    public ConsultarPasivoOutput consultarPasivo(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {
        Log.info("Inicia Proceso de consumo sp_fic_consultarPasivo");

        List<PasivoEntity> pasivoEntityList = new ArrayList<>();

        try {
            connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call sp_fic_consultarPasivo(?,?,?)}");
            callableStatement.setInt(1, numeroCliente);
            callableStatement.setInt(2, pagina);
            callableStatement.setInt(3, tamanoPagina);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                PasivoEntity pasivoEntitySP = new PasivoEntity(
                        numeroCliente,
                        resultSet.getString("i_codigo_cuenta"),
                        mapper.stringATipoProducto(resultSet.getString("i_codigo_producto")),
                        resultSet.getString("i_codigo_subproducto"),
                        resultSet.getString("s_cod_estado_corte"),
                        resultSet.getString("fecha_apertura_creacion"),
                        resultSet.getString("d_fecha_cancelacion"),
                        resultSet.getFloat("capital"),
                        resultSet.getString("m_saldo_rendimiento"),
                        resultSet.getFloat("otros"),
                        resultSet.getFloat("saldoTotal")
                );
                pasivoEntityList.add(pasivoEntitySP);
            }
            resultSet.close();

        } catch (SQLException e) {
            Log.error("Error al ejecutar la consulta en el método consultarPasivo: " + e.getMessage());
            throw new ApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Columna No Identificada: " + e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    Log.info("Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                Log.error("Error al cerrar la conexión: " + e.getMessage());
            }
            Log.info("Termina Consulta");
        }

        int arraySize = pasivoEntityList.size();
        if (pagina > (arraySize / tamanoPagina) + 1) {
            throw new ApplicationException(Response.Status.CONFLICT.getStatusCode(), "Limite de pagina Excedido, calcular bien maximo de paginacion");
        }

        if (arraySize != 0) {
            int inicioDeIndice = (pagina - 1) * tamanoPagina + 1;
            int finalDeIndice;

            // Si el tamaño del array es menor que el tamaño de la página, o estamos en la última página
            if (arraySize < tamanoPagina || inicioDeIndice + tamanoPagina - 1 > arraySize) {
                finalDeIndice = arraySize + 1;
            } else {
                finalDeIndice = inicioDeIndice + tamanoPagina;
            }

            return new ConsultarPasivoOutput(arraySize, new ArrayList<>(pasivoEntityList.subList(inicioDeIndice - 1, finalDeIndice - 1)));
        } else {
            return new ConsultarPasivoOutput(0, new ArrayList<>());
        }
    }

    @Override
    public List<PQREntity> consultarPQR(Integer pagina, Integer tamanoPagina, Integer numeroCliente) {


        List<PQREntity> consultaCliente = new ArrayList<>();
        consultaCliente.add(new PQREntity(
                1,
                "01/01/2000",
                312,
                "x",
                "x",
                "Sin Comentarios")
        );


        return consultaCliente;
    }

    public static String eliminarCaracteresEspeciales(String cadena) {
        // 54. Cuando el sistema (MiBanco) reciba la información, en la capa validator elimina los caracteres especiales como: tildes, ñ, guiones, &, # etc.
        return cadena.replaceAll("[^a-zA-Z0-9]", " ");
    }


    private ClienteFiltroType crearClienteFiltroTypeDesdeResultSet(ResultSet resultSet) throws SQLException {
        return new ClienteFiltroType(
                mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                resultSet.getString("s_numero_identificacion"),
                resultSet.getString("s_nombre_completo"),
                resultSet.getString("d_fecha_ult_actualizacion").substring(0, 10),
                resultSet.getString("s_pais_origen"),
                resultSet.getString("s_ciudad_origen")
        );
    }


    private ClienteFICEntity busquedaClientePorIdentificacion(ResultSet resultSet, ConsultaClienteEntity consultaClienteEntity, String tipoPersona) throws SQLException {

        ClienteFICEntity clienteFIC = new ClienteFICEntity();
        while (resultSet.next()) {
            //14. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, para una persona Jurídica
            if ("NIT".equals(consultaClienteEntity.getTipoDocumento().toString())) {
                clienteFIC = new ClienteFICEntity(
                        consultaClienteEntity.getDigitoVerificacion(),
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_numero_identificacion_replegal"),
                        resultSet.getString("s_nombre_completo_replegal"),
                        resultSet.getFloat("m_total_activos"),
                        resultSet.getString("d_fecha_ult_actualizacion").substring(0, 10),
                        resultSet.getString("s_estado_cliente"),
                        resultSet.getString("nombre_completo_funcionario_ult_act"),
                        EstadoCivilEnum._6,
                        resultSet.getString("s_cod_tip_rep_legal"),
                        new DomicilioBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("s_telefono_fijo_emp"),
                                TipoViviendaEnum._1
                        ),
                        new ClienteBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                "",
                                "",
                                "",
                                "",
                                mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                                resultSet.getString("s_numero_identificacion"),
                                1,
                                mapper.stringATipoPersona(tipoPersona),
                                resultSet.getString("s_correo_electronico"),
                                resultSet.getString("s_telefono_celular_emp")
                        ),
                        new NegocioEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1")
                        ),
                        new DomicilioEmpresaEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("s_telefono_fijo_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1"),
                                resultSet.getString("s_tipo_local")
                        )
                );
            }
            //68. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información, para una persona Jurídica
            if ("TE".equals(consultaClienteEntity.getTipoDocumento().toString())) {
                clienteFIC = new ClienteFICEntity(
                        consultaClienteEntity.getDigitoVerificacion(),
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_numero_identificacion_replegal"),
                        resultSet.getString("s_nombre_completo_replegal"),
                        resultSet.getFloat("m_total_activos"),
                        resultSet.getString("d_fecha_ult_actualizacion").substring(0, 10),
                        resultSet.getString("s_estado_cliente"),
                        resultSet.getString("nombre_completo_funcionario_ult_act"),
                        EstadoCivilEnum._1,
                        resultSet.getString("s_cod_tip_rep_legal"),
                        new DomicilioBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                "",
                                "",
                                "",
                                TipoViviendaEnum._1
                        ),
                        new ClienteBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                "",
                                "",
                                "",
                                "",
                                mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                                resultSet.getString("s_numero_identificacion"),
                                1,
                                mapper.stringATipoPersona(tipoPersona),
                                resultSet.getString("s_correo_electronico"),
                                ""
                        ),
                        new NegocioEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_fijo_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1")
                        ),
                        new DomicilioEmpresaEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("s_telefono_fijo_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1"),
                                resultSet.getString("s_tipo_local")
                        )
                );
            }
            //68. El sistema realiza una transformación de datos por medio de la capa DAO, cuando la consulta retorna la siguiente información,
            // para una persona Natural
            if (!"NIT".equals(consultaClienteEntity.getTipoDocumento().toString()) && !"TE".equals(consultaClienteEntity.getTipoDocumento().toString())) {
                clienteFIC = new ClienteFICEntity(
                        consultaClienteEntity.getDigitoVerificacion(),
                        resultSet.getString("s_nombre_completo"),
                        resultSet.getString("s_nombre_completo"),
                        "",
                        "",
                        resultSet.getFloat("m_total_activos"),
                        resultSet.getString("d_fecha_ult_actualizacion").substring(0, 10),
                        resultSet.getString("s_estado_cliente"),
                        resultSet.getString("nombre_completo_funcionario_ult_act"),
                        mapper.stringAEstadoCivil("_" + resultSet.getString("s_codigo_estado_civil")),
                        "",
                        new DomicilioBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion"),
                                resultSet.getString("s_telefono_celular"),
                                resultSet.getString("s_telefono_fijo"),
                                mapper.stringATipoVivienda("_" + resultSet.getString("s_cod_tipo_vivienda"))
                        ),
                        new ClienteBaseEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                "",
                                "",
                                "",
                                "",
                                mapper.stringATipoDocumento(resultSet.getString("s_codigo_tipo_ident")),
                                resultSet.getString("s_numero_identificacion"),
                                1,
                                mapper.stringATipoPersona(tipoPersona),
                                resultSet.getString("s_correo_electronico"),
                                resultSet.getString("s_telefono_celular")
                        ),
                        new NegocioEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1")

                        ),
                        new DomicilioEmpresaEntity(
                                resultSet.getInt("i_identificacion_cliente"),
                                resultSet.getString("s_direccion_emp"),
                                resultSet.getString("s_telefono_celular_emp"),
                                resultSet.getString("s_telefono_fijo_emp"),
                                resultSet.getString("cod_actividad_economica1"),
                                resultSet.getString("s_actividad_economica1"),
                                "-"
                        )
                );
            }

        }
        return clienteFIC;
    }
}
