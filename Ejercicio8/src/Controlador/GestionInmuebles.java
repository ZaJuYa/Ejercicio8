package Controlador;

import Modelo.Inmueble;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionInmuebles {
    private List<Inmueble> inmuebles;
    private int siguienteId;

    public GestionInmuebles() {
        this.inmuebles = new ArrayList<>();
        this.siguienteId = 1;
    }

    public void darDeAltaInmueble(Inmueble inmueble) {
        inmueble.setId(siguienteId++);
        inmuebles.add(inmueble);
    }

    public boolean darDeBajaInmueble(int id) {
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getId() == id) {
                inmuebles.remove(inmueble);
                return true;
            }
        }
        return false;
    }

    public Inmueble buscarPorId(int id) {
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getId() == id) {
                return inmueble;
            }
        }
        return null;
    }

    public List<Inmueble> buscarPorLocalidad(String localidad) {
        List<Inmueble> inmueblesEnLocalidad = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getLocalidad().equalsIgnoreCase(localidad)) {
                inmueblesEnLocalidad.add(inmueble);
            }
        }
        return inmueblesEnLocalidad;
    }

    public List<Inmueble> buscarPorNumeroHabitaciones(int numeroHabitaciones) {
        List<Inmueble> inmueblesConNumHabitaciones = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getNumeroHabitaciones() == numeroHabitaciones) {
                inmueblesConNumHabitaciones.add(inmueble);
            }
        }
        return inmueblesConNumHabitaciones;
    }

    public void comprarInmueble(Usuario usuario, int idInmueble) {
        Inmueble inmueble = buscarPorId(idInmueble);
        if (inmueble != null) {
            inmueble.setPropietario(usuario);
            usuario.addInmueble(inmueble);
        }
    }

    public void alquilarInmueble(Usuario usuario, int idInmueble) {
        Inmueble inmueble = buscarPorId(idInmueble);
        if (inmueble != null) {
            inmueble.setInquilino(usuario);
            usuario.addInmuebleAlquilado(inmueble);
        }
    }
}
