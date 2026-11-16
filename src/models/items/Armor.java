package models.items;

import enums.TipoArmor;

public class Armor extends Item {

    private static double MAX_BLOCK_CHANCE = 100;
    private static double MIN_BLOCK_CHANCE = 0;
    private TipoArmor tipo;
    private double blockChance;
    private double dmgRed;

    public TipoArmor getTipo() {
        return tipo;
    }
    public void setTipo(TipoArmor tipo) {
        this.tipo = tipo;
    }
    public double getBlockChance() {
        return blockChance;
    }
    public void setBlockChance(double blockChance) {
        if (blockChance > MAX_BLOCK_CHANCE)
            this.blockChance = MAX_BLOCK_CHANCE;
        else if (blockChance < MIN_BLOCK_CHANCE)
            this.blockChance = MIN_BLOCK_CHANCE;
        else
            this.blockChance = blockChance;
    }
    public double getDmgRed() {
        return dmgRed;
    }
    public void setDmgRed(double dmgRed) {
        this.dmgRed = dmgRed;
    }

    public Armor(String nome, double peso, double valore, TipoArmor tipo, double blockChance, double dmgRed) {
        super(nome, peso, valore);
        this.tipo = tipo;
        setBlockChance(blockChance);
        this.dmgRed = dmgRed;
    }
}
