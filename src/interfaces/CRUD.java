package interfaces;

import java.util.ArrayList;

/**
 * @author patrones
 */
public interface CRUD {

    /**
     * El metodo listar retorna las inserciones de una tabla dentro de la Base de Datos
     * @return ArrayList que contiene las inserciones tal cual aparece en una consulta
     */
    public ArrayList<Object> Listar();
    
    /**
     * Este metodo realiza la busqueda por parametro y retorna un unico objeto con el reultado. Si no se encuentra nada en la busqueda el retorno sera un 'null'
     * @param parametro Este es el elemento por el cual se va a realizar la consulta
     * @return Si la busqueda es exitosa el objeto del tipo de la clase implementada, de lo contrario 'null'
     */
    public Object BuscarPor(Object clave);
    
    /**
     * Este metodo realiza la actualizacion de una de las inserciones de la tabla en la base de datos utilizando como parametro para la busqueda la llave primaria de la tabla
     * @param obj_actualizar Objeto que sera actualizando utilizando su clave primaria o identificador
     * @return Si el proceso fue exitoso retorna 'True', de lo contrario 'False'
     */
    public boolean actualizar(Object obj_actualizar);
    
    /**
     * Este metodo se encarga de eliminar una insercion en la tabla seleccionada utilizando por el parametro como filtrode busqueda
     * @param obj_eliminar Objeto el cual sera eliminado de la base de datos
     * @return Si el proceso fue exitoso retorna 'True', de lo contrario 'False'
     */
    public boolean eliminar(Object obj_eliminar);
    
    /**
     * Este metodo realiza una insercion en la tabla.
     * @param obj_crear Objeto el cual se realizara la insercion en la base de datos
     * @return Si el proceso fue exitoso retorna 'True', de lo contrario 'False'
     */
    public boolean crear(Object obj_crear);
}
