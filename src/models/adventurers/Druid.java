package models.adventurers;

public class Druid extends Hero {

    // Constructor chain
    public Druid (String name, int liv, double step) {
        super(name, liv, step);
    }
    public Druid (String name, double step) {
        this(name, 1, step);
    }
    public Druid (String name, int liv) {
        this(name,liv, getStepHpHeroes());
    }
    public Druid (String name) {
        this(name,1, getStepHpHeroes());
    }

    @Override
    public void train () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                :
        this.getClass().getSimpleName() + " rinforza il suo legame con terra, piante e animali\n+1 livello!\n" ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
