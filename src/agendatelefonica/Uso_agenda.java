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
public class Uso_agenda {

    public static void main(String[] args) {
        //Objeto
        Contacto c;
        int op = 0, size, telefono;
        //Variables
        String nombre;
        size = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el tamaño de la agenda", "Introduciendo Tamaño", JOptionPane.INFORMATION_MESSAGE));
        Agenda agenda = new Agenda(size);
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.-Agregar Contacto"
                        + "\n2.-Mostrar Agenda"
                        + "\n3.-Buscar Contacto"
                        + "\n4.-Eliminar Contacto"
                        + "\n5.-Verificar Contacto"
                        + "\n6.-Espacios disponibles"
                        + "\n7.-Agenda Llena"
                        + "\n8.-Cerrar programa"
                        + "\n¿Elige una opcion?", "Menu Opciones", 3));
                switch (op) {
                    case 1: {
                        if (!agenda.agendaLlena()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                            telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero telefonico", "Introduciendo el numero", JOptionPane.INFORMATION_MESSAGE));
                            c = new Contacto(nombre, telefono);
                            agenda.addContacto(c);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda llena", "Agenda Llena", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                    case 2: {
                        if (agenda.noestaVacia()) {
                            agenda.listarContactos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda sin valores", "Agenda vacia", JOptionPane.ERROR_MESSAGE);

                        }
                        break;
                    }
                    case 3: {
                        if (agenda.noestaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                            agenda.buscarContactoNombre(nombre);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda sin valores", "Agenda vacia", JOptionPane.ERROR_MESSAGE);

                        }
                        break;
                    }
                    case 4: {
                        if (agenda.noestaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                            c = new Contacto(nombre, 0);
                            agenda.eliminarContacto(c);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda sin valores", "Agenda vacia", JOptionPane.ERROR_MESSAGE);

                        }

                        break;
                    }

                    case 5: {
                        if (agenda.noestaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                            c = new Contacto(nombre, 0);
                            if (agenda.existenteContacto(c)) {
                                JOptionPane.showMessageDialog(null, "El contacto si existe", "Contacto encontrado", JOptionPane.INFORMATION_MESSAGE);

                            } else {
                                JOptionPane.showMessageDialog(null, "Contacto no encontrado", "Contacto no encontrado", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda sin valores", "Agenda vacia", JOptionPane.ERROR_MESSAGE);

                        }

                        break;
                    }
                    case 6: {
                        JOptionPane.showMessageDialog(null, "Espacio disponibles " + agenda.huecosLibres(), "Espacios disponibles", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    case 7: {
                        if (agenda.agendaLlena()) {
                            JOptionPane.showMessageDialog(null, "La agenda se encuentra llena", "Agenda llena", JOptionPane.ERROR_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Espacios disponibles " + agenda.huecosLibres(), "Espacios disponibles", JOptionPane.INFORMATION_MESSAGE);

                        }

                        break;
                    }
                    case 8: {
                        JOptionPane.showMessageDialog(null, "Cerrando programa", "Cerrando Programa", JOptionPane.ERROR_MESSAGE);

                        break;
                    }
                    default:{
                           JOptionPane.showMessageDialog(null, "Introduce un campo valido", "Dato erroneo", JOptionPane.INFORMATION_MESSAGE);
                 
                    break;}

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 8);

    }


    /*
     Nos piden realizar una agenda telefónica de contactos.
     Un contacto está definido por un nombre y un teléfono (No es necesario de validar). Un contacto es igual a otro cuando sus nombres son iguales.
     Una agenda de contactos está formada por un conjunto de contactos (Piensa en que tipo puede ser)
     Se podrá crear de dos formas, indicándoles nosotros el tamaño o con un tamaño por defecto (10) 
     Los métodos de la agenda serán los siguientes:
     • aniadirContacto(Contacto c): Añade un contacto a la agenda, sino se pueden meter más a la agenda se indicara por pantalla. No se pueden meter contactos que existan, es decir, no podemos duplicar nombres, aunque tengan distinto teléfono.
     • existeContacto(Conctacto c): indica si el contacto pasado existe o no.
     • listarContactos(): Lista toda la agenda
     • buscaContacto(String nombre): busca un contacto por su nombre y muestra su teléfono.
     • eliminarContacto(Contacto c): elimina el contacto de la agenda, indica si se ha eliminado o no por pantalla
     • agendaLlena(): indica si la agenda está llena.
     • huecosLibres(): indica cuantos contactos más podemos meter.
     Crea un menú con opciones por consola para probar todas estas funcionalidades.

     */
}
