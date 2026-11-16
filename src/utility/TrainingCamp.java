package utility;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Trainable;

public class TrainingCamp {

    private List<Trainable> registro = new ArrayList<>();

    public void aggiungi(String classeIn, String nome, int liv){
        try {
            String nomePulito = classeIn.substring(0,1).toUpperCase() + classeIn.substring(1); //prima lettera maiusc, il resto normale
            String percorso   = "models."+nomePulito;

            //cerca la classe in base al percorso
            Class<?> classe = Class.forName(percorso);

            //estrae il costruttore
            Constructor<?> costruttore = classe.getConstructor(String.class, int.class);
            //string.class e int.class sono CLASS LITERAL, i concetti stessi di String e int
            //"cerca un costruttore che prende una Stringa e un int"

            //cast a Trainable, per farlo stare nella lista
            Trainable nuovoEroe = (Trainable) costruttore.newInstance(nome, liv);

            //lo posso finalmente aggiungere al registro
            registro.add(nuovoEroe);
            System.out.println("nuovo "+nomePulito+" aggiunto al registro del campo di addestramento!");

        } catch (ClassNotFoundException e) {
            System.out.println("la classe dell'eroe "+classeIn+"non esiste nel package models.");
        } catch (NoSuchMethodException e) {
            System.out.println("la classe "+classeIn+"non ha un costruttore che accetta (String, int)");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dinamica "+e.getMessage());
        }
    }

    public void aggiungi(String classeIn, String nome) {
        try {
            String nomePulito = classeIn.substring(0, 1).toUpperCase() + classeIn.substring(1); // prima lettera maiusc, il resto normale
            String percorso = "models." + nomePulito;

            // cerca la classe in base al percorso
            Class<?> classe = Class.forName(percorso);

            // estrae il costruttore
            Constructor<?> costruttore = classe.getConstructor(String.class);
            // string.class è un CLASS LITERAL, il concetto stesso di String
            // "cerca un costruttore che prende una Stringa"

            // cast a Trainable, per farlo stare nella lista
            Trainable nuovoEroe = (Trainable) costruttore.newInstance(nome);

            // lo posso finalmente aggiungere al registro
            registro.add(nuovoEroe);
            System.out.println("nuovo " + nomePulito + " aggiunto al registro del campo di addestramento!");

        } catch (ClassNotFoundException e) {
            System.out.println("la classe dell'eroe " + classeIn + "non esiste nel package models.");
        } catch (NoSuchMethodException e) {
            System.out.println("la classe " + classeIn + "non ha un costruttore che accetta (String, int)");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dinamica " + e.getMessage());
        }
    }

    public void giornoAllenamento () {
        for (Trainable t: registro) {
            t.allena();
        }
    }

    public void recap () {
        for (Trainable t: registro) {
            System.out.println(t.toString());
        }
    }
}
