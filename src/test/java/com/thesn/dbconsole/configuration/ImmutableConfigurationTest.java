package com.thesn.dbconsole.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImmutableConfigurationTest {

    Configuration ic = new ImmutableConfiguration(new Stub());

    @Test
    void AssertThatWeCanGetSomethingFromStub() {

        assertEquals("Nothing", ic.get(Argument.PASSWORD));
    }

    @Test
    void AssertThatWeCannotMutateImmutableInstance() {

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            ic.put("string1", "string2");
        });
        assertEquals("Cannot mutate immutable instance", exception.getMessage());
    }

    @Test
    void AssertThatWeCannotMutateImmutableInstanceAnotherInput() {

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            ic.put(Argument.PASSWORD, "string2");
        });
        assertEquals("Cannot mutate immutable instance", exception.getMessage());
    }

    class Stub implements Configuration {
        public String get(Argument argument) {
            return "Nothing";
        }

        public void put(String string, String string1) {

        }

        public void put(Argument argument, String string) {

        }

    }

}