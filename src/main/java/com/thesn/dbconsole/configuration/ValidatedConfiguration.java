package com.thesn.dbconsole.configuration;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ValidatedConfiguration implements Configuration {

    private final Configuration configuration;

    private boolean checked;

    public ValidatedConfiguration(final Configuration configuration) {
        this.configuration = configuration;
        this.checked = false;
    }

    @Override
    public String get(final Argument argument) {
        if (!checked) {
            validateState();
        }
        return configuration.get(argument);
    }

    @Override
    public void put(final Argument argument, final String value) {
        configuration.put(argument, value);
    }

    @Override
    public void put(final String argument, final String value) {
        configuration.put(argument, value);
    }


    private void validateState() {
        List<Argument> absentArguments = Arrays.stream(Argument.values())
                .filter(a -> configuration.get(a) == null)
                .collect(toList());

        if (!absentArguments.isEmpty()) {
            throw new RuntimeException(
                    "All required arguments must be filled! You should set these ones: " + absentArguments.toString()
            );
        }

        if (configuration.get(Argument.QUERY).contains(";")) {
            throw new UnsupportedOperationException("Several queries with ';' delimiter are unsupported now");
        }

        checked = true;
    }
}
