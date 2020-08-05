package interfaces;

import java.util.ArrayList;

/**
 * @author patrones
 */
public interface CRUD {

    public ArrayList<Object> Listar();
    public Object BuscarPor(Object parametro);
    public boolean actualizar(Object obj_actualizar);
    public boolean eliminar(Object obj_eliminar);
    public boolean crear(Object obj_crear);
}
