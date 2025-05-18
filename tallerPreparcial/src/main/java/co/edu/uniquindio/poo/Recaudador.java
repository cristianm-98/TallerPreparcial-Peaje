package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Recaudador extends Persona {
    private double sueldo;

    public Recaudador(String nombre, String apellido, String documento, LocalDate fechaNacimiento,double sueldo){
        super(nombre, apellido, documento, fechaNacimiento);
        this.sueldo=sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
