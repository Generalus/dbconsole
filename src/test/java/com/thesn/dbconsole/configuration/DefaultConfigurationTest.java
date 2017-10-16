package com.thesn.dbconsole.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultConfigurationTest {


    DefaultConfiguration defaultConfiguration = new DefaultConfiguration();


    @Test
    void put1() {


        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            defaultConfiguration.put("TEST_KEY", "TEST_VALUE");
        });
        assertEquals("Argument TEST_KEY is not supported now!", exception.getMessage());

        defaultConfiguration.put("connection", "connection");
        assertEquals("connection", defaultConfiguration.get(Argument.CONNECTION));


    }

    @Test
    void get() {

        defaultConfiguration.put(Argument.SEPARATOR, "TEST");
        defaultConfiguration.get(Argument.SEPARATOR);
        assertEquals("TEST", defaultConfiguration.get(Argument.SEPARATOR));
        assertNotNull(defaultConfiguration.get(Argument.SEPARATOR));

    }

    @Test
    void put() {
        defaultConfiguration.put(Argument.PASSWORD, "TEST");
        assertEquals("TEST", defaultConfiguration.get(Argument.PASSWORD));
        assertNotNull(defaultConfiguration.get(Argument.PASSWORD));

    }

}