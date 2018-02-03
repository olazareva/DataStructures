package ua.lazareva.list;

public class LinkedList implements List {
    private int size;
    private Node head, tail, node;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        node = head;
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
    public void add(Object value, int index) {
        validateIndexToAdd(index);
        Node nodeToAdd = new Node(value);
        /*ins at head*/
        if (index == 0) {
            if (size == 0) {
                head = tail = nodeToAdd;
            } else {
                head.prev = nodeToAdd;
                nodeToAdd.next = head;
                head = nodeToAdd;
            }
        }
        /*ins at tail*/
        if (index == size && size > 0) {
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
        }
        /*ins between*/
        if (index > 0 && index < size) {
            node = getNode(index);
            nodeToAdd.prev = node.prev;
            nodeToAdd.next = node;
            node.prev.next = nodeToAdd;
            node.prev = nodeToAdd;
        }

        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object tmp = 0;
        if (index == 0) {
            tmp = head.value;
            head = head.next;
        }
        if (index == size - 1) {
            tmp = tail.value;
            tail = tail.prev;
        }
        if (index > 0 && index < size - 1) {
            Node nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return tmp;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        node = getNode(index);
        Object tmp = node.value;
        node.value = value;
        return tmp;
    }

    @Override
    public void clear() {
        node = head;
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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(value)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        node = tail;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(value)) {
                return size - i - 1;
            }
            node = node.prev;
        }
        return -1;
    }

    private class Node {
        private Node prev;
        private Node next;
        private Object value;

        private Node(Object value) {
            this.value = value;
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

    private Node getNode(int index) {
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
