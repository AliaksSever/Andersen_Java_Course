package storage;
import java.util.Arrays;

public class CustomArrayList<T> {
    private T[] customArray = (T[]) new Object[10];
    private int size = 0;

    public void put(T o) {
        customArray[size] = o;
        size++;
        checkArrayLength();
    }

    public void get(int index) {}

    public void delete(int index) {}

    public void checkArrayLength() {
        if (size==customArray.length) {
            T[] newCustomArray = (T[]) new Object[customArray.length+5];
            for (int i = 0; i < customArray.length; i++) {
                newCustomArray[i] = customArray[i];
            }
            customArray = newCustomArray;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(customArray);
    }

    public int size() {
        return size;
    }
}