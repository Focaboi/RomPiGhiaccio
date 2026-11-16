package utility;

import java.util.ArrayList;
import java.util.List;

import models.items.Item;

public class Inventory {

    private static final double MAX_WEIGHT = 30000;

    private List<Item> bisaccia;
    private double carico;

    public static double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public double getCarico() {
        return carico;
    }

    private void setCarico(double carico) {
        this.carico = carico;
    }

    public Inventory() {
        this.bisaccia = new ArrayList<>();
        setCarico(0);
    }

    public void mostraOggetti() {
        for (Item i : bisaccia) {
            System.out.println(i.toString());
        }
    }

    public void aggiungiOggetto(Item oggetto) {
        if (oggetto == null) {
            System.out.println("Impossibile aggiungere un oggetto nullo.");
            return;
        }
        if (oggetto.getPeso() + getCarico() <= getMaxWeight()) {
            bisaccia.add(oggetto);
            setCarico(carico + oggetto.getPeso());
        } else
            System.out.println("il peso trasportabile non può eccedere i 30 Kg");
    }

    public void rimuoviOggetto(Item oggetto) {
        if (bisaccia.remove(oggetto))
            setCarico(carico - oggetto.getPeso()); // sfrutta il booleano e i cicli nativi del remove
        else
            System.out.println("Oggetto non presente nell'inventario.");
    }
    // public void rimuoviOggetto (Item oggetto) { //carino ma usa due volte cicli
    // innecessariamente, remove(var1) cicla già
    // for (Item i : bisaccia) {
    // if (i.equals(oggetto)) {
    // bisaccia.remove(i);
    // setCarico(carico - i.getPeso());
    // return;
    // }
    // }
    // System.out.println("Oggetto non presente nell'inventario.");
    // }
    public void stampaPesoG() {
        System.out.println("il peso complessivo degli bisaccia in questo inventario è di: " + getCarico()+"g");
    }
    public void stampaPesoKg() {
        System.out.println("il peso complessivo degli bisaccia in questo inventario è di: " + getCarico()/1000+"Kg");
    }
}
