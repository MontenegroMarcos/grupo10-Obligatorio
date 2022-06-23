package Entities;

import TADs.MyHashTableIMPL;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Todo {
    private MyHashTableIMPL<Long, Brewery> tablaCervecerias = new MyHashTableIMPL<>();
    private MyHashTableIMPL<Long, Beer> tablaCervezas = new MyHashTableIMPL<>();
    private MyHashTableIMPL<Long, Review> tablaReviews = new MyHashTableIMPL<>();
    private MyHashTableIMPL<String, Style> tablaEstilos = new MyHashTableIMPL<>();
    private MyHashTableIMPL<String, User> tablaUsers = new MyHashTableIMPL<>();

    public void leerCSV(String path) throws IOException, OutOfMemoryError, IOException {
        int x = 0;
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        while((line = csvReader.readNext()) != null){
            //agregarDatos(line);
            x = agregarDatos(line, x);
            System.out.println(x);
        }
    }

    public int agregarDatos(String[] line, int x){
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
            //addUser
            x++;
            return x;
        }catch (Exception e){
            return x;
            //no agregar nada
        }
    }

    //AGREGAR O NO UN USUARIO AL LEER UNA LINEA
    public void addUser(String nombreUsuario){
        //existe?
        if (tablaUsers == null || NoExisteUsuario(nombreUsuario)) {
            User dato = new User(nombreUsuario);
            tablaUsers.put(nombreUsuario, dato);
        }
        //si --> nada
        //no --> agregas al hash/lista
    }

    public boolean NoExisteUsuario (String nombreUsario) {
        boolean noExiste = false;


        for (int i = 0; i < tablaUsers.size() ; i++) {
            if (tablaUsers.get(nombreUsario) == null){
                noExiste = true;
            }
        }
        return noExiste;
    }


    //AGREGAR O NO UN ESTILO AL LEER UNA LINEA
    public void addEstilo(){

    }





    //AGREGAR O NO UN REVIEWS AL LEER UNA LINEA
    public void addReview() {

    }




    //AGREGAR O NO UNA CERVEZA AL LEER UNA LINEA
    public void addCerveza() {

    }




}
