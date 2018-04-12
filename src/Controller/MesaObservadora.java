package Controller;

import Dao.Dao;
import Model.Jugador;
import Model.Mesa;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Matias on 04/04/2018.
 */
public class MesaObservadora implements Observer {

    private Mesa m1;
    private Jugador jug1;
    private Jugador jug2;
    private Jugador jug3;
    private Jugador jug4;
    Dao persist = new Dao();

    public void configInicial(String mesa, Jugador j1, Jugador j2, Jugador j3, Jugador j4) {
        this.jug1=j1;
        this.jug2=j2;
        this.jug3=j3;
        this.jug4=j4;
        this.inicMesa(mesa);
        this.setearMesaJugadores();
        m1.setJugadores(jug1,jug2,jug3,jug4);
        m1.setGameover(false);
        m1.setAvailable(true);
        this.empezar();
    }

    public void inicMesa(String mesa){
        m1 = new Mesa();
        m1.setNombre(mesa);
        m1.nuevoMazo();
        m1.addObserver(this);
        generarJuego(m1.getNombre());
    }

    public void setearMesaJugadores(){
        jug1.setMesa(m1);
        jug2.setMesa(m1);
        jug3.setMesa(m1);
        jug4.setMesa(m1);
    }

    public void generarJuego(String mesa){
        persist.generarJuego(mesa);
    }

    public void empezar (){
        jug1.start();
        jug2.start();
        jug3.start();
        jug4.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            System.out.println("--" + arg);
        }
        if (arg instanceof Jugador) {
            System.out.println("EL JUEGO HA FINALIZADO");
            System.out.println("EL GANADOR ES "+((Jugador) arg).getNombre().toUpperCase()+ " CON "
                    +((Jugador) arg).getPuntaje()+" PUNTOS");
            this.persist.guardarResultado(arg);
        }
        if(arg.equals(false)){
            System.out.println("-- EMPATE (TODOS TIENEN LOS MISMOS PUNTOS)");
            this.persist.guardarResultado(false);
        }
    }
}
