package StackTest;

import Entities.Beer;
import TADs.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackMethodsTesting {

    Stack<Beer> cervezas = new Stack<>();
    Stack<Beer> cervezaArt = new Stack<>();
    Stack<Beer> cervezaArt2 = new Stack<>();

    Beer cerveza1 = new Beer(3232L,"Cerveza Corona", 123.0);
    Beer cerveza2 = new Beer(3234L,"Cerveza Patagonia", 140.0);


    @Test
    public void testPush(){
        cervezas.push(cerveza1);
        assertTrue("El metodo push no sirve", cervezas.top().equals(cerveza1) );
    }

    @Test
    public void testIsEmpty(){
        assertFalse("El metodo IsEmpty no funciona", !cervezas.isEmpty());
    }

    @Test
    public void testPop(){
        cervezaArt.push(cerveza1);
        cervezaArt.push(cerveza2);
        cervezaArt.pop();
        assertTrue("El metodo Pop no anda",cervezaArt.top().equals(cerveza1));
    }

    @Test
    public void testMakeEmpty(){
        cervezaArt.push(cerveza1);
        cervezaArt.push(cerveza2);
        cervezaArt.makeEmpty();

        assertTrue("El metodo Make empty no anda", cervezaArt2.isEmpty());


    }




}
