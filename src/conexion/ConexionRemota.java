package conexion;

import interfaces.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encargara de realizar la Conexion LOCAL con el servidor que
 * almacena los datos de la base de datos del programa
 *
 * @author patrones
 */
public class ConexionRemota extends Conexion{

    // Librería de MySQL
    static String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    static String database = "patrones_sql";

    // Host
    static String hostname = "db4free.net";

    // Puerto
    static String port = "3306";

    // Nombre de usuario
    static String username = "patrones";

    // Clave de usuario
    static String password = "Proyecto-123";
//Objeto para poder parametrizar la conexion a otras clases
        Connection conexion = null;
        
    @Override
    public Connection conectar() {
        
        if (conexion == null) {
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"+database, username, password);
            } catch (SQLException ex) {
                try {
                    throw new SQLException(ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(ConexionRemota.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
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
    public ConexionRemota getConexion() {
        return this;
    }

}
