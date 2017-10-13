package com.thesn.dbconsole;


import com.thesn.dbconsole.configuration.Argument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigurationTest {
    String dbLocationControl = "jdbc:mysql://localhost:3306/my_database";
    String passControl = "pass";
    String loginControl = "login";
    String queryControl = "query";
    String[] args = new String[4];

    CommandInterface commandInterface = new CommandInterface(args);


    @Test
    void consoleTest() {

        assertAll("properties",
                () -> {

                    commandInterface.extractConfiguration().put(Argument.CONNECTION, dbLocationControl);
                    String dbLocation = commandInterface.extractConfiguration().get(Argument.CONNECTION);
                    assertEquals(dbLocation, dbLocationControl);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.PASSWORD, passControl);
                    String pass = commandInterface.extractConfiguration().get(Argument.PASSWORD);
                    assertEquals(pass, passControl);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.LOGIN, loginControl);
                    String login = commandInterface.extractConfiguration().get(Argument.LOGIN);
                    assertEquals(login, loginControl);
                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.QUERY, queryControl);
                    String query = commandInterface.extractConfiguration().get(Argument.QUERY);
                    assertEquals(query, loginControl);
                }


        );

    }
}
