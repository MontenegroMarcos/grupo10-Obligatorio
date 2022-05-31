package TADs;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
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
        int lugar = 0;
        Nodo nodoActual = this.cabeza;
        Nodo nodoAnterior = null;

        if(position == 0){
            this.cabeza = this.cabeza.getSiguiente();
        } else {
            while(nodoActual != null && lugar != position){
                lugar++;
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getSiguiente();
            }

            if(nodoActual != null){
                nodoAnterior.setSiguiente(nodoActual.getSiguiente());

            }
        }





/*
        while (nodoActual != null && lugar != position) {
            lugar++;
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }

        if (nodoActual != null) {

            if (position != 0) {

                nodoAnterior.setSiguiente(nodoActual.getSiguiente());


            } else if (position == 0) {

                this.cabeza = null;

            } else if (nodoAnterior.getSiguiente() == this.cola) {

                nodoAnterior.setSiguiente(null);
                this.cola = nodoAnterior;
            }
        }*/

    }

    @Override
    public T get(int position) {
        T valorDevuelto = null;
        int lugar = 0;
        Nodo<T> nodoActual = cabeza;
        while (nodoActual != null && lugar != position) {
            nodoActual = nodoActual.getSiguiente();
            lugar = lugar + 1;
        }

        if (lugar == position) {
            valorDevuelto = nodoActual.getValue();
        }


        return valorDevuelto;

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

    public int size() {
        int count = 0;
        Nodo<T> temp = this.cabeza;

        while (temp != null) {
            count ++;
            temp = temp.getSiguiente();

        }

        return count;
    }
}










    /*@Override
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
}*/
