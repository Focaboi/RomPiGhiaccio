package models;

import combat.BattleUtils;
import utility.Dice;

public abstract class Entity {
    private String name;
    private int liv;
    private int hpMax;
    private int hp;
    private int baseDamage;
    private double baseEvasion;
    private boolean alive;

    private final double talentoVita;

    private static final int BASE_HP_MAX = 80;
    private static final int LIV_CAP = 100;
    private static final double MAX_EVASION = 1.0;
    private static final double MIN_EVASION = 0.0;
    private static final int BASE_DMG = 10;
    private static final double BASE_EVD = 0.0;

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
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public double getBaseEvasion() {
        return baseEvasion;
    }
     public void setBaseEvasion(double evd) {
        if (baseEvasion >= MAX_EVASION)
            this.baseEvasion = MAX_EVASION;
        else if (baseEvasion <= MIN_EVASION)
            this.baseEvasion = MIN_EVASION;
        else
            this.baseEvasion = evd;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getLIV_CAP() {
        return LIV_CAP;
    }
    public int getBASE_HP_MAX() {
        return BASE_HP_MAX;
    }
    public double getTalentoVita() {
        return talentoVita;
    }
    public static double getMAX_EVASION() {
        return MAX_EVASION;
    }
    public static double getMIN_EVASION() {
        return MIN_EVASION;
    }
    public static int getBASE_DMG() {
        return BASE_DMG;
    }
    public static double getBASE_EVD() {
        return BASE_EVD;
    }


    //Constructor chain
    public Entity (String name, int liv, double step, int baseDamage, double baseEvasion) {
        if (step > 0.0) talentoVita = rollaTalentoVita(step);
        else talentoVita = 1.0;
        this.name = name;
        setLiv(liv);
        this.hpMax = Math.max(1, (int) Math.round(hpCurve(liv)*talentoVita)) ; //cast a int, hpMax rischiava di passare per double,
        this.hp = this.hpMax;
        this.baseDamage = baseDamage;
        this.baseEvasion = baseEvasion;                                                  //minimo 1 hpMax, a prescindere dalle riduzioni
        this.alive = true;                                   
    }
    public Entity(String name, int liv, int baseDamage, double baseEvasion) {
        this(name,liv, 0.0, baseDamage, baseEvasion);
    }
    public Entity(String name, int liv, double step) {
        this(name, liv, step, BASE_DMG, BASE_EVD);
    }
    public Entity (String name, double step) {
        this(name, 1, step, BASE_DMG, BASE_EVD);
    }
    public Entity(String name, int liv) {
        this(name,liv, 0.0, BASE_DMG, BASE_EVD);
    }
    public Entity (String name) {
        this(name,1);
    }
    
    public int hpCurve (int liv) {
        return (int) (BASE_HP_MAX * Math.pow(liv, 1.5));
    }

    public void takeDamage (int dmg) {
        if (getHp() <= dmg) {
            setAlive(false);
            setHp (0);
            return;
        }
        setHp(getHp() - dmg);
    }

    public boolean evade() {
        int success = 100 - (int) (getBaseEvasion()*100);
        int roll = Dice.roll(100);
        if ( roll > success) return true;
        else return false;
    }

    public void baseAttack (Entity target) {
        if (target.evade()) {
            System.out.println("il bersaglio, "+target.getName()+" schiva l'attacco.");
            return;
        }
        else {
            BattleUtils.dealDamage(baseDamage, target);
            System.out.println(getName()+" colpisce il bersaglio per "+getBaseDamage()+" danni");
        } 
    }
}
