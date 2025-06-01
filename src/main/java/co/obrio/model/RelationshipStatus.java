package co.obrio.model;

public enum RelationshipStatus {
    SINGLE("Single"),
    IN_RELATIONSHIP("In relationship"),
    COHABITANTS("Cohabitants"),
    ENGAGED("Engaged"),
    MARRIED("Married"),
    SEPARATED("Separated"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    COMPLICATED("Complicated");

    private final String displayName;

    RelationshipStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}