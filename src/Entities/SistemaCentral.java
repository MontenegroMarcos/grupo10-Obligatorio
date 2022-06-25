package Entities;

import EntidadesAuxiliares.NodoBrewery;
import EntidadesAuxiliares.nodoBeerMostReview;
import EntidadesAuxiliares.nodoCatadores;
import EntidadesAuxiliares.nodoStyleBeer;
import TADs.MyHashTableIMPL;
import TADs.MyLinkedListImpl;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import java.util.Date;
import java.util.Random;

public class SistemaCentral {
    public MyHashTableIMPL<Long, Brewery> tablaCervecerias = new MyHashTableIMPL<>(6000);
    public MyHashTableIMPL<Long, Beer> tablaCervezas = new MyHashTableIMPL<>(50000);

    public MyHashTableIMPL<Long, Review> getTablaReviews() {
        return tablaReviews;
    }

    public MyHashTableIMPL<Long, Review> tablaReviews = new MyHashTableIMPL<>(1520000);
    public MyHashTableIMPL<String, Style> tablaEstilos = new MyHashTableIMPL<>(500);
    public MyHashTableIMPL<String, User> tablaUsers = new MyHashTableIMPL<>(40000);


    public void leerCSV(String path) throws IOException, OutOfMemoryError, IOException {
        int x = 0;
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        line = csvReader.readNext();
        while ((line = csvReader.readNext()) != null) {
            //String a = line[12];
            //x = agregarDatos(line, x);

            if (!line[12].isEmpty()) {
                x = agregarDatos(line, x);
            }
            //if( line[12] != null || !line[12].equals("") || 0 != Integer.parseInt(line[12])  ){
            //x = agregarDatos(line, x);


            //}
        }

        System.out.println("Users: " + tablaUsers.size());
        System.out.println("Estilos: " + tablaEstilos.size());
        System.out.println("Cervezas: " + tablaCervezas.size());
        System.out.println("Cervecerias: " + tablaCervecerias.size());
        System.out.println("Reviews: " + tablaReviews.size());

    }

    public int agregarDatos(String[] line, int x) {


        try {

            long review_id = Long.parseLong(line[0]);
            long brewery_id = Long.parseLong(line[1]);
            String brewery_name = line[2];
            long epoch = Long.parseLong(line[3]);
            Date review_time = new Date(epoch * 1000);
            double review_overall = Double.parseDouble(line[4]);
            double review_aroma = Double.parseDouble(line[5]);
            double review_appearance = Double.parseDouble(line[6]);
            String review_profilename = line[7];
            String beer_style = line[8];
            double review_palate = Double.parseDouble(line[9]);
            double review_taste = Double.parseDouble(line[10]);
            String beer_name = line[11];
            double beer_abv = Double.parseDouble(line[12]);
            long beer_beerid = Long.parseLong(line[13]);


            addEstilo(beer_style);
            addCerveza(beer_beerid, beer_name, beer_abv);
            addCerveceria(brewery_id, brewery_name);
            addReview(review_id, review_time, review_overall, review_aroma, review_appearance, review_palate, review_taste);
            addUser(review_profilename, review_id, review_time, review_overall, review_aroma, review_appearance, review_palate, review_taste);


            x++;
            return x;
        } catch (Exception e) {
            //System.out.println(e);
            return x;
            //no agregar nada
        }
    }


    //PRIMER CONSULTA


