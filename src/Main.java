import Controller.MesaObservadora;
import Model.Jugador;
import Model.Mesa;

/**
 * Created by Matias on 04/04/2018.
 */
public class Main {

    public static void main(String[] args) {

        Jugador jug1= new Jugador("Jack Sparrow");
        Jugador jug2= new Jugador("Samara");
        Jugador jug3= new Jugador("Boba Fett");
        Jugador jug4= new Jugador("Albus Dumbledore");

        MesaObservadora mesaOb = new MesaObservadora();

        mesaOb.configInicial("asd",jug1,jug2,jug3,jug4);

    }
}
