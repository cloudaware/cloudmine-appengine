package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * Status of the task.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class TaskStatus {

    /**
     * Output only.
     * <p>
     * The number of attempts dispatched. This count includes tasks which have been dispatched but
     * haven't received a response.
     * The value may be {@code null}.
     */

    private Long attemptDispatchCount;

    /**
     * Output only.
     * <p>
     * The number of attempts which have received a response.
     * The value may be {@code null}.
     */

    private Long attemptResponseCount;

    /**
     * Output only.
     * <p>
     * The status of the task's first attempt.
     * <p>
     * Only AttemptStatus.dispatch_time will be set. The other AttemptStatus information is not
     * retained by Cloud Tasks.
     * The value may be {@code null}.
     */

    private AttemptStatus firstAttemptStatus;

    /**
     * Output only.
     * <p>
     * The status of the task's last attempt.
     * The value may be {@code null}.
     */

    private AttemptStatus lastAttemptStatus;

    /**
     * Output only.
     * <p>
     * The number of attempts dispatched. This count includes tasks which have been dispatched but
     * haven't received a response.
     *
     * @return value or {@code null} for none
     */
    public Long getAttemptDispatchCount() {
        return attemptDispatchCount;
    }

    /**
     * Output only.
     * <p>
     * The number of attempts dispatched. This count includes tasks which have been dispatched but
     * haven't received a response.
     *
     * @param attemptDispatchCount attemptDispatchCount or {@code null} for none
     */
    public TaskStatus setAttemptDispatchCount(final Long attemptDispatchCount) {
        this.attemptDispatchCount = attemptDispatchCount;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The number of attempts which have received a response.
     *
     * @return value or {@code null} for none
     */
    public Long getAttemptResponseCount() {
        return attemptResponseCount;
    }

    /**
     * Output only.
     * <p>
     * The number of attempts which have received a response.
     *
     * @param attemptResponseCount attemptResponseCount or {@code null} for none
     */
    public TaskStatus setAttemptResponseCount(final Long attemptResponseCount) {
        this.attemptResponseCount = attemptResponseCount;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The status of the task's first attempt.
     * <p>
     * Only AttemptStatus.dispatch_time will be set. The other AttemptStatus information is not
     * retained by Cloud Tasks.
     *
     * @return value or {@code null} for none
     */
    public AttemptStatus getFirstAttemptStatus() {
        return firstAttemptStatus;
    }

    /**
     * Output only.
     * <p>
     * The status of the task's first attempt.
     * <p>
     * Only AttemptStatus.dispatch_time will be set. The other AttemptStatus information is not
     * retained by Cloud Tasks.
     *
     * @param firstAttemptStatus firstAttemptStatus or {@code null} for none
     */
    public TaskStatus setFirstAttemptStatus(final AttemptStatus firstAttemptStatus) {
        this.firstAttemptStatus = firstAttemptStatus;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The status of the task's last attempt.
     *
     * @return value or {@code null} for none
     */
    public AttemptStatus getLastAttemptStatus() {
        return lastAttemptStatus;
    }

    /**
     * Output only.
     * <p>
     * The status of the task's last attempt.
     *
     * @param lastAttemptStatus lastAttemptStatus or {@code null} for none
     */
    public TaskStatus setLastAttemptStatus(final AttemptStatus lastAttemptStatus) {
        this.lastAttemptStatus = lastAttemptStatus;
        return this;
    }

}
