package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertChainElement extends AbstractChainElement {

    public InsertChainElement(final ChainElement element) {
        super(element);
    }

    public InsertChainElement(final Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void executeStatement(final Statement statement) throws SQLException {
        statement.executeUpdate(getQuery());
        System.out.println("Data was successfully updated");
    }

    @Override
    public String toString() {
        return "insert";
    }
}
