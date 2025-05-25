package Practica1_ej1;

public class Socio {
    private String nombre;
    private int numero;
    private static int proximoNumero = 1;

    public Socio(String nombre) {
        this.nombre = nombre;
        this.numero = proximoNumero++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarDatos() {
        System.out.println("Socio: " + nombre + ", Número: " + numero);
    }
}
