import java.util.Collection;

public interface ArrayList<E> extends Collection<E> {
    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

    void addCollection(Collection<E> e);
}
