package Practica1.Practica1_ej5;

public class Cuenta {
    private static long contadorCuentas = 100001;
    private final long numeroCuenta; // Número de cuenta (no modificable)
    private long dniCliente; // DNI del cliente
    private double saldoActual;
    private double interesAnual;

    // Constructor por defecto
    public Cuenta() {
        this.numeroCuenta = contadorCuentas++;
        this.dniCliente = 0;
        this.saldoActual = 0.0;
        this.interesAnual = 0.0;
    }

    // Constructor con DNI, saldo e interés
    public Cuenta(long dniCliente, double saldoActual, double interesAnual) {
        this.numeroCuenta = contadorCuentas++;
        this.dniCliente = dniCliente;
        this.saldoActual = saldoActual;
        this.interesAnual = interesAnual;
    }

    // getters
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public long getDniCliente() {
        return dniCliente;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    //  setters
    public void setDniCliente(long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public void actualizarSaldo() {
        double interesDiario = interesAnual / 365; // Interés diario en decimal
        saldoActual += saldoActual * interesDiario;
    }

    // Método para ingresar dinero en la cuenta
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldoActual += cantidad;
        } else {
            System.out.println("La cantidad a ingresar debe ser positiva.");
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldoActual) {
            saldoActual -= cantidad;
        } else {
            System.out.println("No se puede retirar la cantidad solicitada. Verifique el saldo.");
        }
    }

    // Método para mostrar todos los datos de la cuenta
    public void mostrarDatos() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("DNI del cliente: " + dniCliente);
        System.out.println("Saldo actual: $" + saldoActual);
        System.out.println("Interés anual: " + interesAnual + "%");
    }
}