package Fachada;

import clases.Cargo;
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
public class CargoDAO implements CRUD {

    private Conexion tipoConexion = null;

    public CargoDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Cargo Where idCargo = " + parametro + ";";

        String rta = null;

        try {
            Cargo cargo = new Cargo();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setC_descripcion(rs.getString("c_descripcion"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return cargo;
        } catch (SQLException e) {
            System.err.println("ERROR_CargoDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Cargo cargo = (Cargo) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Cargo "
                + "SET c_descripcion  = ?, "
                + " WHERE Cargo.idCargo = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, cargo.getC_descripcion());
            ps.setInt(2, cargo.getIdCargo());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del CARGO actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_CargoDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Cargo cargo = (Cargo) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (cargo != null) {
                String sql = "DELETE FROM Cargo WHERE idCargo = ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, cargo.getIdCargo());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Cargo eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_CargoDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();

        Cargo cargo = (Cargo) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Cargo"
                + "(idCargo, c_descripcion) VALUES"
                + "(?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, cargo.getIdCargo());
            ps.setString(2, cargo.getC_descripcion());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Cargo agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_CargoDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        tipoConexion.conectar();
        Connection conn = tipoConexion.getConexion();
        
        ArrayList listaCargos = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Cargo ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setC_descripcion(rs.getString("c_descripcion"));
                
                listaCargos.add(cargo);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaCargos;
        } catch (SQLException e) {
        System.err.println("ERROR_CargoDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
