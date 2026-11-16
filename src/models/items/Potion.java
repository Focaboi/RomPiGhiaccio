package models.items;

import interfaces.Consumable;
import models.Hero;

public class Potion extends Item implements Consumable {

    private static final int WEIGHT_MIN = 50;
    private static final int WEIGHT_MAX = 250;
    private boolean isFull;

    public boolean isFull() {
        return isFull;
    }

    public void toggleFull() { // inverte la condizione, se è piena la svuota e viceversa
        this.isFull = !isFull();
    }

    public Potion(String name, double weight, double value) {
        super(name, validateWeight(weight), value);
        this.isFull = true;
    }

    private static double validateWeight(double weight) {
        if (weight > WEIGHT_MAX)
            weight = WEIGHT_MAX;
        else if (weight < WEIGHT_MIN)
            weight = WEIGHT_MIN;
        return weight;
    }

    @Override
    public void applyEffect(Hero bersaglio) {
        bersaglio.getInventory().removeItem(this);
        bersaglio.raccogli(new Misc("Fiaschetta vuota", 30, 1));
    }
}
