package Model;

/**
 * Created by Matias on 04/04/2018.
 */
public class Carta {
    private int numero;
    private String palo;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Carta(){}

    public int getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }

    public String printCarta(){
        return " "+getNumero()+ " de "+getPalo();
    }
}
