package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Argument;
import com.thesn.dbconsole.configuration.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractChainElement implements ChainElement {

    private final Configuration configuration;
    private final ConnectionSupplier connectionSupplier;
    private ChainElement element;

    AbstractChainElement(final ChainElement element) {
        this(element.getConfiguration());
        this.element = element;
    }

    AbstractChainElement(final Configuration configuration) {
        this.configuration = configuration;
        this.connectionSupplier = new ConnectionSupplier(configuration);
    }

    @Override
    public void process() {
        if (element != null) {
            element.process();
        }

        if (needProcess()) {
            try (Connection dbConnection = connectionSupplier.supply();
                 Statement statement = dbConnection.createStatement()) {

                executeStatement(statement);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    String getQuery() {
        return getConfiguration().get(Argument.QUERY).trim();
    }

    @Override
    public boolean needProcess() {
        return getQuery().toLowerCase().contains(toString() + " ");
    }

    protected abstract void executeStatement(final Statement statement) throws SQLException;

    @Override
    public abstract String toString();
}
