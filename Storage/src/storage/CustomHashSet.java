package storage;
import java.util.Arrays;
import java.util.ArrayList;

public class CustomHashSet<T> {
	
	private T[] customSet = (T[]) new Object[10];
	private int size = 0;
	
	public void put(T o) {
		if (!contains(o)) {
			customSet[size] = o;
			size++;
			checkLength();
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
				if (objectHash == customSet[i].hashCode()) {
					objectsWithEqualHash.add(o);
					hashEqual = true;
				}
			}
			
			if (hashEqual) {
				for (int i = 0; i<objectsWithEqualHash.size(); i++) {
					if(o.equals(objectsWithEqualHash.get(i))) {
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
	
}
