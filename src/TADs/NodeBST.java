package TADs;

public class NodeBST <K extends Comparable<K>, T> {
    K key;
    T data;
    NodeBST <K, T> leftChild;
    NodeBST <K, T> rightChild;


    public NodeBST(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public NodeBST<K,T> deleteNode(K key) {
        // ----- Busqueda del elemento -----
        if (this.key.compareTo(key) < 0){
            rightChild = rightChild.deleteNode(key);
        }
        else if (this.key.compareTo(key) > 0){
            leftChild = leftChild.deleteNode(key);
        }

        // ----- Se encontro el elemento -----

        // No se ramifica
        else if (leftChild != null && rightChild != null){
            NodeBST<K,T> temp = rightChild.getMin();

            this.key = temp.getKey();
            this.data = temp.getData();
            rightChild = rightChild.deleteNode(temp.getKey());
        }
        else{
            if (leftChild != null){
                return leftChild;
            }
            else{
                return rightChild;
            }
        }
        return this;
    }

    public NodeBST getMin(){
        NodeBST<K,T> objective = this;

        if (leftChild != null){
            objective = leftChild.getMin();
        }

        return objective;
    }



    //Getters y Setters
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }

}

