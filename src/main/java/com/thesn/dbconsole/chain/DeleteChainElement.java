package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteChainElement extends AbstractChainElement {

    public DeleteChainElement(final ChainElement element) {
        super(element);
    }

    public DeleteChainElement(final Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void executeStatement(final Statement statement) throws SQLException {
        statement.execute(getQuery());
        System.out.println("Data was successfully deleted");
    }

    @Override
    public String toString() {
        return "delete";
    }
}
