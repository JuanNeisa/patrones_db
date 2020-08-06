package clases;

/**
 * @author patrones
 */
public class Bodega {
    //Identifica la lave primaria de la tabla Bodega
    private int idBodega;
    //Identifica la ubicacion de la bodega
    private String b_ubicacion;
    //Identifica la capacidad de almacenamiento que tiene la bodega
    private int b_capacidad;

    public Bodega() {
    }
    
    /**
     * Genera un objeto Bogeda con los parametros descritos en la Base de Datos
     * @param idBodega Identifica la lave primaria de la tabla Bodega
     * @param b_ubicacion Identifica la ubicacion de la bodega
     * @param b_capacidad Identifica la capacidad de almacenamiento que tiene la bodega
    */
    public Bodega(int idBodega, String b_ubicacion, int b_capacidad) {
        this.idBodega = idBodega;
        this.b_ubicacion = b_ubicacion;
        this.b_capacidad = b_capacidad;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getB_ubicacion() {
        return b_ubicacion;
    }

    public void setB_ubicacion(String b_ubicacion) {
        this.b_ubicacion = b_ubicacion;
    }

    public int getB_capacidad() {
        return b_capacidad;
    }

    public void setB_capacidad(int b_capacidad) {
        this.b_capacidad = b_capacidad;
    }

    @Override
    public String toString() {
        return "Bogeda{" + "idBodega=" + idBodega + ", b_ubicacion=" + b_ubicacion + ", b_capacidad=" + b_capacidad + '}';
    }
}
