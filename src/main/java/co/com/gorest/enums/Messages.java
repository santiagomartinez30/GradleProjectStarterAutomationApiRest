package co.com.gorest.enums;

public enum Messages {
    USER_NOT_EXISTING("Resource not found");

    private final String value;

    Messages(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }
}
