package enums;

public enum WeaponType {
    SWORD("Spada"),
    MACE("Mazza"),
    BOW("Arco"),
    CROSSBOW("Balestra"),
    DAGGER("Pugnale"),
    STAFF("Scettro"),
    AXE("Ascia"),
    FLAIL("Flagello"),
    KNUCKLES("Tirapugni"),
    GUN("Arma da fuoco");

    private final String displayName;

    WeaponType(String displayName) { //sono privati di default negli enum
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
