package com.thesn.dbconsole.configuration;

public enum Argument {
    CONNECTION("connection"),
    QUERY("query"),
    LOGIN("login"),
    PASSWORD("password"),
    SEPARATOR("separator");

    private final String value;

    Argument(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
