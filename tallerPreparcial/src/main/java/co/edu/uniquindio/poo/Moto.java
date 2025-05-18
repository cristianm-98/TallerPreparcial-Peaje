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
}
