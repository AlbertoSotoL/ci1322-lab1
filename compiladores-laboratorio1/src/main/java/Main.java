import build.DataLoader;
import core.book.service.BookService;
import core.book.service.BookServiceImpl;
import model.Libro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

       /* DataLoader dl = new DataLoader();//Instancia de data loader para cargar las paginas
        dl.LoadSheet();*/ //Llamada al metodo para procesar el .xls e insertar las tuplas.


        //De aqui en adelante se encuentra el codigo para leer un id de libro y buscarlo en la base

        BookService h = new BookServiceImpl();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el titulo del libro que desea buscar ");
        String s = br.readLine();

        Libro temporal = h.findById(s);

        System.out.println("Resultado: ");

        if (temporal != null) {
            System.out.println("Titulo: " + temporal.getTitulo() + "\nTipo: " + temporal.getTipo() + "\nGenero: " + temporal.getGenero());
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }


}
