package Practica6.Practica6_ej6;

import java.util.List;

/**
 * Clase abstracta que representa un libro en la librería.
 */
public abstract class Libro {
    private String titulo;
    private List<String> autores;
    private String editorial;
    private int anioEdicion;
    private String formato; // "Tapas duras" o "Edición económica"
    private String isbn;
    private int stock;

    public Libro(String titulo, List<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.formato = formato;
        this.isbn = isbn;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }

    public String getEditorial() {
        return editorial;
    }

    public abstract String getCategoria();

    // Métodos agregados
    public List<String> getAutores() {
        return autores;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public String getFormato() {
        return formato;
    }
}