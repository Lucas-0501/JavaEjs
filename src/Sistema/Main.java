package Sistema;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1 - Alumno");
            System.out.println("2 - Docente");
            System.out.println("3 - Autoridades");

            int tipoUsuario = 0;
            while (true) {
                try {
                    tipoUsuario = Integer.parseInt(scanner.nextLine());
                    if (tipoUsuario < 1 || tipoUsuario > 3) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese una opción válida (1, 2 o 3):");
                }
            }

            switch (tipoUsuario) {
                case 1: // Alumno
                    System.out.println("Ingrese su nombre:");
                    String nombreAlumno = scanner.nextLine();
                    System.out.println("Ingrese su email:");
                    String emailAlumno = scanner.nextLine();
                    Alumno alumno = new Alumno(nombreAlumno, emailAlumno);
                    gestor.registrarUsuario(alumno);
                    ejecutarOpcionesAlumno(alumno, scanner);
                    break;

                case 2: // Docente
                    System.out.println("Ingrese su nombre:");
                    String nombreDocente = scanner.nextLine();
                    System.out.println("Ingrese su email:");
                    String emailDocente = scanner.nextLine();
                    Docente docente = new Docente(nombreDocente, emailDocente);
                    gestor.registrarUsuario(docente);
                    ejecutarOpcionesDocente(docente, scanner);
                    break;

                case 3: // Autoridades
                    System.out.println("Ingrese su nombre:");
                    String nombreAutoridad = scanner.nextLine();
                    System.out.println("Ingrese su email:");
                    String emailAutoridad = scanner.nextLine();
                    Autoridades autoridad = new Autoridades(nombreAutoridad, emailAutoridad);
                    gestor.registrarUsuario(autoridad);
                    ejecutarOpcionesAutoridad(autoridad, scanner, gestor.getUsuarios());
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("¿Desea continuar? (s/n):");
            String respuesta = scanner.nextLine();
            while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                System.out.println("Por favor, ingrese 's' para continuar o 'n' para salir:");
                respuesta = scanner.nextLine();
            }
            continuar = respuesta.equalsIgnoreCase("s");
        }
    }

    private static void ejecutarOpcionesAlumno(Alumno alumno, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            alumno.mostrarOpciones();
            System.out.print("Seleccione una opción para el alumno: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            alumno.ejecutarOpcion(opcion, scanner);

            System.out.println("¿Desea realizar otra acción? (s/n):");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
    }

    private static void ejecutarOpcionesDocente(Docente docente, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            docente.mostrarOpciones();
            System.out.print("Seleccione una opción para el docente: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            docente.ejecutarOpcion(opcion, scanner);

            System.out.println("¿Desea realizar otra acción? (s/n):");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
    }

    private static void ejecutarOpcionesAutoridad(Autoridades autoridad, Scanner scanner, List<Usuario> usuarios) {
        boolean continuar = true;
        while (continuar) {
            autoridad.mostrarOpciones();
            System.out.print("Seleccione una opción para las autoridades: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 1) { // Consultar ficha de un alumno
                System.out.println("Seleccione el número del alumno:");
                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(i) instanceof Alumno) {
                        System.out.println((i + 1) + " - " + usuarios.get(i).getNombre());
                    }
                }
                int seleccion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                if (seleccion > 0 && seleccion <= usuarios.size() && usuarios.get(seleccion - 1) instanceof Alumno) {
                    Alumno alumnoSeleccionado = (Alumno) usuarios.get(seleccion - 1);
                    autoridad.ejecutarOpcion(opcion, scanner, alumnoSeleccionado);
                } else {
                    System.out.println("Selección no válida.");
                }
            } else {
                autoridad.ejecutarOpcion(opcion, scanner, null);
            }

            System.out.println("¿Desea realizar otra acción? (s/n):");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
    }
}
