package co.edu.uniquindio.poo;

public class Peaje {
    private String nombre;
    private String ubicacion;
    private double valorPeaje;

    public Peaje(String nombre,String ubicacion,double valorPeaje){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
        this.valorPeaje=valorPeaje;
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
}
