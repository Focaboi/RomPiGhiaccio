package utility;

import java.util.ArrayList;
import java.util.List;

import models.items.Item;

public class Inventory {

    private static final double MAX_LOAD = 30000;

    private List<Item> items;
    private double currentLoad;

    public static double getMaxWeight() {
        return MAX_LOAD;
    }
    public double getLoad() {
        return currentLoad;
    }
    private void setLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }
    
    public Inventory() {
        this.items = new ArrayList<>();
        setLoad(0);
    }

    public void showItems() {
        for (Item i : items) {
            System.out.println(i.toString());
        }
    }

    public void addItem(Item oggetto) {
        if (oggetto == null) {
            System.out.println("Impossibile aggiungere un oggetto nullo.");
            return;
        }
        if (oggetto.getWeight() + getLoad() <= getMaxWeight()) {
            items.add(oggetto);
            setLoad(currentLoad + oggetto.getWeight());
        } else
            System.out.println("il weight trasportabile non può eccedere i 30 Kg");
    }

    public void removeItem(Item oggetto) {
        if (items.remove(oggetto))
            setLoad(currentLoad - oggetto.getWeight()); // sfrutta il booleano e i cicli nativi del remove
        else
            System.out.println("Oggetto non presente nell'inventario.");
    }
   
    public void stampaWeightG() {
        System.out.println("il weight complessivo degli items in questo inventario è di: " + getLoad()+"g");
    }
    public void stampaWeightKg() {
        System.out.println("il weight complessivo degli items in questo inventario è di: " + getLoad()/1000+"Kg");
    }
}
