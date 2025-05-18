package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    private boolean electrico;
    private boolean publico;

    public Carro (String placa,int cantidadPeaje,boolean electrico,boolean publico){
        super(placa,cantidadPeaje);
        this.electrico=electrico;
        this.publico=publico;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }
}
