package models;

public class Warrior extends Hero{

    // Constructor chain
    public Warrior (String nome, int liv, int hpMax, double passo) {
        super(nome, liv, hpMax, passo);
    }
    public Warrior (String nome, int hpMax, double passo) {
        this(nome, 1, hpMax, passo);
    }
    public Warrior (String nome, int liv, int hpMax) {
        this(nome,liv, hpMax, getPassoHpEroi());
    }
    public Warrior (String nome, int hpMax) {
        this(nome,1, hpMax, getPassoHpEroi());
    }

    @Override
    public void allena () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                :
        this.getClass().getSimpleName() + " brandisce la sua spada concentrandosi sulla propria tecnica\n+1 livello!\n" ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
