package EntidadesAuxiliares;


public class nodoBeerMostReview {

    private String nombre_Cerveza;
    private int cantidad_de_resenia;
    private double puntaje_general;

    public nodoBeerMostReview(String nombre_Cerveza, int cantidad_de_resenia, double puntaje_general) {
        this.nombre_Cerveza = nombre_Cerveza;
        this.cantidad_de_resenia = cantidad_de_resenia;
        this.puntaje_general = puntaje_general;
    }

    public String getNombre_Cerveza() {
        return nombre_Cerveza;
    }

    public void setNombre_Cerveza(String nombre_Cerveza) {
        this.nombre_Cerveza = nombre_Cerveza;
    }

    public int getCantidad_de_resenia() {
        return cantidad_de_resenia;
    }

    public void setCantidad_de_resenia(int cantidad_de_resenia) {
        this.cantidad_de_resenia = cantidad_de_resenia;
    }

    public double getPuntaje_general() {
        return puntaje_general;
    }

    public void setPuntaje_general(double puntaje_general) {
        this.puntaje_general = puntaje_general;
    }
}

