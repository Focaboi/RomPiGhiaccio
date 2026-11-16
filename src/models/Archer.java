package models;

public class Archer extends Hero {

    // Constructor chain
    public Archer (String name, int liv, int hpMax, double passo) {
        super(name, liv, hpMax, passo);
    }
    public Archer (String name, int hpMax, double passo) {
        this(name, 1, hpMax, passo);
    }
    public Archer(String name, int liv, int hpMax) {
        this(name,liv, hpMax, getPassoHpEroi());
    }
    public Archer (String name, int hpMax) {
        this(name,1, hpMax, getPassoHpEroi());
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
