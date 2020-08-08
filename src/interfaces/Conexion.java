package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author patrones
 */
public abstract class Conexion {

    // Librería de MySQL
    static String driver;

    // Nombre de la base de datos
    static String database;

    // Host
    static String hostname;

    // Puerto
    static String port;

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    static String url;

    // Nombre de usuario
    static String username;

    // Clave de usuario
    static String password;

    //Objeto para poder parametrizar la conexion a otras clases
    private static Connection conexion = null;

    public abstract void conectar();

    public abstract void desconectar();

    public abstract Connection getConexion();
}
