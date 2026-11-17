package models.adventurers;

public class Warrior extends Hero{

    // Constructor chain
    public Warrior (String name, int liv, int hpMax, double step) {
        super(name, liv, hpMax, step);
    }
    public Warrior (String name, int hpMax, double step) {
        this(name, 1, hpMax, step);
    }
    public Warrior (String name, int liv, int hpMax) {
        this(name,liv, hpMax, getStepHpEroi());
    }
    public Warrior (String name, int hpMax) {
        this(name,1, hpMax, getStepHpEroi());
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
