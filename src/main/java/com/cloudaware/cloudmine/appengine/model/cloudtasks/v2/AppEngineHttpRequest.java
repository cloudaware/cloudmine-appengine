package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2;

/**
 * App Engine HTTP request.
 * <p>
 * The message defines the HTTP request that is sent to an App Engine app when the task is
 * dispatched.
 * <p>
 * This proto can only be used for tasks in a queue which has app_engine_http_queue set.
 * <p>
 * Using AppEngineHttpRequest requires
 * [`appengine.applications.get`](https://cloud.google.com/appengine/docs/admin-api/access-control)
 * Google IAM permission for the project and the following scope:
 * <p>
 * `https://www.googleapis.com/auth/cloud-platform`
 * <p>
 * The task will be delivered to the App Engine app which belongs to the same project as the queue.
 * For more information, see [How Requests are
 * Routed](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and how
 * routing is affected by [dispatch
 * files](https://cloud.google.com/appengine/docs/python/config/dispatchref).
 * <p>
 * The AppEngineRouting used to construct the URL that the task is delivered to can be set at the
 * queue-level or task-level:
 * <p>
 * * If set,    app_engine_routing_override    is used for all tasks in the queue, no matter what
 * the setting    is for the    task-level app_engine_routing.
 * <p>
 * The `url` that the task will be sent to is:
 * <p>
 * * `url =` host `+`   relative_uri
 * <p>
 * The task attempt has succeeded if the app's request handler returns an HTTP response code in the
 * range [`200` - `299`]. `503` is considered an App Engine system error instead of an application
 * error. Requests returning error `503` will be retried regardless of retry configuration and not
 * counted against retry counts. Any other response code or a failure to receive a response before
 * the deadline is a failed attempt.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AppEngineHttpRequest {

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, app_engine_routing_override is used for all tasks in the queue, no matter what the
     * setting is for the task-level app_engine_routing.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private AppEngineRouting appEngineRouting;

    /**
     * HTTP request body.
     * <p>
     * A request body is allowed only if the HTTP method is POST or PUT. It is an error to set a body
     * on a task with an incompatible HttpMethod.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String body;

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Headers can be set when the task is
     * created. Repeated headers are not supported but a header value can contain commas.
     * <p>
     * Cloud Tasks sets some headers to default values:
     * <p>
     * * `User-Agent`: By default, this header is   `"AppEngine-Google;
     * (+http://code.google.com/appengine)"`.   This header can be modified, but Cloud Tasks will
     * append   `"AppEngine-Google; (+http://code.google.com/appengine)"` to the   modified `User-
     * Agent`.
     * <p>
     * If the task has a body, Cloud Tasks sets the following headers:
     * <p>
     * * `Content-Type`: By default, the `Content-Type` header is set to   `"application/octet-
     * stream"`. The default can be overridden by explicitly   setting `Content-Type` to a particular
     * media type when the   task is created.   For example, `Content-Type` can be set to
     * `"application/json"`. * `Content-Length`: This is computed by Cloud Tasks. This value is
     * output only.   It cannot be changed.
     * <p>
     * The headers below cannot be set or overridden:
     * <p>
     * * `Host` * `X-Google-*` * `X-AppEngine-*`
     * <p>
     * In addition, Cloud Tasks sets some headers when the task is dispatched, such as headers
     * containing information about the task; see [request
     * headers](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers). These headers are set only when the task is dispatched, so
     * they are not visible when the task is returned in a Cloud Tasks response.
     * <p>
     * Although there is no specific limit for the maximum number of headers or the size, there is a
     * limit on the maximum size of the Task. For more information, see the CreateTask documentation.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.util.Map<String, String> headers;

    /**
     * The HTTP method to use for the request. The default is POST.
     * <p>
     * The app's request handler for the task's target URL must be able to handle HTTP requests with
     * this http_method, otherwise the task attempt will fail with error code 405 (Method Not
     * Allowed). See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [Python Request
     * Handler](https://cloud.google.com/appengine/docs/python/tools/webapp/requesthandlerclass).
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String httpMethod;

    /**
     * The relative URI.
     * <p>
     * The relative URI must begin with "/" and must be a valid HTTP relative URI. It can contain a
     * path and query string arguments. If the relative URI is empty, then the root path "/" will be
     * used. No spaces are allowed, and the maximum length allowed is 2083 characters.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String relativeUri;

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, app_engine_routing_override is used for all tasks in the queue, no matter what the
     * setting is for the task-level app_engine_routing.
     *
     * @return value or {@code null} for none
     */
    public AppEngineRouting getAppEngineRouting() {
        return appEngineRouting;
    }

    /**
     * Task-level setting for App Engine routing.
     * <p>
     * If set, app_engine_routing_override is used for all tasks in the queue, no matter what the
     * setting is for the task-level app_engine_routing.
     *
     * @param appEngineRouting appEngineRouting or {@code null} for none
     */
    public AppEngineHttpRequest setAppEngineRouting(AppEngineRouting appEngineRouting) {
        this.appEngineRouting = appEngineRouting;
        return this;
    }

    /**
     * HTTP request body.
     * <p>
     * A request body is allowed only if the HTTP method is POST or PUT. It is an error to set a body
     * on a task with an incompatible HttpMethod.
     *
     * @return value or {@code null} for none
     * @see #decodeBody()
     */
    public String getBody() {
        return body;
    }

    /**
     * HTTP request body.
     * <p>
     * A request body is allowed only if the HTTP method is POST or PUT. It is an error to set a body
     * on a task with an incompatible HttpMethod.
     *
     * @param body body or {@code null} for none
     * @see #encodeBody()
     */
    public AppEngineHttpRequest setBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * HTTP request body.
     * <p>
     * A request body is allowed only if the HTTP method is POST or PUT. It is an error to set a body
     * on a task with an incompatible HttpMethod.
     *
     * @return Base64 decoded value or {@code null} for none
     * @see #getBody()
     * @since 1.14
     */
    public byte[] decodeBody() {
        return com.google.api.client.util.Base64.decodeBase64(body);
    }

    /**
     * HTTP request body.
     * <p>
     * A request body is allowed only if the HTTP method is POST or PUT. It is an error to set a body
     * on a task with an incompatible HttpMethod.
     *
     * @see #setBody()
     *
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     * @since 1.14
     */
    public AppEngineHttpRequest encodeBody(byte[] body) {
        this.body = com.google.api.client.util.Base64.encodeBase64URLSafeString(body);
        return this;
    }

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Headers can be set when the task is
     * created. Repeated headers are not supported but a header value can contain commas.
     * <p>
     * Cloud Tasks sets some headers to default values:
     * <p>
     * * `User-Agent`: By default, this header is   `"AppEngine-Google;
     * (+http://code.google.com/appengine)"`.   This header can be modified, but Cloud Tasks will
     * append   `"AppEngine-Google; (+http://code.google.com/appengine)"` to the   modified `User-
     * Agent`.
     * <p>
     * If the task has a body, Cloud Tasks sets the following headers:
     * <p>
     * * `Content-Type`: By default, the `Content-Type` header is set to   `"application/octet-
     * stream"`. The default can be overridden by explicitly   setting `Content-Type` to a particular
     * media type when the   task is created.   For example, `Content-Type` can be set to
     * `"application/json"`. * `Content-Length`: This is computed by Cloud Tasks. This value is
     * output only.   It cannot be changed.
     * <p>
     * The headers below cannot be set or overridden:
     * <p>
     * * `Host` * `X-Google-*` * `X-AppEngine-*`
     * <p>
     * In addition, Cloud Tasks sets some headers when the task is dispatched, such as headers
     * containing information about the task; see [request
     * headers](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers). These headers are set only when the task is dispatched, so
     * they are not visible when the task is returned in a Cloud Tasks response.
     * <p>
     * Although there is no specific limit for the maximum number of headers or the size, there is a
     * limit on the maximum size of the Task. For more information, see the CreateTask documentation.
     *
     * @return value or {@code null} for none
     */
    public java.util.Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * HTTP request headers.
     * <p>
     * This map contains the header field names and values. Headers can be set when the task is
     * created. Repeated headers are not supported but a header value can contain commas.
     * <p>
     * Cloud Tasks sets some headers to default values:
     * <p>
     * * `User-Agent`: By default, this header is   `"AppEngine-Google;
     * (+http://code.google.com/appengine)"`.   This header can be modified, but Cloud Tasks will
     * append   `"AppEngine-Google; (+http://code.google.com/appengine)"` to the   modified `User-
     * Agent`.
     * <p>
     * If the task has a body, Cloud Tasks sets the following headers:
     * <p>
     * * `Content-Type`: By default, the `Content-Type` header is set to   `"application/octet-
     * stream"`. The default can be overridden by explicitly   setting `Content-Type` to a particular
     * media type when the   task is created.   For example, `Content-Type` can be set to
     * `"application/json"`. * `Content-Length`: This is computed by Cloud Tasks. This value is
     * output only.   It cannot be changed.
     * <p>
     * The headers below cannot be set or overridden:
     * <p>
     * * `Host` * `X-Google-*` * `X-AppEngine-*`
     * <p>
     * In addition, Cloud Tasks sets some headers when the task is dispatched, such as headers
     * containing information about the task; see [request
     * headers](https://cloud.google.com/appengine/docs/python/taskqueue/push/creating-
     * handlers#reading_request_headers). These headers are set only when the task is dispatched, so
     * they are not visible when the task is returned in a Cloud Tasks response.
     * <p>
     * Although there is no specific limit for the maximum number of headers or the size, there is a
     * limit on the maximum size of the Task. For more information, see the CreateTask documentation.
     *
     * @param headers headers or {@code null} for none
     */
    public AppEngineHttpRequest setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * The HTTP method to use for the request. The default is POST.
     * <p>
     * The app's request handler for the task's target URL must be able to handle HTTP requests with
     * this http_method, otherwise the task attempt will fail with error code 405 (Method Not
     * Allowed). See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [Python Request
     * Handler](https://cloud.google.com/appengine/docs/python/tools/webapp/requesthandlerclass).
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
     * this http_method, otherwise the task attempt will fail with error code 405 (Method Not
     * Allowed). See [Writing a push task request
     * handler](https://cloud.google.com/appengine/docs/java/taskqueue/push/creating-
     * handlers#writing_a_push_task_request_handler) and the documentation for the request handlers in
     * the language your app is written in e.g. [Python Request
     * Handler](https://cloud.google.com/appengine/docs/python/tools/webapp/requesthandlerclass).
     *
     * @param httpMethod httpMethod or {@code null} for none
     */
    public AppEngineHttpRequest setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    /**
     * The relative URI.
     * <p>
     * The relative URI must begin with "/" and must be a valid HTTP relative URI. It can contain a
     * path and query string arguments. If the relative URI is empty, then the root path "/" will be
     * used. No spaces are allowed, and the maximum length allowed is 2083 characters.
     *
     * @return value or {@code null} for none
     */
    public String getRelativeUri() {
        return relativeUri;
    }

    /**
     * The relative URI.
     * <p>
     * The relative URI must begin with "/" and must be a valid HTTP relative URI. It can contain a
     * path and query string arguments. If the relative URI is empty, then the root path "/" will be
     * used. No spaces are allowed, and the maximum length allowed is 2083 characters.
     *
     * @param relativeUri relativeUri or {@code null} for none
     */
    public AppEngineHttpRequest setRelativeUri(String relativeUri) {
        this.relativeUri = relativeUri;
        return this;
    }

}

