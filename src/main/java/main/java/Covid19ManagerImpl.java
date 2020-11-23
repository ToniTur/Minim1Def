package main.java;

import java.util.HashMap;
import java.util.logging.Logger;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;
    protected HashMap<Integer, Usuario> listaUsuarios;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());
    private int numLabs;
    private int numMuestras;
    private Laboratorio laboratorios[];

    private Covid19ManagerImpl() {
        this.listaUsuarios = new HashMap<Integer, Usuario>();
        numLabs = 0;
        this.laboratorios = new Laboratorio[maxLabs];
    }

    public static Covid19Manager getInstance()
    {
        if(instance==null)
        {
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }

    public Laboratorio dameLab(int idLab){
        logger.info("Entramos en conocer lab a partir de un id de laboratorio");
        Laboratorio lab = null;
        for(int i = 0; i < laboratorios.length; i++)
        {
            if(laboratorios[i].getIdLab()==idLab){
                lab = laboratorios[i];
                break;
            }
        }
        logger.info("Ya sabemos cual es el lab con id: "+ idLab);
        return lab;
    }

    @Override
    public void addLaboratorio(Laboratorio lab){
        logger.info("Entramos en añadir un laboratorio");
        if(numLabs<maxLabs){
            lab.setIdLab(numLabs);
            laboratorios[numLabs] = lab;
            numLabs++;
        }
        logger.info("Hemos añadido el lab: " + lab);
    }

    @Override
    public void addUsuario(Usuario nueva) {
        logger.info("Entramos en la funcion de añadir usuario");
        this.listaUsuarios.put(nueva.getIdUsuario(),nueva);
        logger.info("Añadido el usuario: " + nueva);
    }

    @Override
    public void enviarMuestra(Muestra nueva) {
        logger.info("Entramos en enviar muestra a un lab");
        Laboratorio labQueProcesa = dameLab(nueva.idLab);
        labQueProcesa.addMuestra(nueva);
        numMuestras++;
        logger.info("Hemos enviado la muestra al lab con id: " + nueva.idLab + " para que procese la muestra");
    }

    @Override
    public String procesarMuestra(int idLab) {
        logger.info("Entramos a procesar muestra en el lab con id: "+ idLab);
        Laboratorio labQueProcesa = dameLab(idLab);
        Muestra muestraProcesar = labQueProcesa.procesadoMuestras();
        int idPers = muestraProcesar.getIdUsuario();
        Usuario pers = listaUsuarios.get(idPers);
        pers.addMuestra(muestraProcesar);
        if(pers.getSalud().equals("A")){
            logger.info("Hemos procesado la muestra");
            return("Resultado: Poco avanzado \n Comentario: Debe procurar no salir de casa y cuidarse");
        }
        else if(pers.getSalud().equals("B"))
        {
            logger.info("Hemos procesado la muestra");
            return("Resultado: Avanzado Comentario: Debe tener cuidado de que no vaya a mas y quedarse en casa ");
        }
        else if(pers.getSalud().equals("C"))
        {
            logger.info("Hemos procesado la muestra");
            return("Resultado: Bastante avanzado Comentario: Aislamiento dentro de un hospital en planta y cuidados intensivos sin visitas");
        }
        else{
            logger.info("Hemos procesado la muestra");
            return("Resultado: Extremadamente avanzado Comentario: Entrada en UCI y aislamiento total");
        }
    }

    @Override
    public void clear() {
        logger.info("Entramos en el clear");
        listaUsuarios.clear();
        this.laboratorios = new Laboratorio[maxLabs];
        this.numMuestras = 0;
        this.numLabs = 0;
        instance = null;
        logger.info("Salimos del clear");
    }

    @Override
    public int sizeLabs() {
        logger.info("Entramos en saber cuantos laboratorios hay");
        logger.info("Sabemos que hay " + numLabs + " laboratorios");
        return this.numLabs;
    }

    @Override
    public int sizeUsuarios() {
        logger.info("Entramos en saber cuantos usuarios hay");
        logger.info("Sabemos que hay " + listaUsuarios.size() + " usuarios");
        return listaUsuarios.size();
    }

    @Override
    public int sizeMuestras() {
        logger.info("Entramos en saber cuantas muestras hay");
        logger.info("Sabemos que hay " + numLabs + " mustras");
        return numMuestras;
    }
}
