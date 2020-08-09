package interfaces;

import java.sql.Connection;

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
    
    /**
     * Este metodo se encarga de crear una conexion con la base de datos requerida.
     * @return El retorno de este metodo dara el objeto de conexion.
     */
    public abstract Connection conectar();

    /**
     * Este metodo se encarga de desconectar la base de datos que se encuentre trabajando en ese momento.
     */
    public abstract void desconectar();

    /**
     * Este metodo es la aplicacion del patron Singleton e cual hace que sea el unico responsable de tener la instancia.
     * @return La instancia de la propia clase.
     */
    public abstract Conexion getConexion();
}
