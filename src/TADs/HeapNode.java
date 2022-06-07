package TADs;
public class HeapNode<K,T> {

    private K key;
    private T valor;

    public HeapNode(K key, T valor) {
        this.key = key;
        this.valor = valor;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public K getKey() {
        return key;
    }

    public T getValor() {
        return valor;
    }




}