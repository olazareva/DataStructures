package ua.lazareva.datastructures;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArrayListTest {
    private ArrayList arrayListWithThreeElements;
    private ArrayList arrayListWithTenElements;
    private ArrayList arrayListWithZeroElements;


    @Before
    public void before() {
        arrayListWithThreeElements = new ArrayList();
        for (int i = 0; i < 3; i++) {
            arrayListWithThreeElements.add(i);
        }
        assertEquals(3, arrayListWithThreeElements.size());

        arrayListWithTenElements = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayListWithTenElements.add(i);
        }
        assertEquals(10, arrayListWithTenElements.size());

        arrayListWithZeroElements = new ArrayList();
        assertEquals(0, arrayListWithZeroElements.size());
    }


    @Test
    public void testGet() {
        for (int i = 0; i < arrayListWithThreeElements.size(); i++) {
            assertEquals(i, arrayListWithThreeElements.get(i));
        }
        for (int i = 0; i < arrayListWithTenElements.size(); i++) {
            assertEquals(i, arrayListWithTenElements.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        arrayListWithZeroElements.get(0);
    }

    @Test
    public void testAdd() {
        arrayListWithThreeElements.add(-1, 0);
        assertEquals(-1, arrayListWithThreeElements.get(0));

        arrayListWithThreeElements.add(-1, 1);
        assertEquals(-1, arrayListWithThreeElements.get(1));

        arrayListWithThreeElements.add(-1, 5);
        assertEquals(-1, arrayListWithThreeElements.get(5));

        try {
            arrayListWithThreeElements.add(-1, 7);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        for (int i = 2; i < arrayListWithThreeElements.size() - 1; i++) {
            assertEquals(i - 2, arrayListWithThreeElements.get(i));
        }

        try {
            arrayListWithZeroElements.add(-1, 1);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        arrayListWithZeroElements.add(-1, 0);
        assertEquals(-1, arrayListWithZeroElements.get(0));


    }

    @Test
    public void testIsEmpty() {
        /*do {
            arrayListWithThreeElements.remove(0);
        } while(arrayListWithThreeElements.size !=0);
        assertEquals(0, arrayListWithThreeElements.size);

        for (int i = arrayListWithTenElements.size-1; i>=0 ; i--) {
            arrayListWithTenElements.remove(i);
        }
        */
        arrayListWithThreeElements.clear();
        arrayListWithTenElements.clear();
        assertEquals(0, arrayListWithThreeElements.size());
        assertEquals(0, arrayListWithTenElements.size());
        assertEquals(0, arrayListWithZeroElements.size());
    }

    @Test
    public void testSet() {
        for (int i = 0; i < arrayListWithThreeElements.size(); i++) {
            arrayListWithThreeElements.set(-1 * i, i);
            assertEquals(-1 * i, arrayListWithThreeElements.get(i));
        }
        for (int i = 0; i < arrayListWithTenElements.size(); i++) {
            arrayListWithTenElements.set(-1 * i, i);
            assertEquals(-1 * i, arrayListWithTenElements.get(i));
        }

    }

    @Test
    public void testContains() {
        assertFalse(true == arrayListWithThreeElements.contains(8));
        assertTrue(true == arrayListWithThreeElements.contains(2));
    }

    @Test
    public void testLastIndexOf() {
        for (int i = 0; i < 10; i++) {
            arrayListWithZeroElements.add(i % 3);
        }
        assertEquals(9,arrayListWithZeroElements.lastIndexOf(0));
        assertEquals(8,arrayListWithZeroElements.lastIndexOf(2));
        assertEquals(7,arrayListWithZeroElements.lastIndexOf(1));

    }


    @Test
    public void testIndexOf() {
        for (int i = 0; i < 10; i++) {
            arrayListWithZeroElements.add(i % 3);
        }
        assertEquals(0,arrayListWithZeroElements.indexOf(0));
        assertEquals(1,arrayListWithZeroElements.indexOf(1));
        assertEquals(2,arrayListWithZeroElements.indexOf(2));

    }

    @Test
    public void testRemove(){
        arrayListWithTenElements.remove((Object)8);
        assertEquals(9,arrayListWithTenElements.get(8));
        assertEquals(9,arrayListWithTenElements.size());

        arrayListWithTenElements.remove((Object)9);
        assertEquals(7,arrayListWithTenElements.get(7));
        assertEquals(8,arrayListWithTenElements.size());

        arrayListWithTenElements.remove((Object)0);
        assertEquals(1,arrayListWithTenElements.get(0));
        assertEquals(7,arrayListWithTenElements.size());
    }

    @Test
    public void testRemovebyIndex(){
        arrayListWithTenElements.remove(8);
        assertEquals(9,arrayListWithTenElements.get(8));
        assertEquals(9,arrayListWithTenElements.size());

        arrayListWithTenElements.remove(8);
        assertEquals(7,arrayListWithTenElements.get(7));
        assertEquals(8,arrayListWithTenElements.size());

        arrayListWithTenElements.remove(0);
        assertEquals(1,arrayListWithTenElements.get(0));
        assertEquals(7,arrayListWithTenElements.size());
    }
}
