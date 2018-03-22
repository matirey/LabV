import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Matias on 14/03/2018.
 */
public class BeerProductor extends Thread {

    private String name;
    private ArrayList<String> list= new ArrayList<>();
    private BeerHouse bar;

    public BeerProductor(String name, BeerHouse bar, ArrayList<String> list) {
        this.name = name;
        this.bar = bar;
        this.list= list;
    }

    public String RndBeer(){
        Random rnd = new Random();
        return this.list.get(rnd.nextInt(this.list.size()));
    }

    public void run(){
        int i;
        this.bar.setWorking(true);
        for (i=0;i<10;i++){
            this.bar.Produce(this.name,RndBeer());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bar.setWorking(false);
    }
}
