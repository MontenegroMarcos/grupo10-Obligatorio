package TADs;

import java.util.EmptyStackException;

public class Stack<T> implements MyStack<T> {
    private Nodo<T> cabeza;

    @Override
    public void pop() throws EmptyStackException {
        Nodo nodoActual = cabeza;
        Nodo nodoNuevoInicio = nodoActual.getSiguiente();

        if (cabeza != null && nodoNuevoInicio != null){
            cabeza = nodoNuevoInicio;
        } else if (cabeza != null && nodoNuevoInicio == null){
            cabeza = null;
        }
    }

    @Override
    public T top() throws EmptyStackException {
        Nodo<T> nodoActual = cabeza;
        return nodoActual.getValue();
    }

    @Override
    public void push(T element) {
        Nodo nodoActual = cabeza;
        Nodo nodoNuevo = new Nodo(element,null);
        if (cabeza == null){
            cabeza = nodoNuevo;
        } else {
            Nodo nodoViejo = cabeza;
            cabeza = nodoNuevo;
            nodoNuevo.setSiguiente(nodoViejo);
        }
    }

    @Override
    public boolean isEmpty() {
        boolean estaVacio = false;
        if (cabeza == null) {
            estaVacio = true;
        }
        return estaVacio;
    }

    @Override
    public void makeEmpty() {
        cabeza = null;
    }

    public T get(int position) {
        int lugar = 0;
        Nodo<T> nodoActual = cabeza;
        while (lugar < position) {
            nodoActual = nodoActual.getSiguiente();
            lugar = lugar + 1;
        }
        T valor = nodoActual.getValue();
        return valor;
    }

public int size(){
    int count = 0;
    Nodo<T> temp = this.cabeza;

    while (temp != null) {
        count ++;
        temp = temp.getSiguiente();

    }

    return count;
}

}
