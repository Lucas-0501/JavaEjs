package Practica6.Practica6_ej5;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestionDVD {

    private static final String ARCHIVO_DVD = "DVDs.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un nuevo elemento (alta)");
            System.out.println("2. Eliminar un elemento (baja lógica)");
            System.out.println("3. Modificar los datos de un elemento existente");
            System.out.println("4. Consultas");
            System.out.println("5. Informes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarDVD(scanner);
                case 2 -> eliminarDVD(scanner);
                case 3 -> modificarDVD(scanner);
                case 4 -> realizarConsultas(scanner);
                case 5 -> generarInformes(scanner);
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void agregarDVD(Scanner scanner) {
        try {
            System.out.print("Ingrese el título del DVD: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el género: ");
            String genero = scanner.nextLine();
            System.out.print("Ingrese el año: ");
            int anio = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            String nuevoDVD = titulo + "," + genero + "," + anio + ",true";
            Files.write(Paths.get(ARCHIVO_DVD), Collections.singletonList(nuevoDVD), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.println("DVD agregado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al agregar el DVD: " + e.getMessage());
        }
    }

    private static void eliminarDVD(Scanner scanner) {
        try {
            System.out.print("Ingrese el título del DVD a eliminar: ");
            String titulo = scanner.nextLine();
            List<String> dvds = Files.readAllLines(Paths.get(ARCHIVO_DVD));
            List<String> actualizados = dvds.stream()
                    .map(linea -> {
                        String[] partes = linea.split(",");
                        if (partes[0].equalsIgnoreCase(titulo)) {
                            partes[3] = "false"; // Baja lógica
                        }
                        return String.join(",", partes);
                    })
                    .collect(Collectors.toList());
            Files.write(Paths.get(ARCHIVO_DVD), actualizados);
            System.out.println("DVD eliminado (baja lógica) con éxito.");
        } catch (IOException e) {
            System.err.println("Error al eliminar el DVD: " + e.getMessage());
        }
    }

    private static void modificarDVD(Scanner scanner) {
        try {
            System.out.print("Ingrese el título del DVD a modificar: ");
            String titulo = scanner.nextLine();
            List<String> dvds = Files.readAllLines(Paths.get(ARCHIVO_DVD));
            List<String> actualizados = dvds.stream()
                    .map(linea -> {
                        String[] partes = linea.split(",");
                        if (partes[0].equalsIgnoreCase(titulo)) {
                            System.out.print("Ingrese el nuevo género: ");
                            partes[1] = scanner.nextLine();
                            System.out.print("Ingrese el nuevo año: ");
                            partes[2] = String.valueOf(scanner.nextInt());
                            scanner.nextLine(); // Consumir el salto de línea
                        }
                        return String.join(",", partes);
                    })
                    .collect(Collectors.toList());
            Files.write(Paths.get(ARCHIVO_DVD), actualizados);
            System.out.println("DVD modificado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al modificar el DVD: " + e.getMessage());
        }
    }

    private static void realizarConsultas(Scanner scanner) {
        try {
            System.out.println("\nConsultas:");
            System.out.println("1. Mostrar datos de un DVD por título");
            System.out.println("2. Cantidad de elementos");
            System.out.println("3. Cantidad de elementos que cumplen con una condición");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            List<String> dvds = Files.readAllLines(Paths.get(ARCHIVO_DVD));
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el título del DVD: ");
                    String titulo = scanner.nextLine();
                    dvds.stream()
                            .filter(linea -> linea.startsWith(titulo + ",") && linea.endsWith(",true"))
                            .forEach(System.out::println);
                }
                case 2 -> System.out.println("Cantidad de elementos: " + dvds.size());
                case 3 -> {
                    System.out.print("Ingrese el género para filtrar: ");
                    String genero = scanner.nextLine();
                    long cantidad = dvds.stream()
                            .filter(linea -> linea.contains("," + genero + ",") && linea.endsWith(",true"))
                            .count();
                    System.out.println("Cantidad de elementos que cumplen con la condición: " + cantidad);
                }
                default -> System.out.println("Opción no válida.");
            }
        } catch (IOException e) {
            System.err.println("Error al realizar consultas: " + e.getMessage());
        }
    }

    private static void generarInformes(Scanner scanner) {
        try {
            System.out.println("\nInformes:");
            System.out.println("1. Listado de todos los elementos");
            System.out.println("2. Listado de elementos que cumplen con una condición");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            List<String> dvds = Files.readAllLines(Paths.get(ARCHIVO_DVD));
            switch (opcion) {
                case 1 -> dvds.stream()
                        .filter(linea -> linea.endsWith(",true"))
                        .forEach(System.out::println);
                case 2 -> {
                    System.out.print("Ingrese el género para filtrar: ");
                    String genero = scanner.nextLine();
                    dvds.stream()
                            .filter(linea -> linea.contains("," + genero + ",") && linea.endsWith(",true"))
                            .forEach(System.out::println);
                }
                default -> System.out.println("Opción no válida.");
            }
        } catch (IOException e) {
            System.err.println("Error al generar informes: " + e.getMessage());
        }
    }
}