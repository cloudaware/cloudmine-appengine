package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * App Engine task target.
 * <p>
 * This proto can only be used for tasks in a queue which has Queue.app_engine_queue_config set.
 * <p>
 * When creating this type of task target, the following scope must be used:
 * `https://www.googleapis.com/auth/cloud-platform`.
 * <p>
 * The task will be delivered to the URL specified by the AppEngineQueueConfig and
 * AppEngineTaskTarget in the App Engine app which belongs to the same project as the queue. See
 * [here](https://cloud.google.com/appengine/docs/python/how-requests-are-routed) for information on
 * how requests are routed in App Engine and how routing is affected by [dispatch
 * files](https://cloud.google.com/appengine/docs/python/config/dispatchref).
 * <p>
 * The AppEngineRouting used to construct the URL can be set at the queue-level or task-level:
 * <p>
 * *  If set, AppEngineQueueConfig.app_engine_routing_overrides is used for all    tasks in the
 * queue, no matter what the setting is for the    task-level app_engine_routing.
 * <p>
 * The `url` that the task will be sent to is:
 * <p>
 * * `url = host +` AppEngineTaskTarget.relative_url
 * <p>
 * * `host = [application_domain_name]`   `| [service] + '.' + [application_domain_name]`   `|
 * [version] + '.' + [application_domain_name]`   `| [version_dot_service]+ '.' +
 * [application_domain_name]`   `| [instance] + '.' + [application_domain_name]`   `|
 * [instance_dot_service] + '.' + [application_domain_name]`   `| [instance_dot_version] + '.' +
 * [application_domain_name]`   `| [instance_dot_version_dot_service] + '.' +
 * [application_domain_name]`
 * <p>
 * * `application_domain_name` = The domain name of the app, for   example .appspot.com, which is
 * associated with the   queue's project ID.
 * <p>
 * * `service =` AppEngineRouting.service
 * <p>
 * * `version =` AppEngineRouting.version
 * <p>
 * * `version_dot_service =`   AppEngineRouting.version `+ '.' +` AppEngineRouting.service
 * <p>
 * * `instance =` AppEngineRouting.instance
 * <p>
 * * `instance_dot_service =`   AppEngineRouting.instance `+ '.' +` AppEngineRouting.service
 * <p>
 * * `instance_dot_version =`   AppEngineRouting.instance `+ '.' +` AppEngineRouting.version
 * <p>
 * * `instance_dot_version_dot_service =`   AppEngineRouting.instance `+ '.' +`
 * AppEngineRouting.version `+ '.' +` AppEngineRouting.service
 * <p>
 * If AppEngineRouting.service is empty, then the task will be sent to the service which is the
 * default service when the task is attempted.
 * <p>
 * If AppEngineRouting.version is empty, then the task will be sent to the version which is the
 * default version when the task is attempted.
 * <p>
 * If AppEngineRouting.instance is empty, then the task will be sent to an instance which is
 * available when the task is attempted.
 * <p>
 * If AppEngineRouting.service, AppEngineRouting.version, or AppEngineRouting.instance is invalid,
 * then the task will be sent to the default version of the default service when the task is
 * attempted.
 * <p>
 * The task will be sent to a task handler by an HTTP request using the specified
 * AppEngineTaskTarget.http_method (for example POST, HTTP GET, etc). The task attempt has succeeded
 * if the task handler returns an HTTP response code in the range [200 - 299]. Error 503 is
 * considered an App Engine system error instead of an application error. Requests returning error
 * 503 will be retried regardless of retry configuration and not counted against retry counts. Any
 * other response code or a failure to receive a response before the deadline is a failed attempt.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AppEngineTaskTarget {

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, AppEngineQueueConfig.app_engine_routing_overrides is used for all tasks in the queue,
     * no matter what the setting is for the task-level app_engine_routing.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private AppEngineRouting appEngineRouting;

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Repeated headers are not supported but a
     * header value can contain commas.
     * <p>
     * Some headers, such as the ones below, will be automatically set by Cloud Tasks:
     * <p>
     * * Host: The host is constructed from many settings in   AppEngineQueueConfig and
     * AppEngineTaskTarget. See the   documentation for AppEngineTaskTarget for more   information. If
     * set, the host header has to exactly match the   resolved hostname, otherwise an error will be
     * returned. * Content-Length: This will be computed and overwritten by Cloud Tasks. * X-Google-*:
     * For Google internal use only. * X-AppEngine-*: For Google internal use only. See
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     * <p>
     * When a task is attempted, AppEngineQueueConfig.headers will be merged with the task's
     * AppEngineTaskTarget.headers and the merged headers will be sent with the task's HTTP request.
     * In addition, some App Engine headers will be set which contain task-specific information that
     * can be used by the handler; see
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.util.Map<String, String> headers;

    /**
     * The HTTP method to use for the request. The default is POST.
     * <p>
     * The app's request handler for the task's target URL must be able to handle HTTP requests with
     * this http_method, otherwise the task attempt will fail with error code 405 "Method Not Allowed"
     * because "the method specified in the Request-Line is not allowed for the resource identified by
     * the Request-URI". See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [python RequestHandler](https://cloud.google.com/appen
     * gine/docs/python/tools/webapp/requesthandlerclass).
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String httpMethod;

    /**
     * Payload.
     * <p>
     * The payload will be sent as the HTTP message body. A message body, and thus a payload, is
     * allowed only if the HTTP method is POST or PUT. It is an error to set a data payload on a task
     * with an incompatible HttpMethod.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String payload;

    /**
     * The relative URL.
     * <p>
     * The relative URL must begin with "/" and must be a valid HTTP relative URL. It can contain a
     * path, query string arguments, and `#` fragments. If the relative URL is empty, then the root
     * path "/" will be used. No spaces are allowed, and the maximum length allowed is 2083
     * characters.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String relativeUrl;

    /**
     * Settings that determine the retry behavior.
     * <p>
     * The task's retry configuration overrides the queue's retry configuration.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private RetryConfig retryConfig;

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, AppEngineQueueConfig.app_engine_routing_overrides is used for all tasks in the queue,
     * no matter what the setting is for the task-level app_engine_routing.
     *
     * @return value or {@code null} for none
     */
    public AppEngineRouting getAppEngineRouting() {
        return appEngineRouting;
    }

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, AppEngineQueueConfig.app_engine_routing_overrides is used for all tasks in the queue,
     * no matter what the setting is for the task-level app_engine_routing.
     *
     * @param appEngineRouting appEngineRouting or {@code null} for none
     */
    public AppEngineTaskTarget setAppEngineRouting(final AppEngineRouting appEngineRouting) {
        this.appEngineRouting = appEngineRouting;
        return this;
    }

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Repeated headers are not supported but a
     * header value can contain commas.
     * <p>
     * Some headers, such as the ones below, will be automatically set by Cloud Tasks:
     * <p>
     * * Host: The host is constructed from many settings in   AppEngineQueueConfig and
     * AppEngineTaskTarget. See the   documentation for AppEngineTaskTarget for more   information. If
     * set, the host header has to exactly match the   resolved hostname, otherwise an error will be
     * returned. * Content-Length: This will be computed and overwritten by Cloud Tasks. * X-Google-*:
     * For Google internal use only. * X-AppEngine-*: For Google internal use only. See
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     * <p>
     * When a task is attempted, AppEngineQueueConfig.headers will be merged with the task's
     * AppEngineTaskTarget.headers and the merged headers will be sent with the task's HTTP request.
     * In addition, some App Engine headers will be set which contain task-specific information that
     * can be used by the handler; see
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     *
     * @return value or {@code null} for none
     */
    public java.util.Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Repeated headers are not supported but a
     * header value can contain commas.
     * <p>
     * Some headers, such as the ones below, will be automatically set by Cloud Tasks:
     * <p>
     * * Host: The host is constructed from many settings in   AppEngineQueueConfig and
     * AppEngineTaskTarget. See the   documentation for AppEngineTaskTarget for more   information. If
     * set, the host header has to exactly match the   resolved hostname, otherwise an error will be
     * returned. * Content-Length: This will be computed and overwritten by Cloud Tasks. * X-Google-*:
     * For Google internal use only. * X-AppEngine-*: For Google internal use only. See
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     * <p>
     * When a task is attempted, AppEngineQueueConfig.headers will be merged with the task's
     * AppEngineTaskTarget.headers and the merged headers will be sent with the task's HTTP request.
     * In addition, some App Engine headers will be set which contain task-specific information that
     * can be used by the handler; see
     * [here](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers).
     *
     * @param headers headers or {@code null} for none
     */
    public AppEngineTaskTarget setHeaders(final java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * The HTTP method to use for the request. The default is POST.
     * <p>
     * The app's request handler for the task's target URL must be able to handle HTTP requests with
     * this http_method, otherwise the task attempt will fail with error code 405 "Method Not Allowed"
     * because "the method specified in the Request-Line is not allowed for the resource identified by
     * the Request-URI". See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [python RequestHandler](https://cloud.google.com/appen
     * gine/docs/python/tools/webapp/requesthandlerclass).
     *
     * @return value or {@code null} for none
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * The HTTP method to use for the request. The default is POST.
     * <p>
     * The app's request handler for the task's target URL must be able to handle HTTP requests with
     * this http_method, otherwise the task attempt will fail with error code 405 "Method Not Allowed"
     * because "the method specified in the Request-Line is not allowed for the resource identified by
     * the Request-URI". See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [python RequestHandler](https://cloud.google.com/appen
     * gine/docs/python/tools/webapp/requesthandlerclass).
     *
     * @param httpMethod httpMethod or {@code null} for none
     */
    public AppEngineTaskTarget setHttpMethod(final String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    /**
     * Payload.
     * <p>
     * The payload will be sent as the HTTP message body. A message body, and thus a payload, is
     * allowed only if the HTTP method is POST or PUT. It is an error to set a data payload on a task
     * with an incompatible HttpMethod.
     *
     * @return value or {@code null} for none
     * @see #decodePayload()
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Payload.
     * <p>
     * The payload will be sent as the HTTP message body. A message body, and thus a payload, is
     * allowed only if the HTTP method is POST or PUT. It is an error to set a data payload on a task
     * with an incompatible HttpMethod.
     *
     * @param payload payload or {@code null} for none
     * @see #encodePayload()
     */
    public AppEngineTaskTarget setPayload(final String payloadArg) {
        this.payload = payloadArg;
        return this;
    }

    /**
     * Payload.
     * <p>
     * The payload will be sent as the HTTP message body. A message body, and thus a payload, is
     * allowed only if the HTTP method is POST or PUT. It is an error to set a data payload on a task
     * with an incompatible HttpMethod.
     *
     * @return Base64 decoded value or {@code null} for none
     * @see #getPayload()
     * @since 1.14
     */
    public byte[] decodePayload() {
        return com.google.api.client.util.Base64.decodeBase64(payload);
    }

    /**
     * Payload.
     * <p>
     * The payload will be sent as the HTTP message body. A message body, and thus a payload, is
     * allowed only if the HTTP method is POST or PUT. It is an error to set a data payload on a task
     * with an incompatible HttpMethod.
     *
     * @see #setPayload()
     * <p>
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     * @since 1.14
     */
    public AppEngineTaskTarget encodePayload(final byte[] payloadArg) {
        this.payload = com.google.api.client.util.Base64.encodeBase64URLSafeString(payloadArg);
        return this;
    }

    /**
     * The relative URL.
     * <p>
     * The relative URL must begin with "/" and must be a valid HTTP relative URL. It can contain a
     * path, query string arguments, and `#` fragments. If the relative URL is empty, then the root
     * path "/" will be used. No spaces are allowed, and the maximum length allowed is 2083
     * characters.
     *
     * @return value or {@code null} for none
     */
    public String getRelativeUrl() {
        return relativeUrl;
    }

    /**
     * The relative URL.
     * <p>
     * The relative URL must begin with "/" and must be a valid HTTP relative URL. It can contain a
     * path, query string arguments, and `#` fragments. If the relative URL is empty, then the root
     * path "/" will be used. No spaces are allowed, and the maximum length allowed is 2083
     * characters.
     *
     * @param relativeUrl relativeUrl or {@code null} for none
     */
    public AppEngineTaskTarget setRelativeUrl(final String relativeUrl) {
        this.relativeUrl = relativeUrl;
        return this;
    }

    /**
     * Settings that determine the retry behavior.
     * <p>
     * The task's retry configuration overrides the queue's retry configuration.
     *
     * @return value or {@code null} for none
     */
    public RetryConfig getRetryConfig() {
        return retryConfig;
    }

    /**
     * Settings that determine the retry behavior.
     * <p>
     * The task's retry configuration overrides the queue's retry configuration.
     *
     * @param retryConfig retryConfig or {@code null} for none
     */
    public AppEngineTaskTarget setRetryConfig(final RetryConfig retryConfig) {
        this.retryConfig = retryConfig;
        return this;
    }

}
