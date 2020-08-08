package Fachada;

import clases.Producto;
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
public class ProductoDAO implements CRUD {

    private Conexion tipoConexion = null;

    public ProductoDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Producto Where idProducto = " + parametro + ";";

        String rta = null;

        try {
            Producto producto = new Producto();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setP_nombre(rs.getString("p_nombre"));
                producto.setP_marca(rs.getString("p_marca"));
                producto.setIdCategoria(rs.getInt("Categoria_idCategor"));
                producto.setIdProveedor(rs.getInt("Proveedor_idProveedor"));
                
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return producto;
        } catch (SQLException e) {
            System.err.println("ERROR_ProductoDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Producto producto = (Producto) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Producto "
                + "SET p_nombre  = ?, "
                + "p_marca  = ?"
                + "Categoria_idCategoria  = ?"
                + "Proveedor_idProveedor  = ?"
                + " WHERE Producto.idProducto = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, producto.getP_nombre());
            ps.setString(2, producto.getP_marca());
            ps.setInt(3, producto.getIdCategoria());
            ps.setInt(4, producto.getIdProveedor());
            ps.setInt(5, producto.getIdProducto());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del PRODUCTO actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_ProductoDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Producto producto = (Producto) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (producto != null) {
                String sql = "DELETE FROM Producto WHERE idProducto= ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, producto.getIdProducto());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Producto eliminada exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_ProductoDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Producto producto = (Producto) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Producto"
                + "(idProducto, p_nombre, p_marca, Categoria_idCategoria, Proveedor_idPoveedor) VALUES"
                + "(?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, producto.getIdProducto());
            ps.setString(2, producto.getP_nombre());
            ps.setString(3, producto.getP_marca());
            ps.setInt(4, producto.getIdCategoria());
            ps.setInt(5, producto.getIdProveedor());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Producto agregado exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_ProductoDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();
        
        ArrayList listaProductos = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Producto ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setP_nombre(rs.getString("p_nombre"));
                producto.setP_marca(rs.getString("p_marca"));
                producto.setIdCategoria(rs.getInt("Categoria_idCategor"));
                producto.setIdProveedor(rs.getInt("Proveedor_idProveedor"));
                
                listaProductos.add(producto);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaProductos;
        } catch (SQLException e) {
            System.err.println("ERROR_ProductoDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
