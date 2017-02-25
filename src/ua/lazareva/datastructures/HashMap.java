package ua.lazareva.datastructures;

/**
 * Created by Olga on 2/19/2017.
 */
public class HashMap {

    int size;
    java.util.ArrayList<Entry>[] array;

    HashMap() {
        array = new java.util.ArrayList[5];
        for (int i = 0; i < array.length; i++)
            array[i] = new java.util.ArrayList<>();
    }

    int size() {
        return size;
    }

    boolean containsKey(Object key) {
        return !get(key).equals(-1);
    }

    boolean containsValue(Object value) {
        for (int i = 0; i < array.length; i++) {
            for (Entry entry : array[i]) {
                if (value.equals(entry.value)) return true;
            }
        }
        return false;
    }

    Object get(Object key) {
        int index = getBucketIndex(key);
        for (Entry entry : array[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    Object put(Object key, Object value) {
        int index = getBucketIndex(key);
        Object oldValue;
        java.util.ArrayList<Entry> bucket = array[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        bucket.add(new Entry(key, value));
        size++;
        return null;
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode() % array.length);
    }


    Object remove(Object key) {
        int index = getBucketIndex(key);
        java.util.ArrayList<Entry> bucket = array[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (key.equals(entry.key)) {
                Object tmpObject = entry.value;
                bucket.remove(i);
                size--;
                return tmpObject;
            }
        }
        return null;
    }

    void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    Object putIfAbsent(Object key, Object value) {

        if (!containsKey(key)) {

            int index = getBucketIndex(key);
            java.util.ArrayList<Entry> bucket = array[index];
            Entry entry = new Entry(key, value);
            bucket.add(entry);
            size++;
            return entry.value;

        }
        return null;
    }

    void putAll(HashMap map) {
        for (int i = 0; i < map.array.length; i++) {
            for (Entry entry : map.array[i])
                put(entry.key, entry.value);
        }

    }

    Object putAllIfAbsent(HashMap map) {
        for (int i = 0; i < map.array.length; i++) {
            for (Entry entry : map.array[i])
                putIfAbsent(entry.key, entry.value);
        }
        return null;
    }

    public static class Entry {
        Object key;
        Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

}
