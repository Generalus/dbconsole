package com.thesn.dbconsole;

import com.thesn.dbconsole.configuration.Argument;
import com.thesn.dbconsole.configuration.Configuration;
import com.thesn.dbconsole.configuration.DefaultConfiguration;
import org.apache.commons.cli.*;

import java.io.Console;
import java.util.Scanner;


public final class CommandInterface {

    private final String[] arguments;

    public CommandInterface(final String[] arguments) {
        this.arguments = arguments;
    }


    public Configuration extractConfiguration() {
        Options options = new Options();
        options.addOption("h", "help", false, "Print available commands");
        options.addOption("c", "connection", true, "Database coordinates");
        options.addOption("q", "query", true, "Single SQL query");
        options.addOption("l", "login", true, "User login for the database");
        options.addOption("p", "password", true, "User password for the database");
        options.addOption("s", "separator", true, "Separator for table's columns. Default is ' | '");

        CommandLineParser parser = new DefaultParser();

        CommandLine commandLine;

        Configuration configuration = new DefaultConfiguration();

        try {

            commandLine = parser.parse(options, arguments);

            if (commandLine.hasOption("h")) {
                help(options);
            }

            if (!commandLine.hasOption("p")) {
                configuration.put(Argument.PASSWORD, askForPasswordIfNotPassed());
            }

            configuration.put(
                    Argument.SEPARATOR,
                    commandLine.hasOption("s") ? commandLine.getOptionValue("s") : " | "
            );

            for (Option option : commandLine.getOptions()) {
                configuration.put(
                        option.getLongOpt(),
                        option.getValue()
                );
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return configuration;
    }

    private static String askForPasswordIfNotPassed() {
        Console console = System.console();
        if (console == null) {
            System.err.println("Couldn't get Console instance");
            System.exit(0);
        }
        return new String(console.readPassword("Enter DB password: "));
    }

    private void help(final Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", options);  // what "Main" is?
        System.exit(0);
    }
}
