package clases;

import java.sql.Date;

/**
 *
 * @author neisa
 */
public class Movimiento {
    
    //Identifica el movimiento mediante un numero. Hace parte de la llave primaria de la tabla Movimiento
    private int idMovimiento;
    //Identifica la llave primaria de la Bodega a la cual se le relacionara el movimiento. Hace parte de la llave primaria de la tabla Movimiento.
    private int idBodega;
    //Identifica la llave primaria de la Producto a la cual se le relacionara el movimiento. Hace parte de la llave primaria de la tabla Movimiento.
    private int idProducto;
    //Identifica la bodega a la cual llegara esta transaccion. (Opcional)
    private int idBodegaDestino;
    //Identifica el tipo de movimiento o transaccion
    private int idTipo;
    //Identifica la fecha de la transaccion
    private Date m_fecha;
    //Identifica la cantidad del producto que se realizo en la transaccion
    private int m_cantidad;
    //Identifica la persona la cual realizo el movimiento
    private int idPersona;

    public Movimiento() {
    }

    /***
     * Esta clase refleja un movimiento o transaccion dentro del sistemas de inventarios de la empresa. Es de las entidades mas complejas por o que tiene bastantes identificadores con llaves foraneas.
     * @param idMovimiento Identifica el movimiento mediante un numero. Hace parte de la llave primaria de la tabla Movimiento
     * @param idBodega Identifica la llave primaria de la Bodega a la cual se le relacionara el movimiento. Hace parte de la llave primaria de la tabla Movimiento.
     * @param idProducto Identifica la llave primaria de la Producto a la cual se le relacionara el movimiento. Hace parte de la llave primaria de la tabla Movimiento.
     * @param idBodegaDestino Identifica la bodega a la cual llegara esta transaccion. (Opcional)
     * @param idTipo Identifica el tipo de movimiento o transaccion
     * @param m_fecha Identifica la fecha de la transaccion
     * @param m_cantidad Identifica la cantidad del producto que se realizo en la transaccion
     * @param idPersona Identifica la persona la cual realizo el movimiento
     */
    public Movimiento(int idMovimiento, int idBodega, int idProducto, int idBodegaDestino, int idTipo, Date m_fecha, int m_cantidad, int idPersona) {
        this.idMovimiento = idMovimiento;
        this.idBodega = idBodega;
        this.idProducto = idProducto;
        this.idBodegaDestino = idBodegaDestino;
        this.idTipo = idTipo;
        this.m_fecha = m_fecha;
        this.m_cantidad = m_cantidad;
        this.idPersona = idPersona;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
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

    public int getIdBodegaDestino() {
        return idBodegaDestino;
    }

    public void setIdBodegaDestino(int idBodegaDestino) {
        this.idBodegaDestino = idBodegaDestino;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public Date getM_fecha() {
        return m_fecha;
    }

    public void setM_fecha(Date m_fecha) {
        this.m_fecha = m_fecha;
    }

    public int getM_cantidad() {
        return m_cantidad;
    }

    public void setM_cantidad(int m_cantidad) {
        this.m_cantidad = m_cantidad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", idBodega=" + idBodega + ", idProducto=" + idProducto + ", idBodegaDestino=" + idBodegaDestino + ", idTipo=" + idTipo + ", m_fecha=" + m_fecha + ", m_cantidad=" + m_cantidad + ", idPersona=" + idPersona + '}';
    }
    
}
