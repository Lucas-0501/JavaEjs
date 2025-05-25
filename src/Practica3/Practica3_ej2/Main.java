package Practica3.Practica3_ej2;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new EmpleadoAsalariado(1, "Juan Pérez", 50000);
        Empleado empleado2 = new EmpleadoPorHoras(2, "Ana López", 20000, 40, 500);
        Empleado empleado3 = new EmpleadoPorComision(3, "Carlos Gómez", 0.1, 100000);
        Empleado empleado4 = new EmpleadoBaseMasComision(4, "María Fernández", 30000, 0.05, 80000);

        Empleado[] empleados = {empleado1, empleado2, empleado3, empleado4};

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
            System.out.println("Salario: " + empleado.calcularSalario());
            System.out.println();
        }
    }
}
