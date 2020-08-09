package Fachada;

import clases.Inventario;
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
public class InventarioDAO implements CRUD {

    private Conexion tipoConexion = null;

    public InventarioDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        Connection conn = tipoConexion.conectar();

        Statement stm = null;
        ResultSet rs = null;

        Inventario inv = (Inventario)parametro; 
        String sql = "SELECT * FROM Inventario Where Bodega_idBodega = " + inv.getIdBodega() 
                + "and Producto_idProducto = "+ inv.getIdProducto() +";" ;

        String rta = null;

        try {
            Inventario inventario = new Inventario();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                inventario.setIdBodega(rs.getInt("Bodega_idBodega"));
                inventario.setIdProducto(rs.getInt("Producto_idProducto"));
                inventario.setI_cantidad(rs.getInt("i_cantidad"));
                inventario.setI_fecha(rs.getDate("i_fecha"));
                inventario.setI_estado(rs.getBoolean("i_estado"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return inventario;
        } catch (SQLException e) {
            System.err.println("ERROR_InventarioDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        Connection conn = tipoConexion.conectar();

        Inventario inventario = (Inventario) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Inventario "
                + "SET i_cantidad  = ?, "
                + "i_fecha  = ?"
                + "i_estado  = ?"
                + " WHERE Inventario.Bodega_idBodega = ? AND" 
                + " WHERE Inventario.Producto_idProducto = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, inventario.getI_cantidad());
            ps.setDate(2, inventario.getI_fecha());
            ps.setBoolean(3, inventario.isI_estado());
            ps.setInt(4, inventario.getIdBodega());
            ps.setInt(5, inventario.getIdProducto());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del INVENTARIO actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_InventarioDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        Connection conn = tipoConexion.conectar();

        Inventario inventario = (Inventario) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (inventario != null) {
                String sql = "DELETE FROM Inventario WHERE Bodega_idBodega = ? AND Producto_idProducto = ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, inventario.getIdBodega());
                ps.setInt(2, inventario.getIdProducto());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Inventario eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_InventarioDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        Connection conn = tipoConexion.conectar();

        Inventario inventario = (Inventario) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Inventario"
                + "(Bodega_idBodega,Producto_idProducto, i_cantidad, i_fecha, i_estado) VALUES"
                + "(?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, inventario.getIdBodega());
            ps.setInt(2, inventario.getIdProducto());
            ps.setInt(3, inventario.getI_cantidad());
            ps.setDate(4, inventario.getI_fecha());
            ps.setBoolean(5, inventario.isI_estado());
            
            ps.executeUpdate();
            registrar = true;
            System.out.println("Inventario agregado exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_InventarioDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        Connection conn = tipoConexion.conectar();
        
        ArrayList listaInventarios = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Inventario ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdBodega(rs.getInt("Bodega_idBodega"));
                inventario.setIdProducto(rs.getInt("Producto_idProducto"));
                inventario.setI_cantidad(rs.getInt("i_cantidad"));
                inventario.setI_fecha(rs.getDate("i_fecha"));
                inventario.setI_estado(rs.getBoolean("i_estado"));
                listaInventarios.add(inventario);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaInventarios;
        } catch (SQLException e) {
            System.err.println("ERROR_InventarioDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
