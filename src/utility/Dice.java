package utility;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    // Tira un singolo dado (es. roll(20) -> da 1 a 20)
    public static int roll(int facce) {
        if (facce <= 0)
            return 0;
        return ThreadLocalRandom.current().nextInt(1, facce + 1);
    }

    // Tira N dadi e somma i risultati (es. roll(3, 6) -> 3d6)
    public static int roll(int quantita, int facce) {
        int totale = 0;
        for (int i = 0; i < quantita; i++) {
            totale += roll(facce);
        }
        return totale;
    }

    // Tira con Vantaggio (tira 2 volte e tiene il più alto, stile D&D 5e)
    public static int rollConVantaggio(int facce) {
        return Math.max(roll(facce), roll(facce));
    }

    // Tira con Svantaggio (tira 2 volte e tiene il più basso)
    public static int rollConSvantaggio(int facce) {
        return Math.min(roll(facce), roll(facce));
    }
}
