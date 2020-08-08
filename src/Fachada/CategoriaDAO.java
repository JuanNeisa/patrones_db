package Fachada;

import clases.Categoria;
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
public class CategoriaDAO implements CRUD {

    private Conexion tipoConexion = null;

    public CategoriaDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Categoria Where idCategoria = " + parametro + ";";

        String rta = null;

        try {
            Categoria categoria = new Categoria();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setCt_descripcion(rs.getString("ct_descripcion"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return categoria;
        } catch (SQLException e) {
            System.err.println("ERROR_CategoriaDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Categoria categoria = (Categoria) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Categoria "
                + "SET ct_descripcion  = ?, "
                + " WHERE Categoria.idCategoria = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, categoria.getCt_descripcion());
            ps.setInt(2, categoria.getIdCategoria());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del CARGO actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_CategoriaDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Categoria categoria = (Categoria) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (categoria != null) {
                String sql = "DELETE FROM Categoria WHERE idCategoria = ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, categoria.getIdCategoria());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Categoria eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_CategoriaDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Categoria categoria = (Categoria) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Categoria"
                + "(idCategoria, ct_descripcion) VALUES"
                + "(?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getCt_descripcion());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Categoria agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_CategoriaDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();
        
        ArrayList listaCategorias = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Categoria ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setCt_descripcion(rs.getString("ct_descripcion"));
                
                listaCategorias.add(categoria);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaCategorias;
        } catch (SQLException e) {
        System.err.println("ERROR_CategoriaDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
