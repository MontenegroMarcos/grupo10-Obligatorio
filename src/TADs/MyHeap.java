package TADs;
import Exceptions.HeapEmpty;

public interface MyHeap<K,T> {

    void add(K key , T data);

    HeapNode<K,T> remove() throws HeapEmpty;

    int size();
}
