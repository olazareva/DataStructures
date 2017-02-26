package ua.lazareva.datastructures;


public class LinkedList implements List {
    int size;
    Node head;
    Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object object) {
        add(object, size);
    }

    @Override
    public void add(Object object, int index) {
        Node nodeToAdd = new Node(object);

        if (size == 0) {

            head = tail = nodeToAdd;
        } else if (index == 0) {
            nodeToAdd.next = head;
            head.prev = nodeToAdd;
            head = nodeToAdd;
        } else if (index == size) {
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
        } else {
            Node nodeToReplace;
            nodeToReplace = getNode(index);

            nodeToAdd.prev = nodeToReplace.prev;
            nodeToAdd.next = nodeToReplace;

            nodeToReplace.prev.next = nodeToAdd;
            nodeToReplace.prev = nodeToAdd;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        return getNode(index).value;
    }


    @Override
    public void remove(Object object) {
        Node nodeToRemove;
        for (int i = 0; i < size; i++) {
            nodeToRemove = getNode(i);
            if (object.equals(nodeToRemove.value)) {

                if (size == 1) {
                    head = tail = null;
                } else if (i == 0) {
                    head = head.next;
                    head.prev = null;
                } else if (i == size - 1) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    nodeToRemove.prev.next = nodeToRemove.next;
                    nodeToRemove.next.prev = nodeToRemove.prev;
                }
                size--;
            }
        }
    }

    @Override
    public Object remove(int index) {
        Node nodeToRemove;

        if (size == 1) {
            nodeToRemove = head;
            head = tail = null;
        } else if (index == 0) {
            nodeToRemove = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            nodeToRemove = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return nodeToRemove.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(Object object, int index) {
        getNode(index).value = object;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object object) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (object.equals(node.value)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node node = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(node.value)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Index " + index + " should be between 0 and " + size + " exclusive";
            throw new IndexOutOfBoundsException(msg);
        }
    }

    private Node getNode(int index) {
        validateIndex(index);
        Node node;

        if (index <= size / 2) {
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

    private static class Node {
        Node prev;
        Node next;
        Object value;

        private Node(Object obj) {
            value = obj;
        }

    }
}
