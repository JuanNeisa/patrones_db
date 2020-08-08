/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * @author patrones
 */
public class Producto {
    //Identifica la llave primaria de la tabla Producto
    private int idProducto;
    //Identifica el nombre del producto 
    private String p_nombre;
    //Identifica la categoria a la cual esta relacionada el producto
    private int idCategoria;
    //Identifica el proveedor del producto
    private int idProveedor;

    public Producto() {
    }
    /**
     * Este constructor reune todos los parametros necesarios para crear un Producto segun la BDS
     * @param idProducto Identifica la llave primaria de la tabla Producto
     * @param p_nombre Identifica el nombre del producto 
     * @param idCategoria Identifica la categoria a la cual esta relacionada el producto
     * @param idProveedor Identifica el proveedor del producto
    */
    public Producto(int idProducto, String p_nombre, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.p_nombre = p_nombre;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", p_nombre=" + p_nombre + ", idCategoria=" + idCategoria + ", idProveedor=" + idProveedor + '}';
    }
}