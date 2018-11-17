package data;

public class Array implements ArrayInterface{
    int[] array;

    public Array(int size) {
        array = new int[size];
    }

    @Override
    public void set(int index, int value) {
        array[index] = value;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }
}
