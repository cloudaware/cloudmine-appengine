package com.cloudaware.cloudmine.appengine;

import com.google.appengine.api.utils.SystemProperty;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

/**
 * User: urmuzov
 * Date: 17.09.14
 * Time: 20:48
 */
public class WarModule extends ServletModule {
    @Override
    protected void configureServlets() {
        this.bind(com.google.api.control.ServiceManagementConfigFilter.class).in(Singleton.class);
        this.filter("/_ah/api/*").through(com.google.api.control.ServiceManagementConfigFilter.class);
        this.bind(com.google.api.control.extensions.appengine.GoogleAppEngineControlFilter.class).in(Singleton.class);
        this.filter("/_ah/api/*").through(
                com.google.api.control.extensions.appengine.GoogleAppEngineControlFilter.class,
                ImmutableMap.of(
                        "endpoints.projectId", System.getenv("ENDPOINTS_PROJECT_ID") != null ? System.getenv("ENDPOINTS_PROJECT_ID") : SystemProperty.applicationId.get(),
                        "endpoints.serviceName", System.getenv("ENDPOINTS_SERVICE_NAME")
                )
        );
    }
}
