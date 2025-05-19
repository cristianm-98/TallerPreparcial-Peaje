package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String placa,int cantidadPeaje,int cilindraje){
        super(placa, cantidadPeaje);
        this.cilindraje=cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularPeaje() {
        double costoPeaje=5000;
        if(cilindraje>200){
            costoPeaje+=2000;
        }
        return costoPeaje;
    }

    @Override
    public String descripcion() {
        return "Moto - Placa: " + getPlaca() + "Cantidad de peajes: " + getCantidadPeaje() +  ", Cilindraje: " + getCilindraje();
    }
}
