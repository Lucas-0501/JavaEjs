package Practica2.Practica2_ej4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private List<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    public void anadirEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = scanner.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                System.out.println("El código ya existe. No se puede añadir el estudiante.");
                return;
            }
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos del estudiante: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el número de semestre: ");
        int semestre = scanner.nextInt();
        System.out.print("Ingrese la nota final: ");
        double notaFinal = scanner.nextDouble();

        estudiantes.add(new Estudiante(nombre, apellidos, codigo, semestre, notaFinal));
        System.out.println("Estudiante añadido correctamente.");
    }

    public void buscarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante a buscar: ");
        String codigo = scanner.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                System.out.println("Estudiante encontrado: " + estudiante);
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    public void eliminarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante a eliminar: ");
        String codigo = scanner.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                System.out.println("Estudiante encontrado: " + estudiante);
                System.out.print("¿Está seguro de que desea eliminarlo? (s/n): ");
                String confirmacion = scanner.nextLine();
                if (confirmacion.equalsIgnoreCase("s")) {
                    estudiantes.remove(estudiante);
                    System.out.println("Estudiante eliminado correctamente.");
                } else {
                    System.out.println("Eliminación cancelada.");
                }
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    public void cargarNotas() {
        Scanner scanner = new Scanner(System.in);
        for (Estudiante estudiante : estudiantes) {
            System.out.print("Ingrese la nueva nota final para el estudiante con código " + estudiante.getCodigo() + ": ");
            double nuevaNota = scanner.nextDouble();
            estudiante = new Estudiante(estudiante.toString(), estudiante.toString(), estudiante.getCodigo(), 0, nuevaNota);
        }
        System.out.println("Notas actualizadas correctamente.");
    }

    public void calcularPromedio() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el curso.");
            return;
        }

        double sumaNotas = 0;
        for (Estudiante estudiante : estudiantes) {
            sumaNotas += estudiante.getNotaFinal();
        }

        double promedio = sumaNotas / estudiantes.size();
        System.out.println("El promedio del curso es: " + promedio);
    }

    public void cantidadEstudiantesAprobados() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el curso.");
            return;
        }

        int aprobados = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNotaFinal() >= 4.0) {
                aprobados++;
            }
        }

        double porcentaje = (aprobados * 100.0) / estudiantes.size();
        System.out.println("Cantidad de estudiantes aprobados: " + aprobados);
        System.out.println("Porcentaje de estudiantes aprobados: " + porcentaje + "%");
    }
}