package TADs;
public interface HashTable<K,T> {

    void put(K key, T value);

    T get(K key);

    void remove(K key);

    int size();
}
