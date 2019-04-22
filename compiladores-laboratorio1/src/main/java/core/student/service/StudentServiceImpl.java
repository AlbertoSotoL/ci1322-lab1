package core.student.service;

import core.student.dao.JdbcStudentService;
import core.student.dao.StudentDao;
import model.Estudiante;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {

    StudentDao nuevoEstudiante;

    public StudentServiceImpl() throws SQLException {

        nuevoEstudiante = new JdbcStudentService();
    }

    public Estudiante findById(String id) {

        return nuevoEstudiante.findById("");
    };

    public String create(Estudiante e) throws SQLException {

        System.out.print("llego al create de student");
        System.out.print("\n");

        nuevoEstudiante.create(e);
        return "";
    };

    public void update(Estudiante e){

    };

    public void remove(Estudiante e){

    };


}
