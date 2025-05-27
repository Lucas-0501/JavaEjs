package EjerciciosEnClase.text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Txt {

    public static int contarLineas(String rutaArchivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contador;
    }

    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\lucas\\IdeaProjects\\Lucas\\src\\Archivos\\text\\datos.txt";
        int cantidadLineas = contarLineas(rutaArchivo);
        System.out.println("El archivo tiene " + cantidadLineas + " líneas.");
    }
}