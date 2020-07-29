package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase se encargara de realizar la conexion con el servidor que almacena
 * los datos de la base de datos del programa
 *
 * @author Juan David Neisa, Andres Ramirez y Jorge Escobar
 */
public class conexion {

    // Librería de MySQL
    String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    String database = "patrones_sql";

    // Host
    String hostname = "localhost";

    // Puerto
    String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    String username = "juan";

    // Clave de usuario
    String password = "Napsmaster_990517";

    public Connection conectar() {
        
        Connection conn = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

}
