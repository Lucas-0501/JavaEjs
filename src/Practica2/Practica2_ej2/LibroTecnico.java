package Practica2.Practica2_ej2;

import java.util.List;

public class LibroTecnico extends Libro {
    private String especialidad;

    public LibroTecnico(String titulo, List<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock, String especialidad) {
        super(titulo, autores, editorial, anioEdicion, formato, isbn, stock);
        this.especialidad = especialidad;
    }

    @Override
    public String getCategoria() {
        return "Libro Técnico - " + especialidad;
    }
}
