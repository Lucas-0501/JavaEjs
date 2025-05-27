package EjerciciosEnClase.EJ2_29_04;

public class Point3D extends Point {
    private int z;
    private String color;

    public Point3D(int x, int y, int z, String color) {
        super(x, y);
        this.z = z;
        this.color = color;
    }

    public int getZ() {
        return z;
    }

    public String getColor() {
        return color;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