    public NodoBrewery[] QuickSort(NodoBrewery[] entrada, int indiceBajo, int indiceAlto) {
        String[] resultados = new String[indiceAlto + 1];
        NodoBrewery[] entradas = entrada;

        if (indiceBajo >= indiceAlto) {
            return entradas;
        }

        int Pivot = 0;
        int primer_elemento = (entradas[0].getCantidad_de_resenias());
        int medio_elemento = (entradas[indiceAlto / 2].getCantidad_de_resenias());
        int ultimo_elemento = (entradas[indiceAlto].getCantidad_de_resenias());

        if (primer_elemento < medio_elemento && medio_elemento > ultimo_elemento) {
            Pivot = medio_elemento;
        } else if (primer_elemento > medio_elemento && primer_elemento < ultimo_elemento) {
            Pivot = primer_elemento;
        } else {
            Pivot = ultimo_elemento;
        }

        if (Pivot != ultimo_elemento && Pivot == primer_elemento) {
            IntercambiarNodos(entradas, indiceBajo, indiceAlto);
            /*entradas[14].getCantidad_de_resenias() = Pivot;
            entradas[0].getCantidad_de_resenias() = ultimo_elemento;*/
        } else if (Pivot != ultimo_elemento && Pivot == medio_elemento) {
            IntercambiarNodos(entradas, indiceAlto / 2, indiceAlto);
            /*entradas[14].getCantidad_de_resenias() = Pivot;
            entradas[7].getCantidad_de_resenias() = ultimo_elemento;*/
        }


        //Entonces despues de elegir nuestro candidato a Pivote
        int Pivote = entradas[indiceAlto].getCantidad_de_resenias();

        int posicionElementoIzquierdo = indiceBajo;
        int posicionElementoDerecho = indiceAlto;

        while (posicionElementoDerecho > posicionElementoIzquierdo) {

            while (entradas[posicionElementoIzquierdo].getCantidad_de_resenias() >= Pivote &&
                    posicionElementoDerecho > posicionElementoIzquierdo) {
                posicionElementoIzquierdo++;
            }
            while (entradas[posicionElementoDerecho].getCantidad_de_resenias() <= Pivote &&
                    posicionElementoDerecho > posicionElementoIzquierdo) {

                posicionElementoDerecho--;
            }
            IntercambiarNodos(entradas, posicionElementoIzquierdo, posicionElementoDerecho);
        }
        IntercambiarNodos(entradas, posicionElementoIzquierdo, indiceAlto);
        QuickSort(entradas, indiceBajo, posicionElementoIzquierdo - 1);
        QuickSort(entradas, posicionElementoIzquierdo, indiceAlto);

        return entradas;
    }

    public static void IntercambiarNodos(NodoBrewery[] entradas, int posicion1, int posicion2) {
        NodoBrewery dato = entradas[posicion1];
        entradas[posicion1] = entradas[posicion2];
        entradas[posicion2] = dato;


    }

    public int MedioDeTres(int[] entradas, int indiceInicial, int indiceFinal) {

        return 0;
    }


    public NodoBrewery[] PrimerConsulta(Date anio) throws ParseException {

        Long AnioAnalizar = anio.getTime();


        NodoBrewery[] resultados = new NodoBrewery[10];

        //Estructura de Control para que solo cuente los nodos con el anio correcto



        /*for (int i = 0; i < 9; i++) {
            if(true){ //Fixme controlar el anio en que se hizo esto
                entrada[i] = Hashdeentrada[i];
                resultados = QuickSort(entrada,0,9);

            }

        } */
        //resultados = QuickSort(entrada,0,9);

       /* for (int i = 9; i < Hashdeentrada.length; i++) {
            if(true && Hashdeentrada[i] != null &&
                    entrada[9].getCantidad_de_resenias() <= Hashdeentrada[i].getCantidad_de_resenias()){ //Fixme controlar el anio en que se hizo esto y si el ultimo elemento es menor a otro de la tabla
                entrada[9] = Hashdeentrada[i];
                resultados = QuickSort(entrada, 0 , 9);
            }
            resultados = QuickSort(entrada, 0 , 9);
        }
        //resultados = entrada;*/
        return resultados;

    }


