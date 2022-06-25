import EntidadesAuxiliares.nodoCatadores;
import Entities.SistemaCentral;
import TADs.MyLinkedListImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        SistemaCentral Manager = new SistemaCentral();
        Manager.leerCSV("src/archivos/beer_dataset_.csv");

        //MyHashTableIMPL<String, User> tablaUsuarioPrincipal = Manager.getTablaUsers();

        boolean sistemaEncendido = true;
        while (sistemaEncendido) {
            System.out.println("Ingrese la consulta que desea: ");
            Scanner ingreso = new Scanner(System.in);
            String entradaConsulta = ingreso.nextLine();
            int consulta = 0;
            try {
                consulta = Integer.parseInt(entradaConsulta);
            } catch (Exception e) {
                System.out.println("Error, Ingrese de nuevo");
            }


            if (consulta == 1) {
                //Primer Consulta
            /*Listar las 10 casas de cerveza (breweries) con más reseñas en un año (este año va
            a ser ingresado como parámetro por consola). Este listado deberá incluir el id de la
            casa, el nombre, y la cantidad de reseñas para cada uno, y debe estar ordenado por
            cantidad de reseñas en orden descendente. Se espera que esta operación sea de
            orden n en notación Big O*



             */

                System.out.println("Ingrese la fecha de comienzo del periodo en que desea las reviews en formato dd-MM-yyyy: ");
                Scanner lector = new Scanner(System.in);
                String fechaAnio = lector.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("DD-MM-YYYY");
                Date fechaAnioTest = null;
                String date1 = fechaAnio;
                try {
                    fechaAnioTest = df.parse(date1);
                    System.out.println("Ahora hemos creado un objeto date1 con la fecha indicada, " + fechaAnioTest);
                } catch (Exception e) {
                    System.out.println("Formato de fecha invalido");
                }
                if (!df.format(fechaAnioTest).equals(date1)) {
                    System.out.println("Fecha Invalida");
                } else {
                    System.out.println("Fecha Valida");
                }


            }


            if (consulta == 2) {


                //Segunda Consulta
                /*Top 15 catadores con más reseñas. Este listado deberá incluir el nombre de usuario,
                y la cantidad de reseñas de cada uno, ordenado por cantidad de reseñas en orden
                descendente. Se espera que esta operación sea de orden n en notación Big O*/
                MyLinkedListImpl<nodoCatadores> resultado_final = Manager.SegundaConsulta();

                for (int i = 0; i < resultado_final.size(); i++) {
                    System.out.println("El usuario " + resultado_final.get(i).getUsername() + " tiene " + resultado_final.get(i).getCantidad_de_resenias());
                }
            }


            if (consulta == 3) {
                // Tercer Consulta
            /*Cantidad de reviews en un rango dado. Esta cantidad tomará como entrada la fecha
            de inicio y la fecha de finalización. Se deben incluir ambas fechas para la cantidad a
            retornar.*/


                //FECHA DE INICIO DEL PERIODO EN EL QUE DESEA LAS REVIEWS
                System.out.println("Ingrese la fecha de comienzo del periodo en que desea las reviews en formato dd-MM-yyyy: ");
                Scanner lector = new Scanner(System.in);
                String fechaInicioReviewsUsuario = lector.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("DD-MM-YYYY");
                Date fechaInicioReviewsTest = null;
                String date1 = fechaInicioReviewsUsuario;
                try {
                    fechaInicioReviewsTest = df.parse(date1);
                    System.out.println("Ahora hemos creado un objeto date1 con la fecha indicada, " + fechaInicioReviewsTest);
                } catch (Exception e) {
                    System.out.println("Formato de fecha invalido");
                }
                if (!df.format(fechaInicioReviewsTest).equals(date1)) {
                    System.out.println("Fecha Invalida");
                } else {
                    System.out.println("Fecha Valida");
                }

                //FECHA DE FINALIZACION DEL PERIODO EN EL QUE DESEA LAS REVIEWS
                System.out.println("Ingrese la fecha de finalizacion del periodo en que desea las reviews en formato DD-MM-YYYY: ");
                Scanner lector1 = new Scanner(System.in);
                String fechaFinalizacionReviewsUsuario = lector1.nextLine();
                SimpleDateFormat df1 = new SimpleDateFormat("DD-MM-YYYY");
                Date fechaFinalizacionReviewsTest = null;
                String date11 = fechaFinalizacionReviewsUsuario;
                try {
                    fechaFinalizacionReviewsTest = df.parse(date11);
                    System.out.println("Ahora hemos creado un objeto date1 con la fecha indicada, " + fechaFinalizacionReviewsTest);
                } catch (Exception e) {
                    System.out.println("Formato de fecha invalido");
                }
                if (!df.format(fechaFinalizacionReviewsTest).equals(date11)) {
                    System.out.println("Fecha Invalida");
                } else {
                    System.out.println("Fecha Valida");
                }

                //Long resultado_inicio = fechaInicioReviewsTest.getTime();
                // Long resultado_final = fechaFinalizacionReviewsTest.getTime();

                long cantidad_reviews = Manager.tercerConsulta(fechaInicioReviewsTest, fechaFinalizacionReviewsTest);
                System.out.println("---> La cantidad de Reviews entre las fechas seleccionadas es de: " + cantidad_reviews);



            /*Long contadorfechas=0l;
            for (int i = 0; i < Manager.tablaReviews.size(); i++) {
                if (Manager.tablaReviews.existInAsArray(i)){
                    Long time_review =Manager.tablaReviews.getAsArray(i).getDate().getTime();
                    if (resultado_incio <= time_review  && time_review <=resultado_final){
                        contadorfechas = contadorfechas + 1 ;
                    }
                }
            }
            System.out.println("Cantidad de reviews:"+contadorfechas);









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
            if (consulta == 6) {
                sistemaEncendido = false;
            }
        }
        System.out.println("Termino el programa");



    }
}
