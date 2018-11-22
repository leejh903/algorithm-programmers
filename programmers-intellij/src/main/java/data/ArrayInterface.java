package data;

public interface ArrayInterface<E> {

    void init();

    void set(int index, E value);

    E get(int index);

    int size();
}