    public MyLinkedListImpl<nodoCatadores> SegundaConsulta() {

        MyLinkedListImpl<nodoCatadores> top15 = new MyLinkedListImpl<>();

        Object[] arrayLlavesUsuario = tablaUsers.getVector_de_Keys();

        nodoCatadores[] ArrayEntero = new nodoCatadores[tablaUsers.size()];
        for (int i = 0; i < ArrayEntero.length; i++) {
            if (tablaUsers.get((String) arrayLlavesUsuario[i]).getUsername() != null) {
                nodoCatadores dato1 = new nodoCatadores(tablaUsers.get((String) arrayLlavesUsuario[i]).getUsername(), tablaUsers.get((String) arrayLlavesUsuario[i]).getReviews().size());
                if (dato1 != null) {
                    ArrayEntero[i] = dato1;
                }
            }
        }


        nodoCatadores maximo = null;
        for (int i = 0; i < ArrayEntero.length - 1; i++) {

            if (maximo == null) {
                maximo = ArrayEntero[0];
            }
            if (top15.size() == 15) {
                return top15;
            }
            if (ArrayEntero[i] != null && maximo.getCantidad_de_resenias() < ArrayEntero[i].getCantidad_de_resenias()) {
                maximo = ArrayEntero[i];
                ArrayEntero[i] = null;
                top15.add(maximo);
            }


        }


        return top15;
    }




    public nodoCatadores getMax(nodoCatadores[] array_entero) {
        nodoCatadores maximo = null;
        for (int i = 0; i < array_entero.length; i++) {
            if (maximo == null) {
                maximo = array_entero[0];
            }
            if (maximo.getCantidad_de_resenias() < array_entero[i].getCantidad_de_resenias()) {
                maximo = array_entero[i];
            }
        }

        return maximo;
    }


    public nodoCatadores[] QuicksortSegundo(nodoCatadores[] entrada) {

        nodoCatadores[] resultado = QuicksortSegundo(entrada, 0, entrada.length - 1);
        return resultado;
    }


    public nodoCatadores[] QuicksortSegundo(nodoCatadores[] entrada, int indiceBajo, int indiceAlto) {

        nodoCatadores[] resultado = entrada;


        if (indiceBajo >= indiceAlto) {
            return resultado;
        }

        /*for (int i = 0; i < entrada.length; i++) {
            System.out.println(entrada[i].getCantidad_de_resenias());
        }*/


        int posicionPivote = new Random().nextInt(indiceAlto - indiceBajo) + indiceBajo;
        int pivote = resultado[posicionPivote].getCantidad_de_resenias();
        IntercambiarNodos2(entrada, posicionPivote, indiceAlto);


        int elemento_izquierdo = indiceBajo;
        int elemento_derecho = indiceAlto;

        while (elemento_izquierdo < elemento_derecho) {

            while (entrada[elemento_izquierdo].getCantidad_de_resenias() <= pivote && elemento_izquierdo < elemento_derecho) {
                elemento_izquierdo++;
            }
            while (entrada[elemento_derecho].getCantidad_de_resenias() >= pivote && elemento_izquierdo < elemento_derecho) {
                elemento_derecho--;
            }
            IntercambiarNodos2(entrada, elemento_izquierdo, elemento_derecho);

        }
        IntercambiarNodos2(entrada, elemento_izquierdo, indiceAlto);

        QuicksortSegundo(entrada, indiceBajo, elemento_izquierdo - 1);
        QuicksortSegundo(entrada, elemento_izquierdo + 1, indiceAlto);

        return resultado;
    }

    public static void IntercambiarNodos2(nodoCatadores[] entradas, int posicion1, int posicion2) {
        nodoCatadores dato = entradas[posicion1];
        entradas[posicion1] = entradas[posicion2];
        entradas[posicion2] = dato;

    }


