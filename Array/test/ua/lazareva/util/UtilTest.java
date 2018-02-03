package ua.lazareva.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    Util util = new Util();
    private int[] arrayOfInt = {65, 66, 67, 68, 69, 70, 71};
    private char[] arrayOfChar = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    @Test
    public void testPrint() {
        char[] array = new char[10];
        String str;
        for (int i = 0; i < array.length; i++) {
            str = i + "";
            array[i] = str.charAt(0);
        }
        util.print(array);
    }

    @Test
    public void testUnicodeIntToChar() {
        assertArrayEquals(arrayOfChar, util.unicodeIntToChar(arrayOfInt));
    }

    @Test
    public void testMax() {
        assertEquals(2, util.max(2, -1));
        assertEquals(2, util.max(2, 2));
        assertEquals(4, util.max(2, 4));

        assertEquals(5, util.max(2, -1, 5));
        assertEquals(2, util.max(2, -1, -1));
        assertEquals(-1, util.max(-4, -1, -2));

        assertEquals(5, util.max(1, 2, 3, 4, 5));
        assertEquals(5, util.max(5, 4, 3, 2, 1));
        assertEquals(7, util.max(5, 4, 7, 2, 1));
    }

    @Test
    public void testToString() {
        assertEquals("ABCDEFG", util.toString(arrayOfChar));
        assertNotEquals("ABCDEF", util.toString(arrayOfChar));
    }

    @Test
    public void testIndexOf() {
        assertEquals(-1, util.indexOf(arrayOfInt, 72));
        assertEquals(5, util.indexOf(arrayOfInt, 70));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(-1, util.lastIndexOf(arrayOfInt, 72));
        assertEquals(0, util.lastIndexOf(arrayOfInt, 65));
    }

    @Test
    public void testFactorial() {
        assertEquals(362880, util.factorial(9));
        assertEquals(1, util.factorial(0));
    }

    @Test
    public void testIsLeapYear() {
        assertFalse(util.isLeapYear(2100));
        assertFalse(util.isLeapYear(2200));
        assertFalse(util.isLeapYear(2018));
        assertTrue(util.isLeapYear(2016));
        assertTrue(util.isLeapYear(1600));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testPrintMultipliers_Except() {
        util.printMultipliers(arrayOfInt, 0);
    }

    @Test
    public void testPrintMultipliers() {
        util.printMultipliers(arrayOfInt, 2);
    }

    @Test
    public void testSortAsc() {
        int[] arr = {5, 1, 2, 1, 2};
        util.sortAsc(arr);
    }

    @Test
    public void testHasDuplicates() {
        byte[] arr = {1, 1, 0, 127, -128};
        assertTrue(util.hasDuplicates(arr));
    }

    @Test
    public void testMultiplyArrays() {
        int[] arr1 = {5, 1, 2, 1, 2};
        int[] arr2 = {5, 1, 2, 1, 2};
        int[] expected = {25, 1, 4, 1, 4};
        assertArrayEquals(expected, util.multiplyArrays(arr1, arr2));
    }

    @Test
    public void testGetDiscrepancy() {
        int[] arr1 = {5, 1, 2, 1, -2, 7};
        int[] arr2 = {1, 2, 6};
        int[] expected = {5, -2, 7, 6};
        assertArrayEquals(expected, util.getDiscrepancy(arr1, arr2));
    }

    @Test
    public void testReverse() {
        int[] array = {4, 5, 3, 2, 7, 1, 8};
        int[] expected = {8, 1, 7, 2, 3, 5, 4};
        assertArrayEquals(expected, util.reverse(array));
    }

    @Test
    public void testGenerateRandom() {
        int[] array = util.generateRandom(7, 67, 85);
        for (int i = 0; i < 7; i++) {
            assertTrue(array[i] >= 67 && array[i] <= 85);
        }
    }

    @Test
    public void testContains() {
        char[] lookAt = {'a', 'b', 'c', 'd', 'e', 'g'};
        char[] lookFor = {'e', 'g'};
        assertTrue(util.contains(lookAt, lookFor));
    }

    @Test
    public void testNegativeContains() {
        char[] lookAt = {'a', 'b', 'c', 'd', 'e', 'g'};
        char[] lookFor = {'e', 'g', 'f'};
        assertFalse(util.contains(lookAt, lookFor));
    }
}