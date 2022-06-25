package TADs;

import Exceptions.KeyNotExist;
public interface HashTable<K,T> {
    public void put(K key,T value);
    public boolean contains(K key);
    public void remove(K key) throws KeyNotExist;
    public T get(K key);
    public int size();
}
