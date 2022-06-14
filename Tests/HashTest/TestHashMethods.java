package HashTest;

import TADs.MyHashTableIMPL;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHashMethods {

    MyHashTableIMPL<Integer, String> miTablaHash = new MyHashTableIMPL<>();
    MyHashTableIMPL<Integer, String> miTablaHash2 = new MyHashTableIMPL<>();
    MyHashTableIMPL<Integer, Object> miTablaHash3 = new MyHashTableIMPL<>();

    @Test
    public void testPut() {
        miTablaHash.put(5, "Carlo");
        miTablaHash.put(6, "Rober");
        assertTrue("La tabla no funciona", miTablaHash.size() != 0 && miTablaHash.get(5).equals("Carlo"));
    }

    @Test
    public void testRemove() {
        miTablaHash3.put(5, "Carlo");
        miTablaHash3.put(6, "Rober");
        miTablaHash3.remove(5);

        try {
            System.out.println(miTablaHash3.get(5));
        } catch (Exception e) {
            //assertTrue("No funciona remove", true);
        }


        assertNull("El metodo remover no funca", miTablaHash3.get(5));
    }

    @Test
    public void testGet() {
        miTablaHash2.put(4, "Gette");
        assertTrue("El get no funciona", miTablaHash2.get(4).equals("Gette"));
    }

    @Test
    public void testSize() {
        miTablaHash.put(20, "Fede");
        miTablaHash.put(10, "Teo");
        assertTrue("No funciona el Size", miTablaHash.size() == 2);
    }
}
