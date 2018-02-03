package ua.lazareva.list;

public class ArrayList implements List {
    private Object[] array = new Object[5];
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        validateIndexToAdd(index);
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        array[size] = null;
        size--;
        return array[index];
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Object tmp = array[index];
        array[index] = value;
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
    public boolean contains(Object value) {
        return indexOf(value)!=-1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i > 0; i--) {
            if (array[i].equals(value)) {
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

    private void ensureCapacity() {
        if (size == array.length) {
            Object[] tmp = new Object[(int) (size * 1.5)];
            System.arraycopy(array, 0, tmp, 0, array.length);
            clear(array);
            array = tmp;
        }
    }

    private void clear(Object[] obj) {
        for (int i = 0; i < obj.length; i++) {
            obj[i] = null;
        }
    }
}