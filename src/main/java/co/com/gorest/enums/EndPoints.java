package co.com.gorest.enums;

public enum EndPoints {

    USER_FOR_ID("public/v2/users/"),
    USERS ("public/v2/users");

    private final String value;

    EndPoints(String value) {
        this.value = value;
    }

    public String resource() {
        return value;
    }
}
