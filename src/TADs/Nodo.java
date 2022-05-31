package TADs;

public class Nodo<T> {

    private T value;
    private Nodo<T> siguiente;//Siguiente

    public Nodo(T value, Nodo<T> siguiente) {
        this.value = value;
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
