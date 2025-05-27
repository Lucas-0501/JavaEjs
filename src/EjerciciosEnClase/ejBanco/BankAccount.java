package EjerciciosEnClase.ejBanco;
public class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito exitoso. Saldo actual: " + balance);
        } else {
            System.out.println("El monto del depósito debe ser positivo.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Retiro exitoso. Saldo actual: " + balance);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    public double getBalance() {
        return balance;
    }
}