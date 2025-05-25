package Practica3.Practica3_ej2;

public class EmpleadoBaseMasComision extends Empleado {
    private double sueldoBase;
    private double tasaComision;
    private double ventas;

    public EmpleadoBaseMasComision(int legajo, String nombreApellido, double sueldoBase, double tasaComision, double ventas) {
        super(legajo, nombreApellido);
        this.sueldoBase = sueldoBase;
        this.tasaComision = tasaComision;
        this.ventas = ventas;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
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
        return sueldoBase + (ventas * tasaComision);
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo Base: " + sueldoBase + ", Tasa Comisión: " + tasaComision + ", Ventas: " + ventas;
    }
}