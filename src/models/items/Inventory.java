package models.items;

import java.util.ArrayList;
import java.util.List;

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

    public String showItems() {
        String message ="";
        for (Item i : items) {
            message += i.toString();
        }
        return message;
    }

    public void addItem(Item item) {
        if (item == null) {
            System.out.println("Impossibile aggiungere un oggetto nullo.");
            return;
        }
        if (item.getWeight() + getLoad() <= getMaxWeight()) {
            items.add(item);
            setLoad(currentLoad + item.getWeight());
        } else
            System.out.println("il peso trasportabile non può eccedere i 30 Kg");
    }

    public void removeItem(Item item) {
        if (items.remove(item))
            setLoad(currentLoad - item.getWeight()); // sfrutta il booleano e i cicli nativi del remove
        else
            System.out.println("Oggetto non presente nell'inventario.");
    }
}
