package com.thesn.dbconsole;


import com.thesn.dbconsole.configuration.Argument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigurationTest {
    String dbLocationControl = "--connection=jdbc:mysql://localhost:3306/my_database";
    String passControl = "--password=pass";
    String loginControl = "--login=login";
    String queryControl = "--query=query";
    String[] args = {dbLocationControl, passControl, loginControl,queryControl};

    CommandInterface commandInterface = new CommandInterface(args);


    @Test
    void consoleTest() {

        assertAll("properties",
                () -> {

                    commandInterface.extractConfiguration().put(Argument.CONNECTION, dbLocationControl);
                    String dbLocation = commandInterface.extractConfiguration().get(Argument.CONNECTION);
                    assertEquals(dbLocationControl,"--connection=" + dbLocation);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.PASSWORD, passControl);
                    String pass = commandInterface.extractConfiguration().get(Argument.PASSWORD);
                    assertEquals(passControl,"--password=" + pass);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.LOGIN, loginControl);
                    String login = commandInterface.extractConfiguration().get(Argument.LOGIN);
                    assertEquals(loginControl,"--login=" + login);
                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.QUERY, queryControl);
                    String query = commandInterface.extractConfiguration().get(Argument.QUERY);
                    assertEquals(queryControl, "--query=" + query);
                }


        );

    }
}
