package core.student.dao;

import model.Estudiante;

import java.sql.SQLException;

public interface StudentDao {


    public Estudiante findById(String id);

    public String create(Estudiante e) throws SQLException;

    public void update(Estudiante e);

    public void remove(Estudiante e);



}
