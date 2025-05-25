package Practica2_ej1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private List<DVD> dvds;
    private Scanner scanner;

    public Catalogo() {
        this.dvds = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public int leerOpcionMenu() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
    public void agregarDVDInteractivo() {
        System.out.println("\n--- AGREGAR DVD/BLURAY ---");
        try {

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Género (S/C/T): ");
            String genero = scanner.nextLine().toUpperCase();

            System.out.print("Duración (minutos): ");
            int duracion;
            try {
                duracion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: La duración debe ser un número.");
                return;
            }
            System.out.print("¿Tienes el disco? (s/n): ");
            boolean tengo = scanner.nextLine().equalsIgnoreCase("s");

            System.out.print("Comentario: ");
            String comentario = scanner.nextLine();

            // Preguntar si es BluRay
            System.out.print("¿Es un Blu-ray? (s/n): ");
            boolean esBluRay = scanner.nextLine().equalsIgnoreCase("s");

            DVD nuevoDisco;
            if (esBluRay) {
                System.out.print("Resolución (1080p/4K/8K): ");
                String resolucion = scanner.nextLine();

                System.out.print("Calidad de sonido (Ej: Dolby Atmos): ");
                String calidadSonido = scanner.nextLine();

                nuevoDisco = new BluRay(titulo, genero, duracion, tengo, comentario, resolucion, calidadSonido);
            } else {
                nuevoDisco = new DVD(titulo, genero, duracion, tengo, comentario);
            }


            if (dvds.stream().anyMatch(d -> d.getTitulo().equalsIgnoreCase(titulo))) {
                System.out.println("Error: Ya existe un disco con ese título.");
                return;
            }
            dvds.add(nuevoDisco);
            System.out.println("Disco agregado con éxito.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarDVDInteractivo() {
        System.out.println("\n--- ELIMINAR DVD ---");
        System.out.print("Título del DVD a eliminar: ");
        String titulo = scanner.nextLine();
        dvds.removeIf(dvd -> dvd.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("DVD eliminado (si existía).");
    }

    public void modificarDVDInteractivo() {
        System.out.println("\n--- MODIFICAR DVD ---");
        System.out.print("Título del DVD a modificar: ");
        String tituloViejo = scanner.nextLine();

        DVD actual = dvds.stream()
                .filter(d -> d.getTitulo().equalsIgnoreCase(tituloViejo))
                .findFirst()
                .orElse(null);

        if (actual == null) {
            System.out.println("Error: DVD no encontrado.");
            return;
        }

        System.out.println("\nDeja en blanco los campos que no quieras cambiar.");
        System.out.print("Nuevo título: ");
        String nuevoTitulo = scanner.nextLine();

        System.out.print("Nuevo género (S/C/T): ");
        String nuevoGenero = scanner.nextLine().toUpperCase();

        System.out.print("Nueva duración (minutos): ");
        String duracionStr = scanner.nextLine();
        int nuevaDuracion = duracionStr.isEmpty() ? actual.getDuracion() : Integer.parseInt(duracionStr);

        System.out.print("¿Tienes el DVD ahora? (s/n): ");
        String tieneStr = scanner.nextLine();
        boolean tiene = tieneStr.isEmpty() ? actual.loTengo() : tieneStr.equalsIgnoreCase("s");

        System.out.print("Nuevo comentario: ");
        String nuevoComentario = scanner.nextLine();

        DVD modificado = new DVD(
                nuevoTitulo.isEmpty() ? actual.getTitulo() : nuevoTitulo,
                nuevoGenero.isEmpty() ? actual.getGenero() : nuevoGenero,
                nuevaDuracion,
                tiene,
                nuevoComentario.isEmpty() ? actual.getComentario() : nuevoComentario
        );

        dvds.remove(actual); // Elimina el viejo
        dvds.add(modificado); // Agrega el nuevo
        System.out.println("DVD modificado con éxito.");
    }

    public void listarTodos() {
        System.out.println("\n--- TODOS LOS DVDs ---");
        dvds.forEach(DVD::mostrarDatos);
    }

    public void listarTengo() {
        System.out.println("\n--- DVDs QUE TENGO ---");
        dvds.stream().filter(DVD::loTengo).forEach(DVD::mostrarDatos);
    }

    public void listarDuracionMenorA() {
        System.out.println("\n--- DVDs POR DURACIÓN ---");
        System.out.print("Duración máxima (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        dvds.stream()
                .filter(dvd -> dvd.getDuracion() < duracion)
                .forEach(DVD::mostrarDatos);
    }

    public void listarOrdenadosPorTitulo() {
        System.out.println("\n--- DVDs ORDENADOS ---");
        dvds.stream()
                .sorted(Comparator.comparing(DVD::getTitulo))
                .forEach(DVD::mostrarDatos);
    }
}