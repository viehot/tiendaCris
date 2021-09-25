package main;

import Persistencia.ConProducto;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piriv
 */
public class tiendacris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConProducto p = new ConProducto();
        
        p.viewProducto(p.ListarProducto());
        p.newProd(p.crearProducto());
        p.viewProducto(p.ListarProducto());
        p.elimProd(p.searchProducto(p.searchPorNombre(p.wrNombre())));
        p.viewProducto(p.ListarProducto());
    }
    
}
