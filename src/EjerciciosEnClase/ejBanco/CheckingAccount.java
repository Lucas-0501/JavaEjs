package EjerciciosEnClase.ejBanco;

// Subclase CheckingAccount
public class CheckingAccount extends BankAccount {
    private static final double TRANSACTION_FEE = 100.0;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + TRANSACTION_FEE;
        if (amount > 0 && totalAmount <= balance) {
            balance -= totalAmount;
            System.out.println("Retiro exitoso con una tarifa de " + TRANSACTION_FEE + ". Saldo actual: " + balance);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }
}