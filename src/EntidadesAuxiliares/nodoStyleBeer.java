package EntidadesAuxiliares;

public class nodoStyleBeer {

    String estiloCerveza;
    double promedio_review_aroma;

    public nodoStyleBeer(String estiloCerveza, double promedio_review_aroma) {
        this.estiloCerveza = estiloCerveza;
        this.promedio_review_aroma = promedio_review_aroma;
    }

    public String getEstiloCerveza() {
        return estiloCerveza;
    }

    public void setEstiloCerveza(String estiloCerveza) {
        this.estiloCerveza = estiloCerveza;
    }

    public double getPromedio_review_aroma() {
        return promedio_review_aroma;
    }

    public void setPromedio_review_aroma(double promedio_review_aroma) {
        this.promedio_review_aroma = promedio_review_aroma;
    }
}

