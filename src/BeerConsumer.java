import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Matias on 14/03/2018.
 */
public class BeerConsumer extends Thread {

    private String name;
    private BeerHouse bar;
    private ArrayList<String> offer;

    public BeerConsumer(String name, BeerHouse bar, ArrayList<String> offer) {
        this.name = name;
        this.bar = bar;
        this.offer = offer;
    }

    public String RndBeer(){
        Random rnd = new Random();
        return this.offer.get(rnd.nextInt(this.offer.size()));
    }

    public int RndCant(){
        Random rnd = new Random();
        return rnd.nextInt(10)+1;
    }

    public void run(){
        int i;
        for (i=0;i<10;i++){
            this.bar.Consume(this.name, this.RndBeer(), this.RndCant());
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
