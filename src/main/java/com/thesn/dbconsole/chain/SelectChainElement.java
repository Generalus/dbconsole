package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Argument;
import com.thesn.dbconsole.configuration.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectChainElement extends AbstractChainElement {

    public SelectChainElement(final ChainElement element) {
        super(element);
    }

    public SelectChainElement(final Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void executeStatement(final Statement statement) throws SQLException {
        try (ResultSet result = statement.executeQuery(getQuery())) {
            String separator = getConfiguration().get(Argument.SEPARATOR);
            int columns = result.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                System.out.print(result.getMetaData().getColumnName(i));
                if (i != columns) {
                    System.out.print(separator);
                }
            }

            System.out.println();

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(result.getString(i));
                    if (i != columns) {
                        System.out.print(separator);
                    }
                }
                System.out.println();
            }
        }
    }

    @Override
    public String toString() {
        return "select";
    }
}
