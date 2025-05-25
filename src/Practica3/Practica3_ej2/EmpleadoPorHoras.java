package Practica3.Practica3_ej2;

public class EmpleadoPorHoras extends Empleado {
    private double sueldoBasico;
    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHoras(int legajo, String nombreApellido, double sueldoBasico, int horasTrabajadas, double valorHora) {
        super(legajo, nombreApellido);
        this.sueldoBasico = sueldoBasico;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return sueldoBasico + (horasTrabajadas * valorHora);
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo Básico: " + sueldoBasico + ", Horas Trabajadas: " + horasTrabajadas + ", Valor Hora: " + valorHora;
    }
}