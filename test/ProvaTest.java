import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProvaTest { 
    // ARRANGE: crea oggetti del mio programma in una situazione specifica
    // ACT    : invoca un metodo o prova a effettuare un'azione
    // ASSERT : assertEquals(valore atteso, valore reale) per verificare che risponda come previsto

    @Test
    void primoTestFunzionante() {
        assertEquals(4, 2 + 2);
    }
}
