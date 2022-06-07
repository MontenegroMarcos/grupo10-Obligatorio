package TADs;

import Exceptions.HeapEmpty;

public class MyHeapImplMax<K extends Comparable<K>, T> implements MyHeap<K, T> {

    private HeapNode<K, T>[] miVector;

    private int indicesigelemento = 0;

    public static final int Tamanio_Vector = 10;

    public MyHeapImplMax() {
        miVector = new HeapNode[MyHeapImplMax.Tamanio_Vector];

    }

    private int getHijoDerecho(int indicePadre) {
        return (2 * indicePadre) + 2;
    }

    private int getHijoIzquierdo(int indicePadre) {
        return (2 * indicePadre) + 1;
    }

    private int getPadreinidce(int indiceHijo) {

        return (indiceHijo - 1) / 2;
    }

    @Override
    public void add(K key, T data) { //Key es el numero que me determina el orden de los nodos
        HeapNode<K, T> nodoAgregar = new HeapNode<>(key, data);
        miVector[indicesigelemento] = nodoAgregar;

        int idexelement = indicesigelemento;

        indicesigelemento = indicesigelemento + 1;

        int indicePadre = getPadreinidce(idexelement);

        while (nodoAgregar.getKey().compareTo(miVector[indicePadre].getKey()) > 0 && idexelement != 0) {
            miVector[idexelement] = this.miVector[indicePadre];
            miVector[indicePadre] = new HeapNode<>(key, data);

            idexelement = indicePadre;
            indicePadre = getPadreinidce(idexelement);

        }

    }

    @Override
    public HeapNode<K, T> remove() throws HeapEmpty {

        HeapNode<K, T> nodoaEliminar = null;
        int posiciondelUltimo = size() - 1 ;
        int tamanio_array = size();

        if (tamanio_array == 0) {//cambiar size() por una var
            throw new HeapEmpty();
        }
        if (tamanio_array == 1) {
            nodoaEliminar = miVector[0];
            miVector[0] = null;
        } else if (tamanio_array == 2) {
            nodoaEliminar = miVector[0];
            miVector[0] = miVector[1];
            miVector[1] = null;
        } else {
            int raiz = 0;

            nodoaEliminar = miVector[0];

            miVector[raiz] = miVector[posiciondelUltimo];

            miVector[posiciondelUltimo] = null; //Hasta Aqui esta bien

            int posicionHijoMayor = HijoMasGrandePosition(getHijoDerecho(raiz), getHijoIzquierdo(raiz));

            while (miVector[posicionHijoMayor].getKey().compareTo(miVector[raiz].getKey()) > 0) {
                HeapNode<K, T> temp = miVector[posicionHijoMayor];
                miVector[posicionHijoMayor] = miVector[raiz];
                miVector[raiz] = temp;
            }
        }

        return nodoaEliminar;
    }

    private int HijoMasGrandePosition(int position1, int position2) {
        int posicion = 0;
        if ( miVector[position1] != null && miVector[position1].getKey().compareTo(miVector[position2].getKey()) > 0 ) {
            posicion = position1;
        } else if( miVector[position2] != null){
            posicion = position2;
        }
        return posicion;
    }

    @Override
    public int size() {
        int cantidad_de_Entradas = 0;
        for (int i = 0; i < miVector.length; i++) {
            if (miVector[i] != null) {
                cantidad_de_Entradas++;
            }
        }
        return cantidad_de_Entradas;
    }
}
