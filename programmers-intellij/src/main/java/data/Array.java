package data;

public class Array<E> implements ArrayInterface{
    private E[] data;

    @Override
    public void init() {
        this.data = (E[])new Object[10];
    }

    @Override
    public void set(int index, Object value) {
        if(index < data.length) {
            data[index] = (E)value;
            return;
        }
        E[] newData = (E[])new Object[index + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[index] = (E)value;
        data = newData;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int size() {
        return data.length;
    }
}
