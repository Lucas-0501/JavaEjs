package Practica6.Practica6_ej6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Agregar datos iniciales
        libreria.agregarLibro(new Novela("Dune", Arrays.asList("Frank Herbert"), "Editorial A", 1965, "Tapas duras", "123456789", 5, "Ciencia ficción"));
        libreria.agregarLibro(new LibroTecnico("Introducción a la Ingeniería", Arrays.asList("John Doe"), "Editorial B", 2020, "Edición económica", "987654321", 2, "Ingeniería"));
        libreria.agregarProveedor(new Proveedor("Proveedor 1", Arrays.asList("Editorial A", "Editorial C")));

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Eliminar un libro");
            System.out.println("3. Modificar el stock de un libro");
            System.out.println("4. Consultar libros");
            System.out.println("5. Generar informes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarLibro(libreria, scanner);
                case 2 -> eliminarLibro(libreria, scanner);
                case 3 -> modificarStock(libreria, scanner);
                case 4 -> consultarLibros(libreria, scanner);
                case 5 -> generarInformes(libreria, scanner);
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void agregarLibro(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingrese el año de edición: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el formato (Tapas duras/Edición económica): ");
        String formato = scanner.nextLine();
        System.out.print("Ingrese el ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese el stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el género o especialidad: ");
        String categoria = scanner.nextLine();

        System.out.print("¿Es un libro técnico? (s/n): ");
        String esTecnico = scanner.nextLine();
        if (esTecnico.equalsIgnoreCase("s")) {
            libreria.agregarLibro(new LibroTecnico(titulo, Arrays.asList(autor), editorial, anio, formato, isbn, stock, categoria));
        } else {
            libreria.agregarLibro(new Novela(titulo, Arrays.asList(autor), editorial, anio, formato, isbn, stock, categoria));
        }
        System.out.println("Libro agregado con éxito.");
    }

    private static void eliminarLibro(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libreria.venderLibro(titulo); // Simula la eliminación reduciendo el stock
            System.out.println("Libro eliminado (stock reducido a 0).");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void modificarStock(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.print("Ingrese la cantidad a agregar o restar del stock: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            libro.actualizarStock(cantidad);
            System.out.println("Stock actualizado con éxito.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void consultarLibros(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro a consultar: ");
        String titulo = scanner.nextLine();
        Libro libro = libreria.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Stock: " + libro.getStock());
            System.out.println("Editorial: " + libro.getEditorial());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void generarInformes(Libreria libreria, Scanner scanner) {
        System.out.println("\nInforme de libros:");
        for (Libro libro : libreria.getLibros()) {
            System.out.println("Título: " + libro.getTitulo() + ", Stock: " + libro.getStock());
        }
    }
}
