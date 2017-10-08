package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.thesn.dbconsole.configuration.Argument.CONNECTION;
import static com.thesn.dbconsole.configuration.Argument.LOGIN;
import static com.thesn.dbconsole.configuration.Argument.PASSWORD;

public class Connector {
    private Configuration configuration;

    public Connector(final Configuration configuration) {
        this.configuration = configuration;
    }

    public Connection supplyConnection() {
        Connection connection;
        try {
            registerDriver();
            connection = DriverManager.getConnection(
                    configuration.get(CONNECTION),
                    configuration.get(LOGIN),
                    configuration.get(PASSWORD)
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private void registerDriver() throws ClassNotFoundException {
        String uri = configuration.get(CONNECTION);

        String driverName;

        if (uri.toLowerCase().contains("mysql")) {
            driverName = "com.mysql.jdbc.Driver";
        } else if (uri.toLowerCase().contains("postgresql")) {
            driverName = "org.postgresql.Driver";
        } else {
            throw new UnsupportedOperationException("Program supports mysql and postresql drivers only.");
        }

        Class.forName(driverName);
    }

}
