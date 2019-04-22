package build;

import core.book.dao.JdbcBookService;
import core.book.service.BookService;
import core.book.service.BookServiceImpl;

import core.student.service.StudentService;
import core.student.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import model.Estudiante;
import model.Libro;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class DataLoader {

    BookService bs;
    StudentService ss;

    public DataLoader() throws SQLException {
        bs = new BookServiceImpl();
        ss = new StudentServiceImpl();
    }

    public void LoadSheet() throws IOException {

        FileInputStream fileIn = null;

        try {
            fileIn = new FileInputStream("C:\\Tools\\maven\\compiladores-laboratorio1\\src\\main\\resources\\spreadsheet lab1.xls");

            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFSheet sheet2 = wb.getSheetAt(1);

            cargarLibro(sheet);
            cargarEstudiantes(sheet2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (fileIn != null)
                fileIn.close();
        }
    }

    public void cargarLibro(HSSFSheet sheet) throws SQLException {

        String titulo = "";
        String tipo = "";
        String genero = "";

        Libro nuevoLibro = new Libro();

        for (int i = 1; i < 6; i++) {

            HSSFRow row = sheet.getRow(i);

            for (int e = 0; e < 3; e++) {

                HSSFCell cell = row.getCell(e);

                if (e == 0) {
                    titulo = cell.getStringCellValue();
                }

                if (e == 1) {
                    tipo = cell.getStringCellValue();
                }

                if (e == 2) {
                    genero = cell.getStringCellValue();
                }
            }

            nuevoLibro.setDatos(titulo, tipo, genero);
            bs.create(nuevoLibro);
        }
    }


    public void cargarEstudiantes(HSSFSheet sheet) throws SQLException {

        String nombre = "";
        String apellido = "";
        String carne = "";

        Estudiante nuevoEstudiante = new Estudiante();

        for (int i = 1; i < 6; i++) {

            HSSFRow row = sheet.getRow(i);

            for (int e = 0; e < 3; e++) {

                HSSFCell cell = row.getCell(e);

                if (e == 0) {
                    nombre = cell.getStringCellValue();
                }

                if (e == 1) {
                    apellido = cell.getStringCellValue();
                }

                if (e == 2) {
                    carne = cell.getStringCellValue();
                }
            }

            System.out.print(nombre + " " + apellido + " " + carne);
            System.out.print("\n");

            nuevoEstudiante.setDatos(nombre, apellido, carne);
            ss.create(nuevoEstudiante);
        }
    }
}