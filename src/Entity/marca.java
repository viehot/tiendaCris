/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author piriv
 */
public class marca {
    private Integer id_mar;
    private String nombre;

    public marca() {
    }

    public marca(Integer id_mar, String nombre) {
        this.id_mar = id_mar;
        this.nombre = nombre;
    }

    public Integer getId_mar() {
        return id_mar;
    }

    public void setId_mar(Integer id_mar) {
        this.id_mar = id_mar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "marca{" + "id_mar=" + id_mar + ", nombre=" + nombre + '}';
    }

}
