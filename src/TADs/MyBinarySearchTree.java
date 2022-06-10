package TADs;

import Exceptions.ElementNotExistException;

public interface MyBinarySearchTree <K extends Comparable<K>, T> {
    T find(K key) throws ElementNotExistException;

    void insert (K key, T data);

    void delete (K key)throws ElementNotExistException;

}
