package TADs;

public class MyLinkedListImpl implements MyLinkedList{
    private Nodo cabeza;
    private Nodo cola;


    @Override
    public void add(Object value) {
        if (cabeza != null) {
            Nodo nodoActual = cabeza;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(new Nodo(value, null));
        } else {
            Nodo nuevoNodo = new Nodo(value, null);
            cabeza = nuevoNodo;
        }
    }

    @Override
    public void remove(int position) {

    }

    @Override
    public Object get(int position) {
        int lugar = 0;
        Nodo nodoActual = cabeza;
        while (lugar < position) {
            nodoActual = nodoActual.getSiguiente();
            lugar = lugar + 1;
        }
        int valor = (Integer) nodoActual.getValue();

        return valor;

    }

    @Override
    public boolean estaEnLista(Object value) {

        boolean existe = false;
        Nodo nodoTemp = this.cabeza;

        while (nodoTemp != null && !nodoTemp.getValue().equals(value)) {

            nodoTemp = nodoTemp.getSiguiente();
        }

        if (nodoTemp != null) {
            existe = true;
        }

        return existe;

    }
}
