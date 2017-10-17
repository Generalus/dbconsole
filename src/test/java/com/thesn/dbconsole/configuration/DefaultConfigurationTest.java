package com.thesn.dbconsole.configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultConfigurationTest {

    static Configuration defaultConfiguration = new DefaultConfiguration();

    @BeforeAll
    static void setUp() {

        defaultConfiguration.put(Argument.SEPARATOR, "TEST");
        defaultConfiguration.put("connection", "connection");

    }


    @Test
    void assertThatAddedArgumentIsNotSupported() {

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            defaultConfiguration.put("TEST_KEY", "TEST_VALUE");
        });
        assertEquals("Argument TEST_KEY is not supported now!", exception.getMessage());

    }


    @Test
    void assertThatArgumentAdded() {

        assertEquals("TEST", defaultConfiguration.get(Argument.SEPARATOR));
    }

    @Test
    void assertThatArgumentWithStringParametersAdded() {

        assertEquals("connection", defaultConfiguration.get(Argument.CONNECTION));


    }

}