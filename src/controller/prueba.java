/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Fachada.BodegaDAO;
import conexion.ConexionRemota;
import interfaces.Conexion;
import java.sql.SQLException;


/**
 *
 * @author neisa
 */
public class prueba {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
public static void main(String[] args){
        
        BodegaDAO b = new BodegaDAO(new ConexionRemota());
        System.err.println(b.Listar());
    }
    
}


