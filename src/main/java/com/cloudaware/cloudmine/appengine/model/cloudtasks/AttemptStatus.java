package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * The status of a task attempt.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AttemptStatus {

    /**
     * Output only.
     * <p>
     * The time that this attempt was dispatched.
     * The value may be {@code null}.
     */

    private String dispatchTime;

    /**
     * Output only.
     * <p>
     * The response from the target for this attempt.
     * <p>
     * If the task has not been attempted or the task is currently running then the response status
     * will be UNKNOWN.
     * The value may be {@code null}.
     */

    private Status responseStatus;

    /**
     * Output only.
     * <p>
     * The time that this attempt response was received.
     * The value may be {@code null}.
     */

    private String responseTime;

    /**
     * Output only.
     * <p>
     * The time that this attempt was scheduled.
     * The value may be {@code null}.
     */

    private String scheduleTime;

    /**
     * Output only.
     * <p>
     * The time that this attempt was dispatched.
     *
     * @return value or {@code null} for none
     */
    public String getDispatchTime() {
        return dispatchTime;
    }

    /**
     * Output only.
     * <p>
     * The time that this attempt was dispatched.
     *
     * @param dispatchTime dispatchTime or {@code null} for none
     */
    public AttemptStatus setDispatchTime(final String dispatchTime) {
        this.dispatchTime = dispatchTime;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The response from the target for this attempt.
     * <p>
     * If the task has not been attempted or the task is currently running then the response status
     * will be UNKNOWN.
     *
     * @return value or {@code null} for none
     */
    public Status getResponseStatus() {
        return responseStatus;
    }

    /**
     * Output only.
     * <p>
     * The response from the target for this attempt.
     * <p>
     * If the task has not been attempted or the task is currently running then the response status
     * will be UNKNOWN.
     *
     * @param responseStatus responseStatus or {@code null} for none
     */
    public AttemptStatus setResponseStatus(final Status responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The time that this attempt response was received.
     *
     * @return value or {@code null} for none
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Output only.
     * <p>
     * The time that this attempt response was received.
     *
     * @param responseTime responseTime or {@code null} for none
     */
    public AttemptStatus setResponseTime(final String responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The time that this attempt was scheduled.
     *
     * @return value or {@code null} for none
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Output only.
     * <p>
     * The time that this attempt was scheduled.
     *
     * @param scheduleTime scheduleTime or {@code null} for none
     */
    public AttemptStatus setScheduleTime(final String scheduleTime) {
        this.scheduleTime = scheduleTime;
        return this;
    }

}
