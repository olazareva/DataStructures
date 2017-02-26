package ua.lazareva.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HashMapTest {
    HashMap hashMap;

    @Before
    public void before() {
        hashMap = new HashMap();
        for (int i = 0; i < 10; i++) {
            assertEquals(null, hashMap.put("key" + i, "value" + i));
        }
        assertEquals(10, hashMap.size());
    }

    @Test
    public void testGet() {
        for (int i = 0; i < hashMap.size(); i++) {
            assertEquals("value" + i, hashMap.get("key" + i));
        }
        assertEquals(-1, hashMap.get("key" + 10));
    }

    @Test
    public void testContainsKey() {
        for (int i = 0; i < hashMap.size(); i++) {
            assertTrue(true == hashMap.containsKey("key" + i));
        }
        assertTrue(false == hashMap.containsKey("key" + 10));

    }

    @Test
    public void testContainsValue() {
        for (int i = 0; i < hashMap.size(); i++) {
            assertTrue(true == hashMap.containsValue("value" + i));
        }
        assertTrue(false == hashMap.containsValue("value" + 10));

    }

    @Test
    public void testIsEmpty() {
        hashMap.clear();
        assertEquals(0, hashMap.size());
    }

    @Test
    public void testRemove() {
        assertEquals("value9", hashMap.remove("key9"));
        assertTrue(false == hashMap.containsKey("key9"));

        assertEquals("value5", hashMap.remove("key5"));
        assertTrue(false == hashMap.containsKey("key9"));

        assertEquals("value0", hashMap.remove("key0"));
        assertTrue(false == hashMap.containsKey("key9"));

        assertEquals(null, hashMap.remove("key10"));
        assertEquals(7, hashMap.size());

    }

    @Test
    public void testPut() {
        assertEquals("value9", hashMap.put("key9", "newvalue"));
    }

    @Test
    public void testPutIfAbsent() {
        assertEquals(null, hashMap.putIfAbsent("key8", "newvalue8"));
        assertEquals("value10", hashMap.putIfAbsent("key10", "value10"));
    }

    @Test
    public void testPutAll() {
        HashMap hashMapToAdd = new HashMap();
        for (int i = 5; i < 15; i++) {
            assertEquals(null, hashMapToAdd.put("key" + i, "hashMapToAdd" + i));
        }
        hashMap.putAll(hashMapToAdd);
        assertEquals(15, hashMap.size());
        for (int i = 0; i < 5; i++) {
            assertEquals("value" + i, hashMap.get("key" + i));
        }
        for (int i = 5; i < hashMap.size(); i++) {
            assertEquals("hashMapToAdd" + i, hashMap.get("key" + i));
        }
    }

    @Test
    public void testPutAllIfAbsent() {
        HashMap hashMapToAdd = new HashMap();
        for (int i = 5; i < 15; i++) {
            assertEquals(null, hashMapToAdd.put("key" + i, "hashMapToAdd" + i));
        }
        hashMap.putAllIfAbsent(hashMapToAdd);
        assertEquals(15, hashMap.size());
        for (int i = 0; i < 10; i++) {
            assertEquals("value" + i, hashMap.get("key" + i));
        }
        for (int i = 10; i < hashMap.size(); i++) {
            assertEquals("hashMapToAdd" + i, hashMap.get("key" + i));
        }
    }

}
