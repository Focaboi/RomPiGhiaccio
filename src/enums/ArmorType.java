package enums;

public enum ArmorType {
    LIGHT("leggera"),
    MEDIUM("media"),
    HEAVY("pesante"),
    SPECIAL("speciale");

    private final String displayName;
    
    ArmorType (String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName () {
        return displayName;
    }
}
