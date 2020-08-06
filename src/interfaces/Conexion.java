package interfaces;

import java.sql.Connection;

/**
 * @author patrones
 */
public interface Conexion {
    
    public void conectar();
    public void desconectar();
    public Connection getConexion();
}
