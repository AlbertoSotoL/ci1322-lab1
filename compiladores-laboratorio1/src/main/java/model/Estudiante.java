package model;

public class Estudiante {

String nombre;
String apellido;
String carne;

public Estudiante(){

    nombre = "";
    apellido = "";
    carne = "";
}
    public void setDatos(String a, String b, String c){

        nombre = a;
        apellido = b;
        carne = c;
    }

    public String getNombre(){

        return  nombre;
    }

    public String getApellido(){

        return  apellido;
    }

    public String getCarne(){

        return  carne;
    }
}



