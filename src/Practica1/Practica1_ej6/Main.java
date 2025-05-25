package Practica1.Practica1_ej6;

public class Main {
    public static void main(String[] args) {

        Planeta jupiter = new Planeta("Júpiter", 79, 1.898E27, 1.43128E15, 139820, 778, Planeta.TipoPlaneta.GASEOSO, true);
        Planeta marte = new Planeta("Marte", 2, 6.39E23, 1.6318E11, 6779, 228, Planeta.TipoPlaneta.TERRESTRE, true);


        System.out.println("Planeta 1:");
        jupiter.mostrarAtributos();
        System.out.println("Densidad: " + jupiter.calcularDensidad() + " kg/km³");
        System.out.println("¿Es un planeta exterior? " + jupiter.esPlanetaExterior());

        System.out.println("\nPlaneta 2:");
        marte.mostrarAtributos();
        System.out.println("Densidad: " + marte.calcularDensidad() + " kg/km³");
        System.out.println("¿Es un planeta exterior? " + marte.esPlanetaExterior());
    }
}