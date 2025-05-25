package Practica1.Practica1_ej2;

public class pruebaFactura {
    public static void main(String[] args){
        Factura factura1 = new Factura(1, 101, 5, -500,"Tornillo");
        Factura factura2 = new Factura(2,100,500,100,"Clavo");
        factura1.imprimirFactura();
        factura2.imprimirFactura();
    }
}
