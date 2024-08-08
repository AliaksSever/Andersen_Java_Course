package storage;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomHashSet<T> implements Iterable<T>{
	
	private T[] customSet = (T[]) new Object[10];
	private int size = 0;
	
	public void put(T o) {
		if (!contains(o)) {
			customSet[size] = o;
			size++;
			checkLength();
		}
	}
	
	public void delete(T o) {
		if (contains(o)) {
			T[] newCustomSet = (T[]) new Object[size-1];
			int newCustomSetIndex = 0;
			for (int i=0; i<size; i++) {
				
				try {
					if (customSet[i].equals(o)) {
						continue;
					}
					newCustomSet[newCustomSetIndex] = customSet[i];
					newCustomSetIndex++;
				}
				catch (NullPointerException e) {
					if (o == null) {
						continue;
					}
					else {
						newCustomSet[newCustomSetIndex] = customSet[i];
						newCustomSetIndex++;
					}
				}
			}
			customSet = newCustomSet;
			size--;
		}
	}
	
	
	private void checkLength() {
		if (size==customSet.length) {
			T[] newCustomSet = (T[]) new Object[customSet.length+5];
			for (int i = 0; i < customSet.length; i++) {
				newCustomSet[i] = customSet[i];
			}
			customSet = newCustomSet;
		}
	}
	
	public boolean contains(T o) {
		try {
			int objectHash = o.hashCode();
			boolean hashEqual = false;
			
			ArrayList<T> objectsWithEqualHash = new ArrayList<>();
			
			for (int i = 0; i<size; i++) {
				try {
					int setObjHash = customSet[i].hashCode();
					if (objectHash == setObjHash) {
						objectsWithEqualHash.add(customSet[i]);
						hashEqual = true;
					}
				}
				catch (NullPointerException e) {
					continue;
				}
			}
			
			if (hashEqual) {
				for (T obj: objectsWithEqualHash) {
					if (o.equals(obj)) {
						return true;
					}
				}
				return false;
			} else {
				return false;
			}
		}
		catch (NullPointerException e) {
			 for (int i = 0; i<size; i++) {
				 if (customSet[i] == o && o == null) {
					 return true;
				 }
			 }
			 return false;
		}
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		T[] setToPrint = (T[]) new Object[size];
		for (int i=0; i<size; i++) {
			setToPrint[i] = customSet[i];
		}
		return Arrays.toString(setToPrint);
	}
	
	public Iterator<T> iterator() {
		return new Iter(size, customSet);
	}
	
	private class Iter implements Iterator<T>{
		
		private int current;
		private int size;
		private T[] list;
		
		public Iter(int size, T[] list) {
			this.size = size;
			this.list = list;
		}
		
		@Override
		public boolean hasNext() {
			return current<size;
		}
		
		@Override
		public T next() {
			return list[current++];
		}
	}
	
}
