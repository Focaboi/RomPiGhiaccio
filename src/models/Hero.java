package models;

import interfaces.Consumable;
import interfaces.Trainable;
import models.items.Item;
import utility.Inventory;

public abstract class Hero extends Entity implements Trainable {
    
    private Inventory inventory;

    private static final double PASSO_HP_EROI = 0.075;

    
    public static double getPassoHpEroi() {
        return PASSO_HP_EROI;
    }
    public Inventory getInventory() {
        return inventory;
    }

    //Constructor chain
    public Hero (String name, int liv, int hpMax, double passo) {
        super(name, liv, hpMax, passo);
        this.inventory = new Inventory();
    }
    public Hero (String name, int hpMax, double passo) {
        this(name, 1, hpMax, passo);
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

    public void raccogli(Item oggetto) {
        getInventory().addItem(oggetto);
    }

    public void lascia(Item oggetto) {
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
