package Practica3.Practica3_ej1;

public class Persona {
    protected String nombre;
    private int edad;
    public String direccion;

    public Persona(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public void mostrarNombre() {
        System.out.println("Nombre: " + nombre);
    }

    protected void mostrarEdad() {
        System.out.println("Edad: " + edad);
    }

    private void mostrarDireccion() {
        System.out.println("Dirección: " + direccion);
    }
}