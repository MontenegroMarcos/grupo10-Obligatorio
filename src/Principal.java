import Entities.Todo;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        Todo todo = new Todo();
        todo.leerCSV("beer_dataset_test.csv");

    }
}
