package com.thesn.dbconsole;

import com.thesn.dbconsole.chain.*;
import com.thesn.dbconsole.configuration.ImmutableConfiguration;
import com.thesn.dbconsole.configuration.ValidatedConfiguration;

public class Main {

    public static void main(final String[] args) {

        //It isn't Pyramid of Doom, it's Mount Olympus :)

        new SelectChainElement(
                new UpdateChainElement(
                        new CreateChainElement(
                                new InsertChainElement(
                                        new DeleteChainElement(
                                                new ImmutableConfiguration(
                                                        new ValidatedConfiguration(
                                                                new CommandInterface(args)
                                                                        .extractConfiguration()
                                                        )
                                                )
                                        )
                                )
                        )
                )
        ).process();

    }

}
