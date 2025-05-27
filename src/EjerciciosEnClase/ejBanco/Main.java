package EjerciciosEnClase.ejBanco;
public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(2000.0);
        BankAccount checking = new CheckingAccount(1500.0);

        System.out.println("Cuenta de ahorros:");
        savings.deposit(500);
        savings.withdraw(1200);
        savings.withdraw(800);

        System.out.println("\nCuenta corriente:");
        checking.deposit(300);
        checking.withdraw(1000);
        checking.withdraw(1400);
    }
}