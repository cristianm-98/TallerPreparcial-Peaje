package co.edu.uniquindio.poo;

public class Camion extends Vehiculo{
    private int cantidadEje;
    private double cargaToneladas;

    public Camion(String placa,int cantidadPeaje,int cantidadEje,double cargaToneladas){
        super(placa,cantidadPeaje);
        this.cantidadEje=cantidadEje;
        this.cargaToneladas=cargaToneladas;
    }

    public int getCantidadEje() {
        return cantidadEje;
    }

    public void setCantidadEje(int cantidadEje) {
        this.cantidadEje = cantidadEje;
    }

    public double getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(double cargaToneladas) {
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public double calcularPeaje() {
        double costoBasePeaje=cantidadEje*7000;
        if(cargaToneladas>10){
            costoBasePeaje+=costoBasePeaje*0.10;
        }
        return costoBasePeaje;
    }

    @Override
    public String descripcion() {
        return "Camion - Placa: " + getPlaca() + "Cantidad de peaje: " + getCantidadPeaje() + "Cantidad de ejes: " + getCantidadEje() + "Toneladas: " + getCargaToneladas() ;
    }
}
