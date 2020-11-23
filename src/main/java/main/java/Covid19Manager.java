package main.java;

public interface Covid19Manager {

    public void addUsuario(Usuario nueva);
    public void enviarMuestra(Muestra muestra);
    public String procesarMuestra(int idLab);
    public void addLaboratorio(Laboratorio lab);
    public void clear();
    public int sizeLabs();
    public int sizeUsuarios();
    public int sizeMuestras();
    public static final int maxLabs = 6;
}
