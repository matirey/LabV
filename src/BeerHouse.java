import java.util.HashMap;
import java.util.Set;

/**
 * Created by Matias on 14/03/2018.
 */
public class BeerHouse {

    private HashMap<String, Integer> stock;
    private boolean working;

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean isWorkingWithStock(String beer, int cant){
        boolean goAhead=false;
        // si no hay stock suficiente pero el productor esta trabajando, debe seguir esperando (wait)
        if(this.stock.get(beer) < cant && isWorking()){
            goAhead=true;
        }
        return goAhead;
    }

    public BeerHouse() {
        this.stock= new HashMap<>();
    }

    public synchronized void Produce(String prodName, String beer){
        if (!this.stock.containsKey(beer)){
            this.stock.put(beer,10);
        }
        else {
            while(this.stock.get(beer) >= 100 ){
                try {
                    System.out.println(prodName+ "tried to add 10 "+beer+" beers but the capacity is full");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.stock.replace(beer,this.stock.get(beer)+10);
        }
        System.out.println(prodName+ " added some "+beer+" beers. now ("+this.stock.get(beer)+")");
        notifyAll();
    }

    public synchronized void Consume(String consName, String beer, int cant){
        while (!this.stock.containsKey(beer) || isWorkingWithStock(beer,cant)){
            try {
                System.out.println(consName+" is waiting for "+cant+" "+beer+" beers");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!isWorking()){
            Thread.currentThread().interrupt();
        }
        else {
            this.stock.replace(beer, this.stock.get(beer) - cant);
            System.out.println(consName + " bought " + cant + " " + beer + " beers. now (" + this.stock.get(beer) + ")");
        }
        notifyAll();
    }
}
