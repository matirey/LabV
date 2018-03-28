import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Matias on 26/03/2018.
 */
public class Mecanico implements Observer{

    Automovil automovil;

    public Mecanico(Automovil automovil) {
        this.automovil= automovil;
        automovil.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Automovil auto = (Automovil)o;

        if(arg instanceof ArrayList){
            String method = ((ArrayList) arg).get(0).toString();
            String oldValue = ((ArrayList)arg).get(1).toString();
            if(method.equals("setColor")){
                System.out.println(auto.getMarca()+" "+auto.getModelo()+" has changed the color");
                System.out.println("was "+oldValue+" and now is "+auto.getColor());
            }
            if(method.equals("setNivelaceite")){
                System.out.println(auto.getMarca()+" "+auto.getModelo()+" has changed the oil level");
                System.out.println("was "+oldValue+" % and now is "+auto.getNivelaceite()+" %");
            }
            if(method.equals("setPresionneumaticos")){
                System.out.println(auto.getMarca()+" "+auto.getModelo()+" has changed the tires pressure");
                System.out.println("was "+oldValue+" psi and now is "+auto.getPresionneumaticos()+" psi");
            }
            if(method.equals("setNivelagua")){
                System.out.println(auto.getMarca()+" "+auto.getModelo()+" has changed the water level");
                System.out.println("was "+oldValue+" % and now is "+auto.getNivelagua()+" %");
            }
        }
    }
}
