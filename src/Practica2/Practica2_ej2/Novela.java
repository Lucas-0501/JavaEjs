package Practica2.Practica2_ej2;

import java.util.List;

/**
 * Clase que representa una novela.
 */
public class Novela extends Libro {
    private String genero; // Ciencia ficción, Romance, etc.

    /**
     * Constructor de la clase Novela.
     * @param titulo Título de la novela.
     * @param autores Lista de autores de la novela.
     * @param editorial Editorial de la novela.
     * @param anioEdicion Año de edición de la novela.
     * @param formato Formato de la novela.
     * @param isbn Código ISBN de la novela.
     * @param stock Cantidad de novelas en stock.
     * @param genero Género de la novela.
     */
    public Novela(String titulo, List<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock, String genero) {
        super(titulo, autores, editorial, anioEdicion, formato, isbn, stock);
        if (!esGeneroValido(genero)) {
            throw new IllegalArgumentException("Género no válido para una novela.");
        }
        this.genero = genero;
    }

    /**
     * Verifica si el género es válido.
     * @param genero Género a verificar.
     * @return true si el género es válido, false en caso contrario.
     */
    private boolean esGeneroValido(String genero) {
        return genero.equalsIgnoreCase("Ciencia ficción") ||
               genero.equalsIgnoreCase("Romance") ||
               genero.equalsIgnoreCase("Misterio") ||
               genero.equalsIgnoreCase("Juveniles") ||
               genero.equalsIgnoreCase("Policiales");
    }

    @Override
    public String getCategoria() {
        return "Novela - " + genero;
    }
}
