package EjerciciosEnClase.Calculadora;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer número:");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número:");
        int num2 = scanner.nextInt();

        Calculadora calculadora = new Calculadora();
     System.out.println("Suma: " + num1 + " + " + num2 + " = " + calculadora.sumar(num1, num2));
     System.out.println("Resta: " + num1 + " - " + num2 + " = " + calculadora.restar(num1, num2));
     System.out.println("Multiplicación: " + num1 + " * " + num2 + " = " + calculadora.multiplicar(num1, num2));
     System.out.println("División: " + num1 + " / " + num2 + " = " + calculadora.dividir(num1, num2));
    }
}