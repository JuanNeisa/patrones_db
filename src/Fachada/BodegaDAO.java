package Fachada;

import clases.Bodega;
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
public class BodegaDAO implements CRUD {

    private Conexion tipoConexion = null;

    public BodegaDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BODEGA Where idBodega = " + parametro + ";";

        String rta = null;

        try {
            Bodega bodega = new Bodega();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                bodega.setIdBodega(rs.getInt("idBodega"));
                bodega.setB_ubicacion(rs.getString("b_ubicacion"));
                bodega.setB_capacidad(rs.getInt("b_capacidad"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return bodega;
        } catch (SQLException e) {
            System.err.println("ERROR_BodegaDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Bodega bodega = (Bodega) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Bodega "
                + "SET b_ubicacion  = ?, "
                + "b_capacidad  = ?"
                + " WHERE Bodega.idBodega = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, bodega.getB_ubicacion());
            ps.setInt(2, bodega.getB_capacidad());
            ps.setInt(3, bodega.getIdBodega());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos de la BODEGA actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_BodegaDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Bodega bodega = (Bodega) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (bodega != null) {
                String sql = "DELETE FROM Bodega WHERE idBodega= ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, bodega.getIdBodega());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Bodega eliminada exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_BodegaDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Bodega bodega = (Bodega) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Bodega"
                + "(idBodega, b_ubicacion, b_capacidad) VALUES"
                + "(?,?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, bodega.getIdBodega());
            ps.setString(2, bodega.getB_ubicacion());
            ps.setInt(3, bodega.getB_capacidad());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Bodega agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_BodegaDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();
        
        ArrayList listaBodegas = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BODEGA ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Bodega bodega = new Bodega();
                bodega.setIdBodega(rs.getInt("idBodega"));
                bodega.setB_ubicacion(rs.getString("b_ubicacion"));
                bodega.setB_capacidad(rs.getInt("b_capacidad"));
                listaBodegas.add(bodega);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaBodegas;
        } catch (SQLException e) {
            System.err.println("ERROR_BodegaDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
