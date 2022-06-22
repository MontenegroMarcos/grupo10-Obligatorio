import ClasesAuxiliares.NodoBrewery;
import Entities.SistemaCentral;
import Exceptions.ElementNotExistException;
import Exceptions.EmptyQueueException;
import TADs.MyBinarySearchTreeImpl;
import TADs.MyLinkedListImpl;
import TADs.MyQueueImpl;
import TADs.Stack;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Queue;

public class Principal {
    public static void main(String[] args) throws EmptyQueueException, ElementNotExistException, ParseException {

        //Se hace la carga del sistema






        //Consulta que se desea
        SistemaCentral instancia = new SistemaCentral();
        int consulta = 1;
        if (consulta == 1) {

            //Primer Consulta
            /*Listar las 10 casas de cerveza (breweries) con más reseñas en un año (este año va
            a ser ingresado como parámetro por consola). Este listado deberá incluir el id de la
            casa, el nombre, y la cantidad de reseñas para cada uno, y debe estar ordenado por
            cantidad de reseñas en orden descendente. Se espera que esta operación sea de
            orden n en notación Big O*/


            NodoBrewery dato1 = new NodoBrewery(210L,"Cervezeria Hostal", 24);
            NodoBrewery dato2 = new NodoBrewery(212L,"Cerveceria Italia", 30);
            NodoBrewery dato3 = new NodoBrewery(213L,"Cerveceria 8 de Octubre", 20);
            NodoBrewery dato4 = new NodoBrewery(282L,"Cerveceria Yosef", 3);
            NodoBrewery dato5 = new NodoBrewery(272L,"Cerveceria Brezhnex", 40);
            NodoBrewery dato6 = new NodoBrewery(122L,"Cerveceria Le feu", 27);
            NodoBrewery dato7 = new NodoBrewery(332L,"Cerveceria Quinta", 16);
            NodoBrewery dato8 = new NodoBrewery(2312L,"Cerveceria LEbere", 18);
            NodoBrewery dato9 = new NodoBrewery(2321L,"Cerveceria Nova", 34);
            NodoBrewery dato10 = new NodoBrewery(24334L,"Cerveceria Popular", 77);
            NodoBrewery dato11 = new NodoBrewery(24334L,"Cerveceria Dios Funciona", 144);

            NodoBrewery[] carga_de_datos = {dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8,dato9,dato10,dato11};




            String anio = null;
            NodoBrewery[] top10Casas;
            top10Casas = instancia.PrimerConsulta( carga_de_datos , anio);

            for (int i = 0; i < top10Casas.length; i++) {
                System.out.println( top10Casas[i].getId() +  " " + top10Casas[i].getName() + "  " + top10Casas[i].getCantidad_de_resenias());
            }


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
