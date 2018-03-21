import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matias on 21/03/2018.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> beers = new ArrayList<>();
        beers.add("honey");
        //beers.add("stout");
        //beers.add("blonde");

        BeerHouse bar = new BeerHouse();

        BeerProductor prod1 = new BeerProductor("Birreria Pepe", bar, beers);

        BeerConsumer cons1 = new BeerConsumer("the hot girl", bar , beers);
        BeerConsumer cons2 = new BeerConsumer("the drunk guy", bar, beers);
        BeerConsumer cons3 = new BeerConsumer("One old man", bar, beers);

        prod1.start();
        cons1.start();
        cons2.start();
        cons3.start();


    }
}
