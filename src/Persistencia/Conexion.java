/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entity.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        } catch (SQLException e) {
            System.out.println("No conectado");
            e.printStackTrace();
        }
        
    }
    
    public void desconexion(){
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
    
    public void consultarBase() {
        try {
            String pro = "SELECT * FROM producto";
            sent = con.createStatement();
            res = sent.executeQuery(pro);
            ArrayList<Producto> pros = new ArrayList();
            while (res.next()) {
                Producto p = new Producto();
                p.setId(res.getInt(1));
                p.setNombre(res.getString(2));
                p.setStock(res.getInt(3));
                p.setPrecio(res.getDouble(4));
                p.setDescripcion(res.getString(5));
                p.setId_marca(res.getInt(6));
                pros.add(p);
            }
            
            pros.forEach(System.out::println);
            
        } catch (Exception e) {
            System.out.println("Error de consulta");
            e.printStackTrace();
        }
    }
}

