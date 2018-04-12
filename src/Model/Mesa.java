package Model;

import java.util.*;

/**
 * Created by Matias on 04/04/2018.
 */
public class Mesa extends Observable {
    private Jugador j1;
    private Jugador j2;
    private Jugador j3;
    private Jugador j4;

    private Stack<Carta> Mazo;
    private String nombre;
    private boolean available;
    private boolean gameover;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public Mesa() {
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Stack<Carta> getMazo() {
        return Mazo;
    }

    public void nuevoMazo(){
        this.Mazo= new Stack<>();
        crearPalo(12,"oro");
        crearPalo(12,"espada");
        crearPalo(12,"basto");
        crearPalo(12,"copa");
    }

    private void crearPalo(int cartas, String palo){
        int i;
        for(i=0;i<cartas;i++){
            Carta nueva = new Carta(i+1,palo);
            this.Mazo.push(nueva);
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    public synchronized void  sacarCarta(String nombre){

            while (!isAvailable()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setAvailable(false);
            if(!getMazo().empty() && !isGameover()){
                Carta carta = getMazo().pop();
                darCarta(carta,nombre);
                setChanged();
                notifyObservers(nombre + carta.printCarta());
                setAvailable(true);
                notifyAll();
            }
            else{
                this.setGameover(true);
                avisarResultado();
            }


    }

    public synchronized void darCarta(Carta carta, String nombre){
        if(j1.getNombre().equals(nombre)){
            j1.getMazo().add(carta);
            j1.setPuntaje(carta.getNumero());
        }
        if(j2.getNombre().equals(nombre)){
            j2.getMazo().add(carta);
            j2.setPuntaje(carta.getNumero());
        }
        if(j3.getNombre().equals(nombre)){
            j3.getMazo().add(carta);
            j3.setPuntaje(carta.getNumero());
        }
        if(j4.getNombre().equals(nombre)){
            j4.getMazo().add(carta);
            j4.setPuntaje(carta.getNumero());
        }
    }

    public void setJugadores(Jugador j1, Jugador j2, Jugador j3, Jugador j4) {
        this.j1=j1;
        this.j2=j2;
        this.j3=j3;
        this.j4=j4;
    }

    public void avisarResultado(){
            int pj1= j1.getPuntaje();
            int pj2= j2.getPuntaje();
            int pj3= j3.getPuntaje();
            int pj4= j4.getPuntaje();
            if(pj1>pj2 && pj1>pj3&& pj1>pj4){
                setChanged();
                notifyObservers(j1);
            }
            if(pj2>pj1 && pj2>pj3 && pj2>pj4){
                setChanged();
                notifyObservers(j2);
            }
            if(pj3>pj1 && pj3>pj2 && pj3>pj4){
                setChanged();
                notifyObservers(j3);
            }
            if(pj4>pj1 && pj4>pj2 && pj4>pj3){
                setChanged();
                notifyObservers(j4);
            }
            if(pj1==pj2 && pj1==pj3 && pj1==pj4){
                setChanged();
                notifyObservers(false);
            }
    }


}
