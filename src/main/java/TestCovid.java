import main.java.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCovid {

    private Covid19Manager covidManager;

    @Before
    public void setUp() throws Exception
    {
        this.covidManager = main.java.Covid19ManagerImpl.getInstance();
        main.java.Usuario primero = new main.java.Usuario(0, "Toni","Tur Garcia",21,"A");
        main.java.Usuario segundo = new main.java.Usuario(1, "Pedro","Torres",65,"C");
        main.java.Usuario tercero = new main.java.Usuario(2, "Alba","Lopez",33,"D");

        covidManager.addUsuario(primero);
        covidManager.addUsuario(segundo);
        covidManager.addUsuario(tercero);

        main.java.Laboratorio uno = new main.java.Laboratorio("Laboratorio 1");
        main.java.Laboratorio dos = new main.java.Laboratorio("Laboratorio 2");
        main.java.Laboratorio tres = new main.java.Laboratorio("Laboratorio 3");
        main.java.Laboratorio cuatro = new main.java.Laboratorio("Laboratorio 4");

        covidManager.addLaboratorio(uno);
        covidManager.addLaboratorio(dos);
        covidManager.addLaboratorio(tres);
        covidManager.addLaboratorio(cuatro);
    }
    @After
    public void tearDown()
    {
        this.covidManager.clear();
    }

    @Test
    public void crearNuevaPersona() throws Exception{
        main.java.Usuario cuarto = new main.java.Usuario(3, "Manel","Perez",44,"B");
        covidManager.addUsuario(cuarto);
        Assert.assertEquals(4,this.covidManager.sizeUsuarios());
    }

    @Test
    public void procesarMuestra() throws Exception{
        main.java.Muestra nueva1 = new main.java.Muestra(0, 21, 0, "2020/10/09",0);
        main.java.Muestra nueva2 = new main.java.Muestra(1, 32, 1, "2020/11/10",2);

        this.covidManager.enviarMuestra(nueva1);
        this.covidManager.enviarMuestra(nueva2);

        this.covidManager.procesarMuestra(0);
        this.covidManager.procesarMuestra(2);

        Assert.assertEquals(2, this.covidManager.sizeMuestras());
    }
}
