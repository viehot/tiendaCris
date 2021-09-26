/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entity.Producto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author piriv
 */
public class ConProducto extends Conexion {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

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

    public void viewProducto(ArrayList<Producto> p) {
        p.forEach(System.out::println);
        desconexion();
    }

    public String crearProducto() {
        System.out.println("Crear producto");
        String nombre = wrNombre();
        int stock = wrStock();
        double precio = wrPrecio();
        String descripcion = wrDescripcion();
        String sql = "INSERT INTO producto VALUES (DEFAULT,'" + nombre + "'," + stock + "," + precio + ",'" + descripcion + "', 2 )";

        return sql;
    }

    public String wrNombre() {
        System.out.println("Ingresar nombre");
        return read.next();
    }

    public int wrStock() {
        System.out.println("Ingresar stock");
        return read.nextInt();
    }

    public double wrPrecio() {
        System.out.println("Ingresar precio");
        return read.nextDouble();
    }

    public String wrDescripcion() {
        System.out.println("Ingresar descripcion");
        return read.next();
    }

    public void newProd(String sql) {
        eliminarModificarCrear(sql);
        desconexion();
    }

    public void elimProd(int numero) {
        try {
            System.out.println("Este es el numero "+numero);
            if (numero != 0) {
                String sql = "DELETE FROM producto WHERE id = " + numero + "";
                eliminarModificarCrear(sql);
                desconexion();
            } else {
                System.out.println("No se encontro");
            }
        } catch (Exception e) {
            System.out.println("Error. Eliminar producto");
            e.printStackTrace();
        }

    }

    public String searchPorNombre(String nombre) {
        String sql = "SELECT * FROM producto WHERE nombre ='" + nombre + "'";
        return sql;
    }

    public int searchProducto(String sql) {
        try {
            int numero = 0;
            consultarBase(sql);
            if (res != null) {
                res.next();
                numero = res.getInt(1);
                return numero;
            } else {
                return numero;
            }
        } catch (Exception e) {
            System.out.println("ERROR. Cargar id");
            e.printStackTrace();
            return 0;
        }

    }
    
    public void changePro(int id, double precio){
        try {
            String sql = "UPDATE producto SET precio = "+precio+" WHERE id = "+id;
            eliminarModificarCrear(sql);
            desconexion();
        } catch (Exception e) {
            System.out.println("Error. No se pudo cambiar");
            e.printStackTrace();
        }
        
    }
}
