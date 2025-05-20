package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());

    @Test
    public void asignarConductorTest() {
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Conductor conductor = new Conductor("Juan","Restrepo","1025", LocalDate.of(2021,5,11));
        Carro carro = new Carro("AZE879",5,false,true);
        empresa.agregarConductor(conductor);
        boolean resultado=empresa.asignarVehiculo("1025",carro);
        assertTrue(resultado);

        LOG.info("Fin de la prueba");
    }
    @Test
    public void reporteDetalladoTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Moto moto=new Moto("IGS71E",5,200);
        Camion camion=new Camion("IST250",3,4,10);
        empresa.agregarVehiculo(moto);
        empresa.agregarVehiculo(camion);

        empresa.reporteDetallado();

        LOG.info("Fin de la prueba");
    }
}