package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        //Creacion de la empresa
        Empresa empresa = new Empresa("81000","PeajeUQ");

        //Creacion de los vehiculos (Carro,Moto,Camion)
        Carro carro1=new Carro("ACZ741",5,false,true);
        Carro carro2=new Carro("MZS230",10,true,true);
        Moto moto1=new Moto("ZGT87D",5,150);
        Moto moto2=new Moto("GTU20Q",3,250);
        Camion camion1=new Camion("GQP874",14,5,25);
        Camion camion2=new Camion("ZPO360",5,4,8);

        //Creacion de los conductores
        Conductor conductor1=new Conductor("Anderson","Rodriguez","1057410147",LocalDate.of(1990,8,15));
        conductor1.getListaVehiculos().add(carro1);
        conductor1.getListaVehiculos().add(moto1);

        Conductor conductor2=new Conductor("Ana","Benavidez","100741251",LocalDate.of(1985,5,25));
        conductor2.getListaVehiculos().add(carro2);
        conductor2.getListaVehiculos().add(camion1);

        Conductor conductor3=new Conductor("Carlos","Rodriguez","7474084",LocalDate.of(1959,5,30));
        conductor3.getListaVehiculos().add(moto2);
        conductor3.getListaVehiculos().add(camion2);

        //Creacion de los recaudadores
        Recaudador recaudador1=new Recaudador("Adriana","Rodriguez","110412874",LocalDate.of(1990,8,20),1800000);
        Recaudador recaudador2=new Recaudador("Dario","Baena","8747142",LocalDate.of(1985,2,28),1800000);

        //Asignacion de los vehiculos a los conductores
        empresa.asignarVehiculo("1057410147",carro1);
        empresa.asignarVehiculo("1057410147",camion1);
        empresa.asignarVehiculo("100741251",moto1);
        empresa.asignarVehiculo("100741251",carro2);
        empresa.asignarVehiculo("7474084",moto2);
        empresa.asignarVehiculo("7474084",camion2);

        //Registro del vehiculo por el peaje
        empresa.registrarPasoVehiculo("MZS230");
        empresa.registrarPasoVehiculo("GQP874");
        empresa.registrarPasoVehiculo("GTU20Q");

        //Generar Reporte
        System.out.println("=== REPORTE DETALLADO ===");
        empresa.reporteDetallado();
        empresa.generarReporteVehiculos();

        //Consulta el total de peaje por persona
        double totalPeajeCarlos= empresa.consultarTotalPeajePorPersona("7474084");
        System.out.println("Total de peaje pagado por Carlos es: " + totalPeajeCarlos);

        //Obtener vehiculo por conductor y tipo
        LinkedList<Vehiculo>carroDeCarlos=empresa.obtenerVehiculoPorConductor("7474084","camion");
        System.out.println("Carros de Carlos");
        for(Vehiculo vehiculo:carroDeCarlos){
            System.out.println(vehiculo.descripcion());
        }

        //Recaudador por nombre completo
        Recaudador encontrado=empresa.buscarRecaudadorPorNombre("DARIO   BAENA");
        if(encontrado!=null){
            System.out.println("Recaudador encontrado " +encontrado.getNombre()+" "+encontrado.getApellido());
        }else{
            System.out.println("Recaudador no encontrado");
        }

        //Obtener conductores con camiones de mas 10 toneladas
        LinkedList<Conductor>conductoresCamion=empresa.obtenerConductoresConCamionAltoTonelaje();
        System.out.printf("Conductores con camiones de mas de 10 toneladas");
        for(Conductor conductor:conductoresCamion){
            System.out.printf(conductor.getNombre()+ " " +conductor.getApellido());
        }

    }
}
