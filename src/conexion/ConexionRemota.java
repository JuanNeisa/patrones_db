package conexion;

import interfaces.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encargara de realizar la Conexion REMOTA con el servidor que almacena los datos de la base de datos del programa
 * @author patrones
 */
public class ConexionRemota implements Conexion{

    // Librería de MySQL
    //static String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    //static String database = "patrones_sql";

    // Host
    //static String hostname = "localhost";

    // Puerto
    //static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    //static String username = "juan";

    // Clave de usuario
    //static String password = "Napsmaster_990517";

    //Objeto para poder parametrizar la conexion a otras clases
    //static Connection conexion = null;
    
    @Override
    public void conectar() {
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void desconectar() {
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
