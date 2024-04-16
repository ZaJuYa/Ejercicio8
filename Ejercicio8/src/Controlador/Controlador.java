package Controlador;

import Modelo.Inmueble;
import Modelo.Usuario;

import javax.swing.*;
import java.util.List;

public class Controlador {
    private GestionInmuebles gestionInmuebles;
    private GestionUsuarios gestionUsuarios;

    public Controlador() {
        this.gestionInmuebles = new GestionInmuebles();
        this.gestionUsuarios = new GestionUsuarios();
        iniciar();
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            String opcionMenuPrincipal = mostrarMenuPrincipal();
            switch (opcionMenuPrincipal) {
                case "1":
                    gestionarInmuebles();
                    break;
                case "2":
                    gestionarUsuarios();
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    private String mostrarMenuPrincipal() {
        return JOptionPane.showInputDialog(
                "Menú Principal:\n" +
                        "1. Gestionar Inmuebles\n" +
                        "2. Gestionar Usuarios\n" +
                        "3. Salir\n" +
                        "Seleccione una opción:"
        );
    }

    private void gestionarInmuebles() {
        boolean continuar = true;
        while (continuar) {
            String opcion = mostrarMenuInmuebles();
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

    private String mostrarMenuInmuebles() {
        return JOptionPane.showInputDialog(
                "Gestión de Inmuebles:\n" +
                        "1. Dar de alta un inmueble\n" +
                        "2. Buscar inmuebles por ciudad\n" +
                        "3. Buscar inmuebles por número de habitaciones\n" +
                        "4. Dar de baja un inmueble\n" +
                        "5. Modificar un inmueble\n" +
                        "6. Volver al Menú Principal\n" +
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

    private void gestionarUsuarios() {
        boolean continuar = true;
        while (continuar) {
            String opcion = mostrarMenuUsuarios();
            switch (opcion) {
                case "1":
                    darDeAltaUsuario();
                    break;
                case "2":
                    darDeBajaUsuario();
                    break;
                case "3":
                    modificarUsuario();
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    private String mostrarMenuUsuarios() {
        return JOptionPane.showInputDialog(
                "Gestión de Usuarios:\n" +
                        "1. Dar de alta un usuario\n" +
                        "2. Dar de baja un usuario\n" +
                        "3. Modificar un usuario\n" +
                        "4. Volver al Menú Principal\n" +
                        "Seleccione una opción:"
        );
    }

    private void darDeAltaUsuario() {
        String nombre = JOptionPane.showInputDialog("Introduzca el nombre del usuario:");
        String apellido = JOptionPane.showInputDialog("Introduzca el apellido del usuario:");
        String dni = JOptionPane.showInputDialog("Introduzca el DNI del usuario:");
        gestionUsuarios.darDeAltaUsuario(new Usuario(nombre, apellido, dni));
        JOptionPane.showMessageDialog(null, "Usuario dado de alta correctamente");
    }

    private void darDeBajaUsuario() {
        String dni = JOptionPane.showInputDialog("Introduzca el DNI del usuario a dar de baja:");
        boolean exito = gestionUsuarios.darDeBajaUsuario(dni);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Usuario dado de baja correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el DNI proporcionado");
        }
    }

    private void modificarUsuario() {
        String dni = JOptionPane.showInputDialog("Introduzca el DNI del usuario a modificar:");
        Usuario usuarioAModificar = gestionUsuarios.buscarPorDNI(dni);
        if (usuarioAModificar != null) {
            // Solicitar nuevos datos del usuario
            String nombre = JOptionPane.showInputDialog("Introduzca el nuevo nombre (anterior: " + usuarioAModificar.getNombre() + "):");
            String apellido = JOptionPane.showInputDialog("Introduzca el nuevo apellido (anterior: " + usuarioAModificar.getApellido() + "):");
            String nuevoDNI = JOptionPane.showInputDialog("Introduzca el nuevo DNI (anterior: " + usuarioAModificar.getDni() + "):");
            // Modificar el usuario
            usuarioAModificar.setNombre(nombre);
            usuarioAModificar.setApellido(apellido);
            usuarioAModificar.setDni(nuevoDNI);
            JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el DNI proporcionado");
        }
    }
}