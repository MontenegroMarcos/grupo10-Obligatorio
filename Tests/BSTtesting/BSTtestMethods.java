package BSTtesting;

import Exceptions.ElementNotExistException;
import TADs.MyBinarySearchTreeImpl;
import TADs.NodeBST;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class BSTtestMethods {


    MyBinarySearchTreeImpl arbol = new MyBinarySearchTreeImpl();
    MyBinarySearchTreeImpl<Integer,String> arbol2 = new MyBinarySearchTreeImpl();
    MyBinarySearchTreeImpl arbol3 = new MyBinarySearchTreeImpl();


    //Hago pruebas sobre el metodo find
    @Test
    public void testFind() throws ElementNotExistException {
        arbol.insert(8, "Raiz");
        arbol.insert(6, "Segundo izqueirdo");
        arbol.insert(12, "Segundo derecho");

        assertTrue("El metodo find no funciona correctamente", arbol.find(8).equals("Raiz"));

    }


    //hago pruebas sobre el metodo insert
    @Test
    public void testInsert() {

        arbol2.insert(8, "Raiz");
        arbol2.insert(6, "Segundo izqueirdo");
        arbol2.insert(12, "Segundo derecho");

        NodeBST dato = new NodeBST<>(8, "Raiz");

        try {
            assertTrue( "El metodo insert no funciona correctamente",arbol2.find(8) != null);
        } catch (ElementNotExistException e) {
            assertTrue( "El metodo insert no funciona correctamente",false);
        }
        //assertTrue("El metodo no funciona correctamente", arbol.find(8));
    }


    //Hago pruebas sobre el metodo delete
    @Test
    public void testDelete() throws ElementNotExistException {

        arbol3.insert(8, "Raiz");
        arbol3.insert(6, "Segundo izqueirdo");
        arbol3.insert(12, "Segundo derecho");

        arbol3.delete(8);

        try {
            arbol3.find(8);
        } catch (ElementNotExistException e) {
            assertTrue( "El metodo delete no funciona correctamente",true);
        }
    }
}

