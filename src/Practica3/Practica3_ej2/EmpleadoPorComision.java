package Practica3.Practica3_ej2;

public class EmpleadoPorComision extends Empleado {
    private double tasaComision;
    private double ventas;

    public EmpleadoPorComision(int legajo, String nombreApellido, double tasaComision, double ventas) {
        super(legajo, nombreApellido);
        this.tasaComision = tasaComision;
        this.ventas = ventas;
    }

    public double getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(double tasaComision) {
        this.tasaComision = tasaComision;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    @Override
    public double calcularSalario() {
        return ventas * tasaComision;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tasa Comisión: " + tasaComision + ", Ventas: " + ventas;
    }
}