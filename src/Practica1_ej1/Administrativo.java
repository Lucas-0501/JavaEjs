package Practica1_ej1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrativo {
    private String nombre;
    private String telefono;
    private double sueldo;

    public Administrativo(String nombre, String telefono, double sueldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void mostrarDatos() {
        System.out.println("Administrativo: " + nombre + ", Teléfono: " + telefono + ", Sueldo: $" + sueldo);
    }

    public static Administrativo cargarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre: ");
        String nombre = leerNombreValido(scanner);
        System.out.print("Ingrese teléfono: ");
        String telefono = leerTelefonoValido(scanner);
        System.out.print("Ingrese sueldo: ");
        double sueldo = leerSueldoValido(scanner);
        Administrativo adm = new Administrativo(nombre, telefono, sueldo);
        adm.mostrarDatos();
        return adm;
    }
    private static String leerNombreValido(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese Nombre (solo letras): ");
            String nombre = scanner.nextLine();
            if (nombre.matches("[a-zA-Z]+")) { // Verifica que contenga solo letras
                return nombre;
            } else {
                System.out.println("Nombre inválido. Debe contener solo letras.");
            }
        }
    }
    private static String leerTelefonoValido(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese teléfono (solo numeros, minimo 8): ");
            String telefono = scanner.nextLine();
            if (telefono.matches("\\d{8,}")) { // Verifica que contenga solo números y al menos 8 dígitos
                return telefono;
            } else {
                System.out.println("Teléfono inválido. Debe contener solo números y al menos 8 dígitos.");
            }
        }
    }
    private static double leerSueldoValido(Scanner scanner) {
        while (true){
                try {
                    System.out.print("Ingrese sueldo (positivo): ");
                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();

                    if (sueldo <= 0) {
                        System.out.println("El sueldo debe ser un número positivo. Intente nuevamente.");
                    } else {
                        return sueldo;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                    scanner.nextLine(); // Limpiar el buffer para que no quede un valor inválido
                }
        }
    }
    public static void IngresaryCompararAdministrativos() {
        Administrativo adm1 = cargarDatos();
        Administrativo adm2 = cargarDatos();

        if (adm1.getSueldo() > adm2.getSueldo()) {
            System.out.println("El administrativo con mayor sueldo es: " + adm1.getNombre());
        } else if (adm2.getSueldo() > adm1.getSueldo()) {
            System.out.println("El administrativo con mayor sueldo es: " + adm2.getNombre());
        } else {
            System.out.println("Ambos administrativos tienen el mismo sueldo.");
        }
    }
}


