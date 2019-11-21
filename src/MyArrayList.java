import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MyArrayList<E> implements ArrayList<E> {
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
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public void addCollection(E[] e) {
        for (E elem: e){
            add(elem);
        }
    }

    @Override
    public void addCollection(List<E> e) {
        for (E elem: e){
            add(elem);
        }
    }

    @Override
    public void addCollection(Stack<E> e) {
        for (E elem: e){
            add(elem);
        }
    }

    @Override
    public void addCollection(Vector<E> e) {
        for (E elem: e){
            add(elem);
        }
    }

    @Override
    public void addMy(MyArrayList<E> e) {
        for (E elem: e){
            add(elem);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }
}
