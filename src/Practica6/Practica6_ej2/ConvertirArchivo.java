package Practica6.Practica6_ej2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertirArchivo {

    public static void convertirArchivo(String archivoEntrada, String archivoSalida, boolean aMayusculas) {
        Path entrada = Paths.get(archivoEntrada);
        Path salida = Paths.get(archivoSalida);

        try {
            // Leer todas las líneas del archivo de entrada
            List<String> lineas = Files.readAllLines(entrada);

            // Convertir las líneas según la opción especificada
            List<String> lineasConvertidas = lineas.stream()
                    .map(linea -> aMayusculas ? linea.toUpperCase() : linea.toLowerCase())
                    .collect(Collectors.toList());

            // Escribir las líneas convertidas en el archivo de salida
            Files.write(salida, lineasConvertidas);

            System.out.println("Archivo convertido con éxito.");
        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java ConvertirArchivo <archivoEntrada> <archivoSalida> <mayusculas|minusculas>");
            return;
        }

        String archivoEntrada = args[0];
        String archivoSalida = args[1];
        boolean aMayusculas = args[2].equalsIgnoreCase("mayusculas");

        convertirArchivo(archivoEntrada, archivoSalida, aMayusculas);
    }
}