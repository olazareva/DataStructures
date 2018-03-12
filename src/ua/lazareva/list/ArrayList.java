package ua.lazareva.list;

public class ArrayList<T> implements List<T> {

    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        array = (T[]) new Object[5];
    }

    @Override
    public void add(T t) {
        add(t, size);
    }

    @Override
    public void add(T t, int index) {
        validateIndexToAdd(index);
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = t;
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        array[size] = null;
        size--;
        return array[index];
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public T set(T t, int index) {
        validateIndex(index);
        T tmp = array[index];
        array[index] = t;
        return tmp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t)!=-1;
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {
        for (int i = size - 1; i >=0; i--) {
            if (array[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(array[i]);
            if(i<size-1){
                string.append(", ");
            }
        }
        string.append("]");
        return String.valueOf(string);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be between 0(inclusive) and " + (size - 1) + " (inclusive). You put " + index);
        }
    }

    private void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0(inclusive) and " + (size) + " (inclusive). You put " + index);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == array.length) {
            T[] tmp = (T[]) new Object[(int) (size * 1.5)];
            System.arraycopy(array, 0, tmp, 0, array.length);
            clear(array);
            array = tmp;
        }
    }

    private void clear(T[] t) {
        for (int i = 0; i < t.length; i++) {
            t[i] = null;
        }
    }
}