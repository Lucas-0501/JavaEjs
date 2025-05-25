package Practica1.Practica1_ej4;

public class Main {
    public static void main(String[] args) {
        // Crear dos instancias de Libro
        Libro libro1 = new Libro("El Quijote", true, false); // Original y no prestable
        Libro libro2 = new Libro("Fotocopia de Matemáticas", false, true); // Fotocopia y prestable

        // Mostrar información de los libros
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);

        // Modificar atributos usando métodos 'set'
        libro1.setPrestable(true);
        libro2.setTitulo("Fotocopia de Física");

        // Mostrar información actualizada
        System.out.println("\nDespués de modificaciones:");
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);
    }
}