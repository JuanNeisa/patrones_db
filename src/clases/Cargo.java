package clases;

/**
 * @author patrones
 */
public class Cargo {
    
    //Identifica la llave primaria para la tabla cargo
    private int idCargo;
    //Describe el cargo que podria utilizar un trabajor representado como tabla de la forma: Persona.
    private String c_descripcion;

    public Cargo() {
    }

    /**
     * @param idCargo Identifica la llave primaria para la tabla cargo
     * @param c_descripcion Describe el cargo que podria utilizar un trabajor representado como tabla de la forma: Persona.
     */
    public Cargo(int idCargo, String c_descripcion) {
        this.idCargo = idCargo;
        this.c_descripcion = c_descripcion;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", c_descripcion=" + c_descripcion + '}';
    }
    
}
