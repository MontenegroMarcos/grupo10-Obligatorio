package TADs;

import Exceptions.EmptyQueueException;

public class MyQueueImpl <T> implements MyQueue <T> {

    private Nodo first;

    private Nodo last;

    public MyQueueImpl() {
        this.first = null;
        this.last = null;
    }


    @Override
    public void enqueue(T element) {
        Nodo elementToAdd = new Nodo(element);

        if (isEmpty()) {
            this.first = elementToAdd;
            this.last = this.first;
        } else {
            this.last.setSiguiente(elementToAdd);
            this.last = elementToAdd;
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {

        //try {
        if (this.isEmpty() ) {
            throw new  EmptyQueueException() ;
        }

        Nodo tempPrimero = this.first;
        this.first = tempPrimero.getSiguiente();
        T valor = (T) tempPrimero.getValue();
        return valor;

        //} catch (EmptyQueueException) {
        // throw new EmptyQueueException();
        // }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }


    public int size() {
        int count = 0;
        Nodo<T> temp = this.first;

        while (temp != null) {
            count ++;
            temp = temp.getSiguiente();

        }

        return count;
    }
}
