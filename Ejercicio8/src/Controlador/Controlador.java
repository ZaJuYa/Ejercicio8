package Controlador;

import Modelo.Inmueble;

import javax.swing.*;
import java.util.List;

public class Controlador {
    private GestionInmuebles gestionInmuebles;

    public Controlador() {
        this.gestionInmuebles = new GestionInmuebles();
        iniciar();
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            String opcion = mostrarMenu();
            switch (opcion) {
                case "1":
                    darDeAltaInmueble();
                    break;
                case "2":
                    buscarPorCiudad();
                    break;
                case "3":
                    buscarPorNumeroHabitaciones();
                    break;
                case "4":
                    darDeBajaInmueble();
                    break;
                case "5":
                    modificarInmueble();
                    break;
                case "6":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    private String mostrarMenu() {
        return JOptionPane.showInputDialog(
                "Menú:\n" +
                        "1. Dar de alta un inmueble \n" +
                        "2. Buscar inmuebles por ciudad\n" +
                        "3. Buscar inmuebles por número de habitaciones\n" +
                        "4. Dar de baja un inmueble\n" +
                        "5. Modificar un inmueble\n" +
                        "6. Salir\n" +
                        "Seleccione una opción:"
        );
    }

    private void darDeAltaInmueble() {
        String localidad = JOptionPane.showInputDialog("Introduzca la localidad:");
        String calle = JOptionPane.showInputDialog("Introduzca la calle:");
        int numHabitaciones = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de habitaciones:"));
        gestionInmuebles.darDeAltaInmueble(new Inmueble(localidad, calle, numHabitaciones));
        JOptionPane.showMessageDialog(null, "Inmueble dado de alta correctamente");
    }

    private void buscarPorCiudad() {
        String ciudad = JOptionPane.showInputDialog("Introduzca la ciudad:");
        List<Inmueble> inmuebles = gestionInmuebles.buscarPorLocalidad(ciudad);
        mostrarInmuebles("Inmuebles en " + ciudad + ":", inmuebles);
    }

    private void buscarPorNumeroHabitaciones() {
        int numHabitaciones = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de habitaciones:"));
        List<Inmueble> inmuebles = gestionInmuebles.buscarPorNumeroHabitaciones(numHabitaciones);
        mostrarInmuebles("Inmuebles con " + numHabitaciones + " habitaciones:", inmuebles);
    }

    private void darDeBajaInmueble() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ID del inmueble a dar de baja:"));
        boolean exito = gestionInmuebles.darDeBajaInmueble(id);
        if (exito) {


            JOptionPane.showMessageDialog(null, "Inmueble dado de baja correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún inmueble con el ID proporcionado");
        }
    }

    private void modificarInmueble() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ID del inmueble a modificar:"));
        Inmueble inmuebleAModificar = gestionInmuebles.buscarPorId(id);
        if (inmuebleAModificar != null) {
            // Solicitar nuevas características del inmueble
            String localidad = JOptionPane.showInputDialog("Introduzca la nueva localidad (anterior: " + inmuebleAModificar.getLocalidad() + "):");
            String calle = JOptionPane.showInputDialog("Introduzca la nueva calle (anterior: " + inmuebleAModificar.getCalle() + "):");
            int numHabitaciones = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el nuevo número de habitaciones (anterior: " + inmuebleAModificar.getNumeroHabitaciones() + "):"));
            // Modificar el inmueble
            inmuebleAModificar.setLocalidad(localidad);
            inmuebleAModificar.setCalle(calle);
            inmuebleAModificar.setNumeroHabitaciones(numHabitaciones);
            JOptionPane.showMessageDialog(null, "Inmueble modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún inmueble con el ID proporcionado");
        }
    }

    private void mostrarInmuebles(String titulo, List<Inmueble> inmuebles) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(titulo).append("\n");
        for (Inmueble inmueble : inmuebles) {
            mensaje.append(inmueble).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
