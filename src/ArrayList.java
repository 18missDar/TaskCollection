import java.util.List;
import java.util.Stack;
import java.util.Vector;

public interface ArrayList<E> extends Iterable<E> {
    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

    void addCollection(E[] e);

    void addCollection(List<E> e);

    void addCollection(Stack<E> e);

    void addCollection(Vector<E> e);

    void addMy(MyArrayList<E> e);
}
