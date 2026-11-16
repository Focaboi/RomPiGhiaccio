package models;

public class Mage extends Hero {
    
    // Constructor chain
    public Mage (String nome, int liv, int hpMax, double passo) {
        super(nome, liv, hpMax, passo);
    }
    public Mage (String nome, int hpMax, double passo) {
        this(nome, 1, hpMax, passo);
    }
    public Mage (String nome, int liv, int hpMax) {
        this(nome,liv, hpMax, getPassoHpEroi());
    }
    public Mage (String nome, int hpMax) {
        this(nome,1, hpMax, getPassoHpEroi());
    }

     @Override
    public void allena () {
        String messaggio = (this.getLiv() + 1)> getLIV_CAP() ?
        "Questo "+ this.getClass().getSimpleName() + " ha già raggiunto il massimo del suo potenziale\n"                        :
        this.getClass().getSimpleName() + " studia elementi ed incantesimi, poi sperimenta sul suo repertorio\n+1 livello!\n"   ;

        System.out.println(messaggio);
        this.setLiv(this.getLiv() + 1);
    }
}
