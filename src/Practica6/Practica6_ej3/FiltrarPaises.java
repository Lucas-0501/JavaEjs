package Practica6.Practica6_ej3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FiltrarPaises {

    public static void filtrarPaises(String archivoEntrada, String archivoSalidaMenor30, String archivoSalidaMayorIgual30) {
        Path entrada = Paths.get(archivoEntrada);
        Path salidaMenor30 = Paths.get(archivoSalidaMenor30);
        Path salidaMayorIgual30 = Paths.get(archivoSalidaMayorIgual30);

        try {
            // Leer todas las líneas del archivo de entrada
            List<String> lineas = Files.readAllLines(entrada);

            // Filtrar y escribir países con población menor a 30 millones
            List<String> paisesMenor30 = lineas.stream()
                    .filter(linea -> {
                        String[] partes = linea.split("\\s*,\\s*");
                        double poblacion = Double.parseDouble(partes[1]);
                        return poblacion < 30;
                    })
                    .collect(Collectors.toList());
            Files.write(salidaMenor30, paisesMenor30);

            // Filtrar y escribir países con población mayor o igual a 30 millones
            List<String> paisesMayorIgual30 = lineas.stream()
                    .filter(linea -> {
                        String[] partes = linea.split("\\s*,\\s*");
                        double poblacion = Double.parseDouble(partes[1]);
                        return poblacion >= 30;
                    })
                    .collect(Collectors.toList());
            Files.write(salidaMayorIgual30, paisesMayorIgual30);

            System.out.println("Archivos generados con éxito.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java FiltrarPaises <archivoEntrada> <archivoSalidaMenor30> <archivoSalidaMayorIgual30>");
            return;
        }

        String archivoEntrada = args[0];
        String archivoSalidaMenor30 = args[1];
        String archivoSalidaMayorIgual30 = args[2];

        filtrarPaises(archivoEntrada, archivoSalidaMenor30, archivoSalidaMayorIgual30);
    }
}