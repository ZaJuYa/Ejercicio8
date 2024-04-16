package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private List<Inmueble> inmueblesPropios;
    private List<Inmueble> inmueblesAlquilados;

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.inmueblesPropios = new ArrayList<>();
        this.inmueblesAlquilados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void addInmueble(Inmueble inmueble) {
        inmueblesPropios.add(inmueble);
    }

    public void addInmuebleAlquilado(Inmueble inmueble) {
        inmueblesAlquilados.add(inmueble);
    }
}
