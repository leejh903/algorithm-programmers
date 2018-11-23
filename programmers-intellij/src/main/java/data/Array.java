package data;

public class Array<E> implements ArrayInterface {
    private E[] data;

    @Override
    public void init() {
        this.data = (E[]) new Object[1];
    }

    @Override
    public void set(int index, Object value) {
        if (index < data.length) {
            data[index] = (E) value;
            return;
        }
        E[] newData = (E[]) new Object[index + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[index] = (E) value;
        data = newData;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public void remove(int index) {
        if (index >= data.length) throw new ArrayIndexOutOfBoundsException();
        E[] newData = (E[]) new Object[size() - 1];
        int temp = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i == index) {
                temp++;
            }
            newData[i] = data[temp];
            temp++;
        }
        data = newData;
    }

    @Override
    public int size() {
        return data.length;
    }
}
