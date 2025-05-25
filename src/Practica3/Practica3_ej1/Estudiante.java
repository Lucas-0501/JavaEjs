package Practica3.Practica3_ej1;

public class Estudiante extends Persona {
    private String matricula;

    public Estudiante(String nombre, int edad, String direccion, String matricula) {
        super(nombre, edad, direccion);
        this.matricula = matricula;
    }

    public void mostrarMatricula() {
        System.out.println("Matrícula: " + matricula);
    }

    public void mostrarDatos() {
        mostrarNombre(); // Método public heredado
        mostrarEdad(); // Método protected heredado
        //mostrarDireccion(); // Método private no se puede acceder
        mostrarMatricula();
    }
}