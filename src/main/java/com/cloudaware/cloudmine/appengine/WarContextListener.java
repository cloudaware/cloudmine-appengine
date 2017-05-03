package com.cloudaware.cloudmine.appengine;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class WarContextListener extends com.google.inject.servlet.GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new GuiceSssModule(),
                new WarModule()
        );
    }

}
