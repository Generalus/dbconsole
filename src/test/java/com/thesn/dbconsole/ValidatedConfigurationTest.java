package com.thesn.dbconsole;

import com.thesn.dbconsole.configuration.Argument;
import com.thesn.dbconsole.configuration.ValidatedConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatedConfigurationTest {

    String expectedDbLocation = "--connection=jdbc:mysql://localhost:3306/my_database";
    String expectedPassword = "--password=pass";
    String expectedLogin = "--login=login";
    String expectedQuery = "--query=query";
    String[] args = {expectedDbLocation, expectedLogin, expectedPassword, expectedQuery};

    CommandInterface commandInterface = new CommandInterface(args);

    ValidatedConfiguration validatedConfiguration = new ValidatedConfiguration(commandInterface.extractConfiguration());


    @Test
    void validatedConfigurationTest() {


        assertAll("validated configuration",
                () ->
                    assertFalse(validatedConfiguration.get(Argument.QUERY).contains(";")),
                () ->
                    assertNotNull(validatedConfiguration.get(Argument.PASSWORD))
                );

    }

}








