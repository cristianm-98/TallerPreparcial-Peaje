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

    @Override
    public double calcularPeaje() {
        double costoPeaje=10000;
        if(isElectrico()){
            costoPeaje-=costoPeaje*0.20;
        }
        if (isPublico()){
            costoPeaje+=costoPeaje*0.15;
        }
        return costoPeaje;
    }


    @Override
    public String descripcion() {
        return "Carro - Placa: "+ getPlaca() + "Electrico: " + (electrico ? "Si":"No") + "Publico: "+ (publico ? "Si":"No");
    }
}
