package TADs;

import Exceptions.KeyNotExist;



import static java.lang.Math.abs;

public class MyHashTableIMPL<K,T> implements HashTable<K,T> {

    private HashTableNode<K, T>[] values;

    private K[] Vector_de_Keys;

    private int amountElements;

    public HashTableNode<K, T>[] getValues() {
        return values;
    }

    public K[] getVector_de_Keys() {
        return Vector_de_Keys;
    }


    public MyHashTableIMPL() {
        values = new HashTableNode[10];
        amountElements = 0;
    }

    public MyHashTableIMPL(int size) {
        values = new HashTableNode[size];
        Vector_de_Keys = (K[]) new Object[size];
        amountElements = 0;
    }

    public void put(K key, T value) {
        int elementBucket = abs(key.hashCode()) % this.values.length;
        if (this.values[elementBucket] == null || this.values[elementBucket].isDeleated()) {
            this.values[elementBucket] = new HashTableNode(key, value);
        } else {
            int colisionNumber = 1;
            do {
                elementBucket = (abs(key.hashCode()) + colisionNumber) % this.values.length;
                colisionNumber++;
            } while (this.values[elementBucket] != null && !this.values[elementBucket].isDeleated() && colisionNumber < this.values.length);
            this.values[elementBucket] = new HashTableNode(key, value);
        }
        Vector_de_Keys[amountElements] = key;
        this.amountElements++;
        IncrementSize();
    }

    private void IncrementSize() {
        if (((float) this.amountElements / (float) this.values.length) >= 0.8) {
            HashTableNode<K, T>[] temp = this.values;
            this.values = new HashTableNode[temp.length * 2];
            this.amountElements = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null && !temp[i].isDeleated()) {
                    this.put(temp[i].getKey(), temp[i].getValue());
                }
            }
        }
    }

    public boolean contains(K key) {
        boolean contains = false;
        int elementBucket = abs(key.hashCode()) % this.values.length;
        if (this.values[elementBucket] != null) {
            if (this.values[elementBucket].getKey().equals(key) && !this.values[elementBucket].isDeleated()) {
                contains = true;
            } else {
                int colisionNumber = 1;
                do {
                    elementBucket = (abs(key.hashCode()) + colisionNumber) % this.values.length;
                    colisionNumber++;
                } while ((this.values[elementBucket] == null || !this.values[elementBucket].getKey().equals(key)) && colisionNumber < this.values.length);

                if (colisionNumber < this.values.length && !this.values[elementBucket].isDeleated()) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    public void remove(K key) throws KeyNotExist {
        int elementBucket = abs(key.hashCode()) % this.values.length;
        if (this.get(key) != null) {
            if (this.values[elementBucket].getKey().equals(key)) {
                this.values[elementBucket].setDeleated(true);
            } else {
                int colisionNumber = 1;
                do {
                    elementBucket = (abs(key.hashCode()) + colisionNumber) % this.values.length;
                    colisionNumber++;
                } while (!this.values[elementBucket].getKey().equals(key));
                this.values[elementBucket].setDeleated(true);
            }
            this.amountElements--;
        } else {
            throw new KeyNotExist();
        }
    }

    public T get(K key) {
        T value = null;
        int elementBucket = abs(key.hashCode()) % this.values.length;
        if (this.values[elementBucket] != null) {
            if (this.values[elementBucket].getKey().equals(key) && !this.values[elementBucket].isDeleated()) {
                value = this.values[elementBucket].getValue();
            } else {
                int colisionNumber = 1;
                do {
                    elementBucket = (abs(key.hashCode()) + colisionNumber) % this.values.length;
                    colisionNumber++;
                } while (this.values[elementBucket] != null && !this.values[elementBucket].getKey().equals(key) && colisionNumber < this.values.length);
                if (colisionNumber < this.values.length && this.values[elementBucket] != null && !this.values[elementBucket].isDeleated()) {
                    value = this.values[elementBucket].getValue();
                }
            }
        }
        return value;
    }

    public int size() {
        return this.amountElements;
    }

}





