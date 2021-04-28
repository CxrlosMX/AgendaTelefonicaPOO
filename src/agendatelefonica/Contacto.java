/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

/**
 *
 * @author CxrlosMX
 */
public class Contacto {

    //Atributos 
    private String nombre;
    private int telefono;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //Metodo para verificar cuando el nombre sea igual 
    public boolean nombreIgual(Contacto c) {

        return this.nombre.equalsIgnoreCase(c.getNombre());
    }

    @Override
    public String toString() {
        return " Nombre=" + nombre + ", telefono=" + telefono;
    }

}
