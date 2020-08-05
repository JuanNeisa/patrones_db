package clases;

/**
 * @author neisa
 */
public class Tipo {
    
    //Identifica la llave primaria de la tabla Tipo
    private int idTipo;
    //Describe el tipo de movimiento que se podria realizar
    private String t_descripcion;

    public Tipo() {
    }

    /**
     * Representa los tipos de movimientos que pueden existir dentro del esquema de la BD
     * @param idTipo Identifica la llave primaria de la tabla Tipo
     * @param t_descripcion Describe el tipo de movimiento que se podria realizar
     */
    public Tipo(int idTipo, String t_descripcion ) {
        this.idTipo = idTipo;
        this.t_descripcion = t_descripcion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getT_descripcion() {
        return t_descripcion;
    }

    public void setT_descripcion(String t_descripcion) {
        this.t_descripcion = t_descripcion;
    }

    @Override
    public String toString() {
        return "Tipo{" + "idTipo=" + idTipo + ", t_descripcion=" + t_descripcion + '}';
    }
    
}
