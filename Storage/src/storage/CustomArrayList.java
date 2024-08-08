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

    public T get(int index) {
    	if (index<0 || index>=size) {
    		String exceptionMessage = "Index " + index + " out of bounds for length " + size;
    		throw new IndexOutOfBoundsException(exceptionMessage);
    	}
    	return customArray[index];
    }

    public void delete(int index) {
    	if (index<0 || index>=size) {
    		String exceptionMessage = "Index " + index + " out of bounds for length " + size;
    		throw new IndexOutOfBoundsException(exceptionMessage);
    	}
    	
    	int newCustomArrayIndex = 0;
    	T[] newCustomArray = (T[]) new Object[customArray.length-1];
    	
    	for (int i = 0; i<customArray.length; i++) {
    		if (i == index) continue;
    		newCustomArray[newCustomArrayIndex] = customArray[i];
    		newCustomArrayIndex++;
    	}
    	customArray = newCustomArray;
    	size--;
    }

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
    	T[] listToPrint = (T[]) new Object[size];
    	for (int i = 0; i<size; i++) {
    		listToPrint[i] = customArray[i];
    	}
        return Arrays.toString(listToPrint);
    }

    public int size() {
        return size;
    }
}