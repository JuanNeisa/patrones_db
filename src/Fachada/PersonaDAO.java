package Fachada;

import clases.Persona;
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
public class PersonaDAO implements CRUD {

    private Conexion tipoConexion = null;

    public PersonaDAO(Conexion conexion) {
        this.tipoConexion = conexion;
    }

    @Override
    public Object BuscarPor(Object parametro) {
        Connection conn = tipoConexion.conectar();

        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Persona Where idPersona = " + parametro + ";";

        String rta = null;

        try {
            Persona persona = new Persona();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setP_contra(rs.getString("p_contra"));
                persona.setIdCargo(rs.getInt("Cargo_idCargo"));
                persona.setP_nombre(rs.getString("p_nombre"));
                persona.setP_celular(rs.getInt("p_celular"));
                persona.setIdJefe(rs.getInt("idJefe"));
                persona.setIdBodega(rs.getInt("Bodega_idBodega"));
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return persona;
        } catch (SQLException e) {
            System.err.println("ERROR_PersonaDao.buscarPor: \n" + e.getMessage());
        }
        return rta;
    }

    @Override
    public boolean actualizar(Object obj_actualizar) {
        Connection conn = tipoConexion.conectar();

        Persona persona = (Persona) obj_actualizar;
        PreparedStatement ps = null;
        boolean actualizar = false;
        String sql = "UPDATE Persona "
                + "SET p_contra  = ?, "
                + "Cargo_idCargo  = ?"
                + "p_nombre  = ?"
                + "p_celular  = ?"
                + "idJefe  = ?"
                + "Bodega_idBodega  = ?"
                + " WHERE Persona.idPersona = ?;";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, persona.getP_contra());
            ps.setInt(2, persona.getIdCargo());
            ps.setString(3, persona.getP_nombre());
            ps.setInt(4, persona.getP_celular());
            ps.setInt(5, persona.getIdJefe());
            ps.setInt(6, persona.getIdBodega());
            ps.setInt(7, persona.getIdPersona());

            ps.executeUpdate();
            actualizar = true;
            System.out.println("Datos de la Persona actualizados exitosamente");
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_PersonaDao.actualizar: \n" + e.getMessage());
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Object obj_eliminar) {
        Connection conn = tipoConexion.conectar();

        Persona persona = (Persona) obj_eliminar;
        PreparedStatement ps = null;
        boolean borrar = false;

        try {
            if (persona != null) {
                String sql = "DELETE FROM Persona WHERE idPersona= ?;";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, persona.getIdPersona());
                ps.executeUpdate();
                borrar = true;
                System.out.println("Persona eliminada exitosamente");
            }
            tipoConexion.desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR_PersonaDao.borrar: \n" + e.getMessage());
        }
        return borrar;
    }

    @Override
    public boolean crear(Object obj_crear) {

        Connection conn = tipoConexion.conectar();

        Persona persona = (Persona) obj_crear;
        boolean registrar = false;

        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO Persona"
                + "(idPersona, p_contra, Cargo_idCargo,p_nombre,p_celular,idJefe,Bodega_idBodega) VALUES"
                + "(?,?,?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(insertTableSQL);

            ps.setInt(1, persona.getIdPersona());
            ps.setString(2, persona.getP_contra());
            ps.setInt(3, persona.getIdCargo());
            ps.setString(4, persona.getP_nombre());
            ps.setInt(5, persona.getP_celular());
            ps.setInt(6, persona.getIdJefe());
            ps.setInt(7, persona.getIdBodega());
            

            ps.executeUpdate();
            registrar = true;
            System.out.println("Perona o Trabajador agregada exitosamente");
            tipoConexion.desconectar();

        } catch (Exception e) {
            System.err.println("ERROR_PersonaDao.Registrar: \n" + e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<Object> Listar() {
        Connection conn = tipoConexion.conectar();
        
        ArrayList listaPersonas = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Persona ;";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setP_contra(rs.getString("p_contra"));
                persona.setIdCargo(rs.getInt("Cargo_idCargo"));
                persona.setP_nombre(rs.getString("p_nombre"));
                persona.setP_celular(rs.getInt("p_celular"));
                persona.setIdJefe(rs.getInt("idJefe"));
                persona.setIdBodega(rs.getInt("Bodega_idBodega"));
                listaPersonas.add(persona);
            }
            stm.close();
            rs.close();
            tipoConexion.desconectar();
            return listaPersonas;
        } catch (SQLException e) {
            System.err.println("ERROR_PersonasDao.listar: \n" + e.getMessage());
        }
        return null;
    }

}
