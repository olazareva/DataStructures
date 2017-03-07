package ua.lazareva.datastructures;

import java.util.ArrayList;


public class HashMap {

    private ArrayList<Entry>[] array;
    private int size;

    public HashMap() {
        array =  new ArrayList[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<>();
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Object key) {
        int index = getBucketIndex(key);
        for (Entry entry : array[index]) {
            if ((key == null && entry.key == null) ||key.equals( entry.key)) return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < array.length; i++) {
            for (Entry entry : array[i]) {
                if ((value == null && entry.value == null) || value.equals(entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object key) {
        int index = getBucketIndex(key);
        for (Entry entry : array[index]) {
            if ((key == null && entry.key == null) || key.equals(entry.key)) return entry.value;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object put(Object key, Object value) {
        ensureCapacity();
        int index = getBucketIndex(key);
        java.util.ArrayList<Entry> bucket = array[index];
        for (Entry entry : bucket) {
            if ((key == null && entry.key == null) || key.equals(entry.key)) {
                Object oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        bucket.add(new Entry(key, value));
        size++;
        return value;
    }

    private void ensureCapacity() {
        if (size > array.length * 0.75) {
           ArrayList<Entry>[] arrayExtended = new ArrayList[array.length * 2];
            for (int i = 0; i < arrayExtended.length; i++) {
                arrayExtended[i] = new ArrayList<>();
            }
           ArrayList<Entry>[] arrayOld = array;
            array = arrayExtended;
            size = 0;
            for (int i = 0; i < arrayOld.length; i++) {
                for (Entry entry : arrayOld[i]) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public Object remove(Object key) {
        int index = getBucketIndex(key);
        ArrayList<Entry> bucket = array[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if ((key == null && entry.key == null) || key.equals(entry.key)) {
                Object tmpObject = entry.value;
                bucket.remove(i);
                size--;
                return tmpObject;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public Object putIfAbsent(Object key, Object value) {

        if (!containsKey(key)) {

            int index = getBucketIndex(key);
            ArrayList<Entry> bucket = array[index];
            Entry entry = new Entry(key, value);
            bucket.add(entry);
            size++;
            return entry.value;

        }
        return null;
    }

    public void putAll(HashMap map) {
        for (int i = 0; i < map.array.length; i++) {
            for (Entry entry : map.array[i])
                put(entry.key, entry.value);
        }

    }

    public Object putAllIfAbsent(HashMap map) {
        for (int i = 0; i < map.array.length; i++) {
            for (Entry entry : map.array[i])
                putIfAbsent(entry.key, entry.value);
        }
        return null;
    }

    private int getBucketIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % array.length);

    }

    private static class Entry {
        private Object key;
        private Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
