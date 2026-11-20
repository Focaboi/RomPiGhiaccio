package models.adventurers;

public class Mage extends Hero {
    
    // Constructor chain
    public Mage (String name, int liv, double step) {
        super(name, liv, step);
    }
    public Mage (String name, double step) {
        this(name, 1, step);
    }
    public Mage (String name, int liv) {
        this(name,liv, getStepHpHeroes());
    }
    public Mage (String name) {
        this(name,1, getStepHpHeroes());
    }

     @Override
    public void train () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                        :
        this.getClass().getSimpleName() + " studia elementi ed incantesimi, poi sperimenta sul suo repertorio\n+1 livello!\n"   ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
