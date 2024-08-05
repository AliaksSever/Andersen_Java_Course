package storage;
import java.util.ArrayList;

public class CustomArrayList<E> extends ArrayList<E> {
	
    public void Put(int index, E element) {
        super.add(index, element);
    }

    public E Get(int index) {
        return super.get(index);
    }

    public void Delete(int index) {
        super.remove(index);
    }

}
