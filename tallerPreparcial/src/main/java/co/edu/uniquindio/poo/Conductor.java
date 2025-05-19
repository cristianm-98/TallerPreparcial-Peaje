package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Conductor extends Persona{
    private LinkedList<Vehiculo>listaVehiculos;

    public Conductor(String nombre, String apellido, String documento, LocalDate fechaNacimiento){
        super (nombre,apellido,documento,fechaNacimiento);
        listaVehiculos=new LinkedList<>();
    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
