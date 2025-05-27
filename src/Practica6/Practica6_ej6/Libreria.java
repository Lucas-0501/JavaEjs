package Practica6.Practica6_ej6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libros;
    private List<Proveedor> proveedores;
    private static final String ARCHIVO_LIBROS = "libros.txt";

    public Libreria() {
        this.libros = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        cargarLibrosDesdeArchivo();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibrosEnArchivo();
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
        guardarLibrosEnArchivo();
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void modificarStock(String titulo, int cantidad) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.actualizarStock(cantidad);
            guardarLibrosEnArchivo();
        }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void venderLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            if (libro.getStock() > 0) {
                libro.actualizarStock(-1);
                guardarLibrosEnArchivo();
                System.out.println("Libro vendido: " + titulo);
            } else {
                System.out.println("Stock agotado. Realizando encargo...");
                realizarEncargo(libro);
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void realizarEncargo(Libro libro) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.puedeSuministrar(libro.getEditorial())) {
                System.out.println("Encargo realizado al proveedor: " + proveedor.getNombre());
                return;
            }
        }
        System.out.println("No se encontró un proveedor para la editorial: " + libro.getEditorial());
    }

    private void guardarLibrosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS))) {
            for (Libro libro : libros) {
                String tipo = libro instanceof LibroTecnico ? "Tecnico" : "Novela";
                String categoria = libro.getCategoria().replace("Novela - ", "").replace("Libro Técnico - ", "");
                writer.write(String.join(",",
                        tipo,
                        libro.getTitulo(),
                        String.join(";", libro.getAutores()),
                        libro.getEditorial(),
                        String.valueOf(libro.getAnioEdicion()),
                        libro.getFormato(),
                        libro.getIsbn(),
                        String.valueOf(libro.getStock()),
                        categoria));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los libros en el archivo: " + e.getMessage());
        }
    }

    private void cargarLibrosDesdeArchivo() {
        File archivo = new File(ARCHIVO_LIBROS);
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_LIBROS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String tipo = partes[0];
                String titulo = partes[1];
                List<String> autores = List.of(partes[2].split(";"));
                String editorial = partes[3];
                int anioEdicion = Integer.parseInt(partes[4]);
                String formato = partes[5];
                String isbn = partes[6];
                int stock = Integer.parseInt(partes[7]);
                String categoria = partes[8];

                if (tipo.equals("Tecnico")) {
                    libros.add(new LibroTecnico(titulo, autores, editorial, anioEdicion, formato, isbn, stock, categoria));
                } else {
                    libros.add(new Novela(titulo, autores, editorial, anioEdicion, formato, isbn, stock, categoria));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los libros desde el archivo: " + e.getMessage());
        }
    }
}