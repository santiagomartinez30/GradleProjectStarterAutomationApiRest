package co.com.gorest.enums;

public enum Keys {
    USER("Datos del usuario"),
    ID_USER_TO_ELIMINATED("Id del usuario a eliminar");

    private final String text;

    Keys(String text) {
        this.text = text;
    }

    public String value() {
        return text;
    }
}
