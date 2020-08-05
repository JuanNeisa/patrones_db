package clases;

/**
 * @author neisa
 */
public class Tipo {
    
    private int idTipo;
    private String t_descripcion;

    public Tipo() {
    }

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
    
    
    
}
