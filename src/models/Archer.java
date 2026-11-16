package models;

public class Archer extends Hero {

    // Constructor chain
    public Archer (String nome, int liv, int hpMax, double passo) {
        super(nome, liv, hpMax, passo);
    }
    public Archer (String nome, int hpMax, double passo) {
        this(nome, 1, hpMax, passo);
    }
    public Archer(String nome, int liv, int hpMax) {
        this(nome,liv, hpMax, getPassoHpEroi());
    }
    public Archer (String nome, int hpMax) {
        this(nome,1, hpMax, getPassoHpEroi());
    }

    @Override
    public void allena() {
        String messaggio = (this.getLiv() + 1) > getLIV_CAP()
                ? "Questo " + this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"
                : this.getClass().getSimpleName() + " allena la propria mira con dei bersagli sul muro\n+1 livello!\n";

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
