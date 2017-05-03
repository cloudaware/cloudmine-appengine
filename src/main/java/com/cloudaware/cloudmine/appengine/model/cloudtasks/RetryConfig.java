package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * Retry config.
 * <p>
 * These settings determine retry behavior.
 * <p>
 * If a task does not complete successfully, meaning that an acknowledgement is not received from
 * the handler before the
 * [deadline](https://cloud.google.com/appengine/docs/python/taskqueue/push/#the_task_deadline),
 * then it will be retried with exponential backoff according to the settings in RetryConfig.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class RetryConfig {

    /**
     * The maximum number of attempts for a task.
     * <p>
     * Cloud Tasks will attempt the task `max_attempts` times (that is, if the first attempt fails,
     * then there will be `max_attempts - 1` retries).  Must be > 0.
     * The value may be {@code null}.
     */
    private Integer maxAttempts;

    /**
     * The maximum amount of time to wait before retrying a task after it fails. The default is 3600
     * seconds.
     * The value may be {@code null}.
     */
    private String maxBackoff;

    /**
     * The maximum number of times that the interval between failed task retries will be doubled
     * before the increase becomes constant. The constant is: 2**(max_doublings - 1) *
     * RetryConfig.min_backoff. The default for max_doublings is 16.
     * The value may be {@code null}.
     */
    private Integer maxDoublings;

    /**
     * The minimum amount of time to wait before retrying a task after it fails. The default is 0.1
     * seconds.
     * The value may be {@code null}.
     */

    private String minBackoff;

    /**
     * The time limit for retrying a failed task, measured from when the task was first run. If
     * specified with RetryConfig.max_attempts, the task will be retried until both limits are
     * reached.
     * The value may be {@code null}.
     */

    private String taskAgeLimit;

    /**
     * If true, then the number of attempts is unlimited.
     * The value may be {@code null}.
     */

    private Boolean unlimitedAttempts;

    /**
     * The maximum number of attempts for a task.
     * <p>
     * Cloud Tasks will attempt the task `max_attempts` times (that is, if the first attempt fails,
     * then there will be `max_attempts - 1` retries).  Must be > 0.
     *
     * @return value or {@code null} for none
     */
    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * The maximum number of attempts for a task.
     * <p>
     * Cloud Tasks will attempt the task `max_attempts` times (that is, if the first attempt fails,
     * then there will be `max_attempts - 1` retries).  Must be > 0.
     *
     * @param maxAttempts maxAttempts or {@code null} for none
     */
    public RetryConfig setMaxAttempts(final Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
        return this;
    }

    /**
     * The maximum amount of time to wait before retrying a task after it fails. The default is 3600
     * seconds.
     *
     * @return value or {@code null} for none
     */
    public String getMaxBackoff() {
        return maxBackoff;
    }

    /**
     * The maximum amount of time to wait before retrying a task after it fails. The default is 3600
     * seconds.
     *
     * @param maxBackoff maxBackoff or {@code null} for none
     */
    public RetryConfig setMaxBackoff(final String maxBackoff) {
        this.maxBackoff = maxBackoff;
        return this;
    }

    /**
     * The maximum number of times that the interval between failed task retries will be doubled
     * before the increase becomes constant. The constant is: 2**(max_doublings - 1) *
     * RetryConfig.min_backoff. The default for max_doublings is 16.
     *
     * @return value or {@code null} for none
     */
    public Integer getMaxDoublings() {
        return maxDoublings;
    }

    /**
     * The maximum number of times that the interval between failed task retries will be doubled
     * before the increase becomes constant. The constant is: 2**(max_doublings - 1) *
     * RetryConfig.min_backoff. The default for max_doublings is 16.
     *
     * @param maxDoublings maxDoublings or {@code null} for none
     */
    public RetryConfig setMaxDoublings(final Integer maxDoublings) {
        this.maxDoublings = maxDoublings;
        return this;
    }

    /**
     * The minimum amount of time to wait before retrying a task after it fails. The default is 0.1
     * seconds.
     *
     * @return value or {@code null} for none
     */
    public String getMinBackoff() {
        return minBackoff;
    }

    /**
     * The minimum amount of time to wait before retrying a task after it fails. The default is 0.1
     * seconds.
     *
     * @param minBackoff minBackoff or {@code null} for none
     */
    public RetryConfig setMinBackoff(final String minBackoff) {
        this.minBackoff = minBackoff;
        return this;
    }

    /**
     * The time limit for retrying a failed task, measured from when the task was first run. If
     * specified with RetryConfig.max_attempts, the task will be retried until both limits are
     * reached.
     *
     * @return value or {@code null} for none
     */
    public String getTaskAgeLimit() {
        return taskAgeLimit;
    }

    /**
     * The time limit for retrying a failed task, measured from when the task was first run. If
     * specified with RetryConfig.max_attempts, the task will be retried until both limits are
     * reached.
     *
     * @param taskAgeLimit taskAgeLimit or {@code null} for none
     */
    public RetryConfig setTaskAgeLimit(final String taskAgeLimit) {
        this.taskAgeLimit = taskAgeLimit;
        return this;
    }

    /**
     * If true, then the number of attempts is unlimited.
     *
     * @return value or {@code null} for none
     */
    public Boolean getUnlimitedAttempts() {
        return unlimitedAttempts;
    }

    /**
     * If true, then the number of attempts is unlimited.
     *
     * @param unlimitedAttempts unlimitedAttempts or {@code null} for none
     */
    public RetryConfig setUnlimitedAttempts(final Boolean unlimitedAttempts) {
        this.unlimitedAttempts = unlimitedAttempts;
        return this;
    }

}
