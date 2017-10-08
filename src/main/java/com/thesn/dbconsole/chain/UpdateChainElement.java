package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

public class UpdateChainElement extends AbstractChainElement {

    public UpdateChainElement(final ChainElement element) {
        super(element);
    }

    public UpdateChainElement(final Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void executeStatement(final Statement statement) throws SQLException {
        statement.executeUpdate(getQuery());
        System.out.println("Data was successfully updated");
    }

    @Override
    public String toString() {
        return "update";
    }
}
