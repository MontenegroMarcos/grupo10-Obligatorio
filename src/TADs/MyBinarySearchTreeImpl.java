package TADs;


import Exceptions.ElementNotExistException;


public class MyBinarySearchTreeImpl<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

    private NodeBST<K, T> root;
    private NodeBST<K, T> auxiliar;

    public MyBinarySearchTreeImpl() {
    }

    private NodeBST<K, T> findNode(K key, NodeBST<K, T> rootLocal) {

        //Caso en que la raiz == null o la key == key de la raiz
        if (rootLocal == null) {
            return null;
        }

        // Si la key es mas grande que la key de la raiz
        if (rootLocal.getKey().compareTo(key) < 0) {
            return findNode(key, rootLocal.getRightChild());
        }

        // Si la key es mas chica que la key de la raiz
        if (rootLocal.getKey().compareTo(key) > 0) {
            return findNode(key, rootLocal.getLeftChild());
        }
        // if key == rootLocal.key
        return rootLocal;
    }

    private void insertNode(K key, T data, NodeBST<K, T> rootNuevo) {

        //NodeBST<K, T> nodoResul = null;
        //rootNuevo = this.root;

        if (rootNuevo == null) {
            this.root = new NodeBST<K, T>(key, data);
            //return root;
        } else {

            if (rootNuevo.getKey().compareTo(key) < 0) {
                if (rootNuevo.getRightChild() == null) {
                    rootNuevo.setRightChild(new NodeBST<K, T>(key, data));
                } else {
                    insertNode(key, data, rootNuevo.getRightChild());
                }
            } else if (rootNuevo.getKey().compareTo(key) > 0) {
                if (rootNuevo.getLeftChild() == null) {
                    rootNuevo.setLeftChild(new NodeBST<K, T>(key, data));
                } else {
                    insertNode(key, data, rootNuevo.getLeftChild());
                }
            }
        }
    }

    public boolean elementExist(K key) {
        NodeBST<K, T> actualNode = this.root;
        NodeBST<K, T> auxiliar = findNode(key, actualNode);

        if (auxiliar == null) {
            return false;
        }
        return true;
    }

    @Override
    public T find(K key) throws ElementNotExistException {

        NodeBST<K, T> actualNode = this.root;
        NodeBST<K, T> auxiliar = findNode(key, actualNode);

        if (auxiliar == null) {
            System.out.println("No existe");
        }

        if (auxiliar == null) {
            throw new ElementNotExistException();
        }

        return auxiliar.getData();
    }

    @Override
    public void insert(K key, T data) {
        insertNode(key, data, this.root);
    }

    @Override
    public void delete(K key) {


        if (root != null) {
            root.deleteNode(key);


        }

    }
}