package models.adventurers;

import interfaces.Consumable;
import interfaces.Trainable;
import models.Entity;
import models.items.Inventory;
import models.items.Item;

public abstract class Hero extends Entity implements Trainable {
    
    private int xp;
    private int xpCeil;
    private double trainMult = 0.1;   //moltiplicatore allenamento, parte da 10% modificabile inGame
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
    public void setXp (int xp) {
        this.xp = xp;
    }
    public int getXpCeil() {
        return xpCeil;
    }
    public void setXpCeil (int xpCeil) {
        this.xpCeil = xpCeil;
    }

    //Constructor chain
    public Hero(String name, int liv, double step, int baseDamage, double baseEvasion) {
        super(name, liv, step, baseDamage, baseEvasion);
        this.inventory = new Inventory();
        this.xp = 0;
        this.xpCeil = xpCurve(this.getLiv());
    }
    public Hero(String name, int liv, double step) {
        this(name, liv, step, getBASE_DMG(),getBASE_EVD());
    }
    public Hero (String name, double step) {
        this(name, 1, step);
    }
    public Hero(String name, int liv) {
        this(name,liv, STEP_HP_HEROES);
    }
    public Hero (String name) {
        this(name,1, STEP_HP_HEROES);
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

    public void gainXp (int xp) {
        setXp(getXp() + xp);
        while (getXp() >= getXpCeil()) {
            if (getLiv() >= getLIV_CAP()) break;
            levelUp();
        }
    }

    public void levelUp () {
        if (getLiv() >= getLIV_CAP()) return;

        int newLiv = getLiv() + 1;
    
        System.out.println(getName()+" sale di livello.");
        setLiv(newLiv);
        setHpMax((int) Math.round(hpCurve(newLiv)*getTalentoVita())); // levelup NON cura il pg
        setXpCeil(xpCurve(newLiv));
    }

    @Override
    public void train () {
        int xp = (int)(getXp()*trainMult);
        System.out.println("hai ottenuto "+ xp +" xp");
        gainXp(xp);
    }
}
