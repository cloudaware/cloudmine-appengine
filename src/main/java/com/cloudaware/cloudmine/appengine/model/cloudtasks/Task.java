package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * A unit of scheduled work.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Task {

    /**
     * App Engine task target. Can be used only if Queue.app_engine_queue_config is set.
     * The value may be {@code null}.
     */

    private AppEngineTaskTarget appEngineTaskTarget;

    /**
     * Output only.
     * <p>
     * The time that the task was created.
     * <p>
     * create_time will be truncated to the nearest second.
     * The value may be {@code null}.
     */

    private String createTime;

    /**
     * The task name.
     * <p>
     * The task name must have the following format: `projects//locations//queues//tasks/`
     * <p>
     * * `` can contain uppercase and lowercase letters,   numbers, hyphens, colons, and periods; that
     * is, it must match   the regular expression: `[a-zA-Z\\d-:\\.]+`. * `` can contain uppercase and
     * lowercase letters,   numbers, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d-]+`. The maximum length is 100   characters. * `` contain uppercase and lowercase
     * letters, numbers,   underscores, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d_-]+`. The maximum length is 500   characters.
     * <p>
     * Optionally caller-specified in CreateTaskRequest, after which it becomes output only.
     * The value may be {@code null}.
     */

    private String name;

    /**
     * Pull task target. Can be used only if Queue.pull_queue_config is set.
     * The value may be {@code null}.
     */

    private PullTaskTarget pullTaskTarget;

    /**
     * The time when the task is scheduled to be attempted.
     * <p>
     * For pull queues, this is the time when the task is available to be leased; if a task is
     * currently leased, this is the time when the current lease expires, that is, the time that the
     * task was leased plus the PullTasksRequest.lease_duration.
     * <p>
     * For App Engine queues, this is when the task will be attempted or retried.
     * <p>
     * schedule_time will be truncated to the nearest microsecond.
     * The value may be {@code null}.
     */

    private String scheduleTime;

    /**
     * Output only.
     * <p>
     * Task status.
     * The value may be {@code null}.
     */

    private TaskStatus taskStatus;

    /**
     * Output only.
     * <p>
     * The view specifies which subset of the Task has been returned.
     * The value may be {@code null}.
     */

    private String view;

    /**
     * App Engine task target. Can be used only if Queue.app_engine_queue_config is set.
     *
     * @return value or {@code null} for none
     */
    public AppEngineTaskTarget getAppEngineTaskTarget() {
        return appEngineTaskTarget;
    }

    /**
     * App Engine task target. Can be used only if Queue.app_engine_queue_config is set.
     *
     * @param appEngineTaskTarget appEngineTaskTarget or {@code null} for none
     */
    public Task setAppEngineTaskTarget(final AppEngineTaskTarget appEngineTaskTarget) {
        this.appEngineTaskTarget = appEngineTaskTarget;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The time that the task was created.
     * <p>
     * create_time will be truncated to the nearest second.
     *
     * @return value or {@code null} for none
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Output only.
     * <p>
     * The time that the task was created.
     * <p>
     * create_time will be truncated to the nearest second.
     *
     * @param createTime createTime or {@code null} for none
     */
    public Task setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * The task name.
     * <p>
     * The task name must have the following format: `projects//locations//queues//tasks/`
     * <p>
     * * `` can contain uppercase and lowercase letters,   numbers, hyphens, colons, and periods; that
     * is, it must match   the regular expression: `[a-zA-Z\\d-:\\.]+`. * `` can contain uppercase and
     * lowercase letters,   numbers, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d-]+`. The maximum length is 100   characters. * `` contain uppercase and lowercase
     * letters, numbers,   underscores, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d_-]+`. The maximum length is 500   characters.
     * <p>
     * Optionally caller-specified in CreateTaskRequest, after which it becomes output only.
     *
     * @return value or {@code null} for none
     */
    public String getName() {
        return name;
    }

    /**
     * The task name.
     * <p>
     * The task name must have the following format: `projects//locations//queues//tasks/`
     * <p>
     * * `` can contain uppercase and lowercase letters,   numbers, hyphens, colons, and periods; that
     * is, it must match   the regular expression: `[a-zA-Z\\d-:\\.]+`. * `` can contain uppercase and
     * lowercase letters,   numbers, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d-]+`. The maximum length is 100   characters. * `` contain uppercase and lowercase
     * letters, numbers,   underscores, and hyphens; that is, it must match the regular   expression:
     * `[a-zA-Z\\d_-]+`. The maximum length is 500   characters.
     * <p>
     * Optionally caller-specified in CreateTaskRequest, after which it becomes output only.
     *
     * @param name name or {@code null} for none
     */
    public Task setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Pull task target. Can be used only if Queue.pull_queue_config is set.
     *
     * @return value or {@code null} for none
     */
    public PullTaskTarget getPullTaskTarget() {
        return pullTaskTarget;
    }

    /**
     * Pull task target. Can be used only if Queue.pull_queue_config is set.
     *
     * @param pullTaskTarget pullTaskTarget or {@code null} for none
     */
    public Task setPullTaskTarget(final PullTaskTarget pullTaskTarget) {
        this.pullTaskTarget = pullTaskTarget;
        return this;
    }

    /**
     * The time when the task is scheduled to be attempted.
     * <p>
     * For pull queues, this is the time when the task is available to be leased; if a task is
     * currently leased, this is the time when the current lease expires, that is, the time that the
     * task was leased plus the PullTasksRequest.lease_duration.
     * <p>
     * For App Engine queues, this is when the task will be attempted or retried.
     * <p>
     * schedule_time will be truncated to the nearest microsecond.
     *
     * @return value or {@code null} for none
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * The time when the task is scheduled to be attempted.
     * <p>
     * For pull queues, this is the time when the task is available to be leased; if a task is
     * currently leased, this is the time when the current lease expires, that is, the time that the
     * task was leased plus the PullTasksRequest.lease_duration.
     * <p>
     * For App Engine queues, this is when the task will be attempted or retried.
     * <p>
     * schedule_time will be truncated to the nearest microsecond.
     *
     * @param scheduleTime scheduleTime or {@code null} for none
     */
    public Task setScheduleTime(final String scheduleTime) {
        this.scheduleTime = scheduleTime;
        return this;
    }

    /**
     * Output only.
     * <p>
     * Task status.
     *
     * @return value or {@code null} for none
     */
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    /**
     * Output only.
     * <p>
     * Task status.
     *
     * @param taskStatus taskStatus or {@code null} for none
     */
    public Task setTaskStatus(final TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    /**
     * Output only.
     * <p>
     * The view specifies which subset of the Task has been returned.
     *
     * @return value or {@code null} for none
     */
    public String getView() {
        return view;
    }

    /**
     * Output only.
     * <p>
     * The view specifies which subset of the Task has been returned.
     *
     * @param view view or {@code null} for none
     */
    public Task setView(final String view) {
        this.view = view;
        return this;
    }

}
