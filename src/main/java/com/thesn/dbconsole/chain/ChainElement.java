package com.thesn.dbconsole.chain;

import com.thesn.dbconsole.configuration.Configuration;

public interface ChainElement {

    void process();

    Configuration getConfiguration();

    boolean needProcess();

}
