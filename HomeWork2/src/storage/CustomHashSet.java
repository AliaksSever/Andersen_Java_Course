package storage;
import java.util.HashSet;

public class CustomHashSet<E> extends HashSet<E>{

    public void Put(E element) {
        super.add(element);
    }

    public boolean Contains(Object element) {
        return super.contains(element);
    }

    public void Delete(Object element) {
        super.remove(element);
    }

}