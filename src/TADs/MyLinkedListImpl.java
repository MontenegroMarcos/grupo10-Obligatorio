package TADs;

public class MyLinkedListImpl<T> implements MyLinkedList{
    private Nodo<T> cabeza;
    private Nodo<T> cola;


    @Override
    public void add(T value) {
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
Nodo<T> nodoActual = this.cabeza;
if(nodoActual == null){
    //No hacer nada
} else {
    int posicionActual = -1;
    while(posicionActual != position){
        nodoActual = nodoActual.getSiguiente();
        posicionActual = posicionActual + 1;
    }
    if (nodoActual != null){
       Nodo<T> nodoAnterior = nodoActual;
       nodoAnterior.setSiguiente(nodoActual.getSiguiente());


    }
}
    }

    @Override
    public int get(int position) {
        int lugar = 0;
        Nodo<T> nodoActual = cabeza;
        while (lugar < position) {
            nodoActual = nodoActual.getSiguiente();
            lugar = lugar + 1;
        }
        int valor = (int) nodoActual.getValue();

        return valor;

    }



    @Override
    public boolean estaEnLista(T value) {

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
