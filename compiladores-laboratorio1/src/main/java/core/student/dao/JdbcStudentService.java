package core.student.dao;

import model.Estudiante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcStudentService implements StudentDao {

    Connection conn;
    public JdbcStudentService() throws SQLException {

        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root","70seconds");
    }


    @Override
    public Estudiante findById(String id) {
        return null;
    }

    @Override
    public String create(Estudiante e) throws SQLException {

        java.sql.Statement stmt = conn.createStatement();

        stmt.executeUpdate("INSERT INTO Estudiante " + "VALUES ('"+e.getNombre() +"', '"+ e.getApellido()+"', '"+ e.getCarne() +"')");

        System.out.print("Se inserto en la base");

        return null;
    }

    @Override
    public void update(Estudiante e) {

    }

    @Override
    public void remove(Estudiante e) {

    }
}
