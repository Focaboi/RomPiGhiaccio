package models.adventurers;

import interfaces.Consumable;
import interfaces.Trainable;
import models.Entity;
import models.items.Item;
import utility.Inventory;

public abstract class Hero extends Entity implements Trainable {
    
    private Inventory inventory;

    private static final double PASSO_HP_EROI = 0.075;

    
    public static double getStepHpEroi() {
        return PASSO_HP_EROI;
    }
    public Inventory getInventory() {
        return inventory;
    }

    //Constructor chain
    public Hero (String name, int liv, int hpMax, double step) {
        super(name, liv, hpMax, step);
        this.inventory = new Inventory();
    }
    public Hero (String name, int hpMax, double step) {
        this(name, 1, hpMax, step);
    }
    public Hero(String name, int liv, int hpMax) {
        this(name,liv, hpMax, PASSO_HP_EROI);
    }
    public Hero (String name, int hpMax) {
        this(name,1, hpMax, PASSO_HP_EROI);
    }
    

    @Override
    public String toString() { // baby tier reflection, evito di dover fare override in ogni sottoclasse
        String classe = getClass().getSimpleName();
        return classe + " " + getName() + " liv: " + getLiv();
    }

    public void pick(Item oggetto) {
        getInventory().addItem(oggetto);
    }

    public void drop(Item oggetto) {
        getInventory().removeItem(oggetto);
    }

    public void mostraInventory() {
        getInventory().showItems();
        getInventory().stampaWeightKg();
    }

    public void consume(Consumable oggetto) { //così posso chiamare più naturalmente la consumezione
        if (oggetto != null) {
            oggetto.applyEffect(this);
        }
    }
}
