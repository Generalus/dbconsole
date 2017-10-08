package com.thesn.dbconsole.configuration;

public class ImmutableConfiguration implements Configuration {

    private final Configuration configuration;

    public ImmutableConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String get(final Argument argument) {
        return configuration.get(argument);
    }

    @Override
    public void put(final Argument argument, final String value) {
        throw new UnsupportedOperationException("Cannot mutate immutable instance");
    }

    @Override
    public void put(final String argument, final String value) {
        throw new UnsupportedOperationException("Cannot mutate immutable instance");
    }

}
