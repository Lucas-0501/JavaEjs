package Practica2_ej1;

public class DVD {

    private String titulo;
    private String genero;
    private int duracion;
    private boolean tengo;
    private String comentario;

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser vacío.");
        }
    }
    private void validarGenero(String genero) {
        // TODO: ¿Son redundantes las condiciones del IF?
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }
        // TODO: Convertir a toUpperCase <=> genera es lowerCase.
        switch (genero.toUpperCase()) {
            case "S": // Suspenso
            case "C": // Comedia
            case "T": // Terror
                break;
            default:
                throw new IllegalArgumentException("El género debe ser 'S' (Suspenso), 'C' (Comedia) o 'T' (Terror).");
        }
    }
    private void validarDuracion(int duracion) {
        // TODO: Agregar espacio entre duracion > 1000. ¿Unidad de medida de duración?
        if (duracion <= 0 || duracion> 1000) {
            throw new IllegalArgumentException("La duración debe ser positiva.");
        }
    }
    private void validarComentario(String comentario) {
        // TODO: Agregar que no se pueda comentar más de X (a definir) caracteres.
        if (comentario == null || comentario.trim().isEmpty()) {
            throw new IllegalArgumentException("El comentario no puede ser nulo.");
        }
    }
    public DVD(String titulo, String genero, int duracion, boolean tengo, String comentario) {
        validarTitulo(titulo);
        validarGenero(genero);
        validarDuracion(duracion);
        validarComentario(comentario);
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tengo = tengo;
        this.comentario = comentario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        validarTitulo(titulo);
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        validarGenero(genero);
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        validarDuracion(duracion);
        this.duracion = duracion;
    }

    //TODO: Refactorizar el nombre del método loTengo a getTengo.
    public boolean loTengo() {
        return tengo;
    }

    public void setTengo(boolean tengo) {
        this.tengo = tengo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        validarComentario(comentario);
        this.comentario = comentario;
    }

    public void mostrarDatos() {
        System.out.println("Título: " + titulo + ", Género: " + genero + ", Duración: " + duracion + " minutos, Tengo: " + (tengo ? "Sí" : "No") + ", Comentario: " + comentario);
    }
}