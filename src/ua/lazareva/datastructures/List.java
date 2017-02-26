package ua.lazareva.datastructures;

public interface List {

    int size();

    void add(Object object);

    void add(Object object, int index);

    Object get(int index);

    void remove(Object object);

    Object remove(int index);

    boolean isEmpty();

    void set(Object object, int index);

    boolean contains(Object object);

    void clear();

    int indexOf(Object object);

    int lastIndexOf(Object object);
}
