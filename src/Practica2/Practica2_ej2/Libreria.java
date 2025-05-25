package Practica2.Practica2_ej2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una librería.
 */
public class Libreria {
    private List<Libro> libros;
    private List<Proveedor> proveedores;

    /**
     * Constructor de la clase Libreria.
     */
    public Libreria() {
        this.libros = new ArrayList<>();
        this.proveedores = new ArrayList<>();
    }

    /**
     * Agrega un libro a la librería.
     * @param libro Libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Agrega un proveedor a la librería.
     * @param proveedor Proveedor a agregar.
     */
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    /**
     * Busca un libro por su título.
     * @param titulo Título del libro.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Vende un libro por su título.
     * @param titulo Título del libro.
     */
    public void venderLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            if (libro.getStock() > 0) {
                libro.actualizarStock(-1);
                System.out.println("Libro vendido: " + titulo);
            } else {
                System.out.println("Stock agotado. Realizando encargo...");
                realizarEncargo(libro);
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    /**
     * Realiza un encargo de un libro a un proveedor.
     * @param libro Libro a encargar.
     */
    private void realizarEncargo(Libro libro) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.puedeSuministrar(libro.getEditorial())) {
                System.out.println("Encargo realizado al proveedor: " + proveedor.getNombre());
                return;
            }
        }
        System.out.println("No se encontró un proveedor para la editorial: " + libro.getEditorial());
    }

    /**
     * Verifica el stock de un libro por su título.
     * @param titulo Título del libro.
     * @return Cantidad de libros en stock.
     */
    public int verificarStock(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        return libro != null ? libro.getStock() : -1;
    }
}
