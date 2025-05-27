package EjerciciosEnClase.ejBanco;

// Subclase SavingsAccount
public class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000.0;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("El monto excede el límite de retiro de " + WITHDRAWAL_LIMIT);
        } else if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Retiro exitoso. Saldo actual: " + balance);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }
}

