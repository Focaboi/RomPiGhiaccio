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
    public double getCarico() {
        return currentLoad;
    }
    private void setCarico(double currentLoad) {
        this.currentLoad = currentLoad;
    }
    
    public Inventory() {
        this.items = new ArrayList<>();
        setCarico(0);
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
        if (oggetto.getWeight() + getCarico() <= getMaxWeight()) {
            items.add(oggetto);
            setCarico(currentLoad + oggetto.getWeight());
        } else
            System.out.println("il weight trasportabile non può eccedere i 30 Kg");
    }

    public void removeItem(Item oggetto) {
        if (items.remove(oggetto))
            setCarico(currentLoad - oggetto.getWeight()); // sfrutta il booleano e i cicli nativi del remove
        else
            System.out.println("Oggetto non presente nell'inventario.");
    }
   
    public void stampaWeightG() {
        System.out.println("il weight complessivo degli items in questo inventario è di: " + getCarico()+"g");
    }
    public void stampaWeightKg() {
        System.out.println("il weight complessivo degli items in questo inventario è di: " + getCarico()/1000+"Kg");
    }
}
