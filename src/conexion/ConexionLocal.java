package conexion;

import interfaces.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase se encargara de realizar la Conexion LOCAL con el servidor que
 * almacena los datos de la base de datos del programa
 *
 * @author patrones
 */
public class ConexionLocal extends Conexion {

    // Librería de MySQL
    static String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    static String database = "patrones_sql";

    // Host
    static String hostname = "localhost";

    // Puerto
    static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    static String username = "juan";

    // Clave de usuario
    static String password = "Napsmaster_990517";

    //Objeto para poder parametrizar la conexion a otras clases
    private static Connection conexion = null;
    
    @Override
    public Connection conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        return conexion;
    }
    
    @Override
     public void desconectar() {

        try {
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

     @Override
    public ConexionLocal getConexion() {
        return this;
    }
    
}
