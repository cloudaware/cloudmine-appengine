package com.cloudaware.cloudmine.appengine.model.cloudtasks;

/**
 * Request message for CloudTasks.CreateTask.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class CreateTaskRequest {

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     * The value may be {@code null}.
     */

    private String responseView;

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format: `projects//locations//queues//tasks/`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * Explicitly specifying a Task.name enables task de-duplication. If a task's name is identical to
     * the name of an existing task or a task that was deleted or completed within the last ~10 days
     * then the call to CloudTasks.CreateTask will fail. Because there is an extra lookup cost to
     * identify duplicate task names, these CloudTasks.CreateTask calls have significantly increased
     * latency. Using hashed strings for the task id or for the prefix of the task id is recommended.
     * Choosing task ids that are sequential or have sequential prefixes, for example using a
     * timestamp, causes an increase in latency and error rates in all task commands. The
     * infrastructure relies on an approximately uniform distribution of task ids to store and serve
     * tasks efficiently.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     * The value may be {@code null}.
     */

    private Task task;

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     *
     * @return value or {@code null} for none
     */
    public String getResponseView() {
        return responseView;
    }

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     *
     * @param responseView responseView or {@code null} for none
     */
    public CreateTaskRequest setResponseView(final String responseView) {
        this.responseView = responseView;
        return this;
    }

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format: `projects//locations//queues//tasks/`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * Explicitly specifying a Task.name enables task de-duplication. If a task's name is identical to
     * the name of an existing task or a task that was deleted or completed within the last ~10 days
     * then the call to CloudTasks.CreateTask will fail. Because there is an extra lookup cost to
     * identify duplicate task names, these CloudTasks.CreateTask calls have significantly increased
     * latency. Using hashed strings for the task id or for the prefix of the task id is recommended.
     * Choosing task ids that are sequential or have sequential prefixes, for example using a
     * timestamp, causes an increase in latency and error rates in all task commands. The
     * infrastructure relies on an approximately uniform distribution of task ids to store and serve
     * tasks efficiently.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     *
     * @return value or {@code null} for none
     */
    public Task getTask() {
        return task;
    }

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format: `projects//locations//queues//tasks/`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * Explicitly specifying a Task.name enables task de-duplication. If a task's name is identical to
     * the name of an existing task or a task that was deleted or completed within the last ~10 days
     * then the call to CloudTasks.CreateTask will fail. Because there is an extra lookup cost to
     * identify duplicate task names, these CloudTasks.CreateTask calls have significantly increased
     * latency. Using hashed strings for the task id or for the prefix of the task id is recommended.
     * Choosing task ids that are sequential or have sequential prefixes, for example using a
     * timestamp, causes an increase in latency and error rates in all task commands. The
     * infrastructure relies on an approximately uniform distribution of task ids to store and serve
     * tasks efficiently.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     *
     * @param task task or {@code null} for none
     */
    public CreateTaskRequest setTask(final Task task) {
        this.task = task;
        return this;
    }

}
