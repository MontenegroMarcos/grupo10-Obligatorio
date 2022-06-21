import Exceptions.ElementNotExistException;
import Exceptions.EmptyQueueException;
import TADs.MyBinarySearchTreeImpl;
import TADs.MyLinkedListImpl;
import TADs.MyQueueImpl;
import TADs.Stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

public class Principal {
    public static void main(String[] args) throws EmptyQueueException, ElementNotExistException {

        //Se hace la carga del sistema




        String linea;
        Long brewery_id;
        String brewery_name;


        try {
            BufferedReader lecter = new BufferedReader(new FileReader("src/archivos/beer_dataset_test.csv"));
            linea = lecter.readLine();

            while((linea = lecter.readLine() )!= null ){


                String[] entradas = linea.split(",");

                //if(i==150000) {
                //System.out.println(entradas);
                //}
                brewery_id =  Long.parseLong(entradas[0]);
                brewery_name = entradas[2];
                if(!brewery_name.startsWith("\"") /*&& !brewery_name.startsWith("\"")*/){

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Funciona?");


        //Consulta que se desea
        int consulta = 0;

        if (consulta == 1) {
            //Primer Consulta
            /*Listar las 10 casas de cerveza (breweries) con más reseñas en un año (este año va
            a ser ingresado como parámetro por consola). Este listado deberá incluir el id de la
            casa, el nombre, y la cantidad de reseñas para cada uno, y debe estar ordenado por
            cantidad de reseñas en orden descendente. Se espera que esta operación sea de
            orden n en notación Big O*/

        }

        if (consulta == 2) {
            //Segunda Consulta
            /*Top 15 catadores con más reseñas. Este listado deberá incluir el nombre de usuario,
            y la cantidad de reseñas de cada uno, ordenado por cantidad de reseñas en orden
            descendente. Se espera que esta operación sea de orden n en notación Big O*/

        }

        if (consulta == 3) {
            // Tercer Consulta
            /*Cantidad de reviews en un rango dado. Esta cantidad tomará como entrada la fecha
            de inicio y la fecha de finalización. Se deben incluir ambas fechas para la cantidad a
            retornar.*/


        }

        if (consulta == 4) {
            //Cuarta Consulta
            /*Top 7 estilos de cervezas con mejor aroma. Para esto se deberá tomar en cuenta el
            promedio de puntuación de aroma para cada estilo. Se deberá retornar el listado en
            orden descendente por puntuación.*/

        }

        if (consulta == 5) {
            //Quinta Consulta
            /*Top 5 cervezas con más reviews. Para este listado se deberá retornar el nombre de
            la cerveza, junto con la cantidad de reviews hechas a esta, y su puntaje general
            promedio. Se debe ordenar este listado por reviews en orden descendente*/


        }

    }
}
