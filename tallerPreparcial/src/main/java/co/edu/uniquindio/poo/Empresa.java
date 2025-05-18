package co.edu.uniquindio.poo;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.LinkedList;

public class Empresa {
    private String nit;
    private String nombre;
    private LinkedList<Vehiculo>listaVehiculos;
    private LinkedList<Peaje>listaPeajes;

    public Empresa (String nit, String nombre){
        this.nit=nit;
        this.nombre=nombre;
        listaVehiculos=new LinkedList<>();
        listaPeajes=new LinkedList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public LinkedList<Peaje> getListaPeajes() {
        return listaPeajes;
    }

    public void setListaPeajes(LinkedList<Peaje> listaPeajes) {
        this.listaPeajes = listaPeajes;
    }
}
