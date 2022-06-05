package TADs;

public class MyHashTableIMPL<K, T> implements HashTable<K, T> {


    private HashNode<K, T>[] miTabla;

    public static final int TAMANIO_INIT = 10;
    public static final int FACTOR_CRECIMIENTO = 2;


    public MyHashTableIMPL() {
        miTabla = new HashNode[MyHashTableIMPL.TAMANIO_INIT];
    }

    @Override
    public void put(K key, T value) {

        float cargaDelSistema = 0;
        int cantidaddeEntradas = 0;

        for (int i = 0; i < miTabla.length; i++) {
            if (miTabla[i] != null) {
                cantidaddeEntradas = cantidaddeEntradas + 1;
            }
        }

        cargaDelSistema = cantidaddeEntradas / miTabla.length;

        if (cargaDelSistema >= 0.8) {

            miTabla = Redimensionar(miTabla);
            /*HashNode<K, T>[] miTablaNueva = new HashNode[miTabla.length];
            miTablaNueva = miTabla;
            miTabla = new HashNode[2 * (miTablaNueva.length)];
            miTabla = miTablaNueva;*/

        }

        int position = (key.hashCode()) % miTabla.length;
//FIXME isEstaBorrado
        if (miTabla[position] == null || miTabla[position].isEstaBorrado() || miTabla[position].getLlave().equals(key)) {

            HashNode<K, T> nodoAgregar = new HashNode<>(key, value);
            miTabla[position] = nodoAgregar;

        } else {
            int numerodeColision = 1;
            int nuevaposicion = 0;

            do {
                nuevaposicion = (key.hashCode() + colision(numerodeColision)) % miTabla.length;
                numerodeColision++;

            } while (miTabla[nuevaposicion] != null && !miTabla[nuevaposicion].isEstaBorrado() && numerodeColision < miTabla.length);

            if (numerodeColision < miTabla.length) {
                HashNode<K, T> nodoAgregar = new HashNode<>(key, value);
                miTabla[nuevaposicion] = nodoAgregar;
            }

        }


    }

    public static HashNode[] Redimensionar(HashNode[] miTabla) {
        HashNode[] nuevaTabla = new HashNode[FACTOR_CRECIMIENTO * miTabla.length];
        System.arraycopy(miTabla, 0, nuevaTabla, 0, miTabla.length);

        return nuevaTabla;
    }

    public int colision(int intento) {

        if (intento < miTabla.length) {
            return intento;
        } else {
            return 0;
        }
    }

    @Override
    public T get(K key) {
        int position = key.hashCode();
        T retorno = null;

        if (miTabla[position] != null && miTabla[position].getLlave().equals(key) && !miTabla[position].isEstaBorrado()) {
            retorno = miTabla[position].getValor();

        } else {
            int numerodeColision = 1;
            int nuevaposicion = 0;

            do {
                nuevaposicion = key.hashCode() + numerodeColision % miTabla.length;
                numerodeColision++;

            } while (miTabla[nuevaposicion] != null && !miTabla[nuevaposicion].getLlave().equals(key)
                    && numerodeColision < miTabla.length);

            if (numerodeColision < miTabla.length && miTabla[nuevaposicion].getLlave().equals(key) &&
                    !this.miTabla[nuevaposicion].isEstaBorrado()) {
                retorno = miTabla[nuevaposicion].getValor();
            }

        }


        return retorno;
    }

    @Override
    public void remove(K key) {
        int position = key.hashCode() % miTabla.length;

        if (miTabla[position] == null) {
            //No hago nada, no hay nada para borrar

        } else if (!miTabla[position].isEstaBorrado() && miTabla[position].getLlave().equals(key)) {
            miTabla[position].setLlave(null);
            miTabla[position].setValor(null);
            miTabla[position].setEstaBorrado(true);

        } else {

            if (!miTabla[position].getLlave().equals(key)) {

                int numerodeColision = 1;
                int nuevaposicion = 0;

                do {
                    nuevaposicion = key.hashCode() + numerodeColision % miTabla.length;
                    numerodeColision++;

                } while (miTabla[nuevaposicion] != null && !miTabla[nuevaposicion].getLlave().equals(key)
                        && numerodeColision < miTabla.length);

                if (numerodeColision < miTabla.length && miTabla[nuevaposicion].getLlave().equals(key) &&
                        !this.miTabla[nuevaposicion].isEstaBorrado()) {
                    miTabla[nuevaposicion].setLlave(null);
                    miTabla[nuevaposicion].setValor(null);
                    miTabla[nuevaposicion].setEstaBorrado(true);


                }
            }


        }


    }

    @Override
    public int size() {
        int cantidaddeEntradas = 0;

        for (int i = 0; i < miTabla.length; i++) {
            if (miTabla[i] != null) {
                cantidaddeEntradas = cantidaddeEntradas + 1;
            }
        }

        return cantidaddeEntradas;    }
}
