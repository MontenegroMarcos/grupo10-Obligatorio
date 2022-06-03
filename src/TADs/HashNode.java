package TADs;


    public class HashNode<K,T> {

        private K llave;
        private T valor;
        private boolean estaBorrado;

        public HashNode(K key, T valor){
            this.llave = key;
            this.valor = valor;
            this.estaBorrado = false;

        }

        public void setLlave(K llave) {
            this.llave = llave;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public void setEstaBorrado(boolean estaBorrado) {
            this.estaBorrado = estaBorrado;
        }

        public K getLlave() {
            return llave;
        }

        public T getValor() {
            return valor;
        }

        public boolean isEstaBorrado() {
            return estaBorrado;
        }




    }


