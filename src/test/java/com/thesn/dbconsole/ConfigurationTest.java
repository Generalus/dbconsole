package com.thesn.dbconsole;


import com.thesn.dbconsole.configuration.Argument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigurationTest {
    String expectedDbLocation = "--connection=jdbc:mysql://localhost:3306/my_database";
    String expectedPassword = "--password=pass";
    String expectedLogin = "--login=login";
    String expectedQuery = "--query=query";
    String[] args = {expectedDbLocation, expectedLogin, expectedPassword,expectedQuery};

    CommandInterface commandInterface = new CommandInterface(args);


    @Test
    void consoleTest() {

        assertAll("properties",
                () -> {

                    commandInterface.extractConfiguration().put(Argument.CONNECTION, expectedDbLocation);
                    String dbLocation = commandInterface.extractConfiguration().get(Argument.CONNECTION);
                    assertEquals(expectedDbLocation,"--connection=" + dbLocation);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.PASSWORD, expectedPassword);
                    String pass = commandInterface.extractConfiguration().get(Argument.PASSWORD);
                    assertEquals(expectedPassword,"--password=" + pass);

                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.LOGIN, expectedLogin);
                    String login = commandInterface.extractConfiguration().get(Argument.LOGIN);
                    assertEquals(expectedLogin,"--login=" + login);
                },
                () -> {
                    commandInterface.extractConfiguration().put(Argument.QUERY, expectedQuery);
                    String query = commandInterface.extractConfiguration().get(Argument.QUERY);
                    assertEquals(expectedQuery, "--query=" + query);
                }


        );

    }
}
