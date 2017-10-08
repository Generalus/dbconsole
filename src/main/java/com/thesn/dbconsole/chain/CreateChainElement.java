package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateChainElement extends AbstractChainElement {

    public CreateChainElement(final ChainElement element) {
        super(element);
    }

    public CreateChainElement(final Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void executeStatement(final Statement statement) throws SQLException {
        statement.execute(getQuery());
        System.out.println("Data was successfully created");
    }

    @Override
    public String toString() {
        return "create";
    }
}
