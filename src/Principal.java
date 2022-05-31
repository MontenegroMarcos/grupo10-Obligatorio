import Exceptions.EmptyQueueException;
import TADs.MyLinkedListImpl;
import TADs.MyQueueImpl;
import TADs.Stack;

import java.util.Queue;

public class Principal {
    public static void main(String[] args) throws EmptyQueueException {
        /*MyLinkedListImpl myObj = new MyLinkedListImpl();
        myObj.add(0);
        myObj.add(1);
        myObj.add(2);
        myObj.add(3);
        myObj.add(4);
        myObj.add(5);
        myObj.add(6);
        myObj.add(7);

        for (int i = 0; i < myObj.size(); i++) {
            System.out.println(myObj.get(i));
        }

        System.out.println(myObj.estaEnLista(7));
        myObj.remove(2); // en la posicion 2 estaba 4

        for (int i = 0; i < myObj.size(); i++) {
            System.out.println(myObj.get(i));
        }

*/
        Stack pila = new Stack();
        pila.push(0);
        pila.push(1);
        pila.push(3);
        pila.push(4);

        for (int i = 0 ; i < pila.size(); i++){
            System.out.println(pila.get(i));
        }
        pila.pop();
        System.out.println("Se elimina un elemento");
        for (int i = 0 ; i < pila.size(); i++){
            System.out.println(pila.get(i));
        }


    }
}

