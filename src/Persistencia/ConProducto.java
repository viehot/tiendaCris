/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entity.Producto;
import java.util.ArrayList;

/**
 *
 * @author piriv
 */
public class ConProducto extends Conexion {

    public ArrayList<Producto> ListarProducto() {
        try {
            ArrayList<Producto> pros = new ArrayList();
            consultarBase(lisPro());
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
            return pros;
        } catch (Exception e) {
            System.out.println("Error. En elistar");
            e.printStackTrace();
            return null;
        }

    }

    public String lisPro() {
        return "SELECT * FROM producto";
    }
    
    public void viewProducto(ArrayList<Producto> p){
        p.forEach(System.out::println);
    }
}
