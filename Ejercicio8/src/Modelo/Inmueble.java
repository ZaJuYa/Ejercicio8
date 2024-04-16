// En el archivo Inmueble.java
package Modelo;

public class Inmueble {
    private int id;
    private String localidad;
    private String calle;
    private int numeroHabitaciones;

    public Inmueble(String localidad, String calle, int numeroHabitaciones) {
        this.localidad = localidad;
        this.calle = calle;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }


    @Override
    public String toString() {
        return
                ", localidad='" + localidad + '\'' +
                ", calle='" + calle + '\'' +
                ", numeroHabitaciones=" + numeroHabitaciones
                ;
    }
}
