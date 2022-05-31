package TADs;

public interface MyLinkedList<T> {


    void add(T value);

    public void remove(int position);

    public T get(int position);

    public boolean estaEnLista(T value);
}
