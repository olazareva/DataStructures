package ua.lazareva.datastructures.list;

public interface List<T> {

    int size();

    void add(T t);

    void add(T t, int index);

    T get(int index);

    void remove(T t) ;

    T remove(int index);

    boolean isEmpty();

    void set(T t, int index);

    boolean contains(T t);

    void clear();

    int indexOf(T t) ;

    int lastIndexOf(T t) ;
}
