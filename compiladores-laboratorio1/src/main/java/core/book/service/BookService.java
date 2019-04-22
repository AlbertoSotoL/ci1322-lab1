package core.book.service;

import model.Libro;

import java.sql.SQLException;

public interface BookService {


    public Libro findById(String id) throws SQLException;

    public String create(Libro l) throws SQLException;

    public void update(Libro l);

    public void remove(Libro l);
}
