package Practica6.Practica6_ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorArchivo {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ContadorArchivo <opciones> <nombre_archivo>");
            System.out.println("Opciones:");
            System.out.println("  c - Contar caracteres");
            System.out.println("  l - Contar líneas");
            return;
        }

        String opciones = args[0];
        String nombreArchivo = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int contadorCaracteres = 0;
            int contadorLineas = 0;
            String linea;

            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                contadorCaracteres += linea.length();
            }

            if (opciones.contains("c")) {
                System.out.println("Cantidad de caracteres: " + contadorCaracteres);
            }
            if (opciones.contains("l")) {
                System.out.println("Cantidad de líneas: " + contadorLineas);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}