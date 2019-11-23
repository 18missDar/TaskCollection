import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyArrayList<E> implements ArrayList<E>, Collection<E>{
    private E[] values;

    MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) new Object[temp.length+1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    public int find(E e){
        for (int i = 0; i< values.length; i++){
            if (values[i].equals(e)) return i;
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        int number = find((E)o);
        if (number != -1){
            delete(number);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i<values.length; i++){
            delete(i);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public void delete(int index) {
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        int countElements = temp.length - index - 1;
        System.arraycopy(temp, index + 1, values, index, countElements);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return (values.length == 0) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i< values.length; i++){
            if (values[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public void addCollection(Collection<E> e) {
       for (E elem: e){
           add(elem);
       }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}
