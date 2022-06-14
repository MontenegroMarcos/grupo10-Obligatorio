package QueueTesting;

import Exceptions.EmptyQueueException;
import TADs.MyQueueImpl;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;



public class TestQueueMethod {

     //Hago pruebas sobre el metodo enqueue

     MyQueueImpl <String> miQueueBasica = new MyQueueImpl<>();
     MyQueueImpl <String> miQueueBasica2 = new MyQueueImpl<>();
     MyQueueImpl <String> miQueueBasica3 = new MyQueueImpl<>();


     @Test
     public void testEnqueue() throws EmptyQueueException {
         miQueueBasica.enqueue("Cerveza Patricia");
         miQueueBasica.enqueue("Cerveza Heineken");
         miQueueBasica.enqueue("Cerveza Corona");

         assertTrue("El metodo enqueue no funciona correctamente", miQueueBasica.dequeue().equals("Cerveza Patricia"));

     }


     @Test
     public void testDequeue() throws EmptyQueueException {
         miQueueBasica2.enqueue("Cerveza Patricia");
         miQueueBasica2.enqueue("Cerveza Heineken");
         miQueueBasica2.enqueue("Cerveza Corona");

         assertTrue("El metodo dequeue no funciona correctamente", miQueueBasica2.dequeue().equals("Cerveza Patricia"));

     }

     @Test
     public void isEmptyTest() throws EmptyQueueException {
         miQueueBasica3.enqueue("Cerveza Patricia");
         miQueueBasica3.enqueue("Cerveza Heineken");
         miQueueBasica3.enqueue("Cerveza Corona");

         assertFalse("El metodo dequeue no funciona correctamente", miQueueBasica3.isEmpty());

     }
}
