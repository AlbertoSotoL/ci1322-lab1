package core.book.dao;

import model.Libro;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcBookService implements BookDao {

    Connection conn;

    public JdbcBookService() throws SQLException {

        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "70seconds");
    }

    @Override
    public Libro findById(String id) throws SQLException {


        Libro temp = new Libro();

        String nombre = "";
        String apellido = "";
        String carne = "";

        java.sql.Statement stmt = conn.createStatement();


        ResultSet rs = stmt.executeQuery("Select * from Libro Where Titulo = '" + id + "'");

        if (rs.next()) {

            nombre = rs.getString("Titulo");
            apellido = rs.getString("Tipo");
            carne = rs.getString("Genero");

          //  System.out.println(nombre + " " + apellido + " " + carne);
        }

        temp.setDatos(nombre, apellido, carne);

        if(temp.getTitulo() != "") {
            return temp;
        }

        return null;
    }

    @Override
    public String create(Libro l) throws SQLException {

        java.sql.Statement stmt = conn.createStatement();

        stmt.executeUpdate("INSERT INTO Libro " + "VALUES ('" + l.getTitulo() + "', '" + l.getTipo() + "', '" + l.getGenero() + "')");

        return null;
    }

    @Override
    public void update(Libro l) {

    }

    @Override
    public void remove(Libro l) {

    }
}
