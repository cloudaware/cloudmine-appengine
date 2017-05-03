package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * App Engine Routing.
 * <p>
 * For more information about services, versions, and instances see [An Overview of App
 * Engine](https://cloud.google.com/appengine/docs/python/an-overview-of-app-engine) and
 * [Microservices Architecture on Google App Engine](https://cloud.google.com/appengine/docs/python
 * /microservices-on-app-engine).
 * <p>
 * Note: The routing for some queues or tasks which were not created using the Cloud Tasks API may
 * not be parsable into AppEngineRouting. For example, if numeric version names are used, then urls
 * such as `123.my-service.appspot.com` are ambiguous because `123` can be interpretted as a version
 * or instance number. See [here](https://cloud.google.com/appengine/docs/python/how-requests-are-
 * routed#soft_routing) for more information. If the routing is unparsable, AppEngineRouting will be
 * empty; the routing information can be viewed in the HOST header in AppEngineQueueConfig.headers
 * and AppEngineTaskTarget.headers.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AppEngineRouting {

    /**
     * App instance.
     * <p>
     * By default, the task will be sent to an instance which is available when the task is attempted.
     * <p>
     * Requests can only be sent to a specific instance if basic or manual scaling is used. For more
     * information see [here](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes).
     * The value may be {@code null}.
     */

    private String instance;

    /**
     * App service.
     * <p>
     * By default, the task will be sent to the service which is the default service when the task is
     * attempted ("default").
     * The value may be {@code null}.
     */

    private String service;

    /**
     * App version.
     * <p>
     * Version names should begin with a letter, to distinguish them from numeric instances in the app
     * URL; for more information see [here](https://cloud.google.com/appengine/docs/python/how-
     * requests-are-routed#soft_routing).
     * <p>
     * By default, the task will be sent to the version which is the default version when the task is
     * attempted ("default").
     * The value may be {@code null}.
     */

    private String version;

    /**
     * App instance.
     * <p>
     * By default, the task will be sent to an instance which is available when the task is attempted.
     * <p>
     * Requests can only be sent to a specific instance if basic or manual scaling is used. For more
     * information see [here](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes).
     *
     * @return value or {@code null} for none
     */
    public String getInstance() {
        return instance;
    }

    /**
     * App instance.
     * <p>
     * By default, the task will be sent to an instance which is available when the task is attempted.
     * <p>
     * Requests can only be sent to a specific instance if basic or manual scaling is used. For more
     * information see [here](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes).
     *
     * @param instance instance or {@code null} for none
     */
    public AppEngineRouting setInstance(final String instance) {
        this.instance = instance;
        return this;
    }

    /**
     * App service.
     * <p>
     * By default, the task will be sent to the service which is the default service when the task is
     * attempted ("default").
     *
     * @return value or {@code null} for none
     */
    public String getService() {
        return service;
    }

    /**
     * App service.
     * <p>
     * By default, the task will be sent to the service which is the default service when the task is
     * attempted ("default").
     *
     * @param service service or {@code null} for none
     */
    public AppEngineRouting setService(final String service) {
        this.service = service;
        return this;
    }

    /**
     * App version.
     * <p>
     * Version names should begin with a letter, to distinguish them from numeric instances in the app
     * URL; for more information see [here](https://cloud.google.com/appengine/docs/python/how-
     * requests-are-routed#soft_routing).
     * <p>
     * By default, the task will be sent to the version which is the default version when the task is
     * attempted ("default").
     *
     * @return value or {@code null} for none
     */
    public String getVersion() {
        return version;
    }

    /**
     * App version.
     * <p>
     * Version names should begin with a letter, to distinguish them from numeric instances in the app
     * URL; for more information see [here](https://cloud.google.com/appengine/docs/python/how-
     * requests-are-routed#soft_routing).
     * <p>
     * By default, the task will be sent to the version which is the default version when the task is
     * attempted ("default").
     *
     * @param version version or {@code null} for none
     */
    public AppEngineRouting setVersion(final String version) {
        this.version = version;
        return this;
    }

}
