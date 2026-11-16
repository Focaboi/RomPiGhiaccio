package models.items;

import Interfaces.Consumable;
import models.Hero;

public class Potion extends Item implements Consumable {

    private static final int PESO_MIN = 50;
    private static final int PESO_MAX = 250;
    private boolean isFull;

    public boolean isFull() {
        return isFull;
    }

    public void toggleFull() { // inverte la condizione, se è piena la svuota e viceversa
        this.isFull = !isFull();
    }

    public Potion(String nome, double peso, double valore) {
        super(nome, validaPeso(peso), valore);
        this.isFull = true;
    }

    private static double validaPeso(double peso) {
        if (peso > PESO_MAX)
            peso = PESO_MAX;
        else if (peso < PESO_MIN)
            peso = PESO_MIN;
        return peso;
    }

    @Override
    public void applicaEffetto(Hero bersaglio) {
        bersaglio.getInventario().rimuoviOggetto(this);
        bersaglio.raccogli(new Misc("Fiaschetta vuota", 30, 1));
    }
}
