package Practica1.Practica1_ej3;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
    private String nombreVendedor;
    private ArrayList<ArrayList<Double>> ventasPorDia;  // Lista de listas para ventas diarias
    private final double sueldoBase = 2000;
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    // Constructor
    public Vendedor(String nombre) {
        this.nombreVendedor = nombre;
        this.ventasPorDia = new ArrayList<>();
    }

    // Método para ingresar ventas por día
    public void ingresarVentas() {
        Scanner sc = new Scanner(System.in);

        for (String dia : dias) {
            ArrayList<Double> ventasDia = new ArrayList<>();
            System.out.println("\n--- Ventas del " + dia + " ---");
            System.out.println("Ingrese los montos de los artículos vendidos (0 para terminar):");

            double monto;
            do {
                System.out.print("Monto del artículo: $");
                monto = sc.nextDouble();

                if (monto != 0) {
                    ventasDia.add(monto);
                }
            } while (monto != 0);

            ventasPorDia.add(ventasDia);
        }
    }

    // Método para calcular el sueldo total (base + comisión)
    public double calcularSueldoTotal() {
        double ventasTotales = 0;

        // Suma todas las ventas de la semana
        for (ArrayList<Double> ventasDia : ventasPorDia) {
            for (Double monto : ventasDia) {
                ventasTotales += monto;
            }
        }

        double comision = ventasTotales * 0.06;
        return sueldoBase + comision;
    }

    // Método para mostrar resumen de ventas y sueldo
    public void mostrarResumen() {
        System.out.println("\n--- Resumen de Ventas ---");
        System.out.println("Vendedor: " + nombreVendedor);

        // Muestra ventas por día
        for (int i = 0; i < dias.length; i++) {
            ArrayList<Double> ventasDia = ventasPorDia.get(i);
            double totalDia = 0;

            for (Double monto : ventasDia) {
                totalDia += monto;
            }

            System.out.println(dias[i] + ": $" + totalDia);
        }

        // Muestra sueldo total
        double sueldoTotal = calcularSueldoTotal();
        System.out.println("\nSueldo base: $" + sueldoBase);
        System.out.println("Comisión (6% de ventas): $" + (sueldoTotal - sueldoBase));
        System.out.println("Sueldo total: $" + sueldoTotal);
    }
}