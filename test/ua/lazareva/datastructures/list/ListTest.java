package ua.lazareva.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ListTest {
    private ua.lazareva.datastructures.list.LinkedList linkedListWithThreeElements;
    private ua.lazareva.datastructures.list.LinkedList linkedListWithTenElements;
    private ua.lazareva.datastructures.list.LinkedList linkedListWithZeroElements;
    private ua.lazareva.datastructures.list.LinkedList linkedListWithNullElement;

    @Before
    public void before() {
        linkedListWithThreeElements = new ua.lazareva.datastructures.list.LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedListWithThreeElements.add(i);
        }
        assertEquals(3, linkedListWithThreeElements.size());

        linkedListWithTenElements = new ua.lazareva.datastructures.list.LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedListWithTenElements.add(i);
        }
        assertEquals(10, linkedListWithTenElements.size());

        linkedListWithZeroElements = new ua.lazareva.datastructures.list.LinkedList();
        assertEquals(0, linkedListWithZeroElements.size());

        //linkedListWithNullElement.add(null);
    }


    @Test
    public void testGet() {
        for (int i = 0; i < linkedListWithThreeElements.size(); i++) {
            assertEquals(i, linkedListWithThreeElements.get(i));
        }
        for (int i = 0; i < linkedListWithTenElements.size(); i++) {
            assertEquals(i, linkedListWithTenElements.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        linkedListWithZeroElements.get(0);
    }

    @Test
    public void testAdd() {
        linkedListWithThreeElements.add(-1, 0);
        assertEquals(-1, linkedListWithThreeElements.get(0));

        linkedListWithThreeElements.add(-1, 1);
        assertEquals(-1, linkedListWithThreeElements.get(1));

        linkedListWithThreeElements.add(-1, 5);
        assertEquals(-1, linkedListWithThreeElements.get(5));

        try {
            linkedListWithThreeElements.add(-1, 7);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        for (int i = 2; i < linkedListWithThreeElements.size() - 1; i++) {
            assertEquals(i - 2, linkedListWithThreeElements.get(i));
        }

        try {
            linkedListWithZeroElements.add(-1, 1);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        linkedListWithZeroElements.add(-1, 0);
        assertEquals(-1, linkedListWithZeroElements.get(0));


    }

    @Test
    public void testIsEmpty() {
        linkedListWithThreeElements.clear();
        linkedListWithTenElements.clear();
        assertEquals(0, linkedListWithThreeElements.size());
        assertEquals(0, linkedListWithTenElements.size());
        assertEquals(0, linkedListWithZeroElements.size());
    }

    @Test
    public void testSet() {
        for (int i = 0; i < linkedListWithThreeElements.size(); i++) {
            linkedListWithThreeElements.set(-1 * i, i);
            assertEquals(-1 * i, linkedListWithThreeElements.get(i));
        }
        for (int i = 0; i < linkedListWithTenElements.size(); i++) {
            linkedListWithTenElements.set(-1 * i, i);
            assertEquals(-1 * i, linkedListWithTenElements.get(i));
        }

    }

    @Test
    public void testContains() {
        assertFalse(true == linkedListWithThreeElements.contains(8));
        assertTrue(true == linkedListWithThreeElements.contains(2));
    }

    @Test
    public void testLastIndexOf() {
        for (int i = 0; i < 10; i++) {
            linkedListWithZeroElements.add(i % 3);
        }
        assertEquals(9,linkedListWithZeroElements.lastIndexOf(0));
        assertEquals(8,linkedListWithZeroElements.lastIndexOf(2));
        assertEquals(7,linkedListWithZeroElements.lastIndexOf(1));

    }


    @Test
    public void testIndexOf() {
        for (int i = 0; i < 10; i++) {
            linkedListWithZeroElements.add(i % 3);
        }
        assertEquals(0,linkedListWithZeroElements.indexOf(0));
        assertEquals(1,linkedListWithZeroElements.indexOf(1));
        assertEquals(2,linkedListWithZeroElements.indexOf(2));

    }

    @Test
    public void testRemove(){
        linkedListWithTenElements.remove((Object)8);
        assertEquals(9,linkedListWithTenElements.get(8));
        assertEquals(9,linkedListWithTenElements.size());

        linkedListWithTenElements.remove((Object)9);
        assertEquals(7,linkedListWithTenElements.get(7));
        assertEquals(8,linkedListWithTenElements.size());

        linkedListWithTenElements.remove((Object)0);
        assertEquals(1,linkedListWithTenElements.get(0));
        assertEquals(7,linkedListWithTenElements.size());
       // linkedListWithNullElement.remove((Object) null);
    }

    @Test
    public void testRemovebyIndex(){
        linkedListWithTenElements.remove(8);
        assertEquals(9,linkedListWithTenElements.get(8));
        assertEquals(9,linkedListWithTenElements.size());

        linkedListWithTenElements.remove(8);
        assertEquals(7,linkedListWithTenElements.get(7));
        assertEquals(8,linkedListWithTenElements.size());

        linkedListWithTenElements.remove(0);
        assertEquals(1,linkedListWithTenElements.get(0));
        assertEquals(7,linkedListWithTenElements.size());
    }
}