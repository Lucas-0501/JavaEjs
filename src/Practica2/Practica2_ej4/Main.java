package Practica2.Practica2_ej4;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Cargar notas");
            System.out.println("5. Calcular promedio del curso");
            System.out.println("6. Cantidad de estudiantes aprobados");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> curso.anadirEstudiante();
                case 2 -> curso.buscarEstudiante();
                case 3 -> curso.eliminarEstudiante();
                case 4 -> curso.cargarNotas();
                case 5 -> curso.calcularPromedio();
                case 6 -> curso.cantidadEstudiantesAprobados();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }
}