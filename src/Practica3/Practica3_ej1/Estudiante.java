// Clase Estudiante
package Practica3.Practica3_ej1;

public class Estudiante extends Persona {
    private String matricula;

    public Estudiante(String nombre, int edad, String direccion, String matricula) {
        super(nombre, edad, direccion);
        this.matricula = matricula;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Llama al método de la clase base
        System.out.println("Matrícula: " + matricula);
    }
}