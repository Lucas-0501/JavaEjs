package Practica2_ej1;

public class BluRay extends DVD {
    private String resolucion;
    private String calidadSonido;
    // TODO: Agregar más atributos.
    private Integer cantidadCaras;

    public BluRay(String titulo, String genero, int duracion, boolean tengo, String comentario,
                  String resolucion, String calidadSonido) {
        super(titulo, genero, duracion, tengo, comentario);
        this.resolucion = resolucion;
        this.calidadSonido = calidadSonido;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    // TODO: Validar resolución. ¿Qué valores permitidos tiene la resolución?

    public String getCalidadSonido() {
        return calidadSonido;
    }

    public void setCalidadSonido(String calidadSonido) {
        this.calidadSonido = calidadSonido;
    }

    // TODO: Validar calidadSonido. ¿Qué valores permitidos tiene la calidad de sonido? 5.1? 7.1?

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(", Resolución: " + resolucion + ", Sonido: " + calidadSonido);
    }
}