package models.adventurers;

public class Warrior extends Hero{

    // Constructor chain
    public Warrior (String name, int liv, double step) {
        super(name, liv, step);
    }
    public Warrior (String name, double step) {
        this(name, 1, step);
    }
    public Warrior (String name, int liv) {
        this(name,liv, getStepHpHeroes());
    }
    public Warrior (String name) {
        this(name,1, getStepHpHeroes());
    }

    @Override
    public void train () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                :
        this.getClass().getSimpleName() + " brandisce la sua spada concentrandosi sulla propria tecnica\n+1 livello!\n" ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
