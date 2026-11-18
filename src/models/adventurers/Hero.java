package models.adventurers;

import interfaces.Consumable;
import interfaces.Trainable;
import models.Entity;
import models.items.Item;
import utility.Inventory;

public abstract class Hero extends Entity implements Trainable {
    
    private int xp;
    private int xpCeil;
    private final Inventory inventory;

    private static final double STEP_HP_HEROES = 0.075;
    private static final int BASE_XP_REQ = 100;

    
    public static double getStepHpHeroes() {
        return STEP_HP_HEROES;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public int getXp() {
        return xp;
    }
    public int getXpCeil() {
        return xpCeil;
    }

    //Constructor chain
    public Hero (String name, int liv, int hpMax, double step) {
        super(name, liv, hpMax, step);
        this.inventory = new Inventory();
        this.xp = 0;
        this.xpCeil = xpCurve(this.getLiv());
    }
    public Hero (String name, int hpMax, double step) {
        this(name, 1, hpMax, step);
    }
    public Hero(String name, int liv, int hpMax) {
        this(name,liv, hpMax, STEP_HP_HEROES);
    }
    public Hero (String name, int hpMax) {
        this(name,1, hpMax, STEP_HP_HEROES);
    }
    

    @Override
    public String toString() { // baby tier reflection, evito di dover fare override in ogni sottoclasse
        String classe = getClass().getSimpleName();
        return classe + " " + getName() + " liv: " + getLiv();
    }

    public void pick(Item item) {
        getInventory().addItem(item);
    }

    public void drop(Item item) {
        getInventory().removeItem(item);
    }

    public String showInventory() {
        String message ="";
        message += getInventory().showItems() + "\n";
        message += "Il carico attuale è di " + getInventory().getLoad()/1000.0 + "Kg";
        return message;
    }

    private int xpCurve (int liv) {
        return (int) (BASE_XP_REQ * Math.pow(liv, 1.5));
    }

    public void consume(Consumable item) { //così posso chiamare più naturalmente la consumezione
        if (item != null) {
            item.applyEffect(this);
        }
    }

    @Override
    public void train () {

    }
}
