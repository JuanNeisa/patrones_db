package Fachada;

import clases.Tipo;
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
public class TipoDAO implements CRUD {

    private Conexion tipoConexion = null;

    public TipoDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        
       Connection conn = tipoConexion.conectar();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Tipo Where idTipo = " + parametro + ";";

        String rta = null;

        try {
            Tipo tipo = new Tipo();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setT_descripcion(rs.getString("t_descripcion"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return tipo;
        } catch (SQLException e) {
            System.err.println("ERROR_TipoDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        Connection conn = tipoConexion.conectar();

        Tipo tipo = (Tipo) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Tipo "
                + "SET t_descripcion  = ?, "
                + " WHERE Tipo.idTipo = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, tipo.getT_descripcion());
            ps.setInt(2, tipo.getIdTipo());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del Tipo actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_TipoDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        Connection conn = tipoConexion.conectar();

        Tipo tipo = (Tipo) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (tipo != null) {
                String sql = "DELETE FROM Tipo WHERE idTipo = ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, tipo.getIdTipo());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Tipo eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_TipoDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        Connection conn = tipoConexion.conectar();

        Tipo tipo = (Tipo) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Tipo"
                + "(idTipo, t_descripcion) VALUES"
                + "(?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, tipo.getIdTipo());
            ps.setString(2, tipo.getT_descripcion());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Tipo agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_TipoDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        Connection conn = tipoConexion.conectar();
        
        ArrayList listaTipos = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Tipo ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setT_descripcion(rs.getString("t_descripcion"));
                
                listaTipos.add(tipo);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaTipos;
        } catch (SQLException e) {
        System.err.println("ERROR_TipoDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
