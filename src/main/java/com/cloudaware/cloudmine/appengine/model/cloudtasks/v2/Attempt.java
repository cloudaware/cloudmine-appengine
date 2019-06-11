package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2;

/**
 * The status of a task attempt.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Attempt {

    /**
     * Output only. The time that this attempt was dispatched.
     * <p>
     * `dispatch_time` will be truncated to the nearest microsecond.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String dispatchTime;

    /**
     * Output only. The response from the target for this attempt.
     * <p>
     * If `response_time` is unset, then the task has not been attempted or is currently running and
     * the `response_status` field is meaningless.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Status responseStatus;

    /**
     * Output only. The time that this attempt response was received.
     * <p>
     * `response_time` will be truncated to the nearest microsecond.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String responseTime;

    /**
     * Output only. The time that this attempt was scheduled.
     * <p>
     * `schedule_time` will be truncated to the nearest microsecond.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String scheduleTime;

    /**
     * Output only. The time that this attempt was dispatched.
     * <p>
     * `dispatch_time` will be truncated to the nearest microsecond.
     *
     * @return value or {@code null} for none
     */
    public String getDispatchTime() {
        return dispatchTime;
    }

    /**
     * Output only. The time that this attempt was dispatched.
     * <p>
     * `dispatch_time` will be truncated to the nearest microsecond.
     *
     * @param dispatchTime dispatchTime or {@code null} for none
     */
    public Attempt setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
        return this;
    }

    /**
     * Output only. The response from the target for this attempt.
     * <p>
     * If `response_time` is unset, then the task has not been attempted or is currently running and
     * the `response_status` field is meaningless.
     *
     * @return value or {@code null} for none
     */
    public Status getResponseStatus() {
        return responseStatus;
    }

    /**
     * Output only. The response from the target for this attempt.
     * <p>
     * If `response_time` is unset, then the task has not been attempted or is currently running and
     * the `response_status` field is meaningless.
     *
     * @param responseStatus responseStatus or {@code null} for none
     */
    public Attempt setResponseStatus(Status responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    /**
     * Output only. The time that this attempt response was received.
     * <p>
     * `response_time` will be truncated to the nearest microsecond.
     *
     * @return value or {@code null} for none
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Output only. The time that this attempt response was received.
     * <p>
     * `response_time` will be truncated to the nearest microsecond.
     *
     * @param responseTime responseTime or {@code null} for none
     */
    public Attempt setResponseTime(String responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    /**
     * Output only. The time that this attempt was scheduled.
     * <p>
     * `schedule_time` will be truncated to the nearest microsecond.
     *
     * @return value or {@code null} for none
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Output only. The time that this attempt was scheduled.
     * <p>
     * `schedule_time` will be truncated to the nearest microsecond.
     *
     * @param scheduleTime scheduleTime or {@code null} for none
     */
    public Attempt setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
        return this;
    }

}

