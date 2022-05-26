package co.com.gorest.enums;

public enum Values {
    CREATE_USER_EXISTING("existentes"),
    NEW_NAME_USER("Andres Modificado"),
    NEW_STATUS_USER("inactive"),
    BODY_EMPTY("");


    private final String value;

    Values(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }
}
