package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;
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

        Carro carro=new Carro("MZD720",3,true,false);
        Moto moto=new Moto("IGS71E",5,200);
        Camion camion=new Camion("IST250",3,4,10);
        empresa.agregarVehiculo(carro);
        empresa.agregarVehiculo(moto);
        empresa.agregarVehiculo(camion);

        empresa.reporteDetallado();

        LOG.info("Fin de la prueba");
    }
    @Test
    public void generarReporteVehiculosTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");

        Carro carro=new Carro("MZD720",3,true,false);
        Moto moto=new Moto("IGS71E",5,200);
        Camion camion=new Camion("IST250",3,4,10);
        empresa.agregarVehiculo(carro);
        empresa.agregarVehiculo(moto);
        empresa.agregarVehiculo(camion);

        empresa.generarReporteVehiculos();

        LOG.info("Fin de la prueba");
    }
    @Test
    public void consultarTotalPeajePorPersonaTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Conductor conductor = new Conductor("Juan","Restrepo","1025", LocalDate.of(2021,5,11));
        empresa.agregarConductor(conductor);

        Carro carro=new Carro("MZD720",3,true,false);
        Moto moto=new Moto("IGS71E",5,200);

        empresa.asignarVehiculo("1025",carro);
        empresa.asignarVehiculo("1025",moto);

        double totalEsperado= carro.calcularPeaje()+moto.calcularPeaje();
        double totalCalculado=empresa.consultarTotalPeajePorPersona("1025");

        assertEquals(totalEsperado,totalCalculado,0.001);


        LOG.info("Fin de la prueba");
    }
    @Test
    public void obtenerVehiculoPorConductorTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Conductor conductor = new Conductor("Juan","Restrepo","1025", LocalDate.of(2021,5,11));
        empresa.agregarConductor(conductor);

        Carro carro=new Carro("MZD720",3,true,false);
        Moto moto=new Moto("IGS71E",5,200);
        Camion camion=new Camion("IGS71E",5,4,15);

        empresa.asignarVehiculo("1025",carro);
        empresa.asignarVehiculo("1025",moto);
        empresa.asignarVehiculo("1025",camion);

        LinkedList<Vehiculo>vehiculos=empresa.obtenerVehiculoPorConductor("1025","carro");
        assertEquals(1,vehiculos.size());
        assertTrue(vehiculos.contains(carro));

        LOG.info("Fin de la prueba");
    }
    @Test
    public void registrarPasoVehiculoTest(){
        LOG.info("Inico de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Carro carro=new Carro("MZD720",3,true,false);
        empresa.agregarVehiculo(carro);
        empresa.registrarPasoVehiculo("MZD720");

        assertTrue(true);

        LOG.info("Fin de la prueba");
    }
    @Test
    public void buscarRecaudadorPorNombreTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Recaudador recaudador=new Recaudador("Adriana","Rodriguez","2530",LocalDate.of(1990,8,20),1800000);
        empresa.agregrarRecaudador(recaudador);

        Recaudador resultado=empresa.buscarRecaudadorPorNombre("AdrianaRodrigueZ");
        assertNotNull(resultado);
        assertEquals("2530",resultado.getDocumento());

        LOG.info("Fin de la prueba");
    }
    @Test
    public void obtenerConductoresConCamionAltoTonelajeTest(){
        LOG.info("Inicio de la prueba");

        Empresa empresa =new Empresa("81000","PeajeUQ");
        Conductor conductor1=new Conductor("Anderson","Rodriguez","1057",LocalDate.of(1990,8,15));
        Conductor conductor2=new Conductor("Ana","Benavidez","1007",LocalDate.of(1985,5,25));
        Conductor conductor3=new Conductor("Carlos","Rodriguez","7474",LocalDate.of(1959,5,30));
        empresa.agregarConductor(conductor1);
        empresa.agregarConductor(conductor2);
        empresa.agregarConductor(conductor3);
        Camion camion1=new Camion("MDT784",5,4,12);
        Camion camion2=new Camion("SGT102",5,4,15);
        Camion camion3=new Camion("PMR851",5,4,11);
        empresa.agregarVehiculo(camion1);
        empresa.agregarVehiculo(camion2);
        empresa.agregarVehiculo(camion3);

        empresa.asignarVehiculo("1057",camion1);
        empresa.asignarVehiculo("1007",camion2);
        empresa.asignarVehiculo("7474",camion3);

        LinkedList<Conductor>resultado=empresa.obtenerConductoresConCamionAltoTonelaje();

        assertEquals(3,resultado.size());
        assertTrue(resultado.contains(conductor1));
        assertTrue(resultado.contains(conductor2));
        assertTrue(resultado.contains(conductor3));




        LOG.info("Fin de la prueba");
    }
}