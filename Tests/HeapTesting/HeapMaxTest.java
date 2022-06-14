package HeapTesting;

import Exceptions.HeapEmpty;
import TADs.HeapNode;
import TADs.MyHeapImplMax;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeapMaxTest {

    MyHeapImplMax<Integer, String> montonMaximo = new MyHeapImplMax<>();
    MyHeapImplMax<Integer, String> montonMaximo2 = new MyHeapImplMax<>();
    MyHeapImplMax<Integer, String> montonMaximo3 = new MyHeapImplMax<>();

    @Test
    public void testAdd() throws HeapEmpty {
        montonMaximo.add(8, "El segundo mas grande");
        montonMaximo.add(10, "El mas grande");
        montonMaximo.add(3, "El mas chico");

        assertTrue("El add no funciona",montonMaximo.remove().getValor().equals("El mas grande"));
    }



    @Test
    public void testRemove() throws HeapEmpty {
        montonMaximo2.add(8, "El segundo mas grande");
        montonMaximo2.add(10, "El mas grande");
        montonMaximo2.add(3, "El mas chico");
        montonMaximo2.remove();

        assertTrue("No funciona el metodo remove", montonMaximo2.remove().getValor().equals("El segundo mas grande"));


    }

    @Test
    public void testSize() {
        montonMaximo3.add(8, "El segundo mas grande");
        montonMaximo3.add(10, "El mas grande");
        montonMaximo3.add(3, "El mas chico");


        assertTrue("Fallo el size", montonMaximo3.size() == 3);

    }

}
