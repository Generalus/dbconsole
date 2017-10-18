package com.thesn.dbconsole;


import com.thesn.dbconsole.configuration.Argument;
import com.thesn.dbconsole.configuration.DefaultConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurationTest {

    static DefaultConfiguration configuration = new DefaultConfiguration();
    String expectedPassword = "--password=pass";
    String expectedDbLocation = "--connection=jdbc:mysql://localhost:3306/my_database";
    String expectedLogin = "--login=login";
    String expectedQuery = "--query=query";

    @BeforeAll
    static void initAllFields() {


        configuration.put(Argument.PASSWORD, "--password=pass");
        configuration.put(Argument.CONNECTION, "--connection=jdbc:mysql://localhost:3306/my_database");
        configuration.put(Argument.LOGIN, "--login=login");
        configuration.put(Argument.QUERY, "--query=query");
    }

    @Test
    void dbLocationConfigurationTest() {


        assertEquals(expectedDbLocation, configuration.get(Argument.CONNECTION), "Connection test failed, please check connection properties");


    }


    @Test
    void dbPasswordConfigurationTest() {

        assertEquals(expectedPassword, configuration.get(Argument.PASSWORD), "Password test failed, please check password properties");

    }

    @Test
    void dbLoginConfigurationTest() {
        assertEquals(expectedLogin, configuration.get(Argument.LOGIN), "Login test failed, please check login properties");

    }


    @Test
    void dbQueryTest() {
        assertEquals(expectedQuery, configuration.get(Argument.QUERY), "Query test failed, please check Query properties");

    }
}
