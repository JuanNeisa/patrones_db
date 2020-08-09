package Fachada;

import clases.Movimiento;
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
public class MovimientoDAO implements CRUD {

    private Conexion tipoConexion = null;

    public MovimientoDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        Connection conn = tipoConexion.conectar();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Movimiento Where idMovimiento = " + parametro + ";";

        String rta = null;

        try {
            Movimiento movimiento = new Movimiento();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                movimiento.setIdMovimiento(rs.getInt("idMovimiento"));
                movimiento.setIdBodega(rs.getInt("Bodega_idMovimiento"));
                movimiento.setIdProducto(rs.getInt("Producto_idProducto"));
                movimiento.setIdBodegaDestino(rs.getInt("Bodega_idBodegaDestino"));
                movimiento.setIdTipo(rs.getInt("Tipo_idTipo"));
                movimiento.setM_fecha(rs.getDate("n_fecha"));
                movimiento.setM_cantidad(rs.getInt("m_cantidad"));
                movimiento.setIdPersona(rs.getInt("Persona_idPersona"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return movimiento;
        } catch (SQLException e) {
            System.err.println("ERROR_MovimientoDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        Connection conn = tipoConexion.conectar();

        Movimiento movimiento = (Movimiento) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Movimiento "
                + "SET Bodega_idBodega  = ?, "
                + "Producto_idProducto  = ?"
                + "Bodega_idBodegaDestino  = ?"
                + "Tipo_idTipo  = ?"
                + "m_fecha  = ?"
                + "m_cantidad  = ?"
                + "Persona_idPersona  = ?"
                + " WHERE Movimiento.idMovimiento = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, movimiento.getIdBodega());
            ps.setInt(2, movimiento.getIdProducto());
            ps.setInt(3, movimiento.getIdBodegaDestino());
            ps.setInt(4, movimiento.getIdTipo());
            ps.setDate(5, movimiento.getM_fecha());
            ps.setInt(6, movimiento.getM_cantidad());
            ps.setInt(7, movimiento.getIdPersona());
            ps.setInt(8, movimiento.getIdMovimiento());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos del Movimiento actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_MovimientoDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        Connection conn = tipoConexion.conectar();

        Movimiento movimiento = (Movimiento) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (movimiento != null) {
                String sql = "DELETE FROM Movimiento WHERE idMovimiento= ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, movimiento.getIdMovimiento());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Movimiento eliminado exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_BodegaDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        Connection conn = tipoConexion.conectar();

        Movimiento movimiento = (Movimiento) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Movimiento"
                + "(idMovimiento, Bodega_idBodega, Producto_idProducto, Bodega_idBodegaDestino,Tipo_idTipo,m_fecha,m_cantidad,Persona_idPersona) VALUES"
                + "(?,?,?,?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, movimiento.getIdMovimiento());
            ps.setInt(2, movimiento.getIdBodega());
            ps.setInt(3, movimiento.getIdProducto());
            ps.setInt(3, movimiento.getIdBodegaDestino());
            ps.setInt(1, movimiento.getIdTipo());
            ps.setDate(2, movimiento.getM_fecha());
            ps.setInt(3, movimiento.getM_cantidad());
            ps.setInt(3, movimiento.getIdPersona());

            ps.executeUpdate();
            registrar = true;
            System.out.println("Movimiento agregado exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_MovimientoDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        
        Connection conn = tipoConexion.conectar();
        
        ArrayList listaMovimientos = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Movimiento ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setIdMovimiento(rs.getInt("idMovimiento"));
                movimiento.setIdBodega(rs.getInt("Bodega_idBodega"));
                movimiento.setIdProducto(rs.getInt("Producto_idProducto"));
                movimiento.setIdBodegaDestino(rs.getInt("Bodega_idBodegaDestino"));
                movimiento.setIdTipo(rs.getInt("Tipo_idTipo"));
                movimiento.setM_fecha(rs.getDate("m_fecha"));
                movimiento.setM_cantidad(rs.getInt("m_cantidad"));
                movimiento.setIdPersona(rs.getInt("Persona_idPersona"));
                listaMovimientos.add(movimiento);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaMovimientos;
        } catch (SQLException e) {
            System.err.println("ERROR_MovimientoDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
