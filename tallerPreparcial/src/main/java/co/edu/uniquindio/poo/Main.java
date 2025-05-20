package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;


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

        empresa.agregarVehiculo(carro1);
        empresa.agregarVehiculo(carro2);
        empresa.agregarVehiculo(moto1);
        empresa.agregarVehiculo(moto2);
        empresa.agregarVehiculo(camion1);
        empresa.agregarVehiculo(camion2);

        //Creacion de los conductores
        Conductor conductor1=new Conductor("Anderson","Rodriguez","1057",LocalDate.of(1990,8,15));
        Conductor conductor2=new Conductor("Ana","Benavidez","1007",LocalDate.of(1985,5,25));
        Conductor conductor3=new Conductor("Carlos","Rodriguez","7474",LocalDate.of(1959,5,30));
        empresa.agregarConductor(conductor1);
        empresa.agregarConductor(conductor2);
        empresa.agregarConductor(conductor3);


        //Creacion de los recaudadores
        Recaudador recaudador1=new Recaudador("Adriana","Rodriguez","1104",LocalDate.of(1990,8,20),1800000);
        Recaudador recaudador2=new Recaudador("Dario","Baena","8747",LocalDate.of(1985,2,28),1800000);
        empresa.agregrarRecaudador(recaudador1);
        empresa.agregrarRecaudador(recaudador2);

        //Asignacion de los vehiculos a los conductores
        empresa.asignarVehiculo("1054",carro1);
        empresa.asignarVehiculo("1054",moto1);
        empresa.asignarVehiculo("1007",camion1);
        empresa.asignarVehiculo("1007",carro2);
        empresa.asignarVehiculo("7474",moto2);
        empresa.asignarVehiculo("7474",camion2);


        //Registro del vehiculo por el peaje
        empresa.registrarPasoVehiculo("ACZ741");
        empresa.registrarPasoVehiculo("MZS230");
        empresa.registrarPasoVehiculo("ZGT87D");
        empresa.registrarPasoVehiculo("GTU20Q");
        empresa.registrarPasoVehiculo("GQP874");
        empresa.registrarPasoVehiculo("ZPO360");

        //Consulta el total de peaje por persona
        double totalPeajeCarlos= empresa.consultarTotalPeajePorPersona("7474");
        System.out.println("Total de peaje pagado por Carlos es: " + totalPeajeCarlos);

        //Obtener vehiculo por conductor y tipo
        LinkedList<Vehiculo>carroDeCarlos=empresa.obtenerVehiculoPorConductor("7474","camion");
        System.out.println("los carros de que tiene Carlos ");
        for(Vehiculo vehiculo:carroDeCarlos){
            System.out.println(vehiculo.descripcion());
        }

        //Recaudador por nombre completo
        Recaudador encontrado=empresa.buscarRecaudadorPorNombre("AdrianaRodriguez");
        if(encontrado!=null){
            System.out.println("Recaudador encontrado " +encontrado.getNombre() + " " + encontrado.getApellido());
        }else{
            System.out.println("Recaudador no encontrado");
        }

        //Obtener conductores con camiones de mas 10 toneladas
        LinkedList<Conductor>conductoresCamion=empresa.obtenerConductoresConCamionAltoTonelaje();
        System.out.printf("Conductores con camiones de mas de 10 toneladas: ");
        for(Conductor conductor:conductoresCamion){
            System.out.printf(conductor.getNombre() + " " + conductor.getApellido());
        }

        //Generar Reporte
        System.out.println("\n\n=== REPORTE DETALLADO ===");
        empresa.reporteDetallado();
        System.out.println("======================="+"\n");


        //Generar Reporte Vehiculo
        System.out.printf("=== REPORTE POR VEHICULO ===="+"\n");
        empresa.generarReporteVehiculos();
        System.out.printf("============================"+"\n");


    }
}
