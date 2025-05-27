package Sistema;

import java.util.*;

public class Autoridades extends Usuario {

    public Autoridades(String nombre, String email) {
        super(nombre, email);
    }

    public void consultarFichaAlumno(Alumno alumno) {
        System.out.println("Ficha del alumno:");
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Email: " + alumno.getEmail());
        System.out.println("Materias inscritas: " + alumno.getMateriasInscritas().keySet());
        System.out.println("Notas: " + alumno.getNotasMaterias());
        System.out.println("Días de cursada: " + alumno.getDiasCursada());
        // Aquí se pueden agregar más detalles como sanciones, títulos, etc.
    }

    public void consultarActas() {
        System.out.println("Consultando actas de examen, regularidad y promoción...");
        // Implementación simulada
        System.out.println("Acta de Matemáticas: Aprobado\nActa de Física: Regular\nActa de Química: Promoción");
    }

    public void consultarPlanesEstudio() {
        System.out.println("Consultando planes de estudio...");
        // Implementación simulada
        System.out.println("Plan de Matemáticas: 2023\nPlan de Física: 2022\nPlan de Química: 2021");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones para las autoridades:");
        System.out.println("1 - Consultar ficha del alumno");
        System.out.println("2 - Consultar actas de examen, regularidad y promoción");
        System.out.println("3 - Consultar planes de estudio");
    }

    public void ejecutarOpcion(int opcion, Scanner scanner, Alumno alumno) {
        switch (opcion) {
            case 1:
                if (alumno == null) {
                    System.out.println("No se seleccionó un alumno válido.");
                    break;
                }
                consultarFichaAlumno(alumno);
                break;
            case 2:
                consultarActas();
                break;
            case 3:
                consultarPlanesEstudio();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
