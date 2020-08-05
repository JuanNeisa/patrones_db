package clases;

/**
 * @author patrones
 */
public class Persona {
    private int idPersona;
    private int idCargo;
    private String p_nombre;
    private int p_celular;
    private int idJefe;
    private int idBodega;

    public Persona() {
    }

    public Persona(int idPersona, int idCargo, String p_nombre, int p_celular, int idJefe, int idBodega) {
        this.idPersona = idPersona;
        this.idCargo = idCargo;
        this.p_nombre = p_nombre;
        this.p_celular = p_celular;
        this.idJefe = idJefe;
        this.idBodega = idBodega;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public int getP_celular() {
        return p_celular;
    }

    public void setP_celular(int p_celular) {
        this.p_celular = p_celular;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", idCargo=" + idCargo + ", p_nombre=" + p_nombre + ", p_celular=" + p_celular + ", idJefe=" + idJefe + ", idBodega=" + idBodega + '}';
    }
    
}
