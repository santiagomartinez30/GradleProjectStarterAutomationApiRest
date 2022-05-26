package co.com.gorest.enums;

public enum Token {

    ACCES_TOKEN("4c5a38d4124f96fcb28866395e267e2d0a15133f761e5f6dcd21de2665416f4b");

    private final String value;

    Token(String value) {
        this.value = value;
    }

    public String message() {
        return value;
    }
}
