package clases;

/**
 * @author patrones
 */
public class Categoria {
    
    //Identfica la llave primaria de la tabla Categoria
    private int idCategoria;
    //Identifica el nombre de la categoria 
    private String ct_descripcion;

    public Categoria() {
    }
    
    /**
     *Este constructor reune todos los parametros necesarios para crear un Proveedor segun la BD
     * @param idCategoria Identfica la llave primaria de la tabla Categoria
     * @param ct_descripcion Identifica el nombre de la categoria
     */
    public Categoria(int idCategoria, String ct_descripcion) {
        this.idCategoria = idCategoria;
        this.ct_descripcion = ct_descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCt_descripcion() {
        return ct_descripcion;
    }

    public void setCt_descripcion(String ct_descripcion) {
        this.ct_descripcion = ct_descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", ct_descripcion=" + ct_descripcion + '}';
    }
}
