package Practica2.Practica2_ej2;

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

    /**
     * Constructor de la clase Libro.
     * @param titulo Título del libro.
     * @param autores Lista de autores del libro.
     * @param editorial Editorial del libro.
     * @param anioEdicion Año de edición del libro.
     * @param formato Formato del libro ("Tapas duras" o "Edición económica").
     * @param isbn Código ISBN del libro.
     * @param stock Cantidad de libros en stock.
     */
    public Libro(String titulo, List<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.formato = formato;
        this.isbn = isbn;
        this.stock = stock;
    }

    /**
     * Obtiene el título del libro.
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el código ISBN del libro.
     * @return Código ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Obtiene la cantidad de libros en stock.
     * @return Cantidad de libros en stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Actualiza la cantidad de libros en stock.
     * @param stock Nueva cantidad de libros en stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Modifica el stock del libro sumando la cantidad especificada.
     * @param cantidad Cantidad a sumar al stock.
     */
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }

    /**
     * Obtiene la editorial del libro.
     * @return Editorial del libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Obtiene la categoría del libro.
     * @return Categoría del libro.
     */
    public abstract String getCategoria();
}
