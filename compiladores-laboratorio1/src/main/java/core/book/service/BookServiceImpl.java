package core.book.service;

import core.book.dao.BookDao;
import core.book.dao.JdbcBookService;
import model.Libro;

import java.sql.SQLException;

public class BookServiceImpl implements BookService {

    BookDao nuevoLibro;

    public BookServiceImpl() throws SQLException {

        nuevoLibro = new JdbcBookService();
    }

    public Libro findById(String id) throws SQLException {

        return nuevoLibro.findById(id);
    };

    public String create(Libro l) throws SQLException {

        System.out.print("llego al create");
        System.out.print("\n");

        nuevoLibro.create(l);

        return "";
    };

    public void update(Libro l){

    };

    public void remove(Libro l){

    };


}
