package co.edu.uniquindio.poo;

public abstract class Vehiculo implements ICobrable{
    protected String placa;
    protected int cantidadPeaje;

    public Vehiculo(String placa,int cantidadPeaje){
        this.placa=placa;
        this.cantidadPeaje=cantidadPeaje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCantidadPeaje() {
        return cantidadPeaje;
    }

    public void setCantidadPeaje(int cantidadPeaje) {
        this.cantidadPeaje = cantidadPeaje;
    }

    //Retorne una cadena descriptiva
    public abstract String descripcion();

}
