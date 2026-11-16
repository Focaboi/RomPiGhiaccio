package models.items;

import enums.ArmorType;

public class Armor extends Item {

    private static double MAX_BLOCK_CHANCE = 100;
    private static double MIN_BLOCK_CHANCE = 0;
    private ArmorType type;
    private double blockChance;
    private double dmgRed;

    public ArmorType getType() {
        return type;
    }
    public void setType(ArmorType type) {
        this.type = type;
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

    public Armor(String name, double weight, double value, ArmorType type, double blockChance, double dmgRed) {
        super(name, weight, value);
        this.type = type;
        setBlockChance(blockChance);
        this.dmgRed = dmgRed;
    }
}
