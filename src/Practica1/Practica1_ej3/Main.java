package Practica1.Practica1_ej3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema de Cálculo de Sueldo para Vendedores ===");
        System.out.print("Ingrese el nombre del vendedor: ");
        String nombre = sc.nextLine();

        Vendedor vendedor = new Vendedor(nombre);
        vendedor.ingresarVentas();
        vendedor.mostrarResumen();

        sc.close();
    }
}