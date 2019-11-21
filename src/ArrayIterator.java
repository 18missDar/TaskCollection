import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    E[] values;

    public ArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }


    @Override
    public void remove() {
        int nElements = values.length;
        if (index < nElements - 1) {
            System.arraycopy(values, index+1,
                    values, index, nElements - index-1);
        }
        nElements--;
    }
}
