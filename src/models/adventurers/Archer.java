package models.adventurers;

public class Archer extends Hero {

    // Constructor chain
    public Archer (String name, int liv, double step) {
        super(name, liv, step);
    }
    public Archer (String name, double step) {
        this(name, 1, step);
    }
    public Archer(String name, int liv) {
        this(name,liv, getStepHpHeroes());
    }
    public Archer (String name) {
        this(name,1, getStepHpHeroes());
    }

    @Override
    public void train() {
        String messaggio = (this.getLiv() + 1) > getLIV_CAP()
                ? "Questo " + this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"
                : this.getClass().getSimpleName() + " train la propria mira con dei bersagli sul muro\n+1 livello!\n";

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
