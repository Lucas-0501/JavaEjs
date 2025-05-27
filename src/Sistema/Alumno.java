package Sistema;

import java.time.LocalDate;
import java.util.*;

public class Alumno extends Usuario {
    private Map<String, LocalDate> materiasInscritas; // Materia y fecha de inscripción
    private Map<String, Integer> notasMaterias; // Materia y nota
    private Map<String, String> diasCursada; // Materia y días de cursada

    public Alumno(String nombre, String email) {
        super(nombre, email);
        this.materiasInscritas = new HashMap<>();
        this.notasMaterias = new HashMap<>();
        this.diasCursada = new HashMap<>();
    }

    public void inscribirseACursada(String materiasInput) {
        if (materiasInput == null || materiasInput.trim().isEmpty()) {
            System.out.println("No se ingresaron materias válidas.");
            return;
        }
        String[] materias = materiasInput.split(",");
        LocalDate fechaActual = LocalDate.now();
        for (String materia : materias) {
            materia = materia.trim();
            if (!materia.isEmpty()) {
                materiasInscritas.put(materia, fechaActual);
            } else {
                System.out.println("Materia inválida ignorada.");
            }
        }
        System.out.println("Materias inscritas: " + materiasInscritas.keySet() + " en la fecha: " + fechaActual);
    }

    public void consultarInscripciones() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Materias inscritas: ");
        for (Map.Entry<String, LocalDate> entry : materiasInscritas.entrySet()) {
            System.out.println("- " + entry.getKey() + " (Fecha de inscripción: " + entry.getValue() + ")");
        }
    }

    public void consultarCronograma() {
        System.out.println("Fechas de inscripción a exámenes:");
        Random random = new Random();
        for (String materia : materiasInscritas.keySet()) {
            // Generar una fecha aleatoria dentro de los próximos 30 días
            LocalDate fechaExamen = LocalDate.now().plusDays(random.nextInt(30) + 1);
            System.out.println("- " + materia + ": " + fechaExamen);
        }
    }

    public void consultarNotasEvaluaciones() {
        Random random = new Random();
        for (String materia : materiasInscritas.keySet()) {
            int nota = random.nextInt(10) + 1; // Generar nota aleatoria entre 1 y 10
            notasMaterias.put(materia, nota);
        }
        System.out.println("Notas asignadas a las materias:");
        for (Map.Entry<String, Integer> entry : notasMaterias.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void consultarMateriasRegulares() {
        System.out.println("Materias inscritas: " + materiasInscritas.keySet());
    }

    public void consultarAgendaClases() {
        Random random = new Random();
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        for (String materia : materiasInscritas.keySet()) {
            String dia = dias[random.nextInt(dias.length)];
            diasCursada.put(materia, dia);
        }
        System.out.println("Días de cursada asignados a las materias:");
        for (Map.Entry<String, String> entry : diasCursada.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, LocalDate> getMateriasInscritas() {
        return materiasInscritas;
    }

    public Map<String, Integer> getNotasMaterias() {
        return notasMaterias;
    }

    public Map<String, String> getDiasCursada() {
        return diasCursada;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones para el alumno:");
        System.out.println("1 - Inscripción a exámenes y cursadas");
        System.out.println("2 - Consulta de inscripciones, plan de estudios e historia académica");
        System.out.println("3 - Consulta de cronograma de evaluaciones parciales");
        System.out.println("4 - Consulta de notas de evaluaciones parciales");
        System.out.println("5 - Consulta de materias regulares");
        System.out.println("6 - Consulta de agenda de clases");
    }

    public void ejecutarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                System.out.println("Ingrese las materias separadas por comas:");
                String materiasInput = scanner.nextLine();
                inscribirseACursada(materiasInput);
                break;
            case 2:
                consultarInscripciones();
                break;
            case 3:
                consultarCronograma();
                break;
            case 4:
                consultarNotasEvaluaciones();
                break;
            case 5:
                consultarMateriasRegulares();
                break;
            case 6:
                consultarAgendaClases();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}

