package utility;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import interfaces.Trainable;

public class TrainingCamp {

    private List<Trainable> trainingList = new ArrayList<>();

    public void addHero(String classeIn, String name, int liv){
        try {
            String namePulito = classeIn.substring(0,1).toUpperCase() + classeIn.substring(1); //prima lettera maiusc, il resto normale
            String percorso   = "models."+namePulito;

            //cerca la classe in base al percorso
            Class<?> classe = Class.forName(percorso);

            //estrae il costruttore
            Constructor<?> costruttore = classe.getConstructor(String.class, int.class);
            //string.class e int.class sono CLASS LITERAL, i concetti stessi di String e int
            //"cerca un costruttore che prende una Stringa e un int"

            //cast a Trainable, per farlo stare nella lista
            Trainable nuovoEroe = (Trainable) costruttore.newInstance(name, liv);

            //lo posso finalmente aggiungere al trainingList
            trainingList.add(nuovoEroe);
            System.out.println("nuovo "+namePulito+" aggiunto al trainingList del campo di addestramento!");

        } catch (ClassNotFoundException e) {
            System.out.println("la classe dell'eroe "+classeIn+"non esiste nel package models.");
        } catch (NoSuchMethodException e) {
            System.out.println("la classe "+classeIn+"non ha un costruttore che accetta (String, int)");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dinamica "+e.getMessage());
        }
    }

    public void addHero(String classeIn, String name) {
        try {
            String namePulito = classeIn.substring(0, 1).toUpperCase() + classeIn.substring(1); // prima lettera maiusc, il resto normale
            String percorso = "models." + namePulito;

            // cerca la classe in base al percorso
            Class<?> classe = Class.forName(percorso);

            // estrae il costruttore
            Constructor<?> costruttore = classe.getConstructor(String.class);
            // string.class è un CLASS LITERAL, il concetto stesso di String
            // "cerca un costruttore che prende una Stringa"

            // cast a Trainable, per farlo stare nella lista
            Trainable nuovoEroe = (Trainable) costruttore.newInstance(name);

            // lo posso finalmente aggiungere al trainingList
            trainingList.add(nuovoEroe);
            System.out.println("nuovo " + namePulito + " aggiunto al trainingList del campo di addestramento!");

        } catch (ClassNotFoundException e) {
            System.out.println("la classe dell'eroe " + classeIn + "non esiste nel package models.");
        } catch (NoSuchMethodException e) {
            System.out.println("la classe " + classeIn + "non ha un costruttore che accetta (String, int)");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dinamica " + e.getMessage());
        }
    }

    public void trainingDay () {
        for (Trainable t: trainingList) {
            t.train();
        }
    }

    public void recap () {
        for (Trainable t: trainingList) {
            System.out.println(t.toString());
        }
    }
}
