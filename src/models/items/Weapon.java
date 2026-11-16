package models.items;

import enums.WeaponType;

public class Weapon extends Item{
    private final double MAX_ACC = 100;
    private final double MIN_ACC = 0;
    private WeaponType type;
    private double acc;
    private double dmg;
    
    public double getAcc() {
        return acc;
    }
    public void setAcc(double acc) {
        if      (acc > MAX_ACC) this.acc = MAX_ACC;
        else if (acc < MIN_ACC) this.acc = MIN_ACC;
        else                    this.acc = acc;
    }
    public double getDmg() {
        return dmg;
    }
    public void setDmg(double dmg) {
        this.dmg = dmg;
    }
    public WeaponType getType() {
        return type;
    }
    public void setType(WeaponType type) {
        this.type = type;
    }

    public Weapon(String name, double weight, double value, double acc, double dmg) {
        super(name, weight, value);
        setAcc(acc);
        this.dmg = dmg;
    }
    @Override
    public String toString() {
        return super.toString() + "type: " + type + ", acc: " + acc + ", dmg: " + dmg;
    }

    
}
