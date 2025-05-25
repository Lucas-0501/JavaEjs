package Practica2.Practica2_ej2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        // Crear libros
        Novela novela1 = new Novela("Dune", Arrays.asList("Frank Herbert"), "Editorial A", 1965, "Tapas duras", "123456789", 5, "Ciencia ficción");
        LibroTecnico libroTecnico1 = new LibroTecnico("Introducción a la Ingeniería", Arrays.asList("John Doe"), "Editorial B", 2020, "Edición económica", "987654321", 2, "Ingeniería");

        // Agregar libros a la librería
        libreria.agregarLibro(novela1);
        libreria.agregarLibro(libroTecnico1);

        // Crear proveedores
        Proveedor proveedor1 = new Proveedor("Proveedor 1", Arrays.asList("Editorial A", "Editorial C"));
        libreria.agregarProveedor(proveedor1);

        // Buscar y vender libros
        libreria.venderLibro("Dune");
        System.out.println("Stock de 'Dune': " + libreria.verificarStock("Dune"));
        libreria.venderLibro("Dune");
        libreria.venderLibro("Dune");
        libreria.venderLibro("Dune");
        libreria.venderLibro("Dune");
        libreria.venderLibro("Dune"); // Stock agotado
    }
}
