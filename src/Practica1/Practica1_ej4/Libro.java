package Practica1.Practica1_ej4;

public class Libro {
    private String titulo;
    private boolean original;
    private boolean prestable;

    public Libro(String titulo, boolean original, boolean prestable) {
        this.titulo = titulo;
        this.original = original;
        this.prestable = prestable;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getOriginal() {
        return original;
    }

    public boolean getPrestable() {
        return prestable;
    }


    public boolean esOriginal() {
        return original;
    }

    public boolean sePresta() {
        return prestable;
    }

    // Métodos 'set'
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public void setPrestable(boolean prestable) {
        this.prestable = prestable;
    }

    // Método para mostrar información del libro
    @Override
    public String toString() {
        return "Libro{" +
                "título='" + titulo + '\'' +
                ", original=" + original +
                ", prestable=" + prestable +
                '}';
    }
}