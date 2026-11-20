package models.adventurers;

public class Monk extends Hero {
    
    // Constructor chain
    public Monk (String name, int liv, double step) {
        super(name, liv, step);
    }
    public Monk (String name, double step) {
        this(name, 1, step);
    }
    public Monk (String name, int liv) {
        this(name,liv, getStepHpHeroes());
    }
    public Monk (String name) {
        this(name,1, getStepHpHeroes());
    }

     @Override
    public void train () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                            :
        this.getClass().getSimpleName() + " stende i muscoli, poi li contrae e tempra ulteriormente il suo fisico\n+1 livello!\n"   ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
