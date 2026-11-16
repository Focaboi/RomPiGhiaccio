package models.items;

import enums.TipoArma;

public class Weapon extends Item{
    private final double MAX_ACC = 100;
    private final double MIN_ACC = 0;
    private TipoArma tipo;
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
    public TipoArma getTipo() {
        return tipo;
    }
    public void setTipo(TipoArma tipo) {
        this.tipo = tipo;
    }

    public Weapon(String nome, double peso, double valore, double acc, double dmg) {
        super(nome, peso, valore);
        setAcc(acc);
        this.dmg = dmg;
    }
    @Override
    public String toString() {
        return super.toString() + "tipo: " + tipo + ", acc: " + acc + ", dmg: " + dmg;
    }

    
}
