package Fachada;

import clases.Proveedor;
import interfaces.CRUD;
import interfaces.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author patrones
 */
public class ProveedorDAO implements CRUD {

    private Conexion tipoConexion = null;

    public ProveedorDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Proveedor Where idProveedor = " + parametro + ";";

        String rta = null;

        try {
            Proveedor proveedor = new Proveedor();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setP_nombre(rs.getString("p_nombre"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return proveedor;
        } catch (SQLException e) {
            System.err.println("ERROR_ProveedorDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Proveedor proveedor = (Proveedor) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Proveedor "
                + "SET p_nombre  = ?, "
                + " WHERE Proveedor.idProveedor = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, proveedor.getP_nombre());
            ps.setInt(2, proveedor.getIdProveedor());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del CARGO actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_ProveedorDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Proveedor proveedor = (Proveedor) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (proveedor != null) {
                String sql = "DELETE FROM Proveedor WHERE idProveedor = ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, proveedor.getIdProveedor());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Proveedor eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_ProveedorDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Proveedor proveedor = (Proveedor) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Proveedor"
                + "(idProveedor, p_nombre) VALUES"
                + "(?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, proveedor.getIdProveedor());
            ps.setString(2, proveedor.getP_nombre());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Proveedor agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_ProveedorDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();
        
        ArrayList listaProveedors = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Proveedor ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setP_nombre(rs.getString("p_nombre"));
                
                listaProveedors.add(proveedor);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaProveedors;
        } catch (SQLException e) {
        System.err.println("ERROR_ProveedorDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
