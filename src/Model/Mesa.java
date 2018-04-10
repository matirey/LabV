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
            if(!getMazo().empty()){
                Carta carta = getMazo().pop();
                darCarta(carta,nombre);
                setChanged();
                notifyObservers(nombre + carta.printCarta());
            }
            else{
                this.setGameover(true);
            }
            if(isGameover()){
                avisarGanador();
            }

        setAvailable(true);
        notifyAll();
    }

    public void darCarta(Carta carta, String nombre){
        if(j1.getNombre().equals(nombre)){
            j1.getMazo().add(carta);
        }
        if(j2.getNombre().equals(nombre)){
            j2.getMazo().add(carta);
        }
        if(j3.getNombre().equals(nombre)){
            j3.getMazo().add(carta);
        }
        if(j4.getNombre().equals(nombre)){
            j4.getMazo().add(carta);
        }
    }

    public void setJugadores(Jugador j1, Jugador j2, Jugador j3, Jugador j4) {
        this.j1=j1;
        this.j2=j2;
        this.j3=j3;
        this.j4=j4;
    }

    public void avisarGanador(){
            if(j1.cantCartas()>j2.cantCartas() && j1.cantCartas()>j3.cantCartas() && j1.cantCartas()>j4.cantCartas()){
                setChanged();
                notifyObservers(j1);
            }
            if(j2.cantCartas()>j1.cantCartas() && j2.cantCartas()>j3.cantCartas() && j2.cantCartas()>j4.cantCartas()){
                setChanged();
                notifyObservers(j2);
            }
            if(j3.cantCartas()>j1.cantCartas() && j3.cantCartas()>j2.cantCartas() && j3.cantCartas()>j4.cantCartas()){
                setChanged();
                notifyObservers(j3);
            }
            if(j4.cantCartas()>j1.cantCartas() && j4.cantCartas()>j2.cantCartas() && j4.cantCartas()>j3.cantCartas()){
                setChanged();
                notifyObservers(j4);
            }
    }


}
