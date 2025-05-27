package Sistema;

import java.util.*;

public class Docente extends Usuario {
    private Map<String, List<Integer>> evaluacionesParciales; // Materia y lista de notas

    public Docente(String nombre, String email) {
        super(nombre, email);
        this.evaluacionesParciales = new HashMap<>();
    }

    public void consultarAgendaClases() {
        System.out.println("Consultando agenda de clases...");
        // Implementación simulada
        System.out.println("Lunes: Matemáticas\nMiércoles: Física\nViernes: Química");
    }

    public void consultarMesasExamenes() {
        System.out.println("Consultando mesas de exámenes...");
        // Implementación simulada
        System.out.println("Matemáticas: 15/11/2023\nFísica: 20/11/2023\nQuímica: 25/11/2023");
    }

    public void altaEvaluacionParcial(String materia) {
        evaluacionesParciales.putIfAbsent(materia, new ArrayList<>());
        System.out.println("Evaluación parcial creada para la materia: " + materia);
    }

    public void bajaEvaluacionParcial(String materia) {
        if (evaluacionesParciales.remove(materia) != null) {
            System.out.println("Evaluación parcial eliminada para la materia: " + materia);
        } else {
            System.out.println("No existe una evaluación parcial para la materia: " + materia);
        }
    }

    public void cargarNotas(String materia, List<Integer> notas) {
        if (evaluacionesParciales.containsKey(materia)) {
            evaluacionesParciales.get(materia).addAll(notas);
            System.out.println("Notas cargadas para la materia: " + materia);
        } else {
            System.out.println("No existe una evaluación parcial para la materia: " + materia);
        }
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones para el docente:");
        System.out.println("1 - Consultar agenda de clases");
        System.out.println("2 - Consultar mesas de exámenes");
        System.out.println("3 - Alta de evaluaciones parciales");
        System.out.println("4 - Baja de evaluaciones parciales");
        System.out.println("5 - Carga de notas en evaluaciones parciales");
    }

    public void ejecutarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                consultarAgendaClases();
                break;
            case 2:
                consultarMesasExamenes();
                break;
            case 3:
                System.out.println("Ingrese la materia para la evaluación parcial:");
                String materiaAlta = scanner.nextLine();
                altaEvaluacionParcial(materiaAlta);
                break;
            case 4:
                System.out.println("Ingrese la materia para eliminar la evaluación parcial:");
                String materiaBaja = scanner.nextLine();
                bajaEvaluacionParcial(materiaBaja);
                break;
            case 5:
                System.out.println("Ingrese la materia para cargar notas:");
                String materiaNotas = scanner.nextLine();
                System.out.println("Ingrese las notas separadas por comas:");
                String[] notasInput = scanner.nextLine().split(",");
                List<Integer> notas = new ArrayList<>();
                for (String nota : notasInput) {
                    try {
                        int valorNota = Integer.parseInt(nota.trim());
                        if (valorNota < 0 || valorNota > 10) {
                            throw new NumberFormatException();
                        }
                        notas.add(valorNota);
                    } catch (NumberFormatException e) {
                        System.out.println("Nota inválida ignorada: " + nota.trim());
                    }
                }
                cargarNotas(materiaNotas, notas);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
