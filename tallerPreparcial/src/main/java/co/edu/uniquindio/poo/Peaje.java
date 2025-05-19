package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Peaje {
    private String nombre;
    private String ubicacion;
    private double valorPeaje;
    private LinkedList<Recaudador>listaRecaudadores;
    private LinkedList<Vehiculo>listaVehiculos;

    public Peaje(String nombre,String ubicacion,double valorPeaje){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
        this.valorPeaje=valorPeaje;
        listaRecaudadores=new LinkedList<>();
        listaVehiculos=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getValorPeaje() {
        return valorPeaje;
    }

    public void setValorPeaje(double valorPeaje) {
        this.valorPeaje = valorPeaje;
    }

    public LinkedList<Recaudador> getListaRecaudadores() {
        return listaRecaudadores;
    }

    public void setListaRecaudadores(LinkedList<Recaudador> listaRecaudadores) {
        this.listaRecaudadores = listaRecaudadores;
    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

}
