package clases;

import java.sql.Date;

/**
 * @author patrones
 */
public class Inventario {
    
    //Identifica la llave primaria de la tabla Bodega. Tambien hace parte de la llave primaria compuesta de la tabla Inventario
    private int idBodega;
    //Identifica la llave primaria de la tabla Producto. Tambien hace parte de la llave primaria compuesta de la tabla Inventario
    private int idProducto;
    //Identifica a cantidad de un producto en una unica bodega 
    private int i_cantidad;
    //Identifica la fecha de entrada al inventario de un producto dentro de una de las bodegas
    private Date i_fecha;
    //Identifica el estado del producto en una bodega
    private boolean i_estado;

    public Inventario() {
    }

    /**
     *Este constructor reune todos los parametros necesarios para crear el Inventario de las bodegas con sus productos. En el esquema de BD es la tabla de rompimiento entre Producto y Bodega
     * @param idBodega Identifica la llave primaria de la tabla Bodega. Tambien hace parte de la llave primaria compuesta de la tabla Inventario
     * @param idProducto Identifica la llave primaria de la tabla Producto. Tambien hace parte de la llave primaria compuesta de la tabla Inventario
     * @param i_cantidad Identifica a cantidad de un producto en una unica bodega 
     * @param i_fecha Identifica la fecha de entrada al inventario de un producto dentro de una de las bodegas
     * @param i_estado Identifica el estado del producto en una bodega
     */
    public Inventario(int idBodega, int idProducto, int i_cantidad, Date i_fecha, boolean i_estado) {
        this.idBodega = idBodega;
        this.idProducto = idProducto;
        this.i_cantidad = i_cantidad;
        this.i_fecha = i_fecha;
        this.i_estado = i_estado;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getI_cantidad() {
        return i_cantidad;
    }

    public void setI_cantidad(int i_cantidad) {
        this.i_cantidad = i_cantidad;
    }

    public Date getI_fecha() {
        return i_fecha;
    }

    public void setI_fecha(Date i_fecha) {
        this.i_fecha = i_fecha;
    }

    public boolean isI_estado() {
        return i_estado;
    }

    public void setI_estado(boolean i_estado) {
        this.i_estado = i_estado;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idBodega=" + idBodega + ", idProducto=" + idProducto + ", i_cantidad=" + i_cantidad + ", i_fecha=" + i_fecha + ", i_estado=" + i_estado + '}';
    }
}
