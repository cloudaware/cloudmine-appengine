package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2;


/**
 * App Engine Routing.
 *
 * Specifies the target URI. Since this target type dispatches tasks to secure app handlers,
 * unsecure app handlers, and URIs restricted with [`login:
 * admin`](https://cloud.google.com/appengine/docs/standard/python/config/appref) the protocol (for
 * example, HTTP or HTTPS) cannot be explictly specified. Task dispatches do not follow redirects
 * and cannot target URI paths restricted with [`login:
 * required`](https://cloud.google.com/appengine/docs/standard/python/config/appref) because tasks
 * are not run as any user.
 *
 * For more information about services, versions, and instances see [An Overview of App
 * Engine](https://cloud.google.com/appengine/docs/python/an-overview-of-app-engine), [Microservices
 * Architecture on Google App Engine](https://cloud.google.com/appengine/docs/python/microservices-
 * on-app-engine), [App Engine Standard request
 * routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed), and
 * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-
 * requests-are-routed).
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AppEngineRouting  {

    /**
     * Output only. The host that the task is sent to.
     *
     * The host is constructed from the domain name of the app associated with the queue's project ID
     * (for example .appspot.com), and the service, version, and instance. Tasks which were created
     * using the App Engine SDK might have a custom domain name.
     *
     * For more information, see [How Requests are
     * Routed](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed).
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String host;

    /**
     * App instance.
     *
     * By default, the task is sent to an instance which is available when the task is attempted.
     *
     * Requests can only be sent to a specific instance if [manual scaling is used in App Engine
     * Standard](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes). App Engine Flex does not support
     * instances. For more information, see [App Engine Standard request
     * routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and
     * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-
     * requests-are-routed).
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String instance;

    /**
     * App service.
     *
     * By default, the task is sent to the service which is the default service when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String service;

    /**
     * App version.
     *
     * By default, the task is sent to the version which is the default version when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String version;

    /**
     * Output only. The host that the task is sent to.
     *
     * The host is constructed from the domain name of the app associated with the queue's project ID
     * (for example .appspot.com), and the service, version, and instance. Tasks which were created
     * using the App Engine SDK might have a custom domain name.
     *
     * For more information, see [How Requests are
     * Routed](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed).
     * @return value or {@code null} for none
     */
    public String getHost() {
        return host;
    }

    /**
     * Output only. The host that the task is sent to.
     *
     * The host is constructed from the domain name of the app associated with the queue's project ID
     * (for example .appspot.com), and the service, version, and instance. Tasks which were created
     * using the App Engine SDK might have a custom domain name.
     *
     * For more information, see [How Requests are
     * Routed](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed).
     * @param host host or {@code null} for none
     */
    public AppEngineRouting setHost(String host) {
        this.host = host;
        return this;
    }

    /**
     * App instance.
     *
     * By default, the task is sent to an instance which is available when the task is attempted.
     *
     * Requests can only be sent to a specific instance if [manual scaling is used in App Engine
     * Standard](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes). App Engine Flex does not support
     * instances. For more information, see [App Engine Standard request
     * routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and
     * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-
     * requests-are-routed).
     * @return value or {@code null} for none
     */
    public String getInstance() {
        return instance;
    }

    /**
     * App instance.
     *
     * By default, the task is sent to an instance which is available when the task is attempted.
     *
     * Requests can only be sent to a specific instance if [manual scaling is used in App Engine
     * Standard](https://cloud.google.com/appengine/docs/python/an-overview-of-app-
     * engine?hl=en_US#scaling_types_and_instance_classes). App Engine Flex does not support
     * instances. For more information, see [App Engine Standard request
     * routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and
     * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-
     * requests-are-routed).
     * @param instance instance or {@code null} for none
     */
    public AppEngineRouting setInstance(String instance) {
        this.instance = instance;
        return this;
    }

    /**
     * App service.
     *
     * By default, the task is sent to the service which is the default service when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * @return value or {@code null} for none
     */
    public String getService() {
        return service;
    }

    /**
     * App service.
     *
     * By default, the task is sent to the service which is the default service when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * @param service service or {@code null} for none
     */
    public AppEngineRouting setService(String service) {
        this.service = service;
        return this;
    }

    /**
     * App version.
     *
     * By default, the task is sent to the version which is the default version when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * @return value or {@code null} for none
     */
    public String getVersion() {
        return version;
    }

    /**
     * App version.
     *
     * By default, the task is sent to the version which is the default version when the task is
     * attempted.
     *
     * For some queues or tasks which were created using the App Engine Task Queue API, host is not
     * parsable into service, version, and instance. For example, some tasks which were created using
     * the App Engine SDK use a custom domain name; custom domains are not parsed by Cloud Tasks. If
     * host is not parsable, then service, version, and instance are the empty string.
     * @param version version or {@code null} for none
     */
    public AppEngineRouting setVersion(String version) {
        this.version = version;
        return this;
    }


}

