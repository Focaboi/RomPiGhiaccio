package models.adventurers;

public class Mage extends Hero {
    
    // Constructor chain
    public Mage (String name, int liv, int hpMax, double step) {
        super(name, liv, hpMax, step);
    }
    public Mage (String name, int hpMax, double step) {
        this(name, 1, hpMax, step);
    }
    public Mage (String name, int liv, int hpMax) {
        this(name,liv, hpMax, getStepHpHeroes());
    }
    public Mage (String name, int hpMax) {
        this(name,1, hpMax, getStepHpHeroes());
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
