import utility.TrainingCamp;

public class App {
    public static void main(String[] args) throws Exception {
        TrainingCamp ColosseoDeiFolli = new TrainingCamp();
        ColosseoDeiFolli.aggiungi("warrior", "Sartorius", 99);
        ColosseoDeiFolli.aggiungi("mage", "Rudeus Greyrat");
        ColosseoDeiFolli.aggiungi("monk", "Minulost");
        ColosseoDeiFolli.aggiungi("mage", "Thokk Strauss");
        ColosseoDeiFolli.aggiungi("Druid", "Silvester Stallone", 35);

        ColosseoDeiFolli.giornoAllenamento();
        ColosseoDeiFolli.giornoAllenamento();
        // ColosseoDeiFolli.registro.stream().filter(n -> n.nome.equals("Silvester Stallone")).findFirst().orElse(null).allena();
        // ripasso brevissimo dei predicati e degli stream, ci tornerò in seguito ma non ricordavo niente



        ColosseoDeiFolli.recap();
    }
}
