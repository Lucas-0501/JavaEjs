package Practica1.Practica1_ej6;

public class Planeta {
    // Atributos
    private String nombre = null;
    private int cantidadSatelites = 0;
    private double masa = 0.0; // en kilogramos
    private double volumen = 0.0; // en kilómetros cúbicos
    private int diametro = 0; // en kilómetros
    private int distanciaMediaSol = 0; // en millones de kilómetros
    private TipoPlaneta tipoPlaneta;
    private boolean observableSimpleVista = false;

    // Enumeración para el tipo de planeta
    public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distanciaMediaSol, TipoPlaneta tipoPlaneta, boolean observableSimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaSol = distanciaMediaSol;
        this.tipoPlaneta = tipoPlaneta;
        this.observableSimpleVista = observableSimpleVista;
    }

    public void mostrarAtributos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa (kg): " + masa);
        System.out.println("Volumen (km³): " + volumen);
        System.out.println("Diámetro (km): " + diametro);
        System.out.println("Distancia media al Sol (millones de km): " + distanciaMediaSol);
        System.out.println("Tipo de planeta: " + tipoPlaneta);
        System.out.println("Observable a simple vista: " + observableSimpleVista);
    }

    public double calcularDensidad() {
        if (volumen == 0) {
            return 0;
        }
        return masa / volumen;
    }

    // Método para determinar si es un planeta exterior
    public boolean esPlanetaExterior() {
        double distanciaEnUA = distanciaMediaSol * 1_000_000.0 / 149_597_870.0; // Convertir a UA
        return distanciaEnUA > 3.4;
    }
}