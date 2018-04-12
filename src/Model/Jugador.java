package Model;

import java.util.Stack;

/**
 * Created by Matias on 04/04/2018.
 */
public class Jugador extends Thread{
    private String nombre;
    private Stack<Carta> Mazo;
    private Mesa mesa;
    private int puntaje=0;

    public String getNombre() {
        return nombre;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.Mazo = new Stack<>();
    }

    public int cantCartas(){
        return getMazo().size();
    }

    public Stack<Carta> getMazo() {
        return Mazo;
    }

    public void setPuntaje(int p){
        this.puntaje+=p;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setMazo(Stack<Carta> mazo) {
        Mazo = mazo;
    }

    public void run(){
        while (!this.mesa.isGameover()){
                this.mesa.sacarCarta(getNombre());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
