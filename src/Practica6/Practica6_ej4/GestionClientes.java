package Practica6.Practica6_ej4;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GestionClientes {

    // Método para escribir una lista de clientes en un archivo
    public static void escribirClientesEnArchivo(List<String> clientes, String archivo) throws IOException {
        Files.write(Paths.get(archivo), clientes);
    }

    // Método para leer clientes desde un archivo
    public static List<String> leerClientesDesdeArchivo(String archivo) throws IOException {
        return Files.readAllLines(Paths.get(archivo));
    }

    // Método para agregar clientes al principio del archivo
    public static void agregarClientesAlPrincipio(List<String> nuevosClientes, String archivo) throws IOException {
        List<String> clientesExistentes = leerClientesDesdeArchivo(archivo);
        nuevosClientes.addAll(clientesExistentes); // Agregar los existentes después de los nuevos
        escribirClientesEnArchivo(nuevosClientes, archivo);
    }

    // Método para crear el archivo Clientes2 con información adicional
    public static void crearArchivoClientes2(String archivoOriginal, String archivoNuevo) throws IOException {
        List<String> clientes = leerClientesDesdeArchivo(archivoOriginal);
        List<String> clientesConDatos = new ArrayList<>();

        Random random = new Random();
        String[] tiposCuenta = {"Caja de ahorro", "Cuenta corriente"};

        for (String cliente : clientes) {
            int numeroCuenta = 100000 + random.nextInt(900000); // Generar número de cuenta aleatorio
            String tipoCuenta = tiposCuenta[random.nextInt(tiposCuenta.length)];
            clientesConDatos.add(numeroCuenta + ", " + cliente + ", " + tipoCuenta);
        }

        escribirClientesEnArchivo(clientesConDatos, archivoNuevo);
    }

    public static void main(String[] args) {
        String archivoClientes = "Clientes.txt";
        String archivoClientes2 = "Clientes2.txt";

        try {
            // Paso 1: Crear lista inicial de 10 clientes
            List<String> clientes = Arrays.asList(
                    "Juan Perez", "Maria Gomez", "Carlos Lopez", "Ana Torres", "Luis Fernandez",
                    "Sofia Martinez", "Pedro Ramirez", "Lucia Diaz", "Jorge Suarez", "Marta Castro"
            );
            escribirClientesEnArchivo(clientes, archivoClientes);
            System.out.println("Clientes iniciales:");
            clientes.forEach(System.out::println);

            // Paso 2: Agregar 5 clientes ingresados por teclado al principio
            Scanner scanner = new Scanner(System.in);
            List<String> nuevosClientes = new ArrayList<>();
            System.out.println("\nIngrese 5 nuevos clientes:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Cliente " + (i + 1) + ": ");
                nuevosClientes.add(scanner.nextLine());
            }
            agregarClientesAlPrincipio(nuevosClientes, archivoClientes);

            // Leer e imprimir el archivo actualizado
            System.out.println("\nClientes actualizados:");
            List<String> clientesActualizados = leerClientesDesdeArchivo(archivoClientes);
            clientesActualizados.forEach(System.out::println);

            // Paso 3: Crear archivo Clientes2 con información adicional
            crearArchivoClientes2(archivoClientes, archivoClientes2);

            // Leer e imprimir el archivo Clientes2
            System.out.println("\nArchivo Clientes2:");
            List<String> clientes2 = leerClientesDesdeArchivo(archivoClientes2);
            clientes2.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error al manejar los archivos: " + e.getMessage());
        }
    }
}