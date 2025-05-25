package Practica3.Practica3_ej2;

public class EmpleadoAsalariado extends Empleado {
    private double sueldoMensual;

    public EmpleadoAsalariado(int legajo, String nombreApellido, double sueldoMensual) {
        super(legajo, nombreApellido);
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSalario() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo Mensual: " + sueldoMensual;
    }
}
