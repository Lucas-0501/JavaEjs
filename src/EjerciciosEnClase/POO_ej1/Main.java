package EjerciciosEnClase.POO_ej1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese la base del rectángulo: ");
            double base = scanner.nextDouble();

            System.out.print("Ingrese la altura del rectángulo: ");
            double altura = scanner.nextDouble();

            if (base <= 0 || altura <= 0) {
                throw new IllegalArgumentException("La base y la altura deben ser mayores a cero");
            }
            Rectangulo rectangulo = new Rectangulo(base, altura);
            System.out.println("Base: " + rectangulo.getBase());
            System.out.println("Altura: " + rectangulo.getAltura());
            System.out.println("Área: " + rectangulo.calcularArea());
            System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
