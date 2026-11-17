package models;

import utility.Dice;

public abstract class Entity {
    private String name;
    private int liv;
    private int hpMax;
    private int hp;

    private final double talentoVita;

    private static final int LIV_CAP = 100;

    public static double rollaTalentoVita (double step) { //lo scaling del calcolo, ogni +1 = 0.10, 0.20 ecc.
        int tiro = Dice.roll(10);
        double modificatore = 0.0;

        if (tiro <= 4) modificatore -= (5-tiro)*step;
        if (tiro >  6) modificatore += (tiro-6)*step;
        return Math.max(0.1, 1 + modificatore); //non può mai scendere sotto 0.1, cioè il 10% degli hpMax
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLiv() {
        return liv;
    }
    public void setLiv(int liv) {
        if (liv >= LIV_CAP)
            this.liv = LIV_CAP;
        else if (liv <= 0)
            this.liv = 1;
        else
            this.liv = liv;
    }
    public int getHpMax() {
        return hpMax;
    }
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getLIV_CAP() {
        return LIV_CAP;
    }
    public double getTalentoVita() {
        return talentoVita;
    }


    //Constructor chain
    public Entity(String name, int liv, int hpMax) {
        this(name,liv, hpMax, 0.0);
    }
    public Entity (String name, int liv, int hpMax, double step) {
        if (step > 0.0) talentoVita = rollaTalentoVita(step);
        else talentoVita = 1.0;
        this.name = name;
        setLiv(liv);
        this.hpMax = Math.max(1, (int) Math.round(hpMax*talentoVita)) ; //cast a int, hpMax rischiava di passare per double,
        this.hp = this.hpMax;                                           //minimo 1 hpMax, a prescindere dalle riduzioni
    }
    public Entity (String name, int hpMax) {
        this(name,1, hpMax);
    }
    public Entity (String name, int hpMax, double step) {
        this(name, 1, hpMax, step);
    }

    
}
