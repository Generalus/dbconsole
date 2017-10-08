package com.thesn.dbconsole.configuration;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public final class DefaultConfiguration implements Configuration {

    private final Map<Argument, String> state;

    public DefaultConfiguration() {
        state = new EnumMap<>(Argument.class);
    }

    public String get(final Argument argument) {
        return state.get(argument);
    }

    public void put(final Argument argument, final String value) {
        state.put(argument, value);
    }

    public void put(final String argument, final String value) {
        state.put(
                Arrays.stream(Argument.values())
                        .filter(v -> argument.equals(v.getValue()))
                        .findFirst()
                        .orElseThrow(
                                () -> new UnsupportedOperationException(
                                        String.format(
                                                "Argument %s is not supported now!",
                                                argument
                                        )
                                )
                        ),
                value
        );
    }
}
