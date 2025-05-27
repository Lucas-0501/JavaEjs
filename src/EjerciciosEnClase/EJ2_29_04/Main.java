package EjerciciosEnClase.EJ2_29_04;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        System.out.println("Coordenas del punto: (" + point.getX() + ", " + point.getY() + ")");

        Point3D point3D = new Point3D(3, 4, 5, "rojo");
        System.out.println("Coordenadas del punto 3D: (" + point3D.getX() + ", " + point3D.getY() + ", " + point3D.getZ() + ")");
        System.out.println("Color del punto 3D: " + point3D.getColor());
    }
}
