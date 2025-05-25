package Practica1.Practica1_ej2;
/**
 * Clase que representa una factura de artículos vendidos en una ferretería.
 * Incluye información como número de factura, artículo, cantidad, precio unitario y descripción.
 * Realiza validaciones para asegurar que los valores negativos se conviertan a cero.
 */
public class Factura {
    private int nroFactura;
    private int nroArticulo;
    private int cantidad;
    private double precioUnitario;
    private String descripcionArticulo;

    public Factura(int nroFactura, int nroArticulo, int cantidad, double precioUnitario, String descripcionArticulo) {
        this.nroFactura = nroFactura;
        this.nroArticulo = nroArticulo;
        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
        this.descripcionArticulo = descripcionArticulo;
    }
    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getNroArticulo() {
        return nroArticulo;
    }

    public void setNroArticulo(int nroArticulo) {
        this.nroArticulo = nroArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad;
        }
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario < 0){
            this.precioUnitario = 0.0;
        } else {
            this.precioUnitario = precioUnitario;
        }
    }
    public String getDescripcionArticulo(){
        return descripcionArticulo;
    }
    public void setDescripcionArticulo(String descripcionArticulo){
        this.descripcionArticulo = descripcionArticulo;
    }
    public double obtenerMontoFactura() {
        double monto = (double) cantidad * precioUnitario;
        return monto;
    }
    public void imprimirFactura(){
        System.out.println("Número de Factura: " + this.nroFactura);
        System.out.println("Artículo: " + nroArticulo + " - " + this.descripcionArticulo);
        System.out.println("Cantidad: " + this.cantidad);
        System.out.println("Precio Unitario: $" + this.precioUnitario);
        System.out.println("Monto Total: $" + obtenerMontoFactura());
        System.out.println("------------------------");
    }
}
