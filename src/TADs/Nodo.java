package TADs;

public class Nodo {private Object value;
    private Nodo siguiente;//Siguiente

    public Nodo(Object value, Nodo siguiente) {
        this.value = value;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
