package Enumerable;

public enum Faculty {

    CIENCIAS(1, "Ciencias"),
    CIENCIAS_ADMINISTRATIVAS(2, "Ciencias Administrativas"),
    CIVIL_Y_AMBIENTAL(3, "Civil y Ambiental"),
    MECANICA(4, "Mecánica"),
    QUIMICA(5, "Química"),
    SISTEMAS(6, "Sistemas");

    private final int value;
    private final String displayName;

    Faculty(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Faculty fromValue(int value) throws Exception {
        for (Faculty fa : values()) {
            if (fa.value == value) {
                return fa;
            }
        }
        throw new Exception("Facultad no encontrada");
    }
}
