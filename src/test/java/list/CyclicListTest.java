package list;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicListTest {

    @Test
    public void testCreationOfCyclicList(){
        CyclicList<Integer> myList = new CyclicList<>(1);
        myList.addLast(2);
        myList.addLast(4);
        myList.addLast(8);
        myList.addLast(16);
        //List like 1 2 4 8 16
        assertEquals(myList.get(3),new Integer(8));
        assertEquals(myList.get(13),new Integer(8));
        assertEquals(myList.get(2),new Integer(4));
        assertEquals(myList.get(37),new Integer(4));
        assertEquals(myList.get(4),new Integer(16));
        assertEquals(myList.get(9),new Integer(16));
        assertEquals(myList.get(-1),new Integer(16));
    }

    @Test
    public void testCyclicListShift(){
        CyclicList<Integer> myList = new CyclicList<>(1);
        myList.addLast(2);
        myList.addLast(4);
        myList.addLast(8);
        myList.addLast(16);
        //List like 1 2 4 8 16
        myList.setStartOnIndex(2);
        //List like 8 16 1 2 4
        assertEquals(myList.get(0),new Integer(8));
        assertEquals(myList.get(1),new Integer(16));
        assertEquals(myList.get(2),new Integer(1));
        assertEquals(myList.get(3),new Integer(2));
        assertEquals(myList.get(4),new Integer(4));
    }

    @Test
    public void testCyclicListRemove(){
        CyclicList<Integer> myList = new CyclicList<>(1);
        myList.addLast(2);
        myList.addLast(4);
        myList.addLast(8);
        myList.addLast(16);
        //List like 1 2 4 8 16
        myList.remove(2);
        //List like 1 2 8 16
        assertEquals(myList.get(1),new Integer(2));
        assertEquals(myList.get(2),new Integer(8));
    }

}