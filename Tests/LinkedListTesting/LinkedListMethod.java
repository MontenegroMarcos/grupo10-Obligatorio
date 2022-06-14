package LinkedListTesting;

import TADs.MyLinkedListImpl;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LinkedListMethod {

    MyLinkedListImpl myObj = new MyLinkedListImpl();
    MyLinkedListImpl myObj2 = new MyLinkedListImpl();
    MyLinkedListImpl myObj3= new MyLinkedListImpl();
    MyLinkedListImpl myObj4 = new MyLinkedListImpl();

    //Hago pruebas del metodo add
    @Test
    public void addTest() {
        myObj.add(1);
        myObj.add(2);
        myObj.add(3);

        assertTrue("El metodo add no funciona correctamente", myObj.estaEnLista(1));

    }


    //Hago pruebas del metodo remove
    @Test
    public void removeTest() {
        myObj2.add(1);
        myObj2.add(2);
        myObj2.add(3);

        myObj2.remove(0);

        assertFalse("El metodo remove no funciona correctamente", myObj2.estaEnLista(1));

    }


    //Hago pruebas del metodo get
    @Test
    public void getTest() {
        myObj3.add(1);
        myObj3.add(2);
        myObj3.add(3);

        assertTrue("El metodo get no funciona correctamente", myObj3.get(1).equals(2));

    }


    //Hago pruebas del metodo estaEnLista
    @Test
    public void estaEnListaTest() {
        myObj4.add(1);
        myObj4.add(2);
        myObj4.add(3);

        assertTrue("El metodo estaEnLista no funciona correctamente", myObj4.estaEnLista(3));

    }

}


