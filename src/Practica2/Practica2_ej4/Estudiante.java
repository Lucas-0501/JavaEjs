package Practica2.Practica2_ej4;

public class Estudiante {
    private String nombre;
    private String apellidos;
    private String codigo;
    private int semestre;
    private double notaFinal;

    public Estudiante(String nombre, String apellidos, String codigo, int semestre, double notaFinal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.semestre = semestre;
        this.notaFinal = notaFinal;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", codigo='" + codigo + '\'' +
                ", semestre=" + semestre +
                ", notaFinal=" + notaFinal +
                '}';
    }
}