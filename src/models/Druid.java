package models;

public class Druid extends Hero {

    // Constructor chain
    public Druid (String name, int liv, int hpMax, double passo) {
        super(name, liv, hpMax, passo);
    }
    public Druid (String name, int hpMax, double passo) {
        this(name, 1, hpMax, passo);
    }
    public Druid (String name, int liv, int hpMax) {
        this(name,liv, hpMax, getPassoHpEroi());
    }
    public Druid (String name, int hpMax) {
        this(name,1, hpMax, getPassoHpEroi());
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
