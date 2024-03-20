package com.mibanco.clientefic.es.utils.configs;

import com.mibanco.clientefic.es.Respuesta;
import com.mibanco.clientefic.es.dao.entity.SecretoEntity;
import com.mibanco.clientefic.es.services.command.consumer.GestorSecretosCommand;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Singleton
public class ConnectionDB {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ConnectionDB.class);
    @ConfigProperty(name = "usuarioDB")
    String usuarioDB;

    @ConfigProperty(name = "passwordDB")
    String passwordDB;
    @ConfigProperty(name = "nombreBaul")
    String nombreBaul;

    @ConfigProperty(name = "stringConexion")
    String stringConexion;

    @Inject
    GestorSecretosCommand gestorSecretosCommand;

    public Connection getConnection() throws SQLException {
        LOG.info("Inicia getConnection");
        //asignar el usuario con el gestor de secretos
        SecretoEntity usuario = new SecretoEntity();
        usuario.setNombreBaul(nombreBaul);
        usuario.setNombreSecreto(usuarioDB);
        Respuesta user = (Respuesta) gestorSecretosCommand.execute(usuario);

        //asignar el password con el gestor de secretos
        SecretoEntity password = new SecretoEntity();
        password.setNombreBaul(nombreBaul);
        password.setNombreSecreto(passwordDB);
        Respuesta pass = (Respuesta) gestorSecretosCommand.execute(password);

        //asignar string de conexion con el gestor de secretos
        SecretoEntity stringCon = new SecretoEntity();
        stringCon.setNombreBaul(nombreBaul);
        stringCon.setNombreSecreto(stringConexion);
        Respuesta stringConexion = (Respuesta) gestorSecretosCommand.execute(stringCon);

        try {
            return DriverManager.getConnection(stringConexion.getSecreto(), user.getSecreto(), pass.getSecreto());
        } catch (Exception e) {
            LOG.error("Error al obtener la conexión a la base de datos" + e.getMessage());
            throw new SQLException("Error al obtener la conexión a la base de datos");
        }

    }
}
