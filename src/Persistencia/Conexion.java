/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author piriv
 */
public abstract class Conexion {
    protected Connection con = null;
    protected ResultSet res = null;
    protected Statement sent = null;
    
    private final String user = "root";
    private final String password = "root";
    private String database = "negocioCris";
    
    protected void coneccion(){
        try {
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            con = DriverManager.getConnection(urlBaseDeDatos, user, password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("No conectado");
            e.printStackTrace();
        }
        
    }
    
    protected void desconexion(){
        try {
            if (res != null) {
                res.close();
            }
            if (sent != null){
                sent.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Desconectado");
        } catch (Exception e) {
            System.err.println("Error de desconexion");
            e.printStackTrace();
        }
    }
    
    protected void consultarBase(String sql) {
        try {
            coneccion();
            sent = con.createStatement();
            res = sent.executeQuery(sql);            
        } catch (Exception e) {
            System.out.println("Error de consulta");
            e.printStackTrace();
        }
    }
    
    protected void eliminarModificarCrear(String sql){
        try {
            coneccion();
            sent = con.createStatement();
            sent.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error en el UPDATE");
            e.printStackTrace();
        }
    }
}

