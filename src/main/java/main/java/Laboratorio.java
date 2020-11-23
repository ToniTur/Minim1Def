package main.java;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Laboratorio {

    int idLab;
    String nombreLab;
    Queue<main.java.Muestra> colaMuestras;

    public Laboratorio(String nombreLab) {
        this.nombreLab = nombreLab;
        this.colaMuestras = new LinkedList<main.java.Muestra>();
    }

    public void addMuestra(main.java.Muestra nueva){
        this.colaMuestras.add(nueva);
    }

    public main.java.Muestra procesadoMuestras(){
        return this.colaMuestras.poll();
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }

    public Queue<main.java.Muestra> getColaMuestras() {
        return colaMuestras;
    }

    public void setColaMuestras(Queue<main.java.Muestra> colaMuestras) {
        this.colaMuestras = colaMuestras;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "idLab=" + idLab +
                ", nombreLab='" + nombreLab + '\'' +
                ", colaMuestras=" + colaMuestras +
                '}';
    }
}

