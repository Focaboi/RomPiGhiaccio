import utility.TrainingCamp;

public class App {
    public static void main(String[] args) throws Exception {
        TrainingCamp ColosseoDeiFolli = new TrainingCamp();
        ColosseoDeiFolli.addHero("warrior", "Sartorius", 99);
        ColosseoDeiFolli.addHero("mage", "Rudeus Greyrat");
        ColosseoDeiFolli.addHero("monk", "Minulost");
        ColosseoDeiFolli.addHero("mage", "Thokk Strauss");
        ColosseoDeiFolli.addHero("Druid", "Silvester Stallone", 35);

        ColosseoDeiFolli.trainingDay();
        ColosseoDeiFolli.trainingDay();
        // ColosseoDeiFolli.trainingList.stream().filter(n -> n.name.equals("Silvester Stallone")).findFirst().orElse(null).train();
        // ripasso brevissimo dei predicati e degli stream, ci tornerò in seguito ma non ricordavo niente



        ColosseoDeiFolli.recap();
    }
}
