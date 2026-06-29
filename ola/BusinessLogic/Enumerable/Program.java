package Enumerable;

public enum Program {

    Ing_Computación(1, "Ing. Computación"),
    Ing_Software(2, "Ing. Software"),
    Ing_Sistemas(3, "Ing. Sistemas"),
    Ing_Ciencia_de_Datos(4, "Ing. Ciencia de Datos"),
    Ing_Quimica(5, "Ing. Química"),
    Ing_Agroindustria(6, "Ing. Agroindustria"),
    Ing_Mecanica(7, "Ing. Mecánica"),
    Ing_Mecatronica(8, "Ing. Mecatrónica"),
    Ing_Materiales(9, "Ing. Materiales"),
    Ing_Civil(10, "Ing. Civil"),
    Ing_Ambiental(11, "Ing. Ambiental"),
    Matematica(12, "Matemática"),
    Física(13, "Física"),
    Economia(14, "Economía"),
    Administración_de_Empresas(15, "Administración de Empresas");

    private final int value;
    private final String displayName;

    Program(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public static Program fromValue(int value) throws Exception {
        for (Program p : values()) {
            if (p.value == value) {
                return p;
            }
        }
        throw new Exception("Programa no encontrado");
    }
}
