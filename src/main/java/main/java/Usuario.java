package main.java;

import java.util.LinkedList;
import java.util.List;

public class Usuario {

    int idUsuario;
    String nombre;
    String apellidos;
    int edad;
    String salud;
    List<Muestra> listadoMuestras;

    public Usuario(int id, String nombre, String apellidos, int edad, String salud) {
        this.idUsuario = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salud = salud;
        this.listadoMuestras = new LinkedList<Muestra>();
    }

    public void addMuestra(Muestra nueva){
        this.listadoMuestras.add(nueva);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", salud='" + salud + '\'' +
                '}';
    }
}
