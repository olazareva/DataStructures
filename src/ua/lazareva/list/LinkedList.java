package ua.lazareva.list;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> head, tail;

    @Override
    public void add(T t) {
        add(t, size);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            string.append(node.value);
            if (i < size - 1) {
                string.append(", ");
            }
            node = node.next;
        }
        string.append("]");
        return String.valueOf(string);
    }

    @Override
    public void add(T t, int index) {
        validateIndexToAdd(index);
        Node<T> nodeToAdd = new Node<>(t);
        if (size == 0) {
            head = tail = nodeToAdd;
        } else if (index == 0) {
            head.prev = nodeToAdd;
            nodeToAdd.next = head;
            head = nodeToAdd;
        } else if (index == size) {
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
        } else {
            Node<T> node = getNode(index);
            nodeToAdd.prev = node.prev;
            nodeToAdd.next = node;
            node.prev.next = nodeToAdd;
            node.prev = nodeToAdd;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removed = null;
        if(size==1){
            head = tail=null;
        } else if (index == 0) {
            removed = head.value;
            head = head.next;
        } else if (index == size - 1) {
            removed = tail.value;
            tail = tail.prev;
        } else {
            Node<T> nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            removed = nodeToRemove.value;
        }
        size--;
        return removed;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    @Override
    public T set(T t, int index) {
        validateIndex(index);
        Node<T> node = getNode(index);
        T tmp = node.value;
        node.value = t;
        return tmp;
    }

    @Override
    public void clear() {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            node.value = null;
            node.prev = null;
            if (!node.equals(tail)) {
                node = node.next;
                node.prev.next = null;
            }
        }
        head = tail = null;
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
        return indexOf(t) != -1;
    }

    @Override
    public int indexOf(T t) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(t)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {
        Node<T> node = tail;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(t)) {
                return size - i - 1;
            }
            node = node.prev;
        }
        return -1;
    }

    private class Node<V> {
        private Node<V> prev;
        private Node<V> next;
        private V value;

        private Node(V v) {
            this.value = v;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be between 0(inclusive) and " + (size) + " (inclusive). You put " + index);
        }
    }

    private void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0(inclusive) and " + (size) + " (inclusive). You put " + index);
        }
    }

    private Node<T> getNode(int index) {
        Node<T> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
}
