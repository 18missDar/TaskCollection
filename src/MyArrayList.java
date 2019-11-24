import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.Iterator;

public class MyArrayList<E> implements ArrayList<E>{

    private static final int DEFAULT_CAPACITY = 10;

    private E[] values;
    private int size = 0;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    public class ArrayIterator<E> implements Iterator<E> {
        private int index = 0;
        private E[] val;

        ArrayIterator() {
             val = (E[]) MyArrayList.this.values;
         }

         @Override
        public boolean hasNext() {
            return index < val.length;
        }

        @Override
        public E next() {
            return val[index++];
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("You can't delete element before first next() method call");
            }
            else{
                index--;
                E[] temp = (E[]) MyArrayList.this.values;
                val = (E[]) new Object[temp.length - 1];
                System.arraycopy(temp, 0, val, 0, index);
                int countElements = temp.length - index - 1;
                System.arraycopy(temp, index + 1, val, index, countElements);
                for (E elem: val){
                    System.out.println(elem);
                }
            }
        }
        public E[] getVal() {
            return val;
        }

    }

    public MyArrayList(E[] values, int size) {
        this.values = values;
        this.size = size;
    }

    private void grow(int minNewSize) {
        if (values.length == 0) {
            values = (E[]) new Object[Math.max(DEFAULT_CAPACITY, minNewSize)];
        } else {
            int newSize = Math.max(minNewSize, (values.length >> 1) + values.length);
            values = Arrays.copyOf(values, newSize);
        }
    }

    @Override
    public boolean add(E e) {
        if (size == values.length) {
            grow(size + 1);
        }
        values[size++] = e;
        return true;
    }

    public void print(){
        for (int i = 0; i<values.length; i++){
            System.out.println(values[i]);
        }
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
        size--;
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
        E[] temp = values;
        grow(e.size() + size);
        System.arraycopy(temp, 0, values, 0, temp.length);
        System.arraycopy(e, 0, values, temp.length + 1, e.size());
    }

    @Override
    public Iterator<E> iterator() {
        ArrayIterator iterator = new ArrayIterator<E>();
        values = (E[]) Arrays.copyOf( iterator.getVal(), 10);
        return iterator;
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
