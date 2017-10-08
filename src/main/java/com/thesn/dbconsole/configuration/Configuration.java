package com.thesn.dbconsole.configuration;

public interface Configuration {

    String get(Argument argument);

    void put(Argument argument, String value);

    void put(String argument, String value);
}
