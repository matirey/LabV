/**
 * Created by Matias on 26/03/2018.
 */
public class Main {

    public static void wait3seconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Automovil auto1 = new Automovil("ford","fiesta","red",100,30,100);
        Mecanico meca1= new Mecanico(auto1);

        auto1.setColor("green");
        wait3seconds();
        auto1.setNivelaceite(90);
        wait3seconds();
        auto1.setPresionneumaticos(28);
        wait3seconds();
        auto1.setNivelagua(94);


    }
}
