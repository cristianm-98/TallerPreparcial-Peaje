package co.edu.uniquindio.poo;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Locale;

public class Empresa {
    private String nit;
    private String nombre;
    private double totalRecaudado = 0.0;
    private LinkedList<Vehiculo> historialPeaje = new LinkedList<>();
    private LinkedList<Conductor> listaConductores;
    private LinkedList<Recaudador> listaRecaudadores;
    private LinkedList<Vehiculo> listaVehiculos;
    private LinkedList<Peaje> listaPeajes;

    public Empresa(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        listaConductores = new LinkedList<>();
        listaRecaudadores = new LinkedList<>();
        listaVehiculos = new LinkedList<>();
        listaPeajes = new LinkedList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Conductor> getListaConductores() {
        return listaConductores;
    }

    public void setListaConductores(LinkedList<Conductor> listaConductores) {
        this.listaConductores = listaConductores;
    }

    public LinkedList<Recaudador> getListaRecaudadores() {
        return listaRecaudadores;
    }

    public void setListaRecaudadores(LinkedList<Recaudador> listaRecaudadores) {
        this.listaRecaudadores = listaRecaudadores;
    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public LinkedList<Peaje> getListaPeajes() {
        return listaPeajes;
    }

    public void setListaPeajes(LinkedList<Peaje> listaPeajes) {
        this.listaPeajes = listaPeajes;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public LinkedList<Vehiculo> getHistorialPeaje() {
        return historialPeaje;
    }

    public void setHistorialPeaje(LinkedList<Vehiculo> historialPeaje) {
        this.historialPeaje = historialPeaje;
    }

    //CRUD DE CONDUCTOR
    public boolean agregarConductor(Conductor nuevoConductor) {
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(nuevoConductor.getDocumento())) {
                return false;
            }
        }
        listaConductores.add(nuevoConductor);
        return true;
    }

    public Conductor buscarConductor(String documento) {
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                return conductor;
            }
        }
        return null;
    }

    public boolean actualizarConductor(String documento, String nuevoNombre, String nuevoApellido, LocalDate nuevoFechaNacimiento) {
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                conductor.setNombre(nuevoNombre);
                conductor.setApellido(nuevoApellido);
                conductor.setFechaNacimiento(nuevoFechaNacimiento);
            }
            return true;
        }
        return false;
    }

    public boolean eliminarConductor(String documento) {
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                listaConductores.remove(conductor);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Conductor> obtenerConductor() {
        return listaConductores;
    }

    //Asignar vehiculo a una persona
    public boolean asignarVehiculo(String documento, Vehiculo nuevoVehiculo) {
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                conductor.getListaVehiculos().add(nuevoVehiculo);
                return true;
            }
        }
        return false;
    }

    //imprimir en pantalla la lista de los vehiculos
    public void reporteDetallado() {
        double recaudoTotal = 0.0;
        for (Vehiculo vehiculo : listaVehiculos) {
            String tipo = "";
            if (vehiculo instanceof Carro) {
                tipo = "Carro";
            } else if (vehiculo instanceof Moto) {
                tipo = "Moto";
            } else if (vehiculo instanceof Camion) {
                tipo = "Camion";
            }
            double valorPeaje = vehiculo.calcularPeaje();
            recaudoTotal += valorPeaje;
            System.out.println("Tipo: " + tipo + " Placa: " + vehiculo.getPlaca() + " Peaje: " + valorPeaje);
        }
        System.out.println("Total recaudado es de: " + recaudoTotal);
    }

    //Reporte
    public void generarReporteVehiculos() {
        String reporte = "";
        for (Vehiculo vehiculo : listaVehiculos) {
            reporte += vehiculo.descripcion();
        }
        System.out.println(reporte);
    }

    //Consultar total de dinero
    public double consultarTotalPeajePorPersona(String documento) {
        double totalPeaje = 0.0;
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                for (Vehiculo vehiculo : conductor.getListaVehiculos()) {
                    totalPeaje += vehiculo.calcularPeaje();
                }
            }
        }
        return totalPeaje;
    }

    //Lista de vehiculos Conductor
    public LinkedList<Vehiculo> obtenerVehiculoPorConductor(String documento, String tipoVehiculo) {
        LinkedList<Vehiculo> nuevaListaVehiculos = new LinkedList<>();
        for (Conductor conductor : listaConductores) {
            if (conductor.getDocumento().equals(documento)) {
                for (Vehiculo vehiculo : conductor.getListaVehiculos()) {
                    if (tipoVehiculo.equalsIgnoreCase("Carro") && vehiculo instanceof Carro) {
                        nuevaListaVehiculos.add(vehiculo);
                    } else if (tipoVehiculo.equalsIgnoreCase("Moto") && vehiculo instanceof Moto) {
                        nuevaListaVehiculos.add(vehiculo);
                    } else if (tipoVehiculo.equalsIgnoreCase("Camion") && vehiculo instanceof Camion) {
                        nuevaListaVehiculos.add(vehiculo);
                    }
                }
            }
        }
        return nuevaListaVehiculos;
    }

    //Calcular valor del peaje de un vehiculo
    public double registrarPasoVehiculo(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                double valorPeaje = vehiculo.calcularPeaje();
                totalRecaudado += valorPeaje;
                historialPeaje.add(vehiculo);
                return valorPeaje;
            }
        }
        return -1;
    }

    //Buscar el recaudador por nombre completo (nombre+apellido)
    public Recaudador buscarRecaudadorPorNombre(String nombreCompleto) {
        for (Recaudador recaudador : listaRecaudadores) {
            String nombreLimpio = (recaudador.getNombre() + recaudador.getApellido()).trim().toLowerCase().replaceAll("\\s+", "");
            if (nombreCompleto.equals(nombreLimpio)) {
                return recaudador;
            }
        }
        return null;
    }

    //Identificar los conductores que tiene al menos un camion
    public LinkedList<Conductor> obtenerConductoresConCamionAltoTonelaje() {
        LinkedList<Conductor> nuevaListaConductores = new LinkedList<>();
        for (Conductor conductor : listaConductores) {
            for (Vehiculo vehiculo : conductor.getListaVehiculos()) {
                if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    if (camion.getCargaToneladas() > 10) {
                        nuevaListaConductores.add(conductor);
                        break;
                    }
                }
            }
        }
        return nuevaListaConductores;
    }
}