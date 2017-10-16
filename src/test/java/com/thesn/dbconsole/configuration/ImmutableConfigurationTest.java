package com.thesn.dbconsole.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImmutableConfigurationTest {

    ImmutableConfiguration ic = new ImmutableConfiguration(new ImmutableConfigurationStub());

    @Test
    void get() {

        assertEquals("my stubbed return", ic.get(Argument.PASSWORD));
    }

    @Test
    void put() {

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            ic.put("string1", "string2");
        });
        assertEquals("Cannot mutate immutable instance", exception.getMessage());
    }

    @Test
    void put1() {

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            ic.put(Argument.PASSWORD, "string2");
        });
        assertEquals("Cannot mutate immutable instance", exception.getMessage());
    }

    class ImmutableConfigurationStub implements Configuration {
        public String get(Argument argument) {
            return "my stubbed return";
        }

        public void put(String string, String string1) {

        }

        public void put(Argument argument, String string) {

        }

    }

}