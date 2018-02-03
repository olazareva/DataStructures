package ua.lazareva.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class ListTest {
    private List list = getList();

    protected abstract List getList();

    @Before
    public void before() {
        for (int i = 10; i < 16; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    @Test
    public void testAdd() {
        Object[] expected = {10, 11, 12, 13, 14, 15};
        for (int i = 0; i <list.size() ; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testAddByIndex() {
        Object[] expected = {1, 10, 11, 2, 12, 13, 14, 15, 3};
        list.add(1, 0);
        list.add(2, 3);
        list.add(3, 8);
        for (int i = 0; i <list.size() ; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testRemove() {
        Object[] expected = {11, 12, 14};
        list.remove(0);
        list.remove(2);
        list.remove(3);
        for (int i = 0; i <list.size() ; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testGet() {
        assertEquals(10, list.get(0));
        assertEquals(13, list.get(3));
        assertEquals(15, list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegative() {
        list.get(6);
    }

    @Test
    public void testSet() {
        assertEquals(10, list.set(-1, 0));
        assertEquals(15, list.set(-1, 5));
        assertEquals(12, list.set(null, 2));
        Object[] expected = {-1, 11, null, 13, 14, -1};
        for (int i = 0; i <list.size() ; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegative() {
        list.set(-1, 6);
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        assertEquals(6, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(list.contains(15));
        assertFalse(list.contains(-1));
    }

    @Test
    public void testIndexOf() {
        assertEquals(5, list.indexOf(15));
        assertEquals(-1, list.indexOf(-1));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(5, list.lastIndexOf(15));
        assertEquals(-1, list.lastIndexOf(-1));
    }


}