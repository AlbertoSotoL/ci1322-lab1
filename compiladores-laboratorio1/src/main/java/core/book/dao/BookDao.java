package core.book.dao;
import model.Libro;

import java.sql.SQLException;

public interface BookDao {

    public Libro findById(String id) throws SQLException;

    public String create(Libro l) throws SQLException;

    public void update(Libro l);

    public void remove(Libro l);
}
