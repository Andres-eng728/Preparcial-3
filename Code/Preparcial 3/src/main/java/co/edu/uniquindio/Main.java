package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Crear estación de peaje
        EstacionPeaje peaje = new EstacionPeaje();
        peaje.nombre = "Peaje Sur";
        peaje.departamento = "Valle del Cauca";

        // Crear conductores
        Conductor c1 = new Conductor("juan","Pérez", "123456",LocalDate.of(1980, 5, 15));


        Conductor c2 = new Conductor("Ana","Gómez","654321",LocalDate.of(1990, 8, 20));


        // Crear vehículos
        Carro carro1 = new Carro("AAA111", true, false);
        Moto moto1 = new Moto("BBB222", 250);
        Camion camion1 = new Camion("CCC333", 4, 12.5);

        // Asignar vehículos a conductores
        c1.asignarVehiculo(carro1);
        c1.asignarVehiculo(moto1);
        c2.asignarVehiculo(camion1);

        // Crear recaudador
        Recaudador r1 = new Recaudador("Carlos","Ramírez","999999",LocalDate.of(1975, 2, 10),2000000);


        peaje.recaudadores.add(r1);

        // Cobrar peajes
        peaje.cobrarPeaje(carro1);
        peaje.cobrarPeaje(moto1);
        peaje.cobrarPeaje(camion1);

        // Imprimir reporte
        peaje.imprimirReporte();

        // Consultar total peajes pagados por conductor
        System.out.println("\nTotal pagado por Juan Pérez: $" + c1.calcularTotalPeajes());
        System.out.println("Total pagado por Ana Gómez: $" + c2.calcularTotalPeajes());

        // Buscar recaudador
        Recaudador encontrado = peaje.buscarRecaudador("  carlos   ramírez ");
        System.out.println("\nRecaudador encontrado: " + (encontrado != null ? encontrado.getNombreCompleto() : "No encontrado"));

        // Conductores con camiones de alta carga
        List<Conductor> altaCarga = peaje.conductoresConCamionesDeAltaCarga(List.of(c1, c2));
        System.out.println("\nConductores con camiones de alta carga:");
        for (Conductor c : altaCarga) {
            System.out.println(c.nombre + " " + c.apellidos);
        }
    }
}