package Practica6.Practica6_ej6;

import java.util.List;

public class Proveedor {
    private String nombre;
    private List<String> editoriales;

    public Proveedor(String nombre, List<String> editoriales) {
        this.nombre = nombre;
        this.editoriales = editoriales;
    }

    public boolean puedeSuministrar(String editorial) {
        return editoriales.contains(editorial);
    }

    public String getNombre() {
        return nombre;
    }
}
