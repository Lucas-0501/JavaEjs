package Practica3.Practica3_ej2;

public abstract class Empleado {
    private int legajo;
    private String nombreApellido;

    public Empleado(int legajo, String nombreApellido) {
        this.legajo = legajo;
        this.nombreApellido = nombreApellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Legajo: " + legajo + ", Nombre y Apellido: " + nombreApellido;
    }
}