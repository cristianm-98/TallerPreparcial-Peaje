package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected String documento;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre,String apellido,String documento,LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.apellido=apellido;
        this.documento=documento;
        this.fechaNacimiento=fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
