package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2;

/**
 * A unit of scheduled work.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Task  {

    /**
     * App Engine HTTP request that is sent to the task's target. Can be set only if
     * app_engine_http_queue is set on the queue.
     *
     * An App Engine task is a task that has AppEngineHttpRequest set.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private AppEngineHttpRequest appEngineHttpRequest;

    /**
     * Output only. The time that the task was created.
     *
     * `create_time` will be truncated to the nearest second.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String createTime;

    /**
     * Output only. The number of attempts dispatched.
     *
     * This count includes tasks which have been dispatched but haven't received a response.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Integer dispatchCount;

    /**
     * Output only. The status of the task's first attempt.
     *
     * Only dispatch_time will be set. The other Attempt information is not retained by Cloud Tasks.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Attempt firstAttempt;

    /**
     * Output only. The status of the task's last attempt.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Attempt lastAttempt;

    /**
     * Optionally caller-specified in CreateTask.
     *
     * The task name.
     *
     * The task name must have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`
     *
     * * `PROJECT_ID` can contain letters ([A-Za-z]), numbers ([0-9]),    hyphens (-), colons (:), or
     * periods (.).    For more information, see    [Identifying projects](https://cloud.google.com
     * /resource-manager/docs/creating-managing-projects#identifying_projects) * `LOCATION_ID` is the
     * canonical ID for the task's location.    The list of available locations can be obtained by
     * calling    ListLocations.    For more information, see
     * https://cloud.google.com/about/locations/. * `QUEUE_ID` can contain letters ([A-Za-z]), numbers
     * ([0-9]), or   hyphens (-). The maximum length is 100 characters. * `TASK_ID` can contain only
     * letters ([A-Za-z]), numbers ([0-9]),   hyphens (-), or underscores (_). The maximum length is
     * 500 characters.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String name;

    /**
     * Output only. The number of attempts which have received a response.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Integer responseCount;

    /**
     * The time when the task is scheduled to be attempted.
     *
     * For App Engine queues, this is when the task will be attempted or retried.
     *
     * `schedule_time` will be truncated to the nearest microsecond.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String scheduleTime;

    /**
     * Output only. The view specifies which subset of the Task has been returned.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String view;

    /**
     * App Engine HTTP request that is sent to the task's target. Can be set only if
     * app_engine_http_queue is set on the queue.
     *
     * An App Engine task is a task that has AppEngineHttpRequest set.
     * @return value or {@code null} for none
     */
    public AppEngineHttpRequest getAppEngineHttpRequest() {
        return appEngineHttpRequest;
    }

    /**
     * App Engine HTTP request that is sent to the task's target. Can be set only if
     * app_engine_http_queue is set on the queue.
     *
     * An App Engine task is a task that has AppEngineHttpRequest set.
     * @param appEngineHttpRequest appEngineHttpRequest or {@code null} for none
     */
    public Task setAppEngineHttpRequest(AppEngineHttpRequest appEngineHttpRequest) {
        this.appEngineHttpRequest = appEngineHttpRequest;
        return this;
    }

    /**
     * Output only. The time that the task was created.
     *
     * `create_time` will be truncated to the nearest second.
     * @return value or {@code null} for none
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Output only. The time that the task was created.
     *
     * `create_time` will be truncated to the nearest second.
     * @param createTime createTime or {@code null} for none
     */
    public Task setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Output only. The number of attempts dispatched.
     *
     * This count includes tasks which have been dispatched but haven't received a response.
     * @return value or {@code null} for none
     */
    public Integer getDispatchCount() {
        return dispatchCount;
    }

    /**
     * Output only. The number of attempts dispatched.
     *
     * This count includes tasks which have been dispatched but haven't received a response.
     * @param dispatchCount dispatchCount or {@code null} for none
     */
    public Task setDispatchCount(Integer dispatchCount) {
        this.dispatchCount = dispatchCount;
        return this;
    }

    /**
     * Output only. The status of the task's first attempt.
     *
     * Only dispatch_time will be set. The other Attempt information is not retained by Cloud Tasks.
     * @return value or {@code null} for none
     */
    public Attempt getFirstAttempt() {
        return firstAttempt;
    }

    /**
     * Output only. The status of the task's first attempt.
     *
     * Only dispatch_time will be set. The other Attempt information is not retained by Cloud Tasks.
     * @param firstAttempt firstAttempt or {@code null} for none
     */
    public Task setFirstAttempt(Attempt firstAttempt) {
        this.firstAttempt = firstAttempt;
        return this;
    }

    /**
     * Output only. The status of the task's last attempt.
     * @return value or {@code null} for none
     */
    public Attempt getLastAttempt() {
        return lastAttempt;
    }

    /**
     * Output only. The status of the task's last attempt.
     * @param lastAttempt lastAttempt or {@code null} for none
     */
    public Task setLastAttempt(Attempt lastAttempt) {
        this.lastAttempt = lastAttempt;
        return this;
    }

    /**
     * Optionally caller-specified in CreateTask.
     *
     * The task name.
     *
     * The task name must have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`
     *
     * * `PROJECT_ID` can contain letters ([A-Za-z]), numbers ([0-9]),    hyphens (-), colons (:), or
     * periods (.).    For more information, see    [Identifying projects](https://cloud.google.com
     * /resource-manager/docs/creating-managing-projects#identifying_projects) * `LOCATION_ID` is the
     * canonical ID for the task's location.    The list of available locations can be obtained by
     * calling    ListLocations.    For more information, see
     * https://cloud.google.com/about/locations/. * `QUEUE_ID` can contain letters ([A-Za-z]), numbers
     * ([0-9]), or   hyphens (-). The maximum length is 100 characters. * `TASK_ID` can contain only
     * letters ([A-Za-z]), numbers ([0-9]),   hyphens (-), or underscores (_). The maximum length is
     * 500 characters.
     * @return value or {@code null} for none
     */
    public String getName() {
        return name;
    }

    /**
     * Optionally caller-specified in CreateTask.
     *
     * The task name.
     *
     * The task name must have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`
     *
     * * `PROJECT_ID` can contain letters ([A-Za-z]), numbers ([0-9]),    hyphens (-), colons (:), or
     * periods (.).    For more information, see    [Identifying projects](https://cloud.google.com
     * /resource-manager/docs/creating-managing-projects#identifying_projects) * `LOCATION_ID` is the
     * canonical ID for the task's location.    The list of available locations can be obtained by
     * calling    ListLocations.    For more information, see
     * https://cloud.google.com/about/locations/. * `QUEUE_ID` can contain letters ([A-Za-z]), numbers
     * ([0-9]), or   hyphens (-). The maximum length is 100 characters. * `TASK_ID` can contain only
     * letters ([A-Za-z]), numbers ([0-9]),   hyphens (-), or underscores (_). The maximum length is
     * 500 characters.
     * @param name name or {@code null} for none
     */
    public Task setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Output only. The number of attempts which have received a response.
     * @return value or {@code null} for none
     */
    public Integer getResponseCount() {
        return responseCount;
    }

    /**
     * Output only. The number of attempts which have received a response.
     * @param responseCount responseCount or {@code null} for none
     */
    public Task setResponseCount(Integer responseCount) {
        this.responseCount = responseCount;
        return this;
    }

    /**
     * The time when the task is scheduled to be attempted.
     *
     * For App Engine queues, this is when the task will be attempted or retried.
     *
     * `schedule_time` will be truncated to the nearest microsecond.
     * @return value or {@code null} for none
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * The time when the task is scheduled to be attempted.
     *
     * For App Engine queues, this is when the task will be attempted or retried.
     *
     * `schedule_time` will be truncated to the nearest microsecond.
     * @param scheduleTime scheduleTime or {@code null} for none
     */
    public Task setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
        return this;
    }

    /**
     * Output only. The view specifies which subset of the Task has been returned.
     * @return value or {@code null} for none
     */
    public String getView() {
        return view;
    }

    /**
     * Output only. The view specifies which subset of the Task has been returned.
     * @param view view or {@code null} for none
     */
    public Task setView(String view) {
        this.view = view;
        return this;
    }

}
