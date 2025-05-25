package Practica1.Practica1_ej5;

public class Main {
    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta(12345678, 1000.0, 5.0);

        cuenta1.mostrarDatos();

        // Actualizar el saldo aplicando el interés diario
        cuenta1.actualizarSaldo();
        System.out.println("\nDespués de actualizar el saldo con el interés diario:");
        cuenta1.mostrarDatos();

        // Ingresar dinero
        cuenta1.ingresar(500.0);
        System.out.println("\nDespués de ingresar 500.0:");
        cuenta1.mostrarDatos();

        // Retirar dinero
        cuenta1.retirar(300.0);
        System.out.println("\nDespués de retirar 300.0:");
        cuenta1.mostrarDatos();
    }
}
