package models;

public class Monk extends Hero {
    
    // Constructor chain
    public Monk (String name, int liv, int hpMax, double passo) {
        super(name, liv, hpMax, passo);
    }
    public Monk (String name, int hpMax, double passo) {
        this(name, 1, hpMax, passo);
    }
    public Monk (String name, int liv, int hpMax) {
        this(name,liv, hpMax, getPassoHpEroi());
    }
    public Monk (String name, int hpMax) {
        this(name,1, hpMax, getPassoHpEroi());
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
