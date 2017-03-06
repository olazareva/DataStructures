package ua.lazareva.datastructures;

public class ArrayList implements List {

    private Object[] array;
    private int size;


    public ArrayList() {
        array = new Object[5];
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);

        Object tmpObject = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return tmpObject;
    }

    @Override
    public void remove(Object object) {
        remove(indexOf(object));
    }

    public void add(Object obj, int index) {  //0<=index<=size
        validateIndexToAdd(index);

        if (size == array.length) {
            int newLength = (int) (array.length * 1.5) + 1;
            Object[] newArray = new Object[newLength];

            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = obj;
        size++;
    }


    @Override
    public int size() {
        return size;
    }
    @Override
    public void add(Object obj) {
        add(obj, size);
    }

    public int indexOf(Object findObj) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(findObj)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object findObj) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(findObj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }


    public void set(Object obj, int index) {
        validateIndex(index);
        array[index] = obj;
    }


    /*public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add((String) array[i]);
        }
        return stringJoiner.toString();
    }*/

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Index " + index + " should be between 0 and " + size + " exclusive";
            throw new IndexOutOfBoundsException(msg);
        }
    }

    private void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            String msg = "Index " + index + " should be between 0 and " + size + " exclusive";
            throw new IndexOutOfBoundsException(msg);
        }
    }
}