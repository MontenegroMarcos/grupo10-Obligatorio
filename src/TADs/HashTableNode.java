package TADs;

public class HashTableNode<K,T> {

    private K key;
    private T value;
    private boolean isDeleated;

    public HashTableNode(K key, T value) {
        this.key = key;
        this.value = value;
        this.isDeleated = false;
    }

    public void setDeleated(boolean deleated) {
        isDeleated = deleated;
    }

    public boolean isDeleated() {
        return isDeleated;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}

