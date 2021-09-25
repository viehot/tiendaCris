/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author piriv
 */
public class Conexion {
    private Connection con = null;
    private ResultSet res = null;
    private Statement sent = null;
    
    private final String user = "root";
    private final String password = "root";
    private String database = "negocioCris";
    
    public void coneccion(){
        try {
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            con = DriverManager.getConnection(urlBaseDeDatos, user, password);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
            e.printStackTrace();
        }
        
    }
}

