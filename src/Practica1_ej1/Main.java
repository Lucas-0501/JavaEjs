package Practica1_ej1;

public class Main {
    public static void main(String[] args) {
        // Crear socios
        Socio socio1 = new Socio("Juan Perez");
        socio1.mostrarDatos();

        Socio socio2 = new Socio("Maria Lopez");
        socio2.mostrarDatos();

        Socio socio3 = new Socio("Pedro Martinez");
        socio3.mostrarDatos();

        // Crear administrativos y comparar sueldos
        Administrativo.IngresaryCompararAdministrativos();
    }
}
