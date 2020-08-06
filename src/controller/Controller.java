package controller;

import DAO.BodegaDAO;
import clases.Bodega;
import conexion.ConexionLocal;
import conexion.ConexionRemota;
import interfaces.Conexion;

/**
 *
 * @author neisa
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creacion del tipo de conexion
        Conexion conn = new ConexionLocal();
        
        //Creacion de la implementacion sobre el CRUD de una Bodega
        BodegaDAO imple_bodega = new BodegaDAO(conn);

        //Creacion de una bodega      
        Bodega bodega = new Bodega(1, "Algun lugar del mundo", 1111);
        
        //Sentencia para crear una bodega dentro de la BD        
        imple_bodega.crear(bodega);
        
        //Sentencia para listar todas las bodegas existetes en la BD
        System.out.println(imple_bodega.Listar());
        
        //Sentencia para buscar una bodega en especial
        System.out.println(imple_bodega.BuscarPor(bodega));

        //Sentencia para actualizar una base de datos
        imple_bodega.actualizar(bodega);
        
        //Sentencia para eliminar una bodega
        imple_bodega.eliminar(bodega);
        
    }

}
