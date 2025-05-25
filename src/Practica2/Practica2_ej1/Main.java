package Practica2_ej1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        int opcion;

        do {
            mostrarMenu();
            opcion = catalogo.leerOpcionMenu();

            switch (opcion) {
                case 1:
                    catalogo.agregarDVDInteractivo();
                    break;
                case 2:
                    catalogo.eliminarDVDInteractivo();
                    break;
                case 3:
                    catalogo.modificarDVDInteractivo();
                    break;
                case 4:
                    catalogo.listarTodos();
                    break;
                case 5:
                    catalogo.listarTengo();
                    break;
                case 6:
                    catalogo.listarDuracionMenorA();
                    break;
                case 7:
                    catalogo.listarOrdenadosPorTitulo();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ CATÁLOGO ---");
        System.out.println("1. Agregar DVD");
        System.out.println("2. Eliminar DVD");
        System.out.println("3. Modificar DVD");
        System.out.println("4. Listar todos");
        System.out.println("5. Listar los que tengo");
        System.out.println("6. Listar por duración");
        System.out.println("7. Ordenar por título");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
    }

}