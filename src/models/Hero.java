package models;

import Interfaces.Consumable;
import Interfaces.Trainable;
import models.items.Item;
import utility.Inventory;

public abstract class Hero extends Entity implements Trainable {
    
    private Inventory inventario;

    private static final double PASSO_HP_EROI = 0.075;

    
    public static double getPassoHpEroi() {
        return PASSO_HP_EROI;
    }
    public Inventory getInventario() {
        return inventario;
    }

    //Constructor chain
    public Hero (String nome, int liv, int hpMax, double passo) {
        super(nome, liv, hpMax, passo);
        this.inventario = new Inventory();
    }
    public Hero (String nome, int hpMax, double passo) {
        this(nome, 1, hpMax, passo);
    }
    public Hero(String nome, int liv, int hpMax) {
        this(nome,liv, hpMax, PASSO_HP_EROI);
    }
    public Hero (String nome, int hpMax) {
        this(nome,1, hpMax, PASSO_HP_EROI);
    }
    

    @Override
    public String toString() { // baby tier reflection, evito di dover fare override in ogni sottoclasse
        String classe = getClass().getSimpleName();
        return classe + " " + getName() + " liv: " + getLiv();
    }

    public void raccogli(Item oggetto) {
        getInventario().aggiungiOggetto(oggetto);
    }

    public void lascia(Item oggetto) {
        getInventario().rimuoviOggetto(oggetto);
    }

    public void mostraInventario() {
        getInventario().mostraOggetti();
        getInventario().stampaPesoKg();
    }

    public void consuma(Consumable oggetto) { //così posso chiamare più naturalmente la consumazione
        if (oggetto != null) {
            oggetto.applicaEffetto(this);
        }
    }
}
