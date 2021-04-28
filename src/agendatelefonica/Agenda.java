/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import javax.swing.JOptionPane;

/**
 *
 * @author CxrlosMX
 */
public class Agenda {

    private Contacto[] agenda;

    //Constructor para darle un tamaño a nuestro arreglo
    public Agenda(int size) {
        agenda = new Contacto[size];
    }

    //Contructor para darle un valor por defecto
    public Agenda() {

        agenda = new Contacto[10];
    }

    //• aniadirContacto(Contacto c): Añade un contacto a la agenda, sino se pueden meter más a la agenda se indicara por pantalla. 
    //No se pueden meter contactos que existan, es decir, no podemos duplicar nombres, aunque tengan distinto teléfono.
    public void addContacto(Contacto c) {
        if (existenteContacto(c)) {
            JOptionPane.showMessageDialog(null, "El contacto ya existe en la agenda", "Contacto existente", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean encontrado = false;
            for (int i = 0; i < agenda.length && !encontrado; i++) {
                if (agenda[i] == null) {
                    agenda[i] = c;
                    encontrado = true;

                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, "Se ha agregado el contacto", "Agregado", JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

    //• existeContacto(Conctacto c): indica si el contacto pasado existe o no.
    public boolean existenteContacto(Contacto c) {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != null && agenda[i].getNombre().equalsIgnoreCase(c.getNombre())) {//Primero verificamos que nuestra agenda[i] contenga valores
                //Y verificamos su nuestro objeto pasado es igual a algun objeto ya existente con los mismo parametros
                return true;
            }
        }
        return false;
    }

    // • listarContactos(): Lista toda la agenda
    public void listarContactos() {
        System.out.println("*-*-*-*-AGENDA TELEFONICA*-*-*-*-");
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != null) {
                System.out.println(i + 1 + ".- " + agenda[i].toString());
            }

        }
        System.out.println("");
    }

    /*
     • buscaContacto(String nombre): busca un contacto por su nombre y muestra su teléfono.
    
     */
    public void buscarContactoNombre(String nombre) {
        boolean encontrado = false;
        Contacto a = null;
        for (int i = 0; i < agenda.length && !encontrado; i++) {
            if (agenda[i] != null && agenda[i].getNombre().equalsIgnoreCase(nombre)) {
                a = agenda[i];
                encontrado = true;
            }

        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El contacto se encontro:\n" + a.toString(), "Contacto encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El contacto no existe en tu agenda", "Error al buscar", JOptionPane.ERROR_MESSAGE);
        }

    }

    /*
     • agendaLlena(): indica si la agenda está llena.
     */
    public boolean agendaLlena() {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == null) {
                return false;
            }
        }
        return true;
    }

    /*
     • eliminarContacto(Contacto c): elimina el contacto de la agenda, indica si se ha eliminado o no por pantalla
     */
    public void eliminarContacto(Contacto c) {
        boolean encontrado = false;

        for (int i = 0; i < agenda.length && !encontrado; i++) {
            if (agenda[i] != null && agenda[i].getNombre().equalsIgnoreCase(c.getNombre())) {
                agenda[i] = null;
                encontrado = true;
            }

        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El contacto:\n" + c.toString() + " ha sido eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no existente en tu agenda", "Contacto no encontrado", JOptionPane.ERROR_MESSAGE);
        }

    }

    /*
     • huecosLibres(): indica cuantos contactos más podemos meter.
     */
    public int huecosLibres() {
        int c = 0;
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == null) {
                c++;
            }

        }
        return c;
    }

    //Verificar si agenda esta vacia
    public boolean noestaVacia() {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != null) {
                return true;
            }

        }
        return false;
    }
}
