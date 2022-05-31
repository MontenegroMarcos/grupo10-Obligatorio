import TADs.MyLinkedListImpl;

public class Principal {
    public static void main(String[] args) {
        MyLinkedListImpl myObj = new MyLinkedListImpl();
        myObj.add(3);
        myObj.add(9);
        myObj.add(4);
        myObj.add(2);
        myObj.add(4);
        myObj.add(1);
        myObj.add(3);
        myObj.add(32);

        for (int i = 0; i < 8; i++) {
            System.out.println(myObj.get(i));
        }

        System.out.println(myObj.estaEnLista(32));
        myObj.remove(0); // en la posicion 2 estaba 4

        for (int i = 0; i < 8; i++) {
            System.out.println(myObj.get(i));
        }

    }
}

