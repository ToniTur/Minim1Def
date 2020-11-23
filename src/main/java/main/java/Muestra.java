package main.java;
public class Muestra {

    int idMuestra;
    int idClinico;
    int idUsuario;
    String fecha;
    int idLab;

    public Muestra(int idMuestra, int idClinico, int idPersona, String fecha, int idLab) {
        this.idMuestra = idMuestra;
        this.idClinico = idClinico;
        this.idUsuario = idPersona;
        this.fecha = fecha;
        this.idLab = idLab;
    }

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
    }

    public int getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(int idClinico) {
        this.idClinico = idClinico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    @Override
    public String toString() {
        return "Muestra{" +
                "idMuestra=" + idMuestra +
                ", idClinico=" + idClinico +
                ", idUsuario=" + idUsuario +
                ", fecha='" + fecha + '\'' +
                ", idLab=" + idLab +
                '}';
    }
}