    //TERCER CONSULTA
    public int tercerConsulta(Date fecha_inicio, Date fecha_final) {
        int cantidad_reviews = 0;
        Object[] vectorLlaves = tablaReviews.getVector_de_Keys(); //Long[] vectorLlaves = (Long[]) tablaReviews.getVector_de_Keys();

        for (int i = 0; i < tablaReviews.size(); i++) {
            if (tablaReviews.get((Long) vectorLlaves[i]) != null) {
                Date fecha_analizar = tablaReviews.get((Long) vectorLlaves[i]).getDate();
                //long resultado = fecha_analizar.getTime();
                if (fecha_inicio.before(fecha_analizar) && fecha_final.after(fecha_analizar)) {
                    cantidad_reviews++;
                }

            } else {
                break;
            }
        }
        return cantidad_reviews;
    }


    public nodoStyleBeer[] cuartaConsulta() {


        return new nodoStyleBeer[0];
    }

    public nodoBeerMostReview[] quinataConsulta() {


        return new nodoBeerMostReview[0];
    }


    //AGREGAR O NO UN USUARIO AL LEER UNA LINEA

    public void addUser(String username, long ReviewId, Date reviewTime,
                        double reviewOverall, double review_aroma, double review_appearance,
                        double review_palate, double review_taste) {

        Review resenia_Agregar = new Review(ReviewId, reviewTime, reviewOverall, review_aroma, review_appearance, review_palate, review_taste);
        User dato = new User(username);

        if (tablaUsers.get(username) == null) {
            dato.getReviews().put(ReviewId, resenia_Agregar);
            tablaUsers.put(username, dato);

        } else if (tablaUsers.get(username) != null) {

            tablaUsers.get(username).getReviews().put(ReviewId, resenia_Agregar);


        }

    }

    //AGREGAR O NO UN ESTILO AL LEER UNA LINEA
    public void addEstilo(String estiloCerveza) {
        if (NoExisteEstiloCerveza(estiloCerveza)) {
            Style estilo = new Style(estiloCerveza);
            tablaEstilos.put(estiloCerveza, estilo);
        }
    }

    public boolean NoExisteEstiloCerveza(String estiloCerveza) {
        boolean noExiste = false;

        if (tablaEstilos.get(estiloCerveza) == null) {
            noExiste = true;
        }
        return noExiste;
    }

    //AGREGAR O NO UN REVIEWS AL LEER UNA LINEA
    public void addReview(Long review_id, Date review_time, Double review_overall, Double review_aroma, Double review_appearance, Double review_palate, Double review_taste) {
        if (NoExisteReview(review_id)) {
            Review reviews = new Review(review_id, review_time, review_overall, review_aroma, review_appearance, review_palate, review_taste);
            tablaReviews.put(review_id, reviews);


        }
    }

    public boolean NoExisteReview(Long review_id) {
        boolean noExiste = false;

        if (tablaReviews.get(review_id) == null) {
            noExiste = true;
        }
        return noExiste;
    }


    //AGREGAR O NO UNA CERVEZA AL LEER UNA LINEA
    public void addCerveza(Long id_cerveza, String name, Double abv) {
        if (NoExisteCerveza(id_cerveza)) {
            Beer cerveza = new Beer(id_cerveza, name, abv);
            tablaCervezas.put(id_cerveza, cerveza);
        }
    }

    public boolean NoExisteCerveza(Long id_cerveza) {
        boolean noExiste = false;

        if (tablaCervezas.get(id_cerveza) == null) {
            noExiste = true;

        }
        return noExiste;
    }

    //AGREGAR O NO UNA CERVECERIA AL LEER UNA LINEA

    public void addCerveceria(Long id_cerveceria, String name) {
        if (NoExisteCerveceria(id_cerveceria)) {
            Brewery cerveceria = new Brewery(id_cerveceria, name);
            tablaCervecerias.put(id_cerveceria, cerveceria);
        }
    }

    public boolean NoExisteCerveceria(Long id_cerveceria) {
        boolean noExiste = false;

        if (tablaCervecerias.get(id_cerveceria) == null) {
            noExiste = true;

        }
        return noExiste;
    }

    public MyHashTableIMPL<String, User> getTablaUsers() {
        return tablaUsers;
    }


}

