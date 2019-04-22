package model;

public class Libro {

    String titulo;
    String tipo;
    String genero;

    public Libro(){

        titulo = "";
        tipo = "";
        genero = "";
    }

    public void setDatos(String a, String b, String c){
        titulo = a;
        tipo = b;
        genero = c;
    }

    public String getTitulo(){

        return  titulo;
    }

    public String getTipo(){

        return  tipo;
    }

    public String getGenero(){

        return  genero;
    }
}
