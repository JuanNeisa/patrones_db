package clases;

/** 
 * @author patrones
 */
public class Proveedor {
    //Identifica la llave primaria de la tabla de proveedores
    private int idProveedor ;
    //Identifica el nombre de la empresa u organizacion del proveedor
    private String p_nombre;

    
    public Proveedor() {
    }
    
    /**
     * Este constructor reune todos los parametros necesarios para crear un Proveedor segun la BD
     * @param idProveedor Identifica la llave primaria de la tabla de proveedores
     * @param p_nombre Identifica el nombre de la empresa u organizacion del proveedor
     */
    public Proveedor(int idProveedor, String p_nombre) {
        this.idProveedor = idProveedor;
        this.p_nombre = p_nombre;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", p_nombre=" + p_nombre + '}';
    }
    
    
}
