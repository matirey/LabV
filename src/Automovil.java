import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Matias on 26/03/2018.
 */
public class Automovil extends Observable{

    private String marca;
    private String modelo;
    private String color;
    private List<String> lastChange;
    private int nivelaceite;
    private int presionneumaticos;
    private int nivelagua;


    public Automovil() {
    }

    public Automovil(String marca, String modelo, String color, int nivelaceite, int presionneumaticos, int nivelagua) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.nivelaceite = nivelaceite;
        this.presionneumaticos = presionneumaticos;
        this.nivelagua = nivelagua;
        lastChange= new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!this.color.equals(color)) {
            this.lastChange.add(0,"setColor");
            this.lastChange.add(1,getColor());
            this.color = color;
            setChanged();
            notifyObservers(this.lastChange);
        }
    }

    public int getNivelaceite() {
        return nivelaceite;
    }

    public void setNivelaceite(int nivelaceite) {
        if(this.nivelaceite!=nivelaceite) {
            this.lastChange.add(0,"setNivelaceite");
            this.lastChange.add(1, String.valueOf(getNivelaceite()));
            this.nivelaceite = nivelaceite;
            setChanged();
            notifyObservers(this.lastChange);
        }
    }

    public int getPresionneumaticos() {
        return presionneumaticos;
    }

    public void setPresionneumaticos(int presionneumaticos) {
        if(this.presionneumaticos!=presionneumaticos) {
            this.lastChange.add(0,"setPresionneumaticos");
            this.lastChange.add(1, String.valueOf(getPresionneumaticos()));
            this.presionneumaticos = presionneumaticos;
            setChanged();
            notifyObservers(this.lastChange);
        }
    }

    public int getNivelagua() {
        return nivelagua;
    }

    public void setNivelagua(int nivelagua) {
        if(this.nivelagua!=nivelagua) {
            this.lastChange.add(0,"setNivelagua");
            this.lastChange.add(1, String.valueOf(getNivelagua()));
            this.nivelagua = nivelagua;
            setChanged();
            notifyObservers(this.lastChange);
        }
    }
}
